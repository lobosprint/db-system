'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:AdminPassTurnCtrl
 * @description
 * # AdminPassTurnCtrl
 * Controller of the appFrontApp
 */

  angular.module('appFrontApp')
  .controller('AdminPassTurnCtrl',['$http','$log','$scope', function ($http, $log, $scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.turn=[];
    $http.get('/app-backend/getTurn').success(function(data){
      $scope.turn=data;
      //$log.error(data);
    });

    
  }]);
