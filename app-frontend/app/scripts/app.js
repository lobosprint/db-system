'use strict';

/**
 * @ngdoc overview
 * @name appFrontApp
 * @description
 * # appFrontApp
 *
 * Main module of the application.
 */
angular
  .module('appFrontApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/studentHome', {
        templateUrl: 'views/studentHome.html',
        controller: 'StudentHomeCtrl',
        controllerAs: 'studentHome'
      })
      .when('/registrer', {
        templateUrl: 'views/registrer.html',
        controller: 'RegistrerCtrl',
        controllerAs: 'registrer'
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

var app = angular.module('navTurno', []);
app.controller('myCtrl', function($scope) {
    $scope.names = ["Solicitar", "Pendientes"];
});

var app = angular.module('navPenalty', []);
app.controller('myCtrl', function($scope) {
    $scope.names = ["Pagadas", "Pendientes"];
});
