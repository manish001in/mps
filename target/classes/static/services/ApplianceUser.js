/**
 * @ngdoc service
 * @name newApp:ApplianceUser
 *
 * @description
 *
 *
 * */
app.service('ApplianceUser', ['$resource',
    function ($resource) {
        var components = $resource('', {},
            {
                list: {method: 'GET', isArray: false , url : 'enterprise/:id'},
                remove: {method: 'DELETE', url:'enterprise/delete/:id', params:{id: '@id'}},
                update: {method: 'PUT', url:'enterprise/update/:id', params:{id: '@id'}},

                listAU: {method: 'GET', isArray: true , url : ':id/list', params:{id: '@id'}},

                saveA: {method: 'POST', isArray: false , url : ':id/appliance/add', params:{id: '@id'}},
                removeA: {method: 'DELETE', url:'appliance/delete/:id', params:{id: '@id'}},
                updateA: {method: 'PUT', url:'appliance/update/:id', params:{id: '@id'}},

                saveU: {method: 'POST', isArray: false , url : ':id/user/add', params:{id: '@id'}},
                removeU: {method: 'DELETE', url:'user/delete/:id', params:{id: '@id'}},
                updateU: {method: 'PUT', url:'user/update/:id', params:{id: '@id'}}
            });
        return components;
    }]);

