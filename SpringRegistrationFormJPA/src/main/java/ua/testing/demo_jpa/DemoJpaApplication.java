package ua.testing.demo_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.testing.demo_jpa.entity.RoleType;
import ua.testing.demo_jpa.entity.User;
import ua.testing.demo_jpa.service.UserService;

@SpringBootApplication
public class DemoJpaApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }

}
