'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:AdminTurnsHistoryCtrl
* @description
* # AdminTurnsHistoryCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('AdminTurnsHistoryCtrl', ['$http','$log','$scope','turnService', function ($http, $log,$scope, turnService) {

  $scope.turnVariable=turnService.adminTurnHistorySharedObject;
  $scope.turns=[];
  $scope.searchedID="";
  $scope.getTurnHistory =function(){
    $http.get("/app-backend/getAllTurnsByStudentNumber/".concat($scope.searchedID)).success(function(data){
    $scope.testString="/app-backend/getAllTurnsByStudentNumber/".concat($scope.searchedID);
      $scope.turns=data;
      $log.error(data);

    });
  }
  

}]);
