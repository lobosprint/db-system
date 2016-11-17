'use strict';

/**
* @ngdoc function
* @name appFrontAPendingontroller:StudentListTurnsCtrl
* @description
* # StudentListTurnsCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('StudentListTurnsCtrl', ['$http','$log','$scope', function ($http, $log,$scope){

  $scope.ID=1;
  $scope.turns=[];
  $http.get('/app-backend/getTurnsByStudent/1').success(function(data){
    $scope.turns=data;
  });
  $scope.getPendingTurns=function(){


    $http.get('/app-backend/getTurnsByStudent/'.concat($scope.ID)).success(function(data){
      $scope.turns=data;
      $log.error(data);
    });
  }
}]);
