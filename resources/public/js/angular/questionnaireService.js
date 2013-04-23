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
      
      /*$http.post("/user/questionnaire/save", o: questions)
        .success(function(){ console.log('success'); $window.location.href = '/user/questionnaire/save'; })
        .error(function(){ console.log('failure'); $window.location.href = '/user/questionnaire/save'; });*/
      /*$http({
        method: 'POST',
        url: "/user/questionnaire/save",
        data: {o: questions},
        transformRequest: function(data){
          return $.param(data);
        },
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
      });*/
      /*
      $http.post("/user/questionnaire/save", 
        questions,
        {  
          headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
          transformRequest: function(questions){
            return $.param(questions);
          }
        }
      );
      */
      console.log(questions);
      $.post("/user/questionnaire/save", {o: questions});
    };

    handler.getQuestionnaire = function(){
      return question;
    };

    return handler;
  })
