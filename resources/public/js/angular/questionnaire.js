function QuestionnaireCtrl($scope) {
  
  $scope.questions = [
    {title:'learn angular'},
  ];

  $scope.addQuestion = function() {
    $scope.questions.push({title:$scope.questionTitle});
    $scope.questionTitle = '';
  };
      
/*                           
  $scope.archive = function() {
    var oldTodos = $scope.todos;
    $scope.todos = [];
    angular.forEach(oldTodos, function(todo) {
      if (!todo.done) $scope.todos.push(todo);
    });
  };
*/
}