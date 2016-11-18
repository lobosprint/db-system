'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:StudentPaymentsViewCtrl
* @description
* # StudentPaymentsViewCtrl
* Controller of the appFrontApp
*/

angular.module('appFrontApp')
.controller('StudentPaymentsViewCtrl',['$http','$log','$scope','turnService', function ($http, $log,$scope,turnService) {

  $scope.paymentsVariable=turnService.sharedObject;
  $scope.payments=[];
  $http.get('/app-backend/getPaymentsByStud/1').success(function(data){
    $scope.payments=data;
    //$log.error(data);
  });

  $scope.getPayments=function(){
    $http.get('/app-backend/getPaymentsByStud/'.concat($scope.ID)).success(function(data){
      $scope.payments=data;
      $log.error(data);
    });
  }

}]);

// (function(){
// 	var app= angular.module('appFrontApp',[]);

// 	app.controller('AdminCurrentTurnCtrl',function(){
// 	var testing='123444';
// 	});
// })
