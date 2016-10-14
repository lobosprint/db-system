'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:AdminTurnsHistoryCtrl
 * @description
 * # AdminTurnsHistoryCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('AdminTurnsHistoryCtrl', ['$http','$log','$scope', function ($http, $log,$scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.turns=[];
 	$http.get('/app-backend/getTurns').success(function(data){
 			$scope.turns=data;
 			$log.error(data);
 		});
  }]);
