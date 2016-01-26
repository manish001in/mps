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


  /*  @ResponseBody
    public String create(String entp, String contact) {
        Enterprises enterprise = null;
        try {
            enterprise = new Enterprises(entp, contact);
            enterpriserepo.save(enterprise);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + enterprise.getId() + ")";
    }*/
    @RequestMapping(value="/create" , method = RequestMethod.POST)
    Enterprises add(@RequestBody Enterprises enterprise) {
        System.out.println("name"+ enterprise.getEntpName() +"contact"+ enterprise.getContactPerson() +"");
        return enterpriserepo.save(enterprise);
    }


    @RequestMapping(value = "/view")
    @ResponseBody
    public List<Enterprises> list() {
            List enterprises = enterpriserepo.findAll();
        return enterprises;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    Enterprises update(@PathVariable long id, @RequestBody Enterprises enterprise) {
        System.out.println(id);
        System.out.println(enterprise);
        enterprise.setId(id);
        enterprise.setModifiedDate();
        return enterpriserepo.save(enterprise);

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id) {
        enterpriserepo.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Enterprises get(@PathVariable Long id) {
        return enterpriserepo.findOne(id);
    }

}
/*

@RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Enterprises enterprise = new Enterprises(id);
            enterpriserepo.delete(enterprise);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User successfully deleted!";
    }


    @RequestMapping(value = "/{sort}/{size}/{page}", method = RequestMethod.GET)
    Page<Book> list(@PathVariable String sort, @PathVariable Integer size, @PathVariable Integer page) {
        return (Page<Book>) bookRepository.findAll(new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.ASC,
                sort))));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Book update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id) {
        bookRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Book get(@PathVariable Long id) {
        return bookRepository.findOne(id);
    }



    @RequestMapping("/add")
    @ResponseBody
    public String add(String EntpName, String ContactPerson) {
        Enterprises enterprise = null;
        try {
            user = new User(email, name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    */
/**
     * /delete  --> Delete the user having the passed id.
     *
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     *//*

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    */
/**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     *//*

    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    */
/**
     * /update  --> Update the email and the name for the user in the database
     * having the passed id.
     *
     * @param id The id for the user to update.
     * @param email The new email.
     * @param name The new name.
     * @return A string describing if the user is succesfully updated or not.
     *//*

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
*/


