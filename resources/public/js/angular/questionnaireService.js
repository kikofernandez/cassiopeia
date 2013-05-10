angular.module('questionnaireService', ['ngResource']).
  factory('QuestionnaireDI', function($http, $window){
    //var questions =  [];
    var questions = [
      {id: 1, title:'Do you like your job?', answers: [{title: 'Yes'}, {title: 'No'}]},
      {id: 2, title:'Do you drink alcohol?', answers: [{title: 'Yes'}, {title: 'No'}]},
    ];
    // questions = [
    //    { question: 'title', answers: [{title: '', value: ''}]}
    // ]
    var handler = {};
    handler.query = function(){
      return questions;
    };

    handler.saveQuestionnaire = function(title, answers){
      questions.push({'title': title, 'answers': answers});
    };

    handler.sendQuestionnaire = function(){
      $http.post("/api/user/questionnaire/save", questions)
        .success(function(){ console.log('success'); /*$window.location.href = '/user/questionnaire/save';*/ })
        .error(function(){ console.log('failure'); /*$window.location.href = '/user/questionnaire/save';*/ });
    };

    handler.getQuestionnaire = function(){
      return question;
    };

    return handler;
  })
