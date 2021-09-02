package com;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }


}
