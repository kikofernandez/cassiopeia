/*
angular.module('project', ['mongolab']).
  config(function($routeProvider) {
    $routeProvider.
      when('/', {controller:QuestionCtrl, templateUrl:'list.html'}).
      when('/edit/:projectId', {controller:EditCtrl, templateUrl:'detail.html'}).
      when('/new', {controller:CreateCtrl, templateUrl:'detail.html'}).
      otherwise({redirectTo:'/'});
  });

function QuestionCtrl($scope){
  $scope.questions = [
    {title:'Do you like your job?' questions: [{title: 'Answer 1', value: "1"}, {title: 'Answer 2', value: '2'}]},
  ]
}
*/


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