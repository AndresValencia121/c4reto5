package com.cuatroa.retotres.repository.crud;

import java.util.List;

import com.cuatroa.retotres.model.Accessory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author desaextremo
 */
public interface AccesoryCrudRepository extends MongoRepository<Accessory, String> {
    //*Reto 5 metodos
    @Query("{'price': {$lte:?0}}")
    List<Accessory> findByPrice(double price);

    @Query("{'description': {$regex:?0,$options:'i'}}")
    List<Accessory> findByDescription(String description);
}
