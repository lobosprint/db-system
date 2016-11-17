'use strict';

/**
 * @ngdoc function
 * @name appFrontAPendingontroller:StudentConfirmTicketCtrl
 * @description
 * # StudentConfirmTicketCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('StudentConfirmTicketCtrl',['$http','$log','$scope','turnService', function ($http, $log,$scope,turnService) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    //turnVariable is shared between this and studentGetTurn
    $scope.turnQueue=[];
    $scope.sharedVariable=turnService.studentGetTurnSharedObject;
    // $http.get('/app-backend/getWaitQueue/'.concat( $scope.sharedVariable.studentGetTurnAreaID.concat($scope.sharedVariable.studentGetTurnJobID.concat($scope.sharedVariable.studentGetTurnAdminID)))).success(function(data){
    //   $scope.turnQueue=data;
    // };
    $scope.studentConfirmTicketGetRoute="/app-backend/getWaitQueue/";
    $scope.studentConfirmTicketGetRoute=  $scope.studentConfirmTicketGetRoute.concat($scope.sharedVariable.studentGetTurnAreaID);
    $scope.studentConfirmTicketGetRoute=  $scope.studentConfirmTicketGetRoute.concat("/");
    $scope.studentConfirmTicketGetRoute=  $scope.studentConfirmTicketGetRoute.concat($scope.sharedVariable.studentGetTurnJobID);
    $scope.studentConfirmTicketGetRoute=  $scope.studentConfirmTicketGetRoute.concat("/");
    $scope.studentConfirmTicketGetRoute=  $scope.studentConfirmTicketGetRoute.concat($scope.sharedVariable.studentGetTurnAdminID);
    $log.error($scope.studentConfirmTicketGetRoute);
    $http.get($scope.studentConfirmTicketGetRoute).success(function(data){
      $scope.turnQueue=data;
      $log.error($scope.turnQueue.length);
      //$log.error(data);
    });
  }]);
