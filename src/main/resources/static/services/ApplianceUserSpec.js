describe('Service: newApp.ApplianceUser', function () {

    // load the service's module
    beforeEach(module('newApp'));

    // instantiate service
    var service;

    //update the injection
    beforeEach(inject(function (_ApplianceUser_) {
        service = _ApplianceUser_;
    }));

    /**
     * @description
     * Sample test case to check if the service is injected properly
     * */
    it('should be injected and defined', function () {
        expect(service).toBeDefined();
    });
});
