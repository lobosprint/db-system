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
       var data = {
            name : $scope.name,
            middleName : $scope.middleName,
            lastName : $scope.lastName,
            rumIdNumber : $scope.rumIdNumber,
            birthDate : $scope.birthDate,
            phone : $scope.phone,
            handicap : $scope.inputHandicap,
            mail : $scope.mail,
            pass : $scope.pass,
       };

       $http.post('http://136.145.116.186:9090/registrer', data)
           .success(function(data) {
             $log.debug(data);
           });
       };
  });










