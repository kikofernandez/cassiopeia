angular.module('project', ['questionnaireService']).
  config(function($routeProvider) {
    $routeProvider.
      when('/', {controller:QuestionCtrl, templateUrl:'/html/questionnaires/list.html'}).
      when('/new', {controller:EditCtrl, templateUrl:'/html/questionnaires/detail.html'});
      //when('/new', {controller:CreateQuestionCtrl, templateUrl:'/html/questionnaires/list.html'});
      //when('/addAnswer', {controller:CreateQuestionCtrl, templateUrl:'/html/questionnaires/list.html'});
  });

function QuestionCtrl($scope, QuestionnaireDI){
  $scope.questions = [
    {id: 1, title:'Do you like your job?', answers: [{title: 'Yes'}, {title: 'No'}]},
    {id: 2, title:'Do you drink alcohol?', answers: [{title: 'Yes'}, {title: 'No'}]},
  ];

  $scope.questions = QuestionnaireDI.query();

  $scope.saveQuestionnaire = function(){
    console.log('Did you call me?');
    QuestionnaireDI.sendQuestionnaire();
  }
  /*  
  $scope.addQuestion = function(){
    $scope.questions.push({title:$scope.questionTitle, answers:[]});
    $scope.questionTitle = '';
  }
  */
}

function EditCtrl($scope, $location, QuestionnaireDI){
  
  $scope.answer = '';
  $scope.answers = [];
  $scope.question = {
    title: '',
    description: ''
  };
  

  //$scope.init();

  $scope.init = function(){
    $scope.answer = '';
    $scope.answers = [];
    $scope.question = {
      title: '',
      description: ''
    };
  }

  $scope.createAnswer = function(){
    $scope.answers.push({ title: $scope.answer});
    $scope.answer = '';
  }



  $scope.saveAnswer = function(){
    QuestionnaireDI.saveQuestionnaire($scope.question.title, $scope.answers);
    $location.path('/');
    $scope.init();
  }
}


/*
  function QuestionnaireCtrl($scope) {
    
    $scope.questions = [
  //    {title:'Do you like your job?', answers: [{title: 'Answer 1', value: "1"}, {title: 'Answer 2', value: '2'}]},
  //    {title:'Do you like your job?', answers: [{title: 'Answer 1', value: "1"}, {title: 'Answer 2', value: '2'}]},
    ];
  
    $scope.addQuestion = function() {
      $scope.questions.push({title:$scope.questionTitle, answers:[]});
      $scope.questionTitle = '';
    };
    
  }
  
  function AnswerCtrl($scope){
    $scope.anwers = [];
    
    $scope.addAnswer = function(question){
      for(var i=0; i<$scope.questions.length; i++){
        if($scope.questions[i]==question){
          var value = ($scope.answerValue!='') ? $scope.answerTitle : $scope.answerValue;
          $scope.questions[i].answers.push({title: $scope.answerTitle, value: value});
          $scope.answerTitle = '';
          $scope.answerValue = '';
          return;
        }
      }
    }
  }
*/
