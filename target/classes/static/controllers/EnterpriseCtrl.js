/**
 * @ngdoc controller
 * @name mpsApp:showEnterpriseCtrl
 *
 * @description
 *
 *
 * @requires $scope
 * */
app.controller('EnterpriseCtrl', ['$scope', 'Enterprise','$route', '$location','$rootScope', function($scope, Enterprise, $route, $location, $rootScope) {

    $scope.enterprises = Enterprise.list({}, function (response) {
            return response;
            });

    $scope.add = function(){
           	Enterprise.save($scope.enterprise,function (){});
           	$scope.enterprise = null;
    	};

    $scope.delete = function(enterprise, index){
    var r = confirm("Do you really want to delete an Enterprise at index " + (index+1) + "?");
    if (r == true) {
        Enterprise.remove(enterprise);
		$scope.enterprises.splice(index, 1);
    } else {}
	};

    if(!isNaN($route.current.params.id)){
            $scope.enterpriseOld = Enterprise.getOne({id: $route.current.params.id}, function (response){
                return response;
            });
    }

	$scope.update = function(){
    	enterprise=$scope.enterprise;
		Enterprise.update({id : $route.current.params.id}, enterprise , function (){});
		$scope.enterprise = null;
	};

    $scope.show = function(enterprise){
      	$location.path('/' + enterprise.id + '/list');
    };

	$scope.edit = function(enterprise){
    	$location.path('/enterprise/update/' + enterprise.id);
    };

}]);
