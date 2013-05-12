angular.module('project', ['questionnaireService']).
  config(function($routeProvider) {
    $routeProvider.
      when('/', {controller:QuestionCtrl, templateUrl:'/html/questionnaires/list.html'}).
      when('/new', {controller:EditCtrl, templateUrl:'/html/questionnaires/detail.html'});
  });

function QuestionCtrl($scope, QuestionnaireDI){
  $scope.container = QuestionnaireDI.query();
  console.log('Executed QuestionCtrl');

  $scope.saveQuestionnaire = function(){
    QuestionnaireDI.sendQuestionnaire();
  }
}

function EditCtrl($scope, $location, QuestionnaireDI){

  $scope.answer = '';
  $scope.answers = [];
  $scope.question = {
    title: '',
    description: ''
  };

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
