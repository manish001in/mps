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
        $location.path('/enterprise/view');
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
        	$rootScope.applianceOld = ApplianceUser.getA({id: appliance.id}, function (response){
                return response;
            });

    };

    $scope.editU = function(user){
          	$location.path('/user/update/' + user.id);
          	$rootScope.userOld = ApplianceUser.getU({id: user.id}, function (response){
                return response;
            });
    };

    $scope.deleteA = function(appliance, index){
            var r = confirm("Do you really want to delete this Appliance at index " + (index+1) + "?");
            if (r == true) {
                ApplianceUser.removeA(appliance);
                var listApp= $scope.components[0];
                delete listApp[index];
                $scope.components[0] = listApp;
            } else {}
    };

    $scope.deleteU = function(user, index){
            var r = confirm("Do you really want to delete this User at index " + (index+1) + "?");
            if (r == true) {
                ApplianceUser.removeU(user);
                var listUser= $scope.components[1];
                delete listUser[index];
                $scope.components[1] = listUser;
            } else {}
    };

    $scope.addApp = function(){
            appliance = $scope.appliance;
          	ApplianceUser.saveA({idd: $route.current.params.id},appliance,function (){});
           	$scope.appliance = null;
    };

    $scope.addUser = function(){
            user = $scope.user;
           	ApplianceUser.saveU({idd: $route.current.params.id},user,function (){});
           	$scope.user = null;
    };

    $scope.updateApp = function(){
        	appliance=$scope.appliance;
    		ApplianceUser.update({id : $route.current.params.id}, appliance , function (){});
    		$scope.appliance = null;
    	};

	$scope.updateUser = function(){
    	user=$scope.user;
		ApplianceUser.update({id : $route.current.params.id}, user , function (){});
		$scope.user = null;
	};

}]);
