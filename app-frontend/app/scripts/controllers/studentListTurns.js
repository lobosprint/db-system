'use strict';

/**
 * @ngdoc function
 * @name appFrontAPendingontroller:StudentListTurnsCtrl
 * @description
 * # StudentListTurnsCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('StudentListTurnsCtrl', ['$http','$log','$scope', function ($http, $log,$scope){
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
