package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The model class from MVC model
 * @author SinitsynVolodymyr
 * @version 0.0.1
 * @since 0.0.1
 */
public class Model {
    /** List of registered users */
    List<User> userList = new ArrayList<>();

    /**
     * Add user object to model
     * @param user - The added user
     */
    public void addUser(User user){
        userList.add(user);
    }


}
