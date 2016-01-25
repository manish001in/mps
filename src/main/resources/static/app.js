var app = angular.module('mpsApp', ['ngRoute','ngResource']);

app.config(['$routeProvider','$locationProvider',
    function ($routeProvider,$locationProvider) {
		$routeProvider.
		    when('/', {
                templateUrl: 'home.html'
            }).
            when('/enterprise/view', {
                controller: 'EnterpriseCtrl',
                templateUrl: 'showEnterprise.html'
            }).
            when('/enterprise/add', {
                controller: 'EnterpriseCtrl',
                templateUrl: 'addEnterprise.html'
            }).
            when('/enterprise/update/:id', {
                controller: 'EnterpriseCtrl',
                templateUrl: 'updateEnterprise.html'
            }).
            otherwise({
			    redirectTo: '/'
			});
	}
]);

function goBack() {
    window.history.back();
}
