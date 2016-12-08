'use strict';

/**
* @ngdoc function
* @name appFrontAPendingontroller:StudentListTurnsCtrl
* @description
* # StudentListTurnsCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('StudentListTurnsCtrl', ['$http','$log','$scope', function ($http, $log,$scope){


  $scope.turns=[];
  $http.get('/app-backend/getTurnsByStudent/'.concat(localStorage.getItem('id_student'))).success(function(data){
    $scope.turns=data;
  });

}]);
