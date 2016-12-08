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
      alert("La combinación de email/contraseña entrada es incorrecta, favor verificar su entrada.");
    }
    else{
      var values = {
        mail : $scope.mail,
        pass : md5($scope.pass)
      };

      //$log.error(values);

      $http.post('/app-backend/login', values)
      .success(function(data) {
        localStorage.setItem('user', data.name);
        if(data.idStudent==data.idPerson){
          $scope.role=student;
        }
        if(data.idStudent!= null ){
          $scope.role='student';
        }
        if(data.idAdministrative!= null){
          $scope.role='administrative';
        }
        localStorage.setItem('role', $scope.role);
        localStorage.setItem('id', data.idPerson);
        localStorage.setItem('id_student', data.idStudent);

        if($scope.role=='administrative'){
           window.location.replace("/#/adminHome");
        }
        else if ($scope.role=='student'){
          window.location.replace("/#/studentHome");
        }
        // //Generate If Statement depending on tipo-de-rol
        //   window.location.replace("/#/studentHome");
        //   window.location.replace("/#/adminHome");
        $log.error(data);
        $log.error($scope.role);
        $log.error(data.name);
        $log.error(data.idPerson);
                $log.error(data.idStudent);
                        $log.error(data.idAdministrative);

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
