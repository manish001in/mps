package MPS.controllers;

/**
 * Created by manish.rastogi on 20/1/16.
 */
import MPS.models.Enterprises;
import MPS.repository.EnterprisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterprisesRepository enterpriserepo;

    @RequestMapping(value="/create" , method = RequestMethod.POST)
    @ResponseBody
    Enterprises add(@RequestBody Enterprises enterprise) {
        System.out.println("name"+ enterprise.getEntpName() +"contact"+ enterprise.getContactPerson() +"");
        return enterpriserepo.save(enterprise);
    }


    @RequestMapping(value = "/view")
    @ResponseBody
    public List<Enterprises> list() {
            List enterprises = enterpriserepo.findAll();
        System.out.println(enterprises.get(0));
        return enterprises;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Enterprises update(@PathVariable("id") Long id, @RequestBody Enterprises enterprise) {
        System.out.println(id);
        System.out.println(enterprise);
        Enterprises enterpriseOld= enterpriserepo.findById(id);
        //enterprise.setId(id);
        enterpriseOld.setEntpName(enterprise.getEntpName());
        enterpriseOld.setContactPerson(enterprise.getContactPerson());
        enterpriseOld.setModifiedDate();
        return enterpriserepo.save(enterpriseOld);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void delete(@PathVariable Long id) {
        enterpriserepo.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    Enterprises get(@PathVariable("id") Long id) {
        Enterprises enterprise=enterpriserepo.findEnterprise(id);
        System.out.println(enterprise);
        return enterprise;
    }

}
