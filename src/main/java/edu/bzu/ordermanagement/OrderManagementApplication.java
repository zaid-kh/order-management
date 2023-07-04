package edu.bzu.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OrderManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "This is the root page of the Order Management Application. Please use the API endpoints to interact with the application.";
    }

}
