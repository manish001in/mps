/**
 * @ngdoc service
 * @name mpsApp:Enterprise
 *
 * @description
 *
 *
 * */
app.service('Enterprise', ['$resource',
    function ($resource) {
        var enterprise = $resource('', {},
            {
                getOne: {method: 'GET', isArray: false , url : 'enterprise/:id', params:{id: '@id'}},
                list: {method: 'GET', isArray: true , url : 'enterprise/view'},
                save: {method: 'POST', isArray: false , url : 'enterprise/create'},
                remove: {method: 'DELETE', url:'enterprise/delete/:id', params:{id: '@id'}},
                update: {method: 'PUT', url:'enterprise/update/:id', params:{id: '@id'}}
            });
        return enterprise;
    }]);


