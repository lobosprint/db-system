'use strict';

/**
* @ngdoc function
* @name appFrontApp.controller:AdminCurrentTurnCtrl
* @description
* # AdminCurrentTurnCtrl
* Controller of the appFrontApp
*/
angular.module('appFrontApp')
.controller('AdminCurrentTurnCtrl',['$http','$log','$scope','turnService','$timeout' ,function ($http, $log,$scope,turnService, $timeout) {
  //turnVariable is shared between this and adminPendingTurns
  $scope.turnVariable=turnService.sharedObject;
  $scope.comments=[];
  $scope.comment="";
  $scope.commentInfo={
    description:"test",
    id_turn:0
  }
  $scope.timer={
    seconds:0
  };
  $scope.student=[];
  $http.get('/app-backend/getTurn/'.concat($scope.turnVariable.turnID)).success(function(data){
    $scope.student=data;
    //$log.error(data);
  });
  $http.get('/app-backend/getAllCommentsByTurn/'.concat($scope.turnVariable.turnID)).success(function(data){

    $scope.comments=data;
    $log.error(data);
    //$log.error(data);
  });
  $scope.activateTimer=function(){
    $scope.updateValue = function(){

      $timeout(function(){
        $scope.timer.seconds++ ;
        $scope.updateValue();
        $log.error("clicked");
        $log.error($scope.timer.seconds);
      },1000);
    }
    $scope.updateValue();
  }

  $scope.postComment= function(){

    $scope.commentInfo.description=$scope.comment;
    $scope.commentInfo.id_turn=$scope.turnVariable.turnID;
    $http.post('/app-backend/addComment',$scope.commentInfo).success(function(){
      $http.get('/app-backend/getAllCommentsByTurn/'.concat($scope.turnVariable.turnID)).success(function(data){
        $scope.comments=data;
        $scope.comment="";
        //$log.error(data);
      });
    });
  };
$scope.startTime=function(){
      $scope.commentInfo.id_turn=$scope.turnVariable.turnID;
      $log.error("id-turn: "+$scope.commentInfo.id_turn);
      $http.post('/app-backend/addStartTimeTurn',$scope.commentInfo).success(function(data){
        $log.error('starttimePosted');
      });



};

$scope.finishTime=function(){
      $scope.commentInfo.id_turn=$scope.turnVariable.turnID;
      $http.post('/app-backend/addFinishTime',$scope.commentInfo).success(function(data){
        $log.error('finishTimePosted');
      });
      $http.post('/app-backend/addAttended',$scope.commentInfo).success(function(data){
        $log.error('attendendTurn');
      })};
}]);

// (function(){
// 	var app= angular.module('appFrontApp',[]);

// 	app.controller('AdminCurrentTurnCtrl',function(){
// 	var testing='123444';
// 	});
// })
