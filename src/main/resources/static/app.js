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
            when('/:id/appliance/add', {
                controller: 'ApplianceUserCtrl',
                templateUrl: 'addAppliance.html'
            }).
            when('/:id/user/add', {
                controller: 'ApplianceUserCtrl',
                templateUrl: 'addUser.html'
            }).
            when('/appliance/update/:id', {
                controller: 'ApplianceUserCtrl',
                templateUrl: 'updateAppliance.html'
            }).
            when('/user/update/:id', {
                controller: 'ApplianceUserCtrl',
                templateUrl: 'updateUser.html'
            }).
            otherwise({
			    redirectTo: '/'
			});
	}
]);

function goBack() {
    window.history.back();
}
