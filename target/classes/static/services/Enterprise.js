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
                list: {method: 'GET', isArray: true , url : 'enterprise/view'},
                save: {method: 'POST', isArray: true , url : 'enterprise/create'},
                remove: {method: 'DELETE', url:'enterprise/delete/:id', params:{id: '@id'}},
                update: {method: 'PUT', url:'enterprise/update/:id', params:{id: '@id'}}
            });
        return enterprise;
    }]);


