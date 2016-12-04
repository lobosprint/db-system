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

    if ( $scope.sharedVariable.first_name=="" ||
    $scope.sharedVariable.last_name=="" ||
    $scope.sharedVariable.date_birth=="" ||
    $scope.sharedVariable.phone=="" ||
    $scope.sharedVariable.email=="" ||
    $scope.sharedVariable.password=="" ||
    $scope.sharedVariable.rum_id==""
  ){
    alert("Debe llenar todos los campos con asterisco.")
  }
  else {
    $scope.sharedVariable.password=md5($scope.sharedVariable.password);
    $http.post('/app-backend/addStudent',$scope.sharedVariable,$scope.config).success(function(data){
      alert("It Worked");
      $('#form-registrer').html('<div class="panel panel-default">  <div class="panel-heading">Registro</div> <div class="panel-body">Te has registrado con éxito<br><center> <img style="max-height:100px;" src="./images/check.png" class="img-responsive" alt=""><div class="col-md-offset-4 col-md-6"> <a href="/#/"><button type="submit"  class="btn btn-success col-md-6" style="margin: 10px;">Iniciar Sesion</button></a> </div> </center> </div></div>');


    }).error(function(data){
      $('.panel.panel-success').addClass('panel-danger');
      $('.panel.panel-success').removeClass('panel-success');
      $('.panel-heading').text("Registrar - El formulario tiene errores");


      alert("Didnt' Work");
    });
  }
};
}]);
