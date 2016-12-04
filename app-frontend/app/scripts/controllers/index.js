'use strict';

/**
 * @ngdoc function
 * @name appFrontApp.controller:IndexCtrl
 * @description
 * # IndexCtrl
 * Controller of the appFrontApp
 */
angular.module('appFrontApp')
  .controller('IndexCtrl', function ($scope, $location, $log) {
    $scope.navDefault = false;
    $scope.navAdmin = false;
    $scope.navStudent = false;
$log.error($location.path());
    if ($location.path() == "/" || $location.path() == "/registrer" || $location.path() == "/closeSession") {
        $scope.navDefault = true;
        $scope.navAdmin = false;
        $scope.navStudent = false;
    } else if ($location.path() == "/registrerConfirm" || $location.path() == "/studentConfirmPayment" || $location.path() == "/studentConfirmTicket" || $location.path() == "/studentGetTurn" || $location.path() == "/studentHome" || $location.path() == "/studentListTurns" || $location.path() == "/studentPayPenalty" || $location.path() == "/studentPaymentsView" || $location.path() == "/studentPenaltiesView") {
        $scope.navDefault = false;
        $scope.navAdmin = false;
        $scope.navStudent = true;
    } else if ($location.path() == "/registrerConfirm" || $location.path() == "/adminCurrentTurn" || $location.path() == "/adminHome" || $location.path() == "/adminPassTurn" || $location.path() == "/adminPendingTurns" || $location.path() == "/adminTurnQueue" || $location.path() == "/adminTurnsHistory") {
        $scope.navDefault = false;
        $scope.navAdmin = true;
        $scope.navStudent = false;
    }
  });
