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
  $scope.admins=[];
  $http.get('/app-backend/getAreas').success(function(data){
    $scope.areas=data;
    //$log.error(data);
  });

  $scope.openJobs=function(){
    $('#collapseOne').removeClass("in");
    $('#collapseTwo').addClass("in");
    $('#collapseTwo').removeAttr("style");
  };

  $scope.openAdministrative=function(){
    $('#collapseOne').removeClass("in");
    $('#collapseTwo').removeClass("in");
    $('#collapseThree').addClass("in");
    $('#collapseThree').removeAttr("style");

  };
  $scope.getAdminsByJobRoute='';
  $scope.openDescription=function(){
    //  $scope.getAdminsByJobRoute= '/app-backend/getAdminsByJob/'.concat( $scope.sharedVariable.studentGetTurnAreaID.concat('/'.concat($scope.sharedVariable.studentGetTurnJobID)));
    $('#collapseOne').removeClass("in");
    $('#collapseTwo').removeClass("in");
    $('#collapseThree').removeClass("in");
    $('#collapseFour').addClass("in");
    $('#collapseFour').removeAttr("style");
  };

  $scope.getJob= function(){
    $http.get('/app-backend/getJobsByArea/'.concat( $scope.sharedVariable.studentGetTurnAreaID)).success(function(data){
      $scope.jobs=data;
    });

    $scope.collapseOpen="panel-collapse collapse in";
    $scope.collapseClose="panel-collapse collapse"
    $scope.areaClass="panel-collapse collapse in";
    $scope.jobsClass="panel-collapse collapse";
    $scope.descriptionClass="panel-collapse collapse";
    $scope.jobsClass="panel-collapse collapse";
    $scope.descriptionClass="panel-collapse collapse";
  };

    $scope.sharedVariable.studentGetTurnAdminName="";
  $scope.sharedVariable.studentGetTurnAdminID="";

  $scope.getAdministrative= function(){
    $scope.getAdminsByJobRoute="/app-backend/getAdminsByJob/";
      $scope.getAdminsByJobRoute=$scope.getAdminsByJobRoute.concat($scope.sharedVariable.studentGetTurnAreaID);
        $scope.getAdminsByJobRoute=$scope.getAdminsByJobRoute.concat("/");
      $scope.getAdminsByJobRoute=$scope.getAdminsByJobRoute.concat($scope.sharedVariable.studentGetTurnJobID);
    $http.get($scope.getAdminsByJobRoute).success(function(data){
      $scope.admins=data;
    });
  };
}]);
