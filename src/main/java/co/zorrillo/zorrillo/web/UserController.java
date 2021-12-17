package co.zorrillo.zorrillo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.zorrillo.zorrillo.model.User;
import co.zorrillo.zorrillo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
/**
* clase controlador
*/
public class UserController {
    @Autowired
    private UserService userService;
    /**
    * peticion
    */
    @GetMapping("/all")
    /**
    * get
    */
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
    * petiicion get
    */
    @GetMapping("/{id}")
    /**
    * optional
    */
    public Optional <User> getUser(@PathVariable("id") int id) {
            return userService.getUser(id);
    }
    /**
    * post
    */
    @PostMapping("/new")
    /**
    * status
    */
    @ResponseStatus(HttpStatus.CREATED)
    /**
    * borrar
    */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    /**
    * update
    */
    @PutMapping("/update")
    /**
    * status
    */
    @ResponseStatus(HttpStatus.CREATED)
    /**
    * actualizar
    */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    /**
    * borrar
    */
    @DeleteMapping("/{id}")
    /**
    * status
    */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
    * borrar
    */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
      /**
    * peticion get
    */
    @GetMapping("/{email}/{password}")
    /**
    * autenticar usuario
    */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
    * peticion get
    */
    @GetMapping("/emailexist/{email}")
    /**
    * veriricar email
    */
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.emailExist(email);
    }
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}
    