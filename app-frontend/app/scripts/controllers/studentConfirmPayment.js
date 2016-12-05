'use strict';

/**
 * @ngdoc function
 * @name appFrontAPendingontroller:StudentConfirmPaymentCtrl
 * @description
 * # StudentConfirmPaymentCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('StudentConfirmPaymentCtrl', ['$http','$log','$scope','turnService', function ($http, $log,$scope, turnService){

$scope.paymentVariable=turnService.studentPaymentInfoSharedObject;


  }]);
