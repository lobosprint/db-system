'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:AdminTurnsHistoryCtrl
* @description
* # AdminTurnsHistoryCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('AdminTurnsHistoryCtrl', ['$http','$log','$scope', function ($http, $log,$scope) {
  this.awesomeThings = [
    'HTML5 Boilerplate',
    'AngularJS',
    'Karma'
  ];
  $scope.turns=[];
  $scope.searchedID="";
  $scope.getTurnHistory =function(){
    $http.get("/app-backend/getAllTurnsByStudentNumber/".concat($scope.searchedID)).success(function(data){
    //var getTurnHistory = $http.get('/app-backend/getTurnsByAdmin/1'.concat($scope.searchedID)).success(function(data){
    $scope.testString="/app-backend/getAllTurnsByStudentNumber/".concat($scope.searchedID);
      $scope.turns=data;
      $log.error(data);

    });
  }
  $http.get('/app-backend/getTurns').success(function(data){
    $scope.turns=data;
    $log.error(data);
  });
}]);
