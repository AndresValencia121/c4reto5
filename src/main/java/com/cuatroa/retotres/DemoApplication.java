package com.cuatroa.retotres;
//import com.cuatroa.retotres.model.Accessory;
// import com.cuatroa.retotres.model.Order;
// import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.crud.AccesoryCrudRepository;
import com.cuatroa.retotres.repository.crud.OrderCrudRepository;
import com.cuatroa.retotres.repository.crud.UserCrudRepository;
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private AccesoryCrudRepository crudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll(); 
    }
}
