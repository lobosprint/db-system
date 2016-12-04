'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:RegistrerCtrl
* @description
* # RegistrerCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('RegistrerCtrl', ['$scope', '$http', '$log', 'turnService',function ($scope, $http, $log, turnService) {
  //  $scope.signup = function() {
  //    var data = {
  //         name : $scope.name,
  //         middleName : $scope.middleName,
  //         lastName : $scope.lastName,
  //         rumIdNumber : $scope.rumIdNumber,
  //         birthDate : $scope.birthDate,
  //         phone : $scope.phone,
  //         handicap : $scope.inputHandicap,
  //         mail : $scope.mail,
  //         pass : $scope.pass,
  //    };


  //};
  $scope.sharedVariable=turnService.studentRegisterSharedobject;
  $scope.sharedVariable.handiecap=false;
  $scope.sharedVariable.first_name="";
  $scope.sharedVariable.middle_name="";
  $scope.sharedVariable.last_name="";
  $scope.sharedVariable.date_birth="";
  $scope.sharedVariable.phone="";
  $scope.sharedVariable.email="";
  $scope.sharedVariable.password="";
  $scope.sharedVariable.rum_id="";

  $scope.config = {
    headers : {
      'Content-Type': 'application/json'
    }
  }


  $scope.registerUser= function(){
    $http.post('/app-backend/addStudent',$scope.sharedVariable,$scope.config).success(function(data){
      $log.error(data);
    });

  };
}]);
