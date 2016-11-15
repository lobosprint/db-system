'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:StudentGetTurnCtrl
* @description
* # StudentGetTurnCtrl
* Controller of the appFrontApp
*/

angular.module('appFrontApp')
.controller('StudentGetTurnCtrl',['$http','$log','$scope','turnService', function ($http, $log,$scope,turnService) {
  this.awesomeThings = [
    'HTML5 Boilerplate',
    'AngularJS',
    'Karma'
  ];
  //turnVariable is shared between this and adminPendingTurns
  $scope.sharedVariable=turnService.studentGetTurnSharedObject;
  $scope.areas=[];
  $scope.jobs=[];
  $http.get('/app-backend/getAreas').success(function(data){
    $scope.areas=data;
    //$log.error(data);
  });

  $scope.getJob= function(){
    $http.get('/app-backend/getJobsByArea/'.concat( $scope.sharedVariable.studentGetTurnAreaID)).success(function(data){
      $scope.jobs=data;
  });
};
}]);
