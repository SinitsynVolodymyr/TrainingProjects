package ua.testing.demo_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.testing.demo_jpa.dto.UserDTO;
import ua.testing.demo_jpa.dto.UsersDTO;
import ua.testing.demo_jpa.entity.RoleType;
import ua.testing.demo_jpa.entity.User;
import ua.testing.demo_jpa.service.UserService;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class LoginFormController {

    private final UserService userService;

    @Autowired
    public LoginFormController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    //@RequestMapping(value = "login", method = RequestMethod.POST)
    @PostMapping(value = "login")
    public void loginFormController(UserDTO user){
        log.info("{}",userService.findByUserLogin(user));
        log.info("{}", user);

       userService.saveNewUser(User.builder()
                .firstName("Ann")
                .lastName("Reizer")
                .email("AnnReizer@testing.ua")
                .role(RoleType.ROLE_USER)
                .build());

       userService.saveNewUser(User.builder()
                .firstName("Misha")
                .lastName("Oduha")
                .email("MishaOduha@testing.ua")
                .role(RoleType.ROLE_USER)
                .build());

       userService.saveNewUser(User.builder()
                .firstName("Andriy")
                .lastName("Hmelnik")
                .email("AndriyHmelnik@testing.ua")
                .role(RoleType.ROLE_ADMIN)
                .build());

       userService.saveNewUser(User.builder()
                .firstName("Oleg")
                .lastName("Shevchenko")
                .email("OlegShevchenko@testing.ua")
                .role(RoleType.ROLE_SUPERADMIN)
                .build());



    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UsersDTO getAllUser(){
        log.info("{}",userService.getAllUsers());
        return userService.getAllUsers();
    }
}
