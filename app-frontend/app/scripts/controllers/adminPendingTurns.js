'use strict';

/**
* @ngdoc function
* @name appFrontAPendingontroller:AdminPendingTurnsCtrl
* @description
* # AdminPendingTurnsCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('AdminPendingTurnsCtrl', ['$http','$log','$scope', 'turnService', function ($http, $log,$scope, turnService)  {
  this.awesomeThings = [
    'HTML5 Boilerplate',
    'AngularJS',
    'Karma'
  ];
  $scope.turnVariable=turnService.sharedObject;
  $scope.turns=[];
  $http.get('/app-backend/getTurnsByAdmin/1').success(function(data){
    $scope.turns=data;
    //$log.error(data);
  });
}]);
