var app = angular.module('mpsApp', ['ngRoute','ngResource']);

app.config(['$routeProvider','$locationProvider',
    function ($routeProvider) {
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
            when('/:id/list', {
                controller: 'ApplianceUserCtrl',
                templateUrl: 'enterpriseComponents.html'
            }).
            otherwise({
			    redirectTo: '/'
			});
	}
]);

function goBack() {
    window.history.back();
}
