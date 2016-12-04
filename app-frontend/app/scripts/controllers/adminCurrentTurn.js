'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:AdminCurrentTurnCtrl
 * @description
 * # AdminCurrentTurnCtrl
 * Controller of the appFrontApp
 */
 angular.module('appFrontApp')
 .controller('AdminCurrentTurnCtrl',['$http','$log','$scope','turnService', function ($http, $log,$scope,turnService) {
//turnVariable is shared between this and adminPendingTurns
  $scope.turnVariable=turnService.sharedObject;
 	$scope.student=[];
 	$http.get('/app-backend/getTurn/'.concat($scope.turnVariable.turnID)).success(function(data){
 			$scope.student=data;
 			//$log.error(data);
 		});
 }]);

 // (function(){
 // 	var app= angular.module('appFrontApp',[]);

 // 	app.controller('AdminCurrentTurnCtrl',function(){
 // 	var testing='123444';
 // 	});
 // })
