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

       $http.post('http://136.145.216.150:9090/app-backend/login', values)
           .success(function(data) {
             $log.debug(data);
           });
       };
  });
