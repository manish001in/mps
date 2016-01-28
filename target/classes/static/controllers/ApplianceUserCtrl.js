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
    $scope.idd=$route.current.params.id;
    $scope.enterprise = ApplianceUser.list({id: $route.current.params.id}, function (response) {
            return response;
    });

    $scope.delete = function(enterprise){
        var r = confirm("Do you really want to delete this Enterprise?");
        if (r == true) {
            ApplianceUser.remove(enterprise);
        } else {}
    };

    $scope.components = ApplianceUser.listAU({id: $route.current.params.id}, function (response) {
        return response;
    });

	$scope.edit = function(enterprise){
    	$location.path('/enterprise/update/' + enterprise.id);
    };

    $scope.addA = function(){
        	$location.path($route.current.params.id + '/appliance/add');
    };

    $scope.addU = function(){
        	$location.path($route.current.params.id + '/user/add');
    };

    $scope.editA = function(appliance){
        	$location.path('/appliance/update/' + appliance.id);
    };

    $scope.editU = function(user){
          	$location.path('/user/update/' + user.id);
    };

    $scope.deleteA = function(appliance, index){
            var r = confirm("Do you really want to delete this Appliance at index " + (index+1) + "?");
            if (r == true) {
                ApplianceUser.removeA(appliance);
                var listapp= $scope.components[0];
                delete listapp[index];
                $scope.components[0] = listapp;
            } else {}
    };

    $scope.deleteU = function(user, index){
            var r = confirm("Do you really want to delete this User at index " + (index+1) + "?");
            if (r == true) {
                ApplianceUser.removeU(user);
                var listuser= $scope.components[1];
                delete listuser[index];
                $scope.components[1] = listuser;
            } else {}
    };
    console.log($scope.appliance);
    $scope.addApp = function(){
            appliance = $scope.appliance;
            console.log(appliance);
          	ApplianceUser.saveA({idd: $route.current.params.id},appliance,function (){});
           	$scope.appliance = null;
    };

    $scope.addUser = function(){
            user = $scope.user;
           	ApplianceUser.saveU({idd: $route.current.params.id},user,function (){});
           	$scope.user = null;
    };
/*
    $scope.appliance = ApplianceUser.getA({id: $route.current.params.id});
    	$scope.updateApp = function(){
    		console.log($route.current.params.id);
    		ApplianceUser.updateA($route.current.params.id, $scope.appliance);
    		$scope.appliance = null;
    		//$location.path($rootScope.history.view);
    };

    $scope.user = ApplianceUser.getU({id: $route.current.params.id});
    	$scope.updateUser = function(){
    		console.log($route.current.params.id);
    		ApplianceUser.updateU($route.current.params.id, $scope.user);
    		$scope.user = null;
    		//$location.path($rootScope.history.view);
    };*/

/*
    $scope.add = function(){
           	Enterprise.save($scope.enterprise,function (){});
           	$scope.enterprise = null;
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
