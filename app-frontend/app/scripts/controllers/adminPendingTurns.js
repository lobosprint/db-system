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

  $scope.job=-1;
  $scope.jobs=[];
  $scope.secretario=false;;
  $scope.profesor=false;
  $scope.consejero=false;

  $http.get('/app-backend/getJobsofTurnsAdmin/'.concat(localStorage.getItem('id_administrative'))).success(function(data){
    $scope.jobs=data;
    for( var i =0; i<$scope.jobs.length; i++){
      if ($scope.secretario==false && $scope.jobs[i].idJob==1){
        $scope.secretario=true;
      }
      if($scope.profesor==false && $scope.jobs[i].idJob==2){
        $scope.profesor=true;
      }
      if($scope.consejero=false && $scope.jobs[i].idJob==3){
        $scope.consejero=true;
      }
    }
  });
  $scope.turnVariable=turnService.sharedObject;
  $scope.turns=[];
  $http.get('/app-backend/getTurnsByAdmin/'.concat(localStorage.getItem('id_administrative'))).success(function(data){
    $scope.turns=data;
    //$log.error(data);
  });
  $scope.getAllTurnsByAdmin= function(){
    $http.get('/app-backend/getTurnsByAdmin/'.concat(localStorage.getItem('id_administrative'))).success(function(data){
      $scope.turns=data;
      //$log.error(data);
    });
  };
  $scope.getActiveTurns= function(){
    $log.error('/app-backend/getTurnsByAdminJob/'.concat(localStorage.getItem('id_administrative')).concat('/').concat($scope.job));

    $http.get('/app-backend/getTurnsByAdminJob/'.concat(localStorage.getItem('id_administrative')).concat('/').concat($scope.job)).success(function(data){
      $scope.turns=data;
      $log.error(data);
    });
    // $scope.$apply();
  } ;

}]);
