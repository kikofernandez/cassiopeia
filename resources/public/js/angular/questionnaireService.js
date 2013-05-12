angular.module('questionnaireService', ['ngResource']).
  factory('QuestionnaireDI', function($http, $window){
    //var questions =  [];
    //var questions = [
      //{id: 1, title:'Do you like your job?', answers: [{title: 'Yes'}, {title: 'No'}]},
      //{id: 2, title:'Do you drink alcohol?', answers: [{title: 'Yes'}, {title: 'No'}]},
    //];
    var container = { title: "", description: "", questions: []};
    // questions = [
    //    { question: 'title', answers: [{title: '', value: ''}]}
    // ]
    var handler = {};
    handler.query = function(){
      return container;
    };

    handler.saveQuestionnaire = function(title, answers){
      container.questions.push({'title': title, 'answers': answers});
    };

    handler.sendQuestionnaire = function(){
      $http.post("/api/user/questionnaire/save", container)
        .success(function(){ console.log('success'); /*$window.location.href = '/user/questionnaire/save';*/ })
        .error(function(){ console.log('failure'); alert('No pudimos guardar su respuesta, inténtelo de nuevo.'); });
    };

    handler.getQuestionnaire = function(){
      return question;
    };

    return handler;
  })
