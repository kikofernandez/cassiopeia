angular.module('project', []).
  config(function($routeProvider) {
    $routeProvider.
      when('/', {controller:QuestionCtrl, templateUrl:'/html/questionnaires/list.html'}).
      when('/new', {controller:CreateQuestionCtrl, templateUrl:'/html/questionnaires/list.html'});
      when('/addAnswer', {controller:CreateQuestionCtrl, templateUrl:'/html/questionnaires/list.html'});
  });

function QuestionCtrl($scope){
  $scope.questions = [
    {title:'Do you like your job?'},
    {title:'Do you like your job?'},
  ];
    
  $scope.addQuestion = function(){
    $scope.questions.push({title:$scope.questionTitle, answers:[]});
    $scope.questionTitle = '';
  }
}

function CreateQuestionCtrl($scope){
  
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