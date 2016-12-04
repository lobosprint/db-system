'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:MainCtrl
* @description
* # MainCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('MainCtrl', ['$scope','$http','$log','$location','$window',function ($scope, $http, $log, $location, $window) {

  $scope.mail="";
  $scope.pass="";
  $scope.signup = function() {
    if($scope.mail==""|| $scope.pass==""){
      alert("Hay campos que le falta por completar, favor revisar campos con *");
    }
    else{
      var values = {
        mail : $scope.mail,
        pass : md5($scope.pass)
      };

      //$log.error(values);

      $http.post('/app-backend/login', values)
      .success(function(data) {
        //   localStorage.setItem('user', 'nombre');
        //   localStorage.setItem('role', 'tipo-de-rol');
        //   localStorage.setItem('id', 'id-persona');
        // //Generate If Statement depending on tipo-de-rol
        //   window.location.replace("/#/studentHome");
        //   window.location.replace("/#/adminHome");


        //$log.debug(data);
      }).error(function(data){
        // alert(data);
        $('.panel.panel-success').addClass('panel-danger');
        $('.panel.panel-success').removeClass('panel-success');
        $('.panel-heading').text("Log in - No puedes inicar sesión con esas credenciales");

      });
    }
  };
}]);
