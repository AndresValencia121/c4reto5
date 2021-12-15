package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Andres Valencia Trujillo
 */

@Repository
public class UserRepository {

    @Autowired
    /**
     * Atributo de tipo UserCrudRepository
     */
    private UserCrudRepository userCrudRepository;
    
    /**
     * Metodo que crea una lista con todos los usuarios registrados en la DB.
     * @return una lista creada con el metodo findAll del userCrudRepository
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Metodo que optiene un usuario por medio de su id
     * @param id
     * @return un usuario encontrado por medio del metodo findById(id) del userCrudRepository
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Metodo que crea un usuario en la DB
     * @param user
     * @return el usuario creado mediante el metodo save(user) del userCrudRepository
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Metodo que actualiza los datos de un usuario registrado en la DB
     * @param user
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    
    /**
     * Metodo que borra un usuario de la DB
     * @param user
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    /**
     * Metodo que valida si un email ya existe en la DB
     * @param email
     * @return True si el email existe en la DB. False si el email no existe en la DB
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    /**
     * Metodo mediante el cual un usuario se autentica en la aplicación
     * @param email
     * @param password
     * @return el email y el password del usuario registrado en la DB
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Metodo que optiene el primer usuario registrado por su id
     * @return el primer usuario encontrado en la colección usuario organizada de forma descendente
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    //* Reto 5 metodos
    /**
     * Metodo que optiene un usuario por su mes de cumpleaños
     * @param monthBirthtDay
     * @return El usuario según el criterio de busqueda
     */
    public List<User> getUsersBymonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findmonthBirthDay(monthBirthtDay);
     }
}
