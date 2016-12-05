'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:StudentPayPenaltyCtrl
* @description
* # StudentPayPenaltyCtrl
* Controller of the appFrontApp
*/

angular.module('appFrontApp')
.controller('StudentPayPenaltyCtrl', ['$http','$log','$scope', 'turnService', function ($http, $log,$scope, turnService)  {

  $scope.paymentVariable=turnService.studentPaymentInfoSharedObject;
  $scope.turns=[];

  $scope.paymentVariable.date_payment="";
  $scope.paymentVariable.type_card="";
  $scope.paymentVariable.numbers_card="";
  $scope.paymentVariable.expiration_card="";

  // $http.get('/app-backend/getTurnsByAdmin/1').success(function(data){
  //   $scope.turns=data;
  //   //$log.error(data);
  // });
  var change= function(){
    $log.error($('#dtp-expiration').datepicker('getDate'));
  };
  $scope.myDate = new Date();

  $scope.minDate = new Date(
    $scope.myDate.getFullYear(),
    $scope.myDate.getMonth(),
    $scope.myDate.getDate()
  );


  $scope.payment= function(){

    $scope.paymentVariable.date_payment=$scope.minDate;
    if($scope.paymentVariable.date_payment===""||
    $scope.paymentVariable.type_card===""||
    $scope.paymentVariable.numbers_card.length<2147483647||
    $scope.paymentVariable.expiration_card===""||
    $scope.paymentVariable.id_penalty===""
  ){
    alert("Por Favor verifique los campos requeridos.");
    }else{
      $scope.paymentVariable.confirmation_number= Math.floor((Math.random() * 100000000) + 1);

      $http.post('/app-backend/addPayment',$scope.paymentVariable).success(function(data){
        $log.error(data);
        window.location.replace("/#/studentConfirmPayment");

      });
    };
  }
}]);
