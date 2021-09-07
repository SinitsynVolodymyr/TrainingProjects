package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The container of users
 * @author SinitsynVolodymyr
 * @version 0.0.3
 * @since 0.0.3
 */
public class NoteBook {

    /** List of registered users */
    List<User> userList = new ArrayList<>();

    /**
     * Add user object to NoteBook
     * @param user - The added user
     */
    public void addUser(User user){
        userList.add(user);
    }


}
