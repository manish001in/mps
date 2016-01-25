describe('Service: mpsApp.Enterprise', function () {

    // load the service's module
    beforeEach(module('mpsApp'));

    // instantiate service
    var service;

    //update the injection
    beforeEach(inject(function (_Enterprise_) {
        service = _Enterprise_;
    }));

    /**
     * @description
     * Sample test case to check if the service is injected properly
     * */
    it('should be injected and defined', function () {
        expect(service).toBeDefined();
    });
});
