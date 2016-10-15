'use strict';

/**
 * @ngdoc function
 * @name appFrontAPendingontroller:StudentConfirmPaymentCtrl
 * @description
 * # StudentConfirmPaymentCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('StudentConfirmPaymentCtrl', ['$http','$log','$scope', function ($http, $log,$scope){
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.pay=[];
    $http.post('/app-backend/addPayment').success(function(data){
      $scope.pay=data;
      $log.error(data);
    });

  }]);
