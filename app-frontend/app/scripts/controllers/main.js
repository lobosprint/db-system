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
         email : $scope.mail,
         pass : $scope.pass
       };

       $http.get('http://136.145.116.186:9090/login', values)
           .success(function(data) {
             $log.debug(data);
           });
       };
  });
