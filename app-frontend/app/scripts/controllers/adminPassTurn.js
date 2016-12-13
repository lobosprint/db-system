'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:AdminPassTurnCtrl
 * @description
 * # AdminPassTurnCtrl
 * Controller of the appFrontApp
 */

  angular.module('appFrontApp')
  .controller('AdminPassTurnCtrl',['$http','$log','$scope', 'turnService', function ($http, $log, $scope,turnService) {
    $log.error(turnService.adminTurnHistorySharedObject.pastTurnId);
    $scope.startDate;
    $scope.studentName;
    $scope.count=0;
    $scope.turn=[];
    $http.get('/app-backend/getTurn'.concat('/').concat(turnService.adminTurnHistorySharedObject.pastTurnId)).success(function(data){
      $scope.turn=data;
      //$log.error(data);
      $scope.startDate=$scope.turn.startTime.dayOfMonth + "-" +$scope.turn.startTime.monthOfYear  + "-"+ $scope.turn.startTime.year+ " | "+($scope.turn.startTime.hourOfDay).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false})+":"+($scope.turn.startTime.minuteOfHour).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
      $scope.endDate=$scope.turn.endTime.dayOfMonth + "-" +$scope.turn.endTime.monthOfYear  + "-"+ $scope.turn.endTime.year+ " | "+($scope.turn.endTime.hourOfDay).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false})+":"+($scope.turn.endTime.minuteOfHour).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
      $scope.studentName= $scope.turn.student.name+ " "+ $scope.turn.student.middleName+ " "+$scope.turn.student.lastName;
      $scope.adminArea= $scope.turn.administrative.position.area.name;
      $scope.adminName=$scope.turn.administrative.name+ " " +$scope.turn.administrative.middleName+" "+ $scope.turn.administrative.lastName;
    });

    $scope.turnList=[];
    $log.error(turnService.adminTurnHistorySharedObject.pastTurnId);
    $http.get('/app-backend/getAllCommentsByTurn/'.concat(turnService.adminTurnHistorySharedObject.pastTurnId)).success(function(data){
      $scope.turnList=data;
    });

  }]);
