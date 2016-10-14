'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:RegistrerCtrl
 * @description
 * # RegistrerCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('RegistrerCtrl', function ($scope, $http, $log) {
     $scope.signup = function() {
       var payload = {
         email : $scope.mail,
         password : $scope.password
       };

       $http.post('http://136.145.116.186:9090/registrer', payload)
           .success(function(data) {
             $log.debug(data);
           });
       };
  });
