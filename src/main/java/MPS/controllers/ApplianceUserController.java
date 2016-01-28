package MPS.controllers;

/**
 * Created by manish.rastogi on 20/1/16.
 */
import MPS.models.Appliance;
import MPS.models.Enterprises;
import MPS.models.Users;
import MPS.repository.ApplianceRepository;
import MPS.repository.EnterprisesRepository;
import MPS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ApplianceUserController {

    @Autowired
    private ApplianceRepository appliancerepo;
    @Autowired
    private UserRepository userrepo;

    @RequestMapping(value="{idd}/appliance/add" , method = RequestMethod.POST)
    @ResponseBody
    Appliance addAppliance(@PathVariable("idd") Enterprises idd , @RequestBody Appliance appliance) {
        appliance.setEnterprise(idd);
        appliance.setCreatedDate();
        return appliancerepo.save(appliance);
    }


    @RequestMapping(value = "{id}/list", method = RequestMethod.GET)
    @ResponseBody
    public LinkedList<List> listStuff(@PathVariable("id") Enterprises id) {
        List<Appliance> appliances = appliancerepo.findApplianceByEnt_id(id);
        List<Users> users = userrepo.findUsersByEnt_id(id);
        LinkedList<List> together = new LinkedList<List>();
        together.add(appliances);
        together.add(users);
        return together;
    }

    @RequestMapping(value = "appliance/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Appliance updateAppliance(@PathVariable("id") Long id, @RequestBody Appliance appliance) {
        appliance.setId(id);
        appliance.setModifiedDate();
        return appliancerepo.save(appliance);

    }

    @RequestMapping(value = "appliance/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteAppliance(@PathVariable("id") Long id) {
        appliancerepo.delete(id);
    }


    @RequestMapping(value="{idd}/user/add" , method = RequestMethod.POST)
    @ResponseBody
    Users addUser(@PathVariable("idd") Enterprises idd ,@RequestBody Users user) {
        user.setEnterprise(idd);
        user.setCreatedDate();
        return userrepo.save(user);
    }


    @RequestMapping(value = "user/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Users updateUser(@PathVariable("id") Long id, @RequestBody Users user) {
        user.setId(id);
        user.setModifiedDate();
        return userrepo.save(user);

    }

    @RequestMapping(value = "user/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteUser(@PathVariable("id") Long id) {
        userrepo.delete(id);
    }

}
