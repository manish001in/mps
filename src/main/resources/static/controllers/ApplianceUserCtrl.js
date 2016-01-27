/**
 * @ngdoc controller
 * @name mpsApp:ApplianceUserCtrl
 *
 * @description
 *
 *
 * @requires $scope
 * */
app.controller('ApplianceUserCtrl', ['$scope', 'ApplianceUser','$route', '$location','$rootScope', function($scope, ApplianceUser, $route, $location, $rootScope) {

    $scope.enterprise = ApplianceUser.list({id: $route.current.params.id}, function (response) {
            return response;
            });

    $scope.delete = function(enterprise){
        var r = confirm("Do you really want to delete this Enterprise?");
        if (r == true) {
            ApplianceUser.remove(enterprise);
        } else {}
    };

	$scope.edit = function(enterprise){
    	$location.path('/enterprise/update/' + enterprise.id);
    };


/*
    $scope.add = function(){
           	Enterprise.save($scope.enterprise,function (){});
           	$scope.enterprise = null;
    	};



    $scope.show = function(enterprise){
      	$location.path('/' + enterprise[0] + '/list');
    };


	$scope.enterprise = Enterprise.get({id: $route.current.params.id});
	$scope.update = function(){
		console.log($route.current.params.id);
		Enterprise.update($route.current.params.id, $scope.enterprise);
		$scope.enterprise = null;
		//$location.path($rootScope.history.view);
	};

*/
}]);
