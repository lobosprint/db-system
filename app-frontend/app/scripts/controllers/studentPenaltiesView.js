'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:StudentPenaltiesViewCtrl
 * @description
 * # StudentPenaltiesViewCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('StudentPenaltiesViewCtrl', ['$http','$log','$scope', 'turnService', function ($http, $log,$scope, turnService){
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.studentPaymentInfoSharedObject=turnService.studentPaymentInfoSharedObject;
    $scope.penalties=[];
    $http.get('/app-backend/getPenalByStudent/'.concat(localStorage.getItem('id_student'))).success(function(data){
      $scope.penalties=data;
      $log.error(data);
    });


    }
]);
