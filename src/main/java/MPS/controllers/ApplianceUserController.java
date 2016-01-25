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
    private UserRepository userrepo;


    /*  @ResponseBody
      public String create(String entp, String contact) {
          Enterprises enterprise = null;
          try {
              enterprise = new Enterprises(entp, contact);
              enterpriserepo.save(enterprise);
          } catch (Exception ex) {
              return "Error creating the user: " + ex.toString();
          }
          return "User successfully created! (id = " + enterprise.getId() + ")";
      }*/
    @RequestMapping(value="appliance/add" ,method = RequestMethod.POST)
    Appliance add(@RequestBody Appliance appliance) {
        return appliancerepo.save(appliance);
    }


    @RequestMapping(value = "/{id}/list")
    @ResponseBody
    public LinkedList<List> list(long id) {
        List appliances = appliancerepo.findApplianceByEnt_id(id);
        List users = userrepo.findUsersByEnt_id(id);
        LinkedList<List> together = new LinkedList<List>();
        together.add(appliances);
        together.add(users);
        return together;
    }

    @RequestMapping(value = "appliance/update/{id}", method = RequestMethod.PUT)
    Appliance update(@PathVariable long id, @RequestBody Appliance appliance) {
        appliance.setId(id);
        appliance.setModifiedDate();
        return appliancerepo.save(appliance);

    }

    @RequestMapping(value = "appliance/delete/{id}", method = RequestMethod.DELETE)
    void deleteAppliance(@PathVariable Long id) {
        appliancerepo.delete(id);
    }


    @RequestMapping(value="user/add" , method = RequestMethod.POST)
    Users add(@RequestBody Users user) {
        return userrepo.save(user);
    }


    @RequestMapping(value = "user/update/{id}", method = RequestMethod.PUT)
    Users update(@PathVariable long id, @RequestBody Users user) {
        user.setId(id);
        user.setModifiedDate();
        return userrepo.save(user);

    }

    @RequestMapping(value = "user/delete/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable Long id) {
        userrepo.delete(id);
    }

}
