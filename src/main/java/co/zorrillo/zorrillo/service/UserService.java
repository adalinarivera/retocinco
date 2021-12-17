package co.zorrillo.zorrillo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.zorrillo.zorrillo.model.User;
import co.zorrillo.zorrillo.repository.UserRepository;
/**
 *Establece la logica de las diferentes consultas del programa
 * @author ada
 */
@Service
public class UserService {
    /**
    *Relacionar la capa repositorio con la logica de servicio
    * 
    */
    @Autowired
    private UserRepository userRepository;
    /**
    *Logica para listar todos los usuarios existentes
    * 
    */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
    *Logica para consultar usuarios por id
    * 
    */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
    /**
    *Logica para para la creacion de usuarios
    * 
    */
    public User create(User user) {
        if (user.getId() == null) {
            return user;            
        }else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExist(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }           
        }
    }
    /**
    *Logica para para la actualizacion de usuarios
    * 
    */
    public User update(User user) {        
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
    *Logica para el borrado de usuarios
    * 
    */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
    *Validación de email en la base de datos
    * 
    */
    public boolean emailExist(String email) {
        return userRepository.emailExist(email);
    }
    /**
    *Validación de email y clave en la base de datos
    * 
    */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}
