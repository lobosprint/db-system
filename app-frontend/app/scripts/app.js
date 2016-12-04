'use strict';

/**
* @ngdoc overview
* @name appFrontApp
* @description
* # appFrontApp
*
* Main module of the application.
*/
var app= angular.module('appFrontApp',[  'ngAnimate',
  'ngCookies',
  'ngResource',
  'ngRoute',
  'ngSanitize',
  'ngTouch']);
app.config(function ($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'views/main.html',
    controller: 'MainCtrl',
    controllerAs: 'main'
  })
  .when('/studentConfirmTicket', {
    templateUrl: 'views/studentConfirmTicket.html',
    controller: 'StudentConfirmTicketCtrl',
    controllerAs: 'studentConfirmTicket'
  })
  .when('/studentConfirmPayment', {
    templateUrl: 'views/studentConfirmPayment.html',
    controller: 'StudentConfirmPaymentCtrl',
    controllerAs: 'studentConfirmPayment'
  })
  .when('/studentListTurns', {
    templateUrl: 'views/studentListTurns.html',
    controller: 'StudentListTurnsCtrl',
    controllerAs: 'studentListTurns'
  })
  .when('/studentGetTurn', {
    templateUrl: 'views/studentGetTurn.html',
    controller: 'StudentGetTurnCtrl',
    controllerAs: 'studentGetTurn'
  })
  .when('/about', {
    templateUrl: 'views/about.html',
    controller: 'AboutCtrl',
    controllerAs: 'about'
  })
  .when('/studentPenaltiesView', {
    templateUrl: 'views/studentPenaltiesView.html',
    controller: 'StudentPenaltiesViewCtrl',
    controllerAs: 'studentPenaltiesView'
  })
  .when('/adminHome', {
    templateUrl: 'views/adminHome.html',
    controller: 'AdminHomeCtrl',
    controllerAs: 'adminHome'
  })
  .when('/adminPassTurn', {
    templateUrl: 'views/adminPassTurn.html',
    controller: 'AdminPassTurnCtrl',
    controllerAs: 'adminPassTurn'
  })
  .when('/adminTurnQueue', {
    templateUrl: 'views/adminTurnQueue.html',
    controller: 'AdminTurnQueueCtrl',
    controllerAs: 'adminTurnQueue'
  })
  .when('/adminCurrentTurn', {
    templateUrl: 'views/adminCurrentTurn.html',
    controller: 'AdminCurrentTurnCtrl',
    controllerAs: 'adminCurrentTurn'
  })
  .when('/adminTurnsHistory', {
    templateUrl: 'views/adminTurnsHistory.html',
    controller: 'AdminTurnsHistoryCtrl',
    controllerAs: 'adminTurnsHistory'
  })
  .when('/studentPaymentsView', {
    templateUrl: 'views/studentPaymentsView.html',
    controller: 'StudentPaymentsViewCtrl',
    controllerAs: 'studentPaymentsView'
  })
  .when('/studentPayPenalty', {
    templateUrl: 'views/studentPayPenalty.html',
    controller: 'StudentPayPenaltyCtrl',
    controllerAs: 'studentPayPenalty'
  })
  .when('/studentHome', {
    templateUrl: 'views/studentHome.html',
    controller: 'StudentHomeCtrl',
    controllerAs: 'studentHome'
  })
  .when('/adminPendingTurns', {
    templateUrl: 'views/adminPendingTurns.html',
    controller: 'AdminPendingTurnsCtrl',
    controllerAs: 'adminPendingTurns'
  })
  .when('/registrer', {
    templateUrl: 'views/registrer.html',
    controller: 'RegistrerCtrl',
  })
  .when('/registrerConfirm', {
    templateUrl: 'views/registrerConfirm.html',
    controller: 'RegistrerConfirmCtrl',
    controllerAs: 'registrerConfirm'
  })
  .otherwise({
    redirectTo: '/'
  });
});

app.factory("turnService", function(){

  return {
    sharedObject: { turnID: '0'},
    studentGetTurnSharedObject: {
      studentGetTurnAreaName: 0,
      studentGetTurnAreaID:0,
      studentGetTurnJobName:0,
      studentGetTurnJobID:0,
      studentGetTurnAdminName:0,
      studentGetTurnAdminID:0
    },
    studentRegisterSharedobject: {

      handiecap: 0,
      first_name: 0,
      middle_name: 0,
      last_name: 0,
      date_birth:0,
      phone: 0,
      email: 0,
      password:0,
      rum_id:0

    }
  };

});
