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

  $scope.currentID={
    id_turn:0
  }
  $scope.turns=[];
  $http.get('/app-backend/getTurnsByStudent/'.concat(localStorage.getItem('id_student'))).success(function(data){
    $scope.turns=data;
    $log.error('test');
  });
  $scope.testing= function (){
    if(confirm("testing")==true){
      $http.post('/app-backend/deleteTurn',$scope.currentID).success(function(data){
        $scope.turns=[];
        $log.error('turn Deleted');
        $http.get('/app-backend/getTurnsByStudent/'.concat(localStorage.getItem('id_student'))).success(function(data){
          $scope.turns=data;
    
        });
      });

      $log.error('true: '+$scope.currentID.id_turn);
    }
    else {
      $log.error('cancelled');
    }

  };

}]);
