'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:StudentPenaltiesViewCtrl
 * @description
 * # StudentPenaltiesViewCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('StudentPenaltiesViewCtrl', ['$http','$log','$scope', function ($http, $log,$scope){
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.penalties=[];
    $http.get('/app-backend/getPenalByStudent/1').success(function(data){
      $scope.penalties=data;
      //$log.error(data);
    });
  }]);
