'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:AdminCurrentTurnCtrl
 * @description
 * # AdminCurrentTurnCtrl
 * Controller of the appFrontApp
 */
 angular.module('appFrontApp')
 .controller('AdminCurrentTurnCtrl',['$http','$log','$scope', function ($http, $log,$scope) {
 	this.awesomeThings = [
 	'HTML5 Boilerplate',
 	'AngularJS',
 	'Karma'
 	];


 	$scope.student=[];
 	$http.get('/app-backend/getTurn').success(function(data){
 			$scope.student=data;
 			$log.error(data);
 		});



 }]);

 // (function(){
 // 	var app= angular.module('appFrontApp',[]);

 // 	app.controller('AdminCurrentTurnCtrl',function(){
 // 	var testing='123444';
 // 	});
 // })
