'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('MainCtrl', function ($scope, $http, $log) {
     $scope.signup = function() {
       var values = {
         mail : $scope.mail,
         pass : $scope.pass
       };

       $log.error(values);

       $http.post('http://localhost:9090/login', values)
           .success(function(data) {
             $log.debug(data);
           });
       };
  });
