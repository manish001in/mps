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

    @RequestMapping(value="{idd}/appliance/add" , method = RequestMethod.POST)
    @ResponseBody
    Appliance addAppliance(@PathVariable("idd") Enterprises idd , @RequestBody Appliance appliance) {
        appliance.setEnterprise(idd);
        appliance.setCreatedDate();
        return appliancerepo.save(appliance);
    }

    @RequestMapping(value = "appliance/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Appliance updateAppliance(@PathVariable("id") Long id, @RequestBody Appliance appliance) {
        Appliance applianceOld= appliancerepo.findById(id);
        applianceOld.setAppName(appliance.getAppName());
        applianceOld.setparam1(appliance.getparam1());
        applianceOld.setparam2(appliance.getparam2());
        applianceOld.setparam3(appliance.getparam3());
        applianceOld.setModifiedDate();
        return appliancerepo.save(applianceOld);

    }

    @RequestMapping(value = "appliance/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteAppliance(@PathVariable("id") Long id) {
        appliancerepo.delete(id);
    }

    @RequestMapping(value = "appliance/{id}", method = RequestMethod.GET)
    @ResponseBody
    Appliance getA(@PathVariable("id") Long id) {
        Appliance appliance=appliancerepo.findAppliance(id);
        System.out.println(appliance);
        return appliance;
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
        Users userOld= userrepo.findById(id);
        userOld.setName(user.getName());
        userOld.setPasscode(user.getPasscode());
        user.setModifiedDate();
        return userrepo.save(userOld);
    }

    @RequestMapping(value = "user/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteUser(@PathVariable("id") Long id) {
        userrepo.delete(id);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    Users getU(@PathVariable("id") Long id) {
        Users user = userrepo.findUser(id);
        System.out.println(user);
        return user;
    }


}
