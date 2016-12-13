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

  $http.get('/app-backend/getJobsofTurnsAdmin/'.concat(localStorage.getItem('id'))).success(function(data){
    $log.error('/app-backend/getJobsofTurnsAdmin/'.concat(localStorage.getItem('id')));
    $scope.jobs=data;
    for( var i =0; i<$scope.jobs.length; i++){
      if($scope.consejero==false && $scope.jobs[i].idJob==3){
        $scope.consejero=true;
        $log.error('consejero ');
      }
      if ($scope.secretario==false && $scope.jobs[i].idJob==1){
        $scope.secretario=true;
          $log.error('secretario ');
      }
      if($scope.profesor==false && $scope.jobs[i].idJob==2){
        $scope.profesor=true;
          $log.error('profesor ');
      }

      $log.error(i);
      $log.error($scope.jobs);
    }
  });
  $scope.turnVariable=turnService.sharedObject;
  $scope.turns=[];
  $http.get('/app-backend/getTurnsByAdmin/'.concat(localStorage.getItem('id'))).success(function(data){
    $scope.turns=data;
    //$log.error(data);
  });
  $scope.getAllTurnsByAdmin= function(){
    $http.get('/app-backend/getTurnsByAdmin/'.concat(localStorage.getItem('id'))).success(function(data){
      $scope.turns=data;
      //$log.error(data);
    });
  };
  $scope.getActiveTurns= function(){
    $log.error('/app-backend/getTurnsByAdminJob/'.concat(localStorage.getItem('id')).concat('/').concat($scope.job));

    $http.get('/app-backend/getTurnsByAdminJob/'.concat(localStorage.getItem('id')).concat('/').concat($scope.job)).success(function(data){
      $scope.turns=data;
      $log.error(data);
    });
    // $scope.$apply();
  } ;

}]);
