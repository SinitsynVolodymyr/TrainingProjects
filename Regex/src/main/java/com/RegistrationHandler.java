package com;

import com.view.MessageRequest;
import com.view.View;
import com.view.WrongRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Handler of registration inputs
 */
public class RegistrationHandler {

    private View view;
    private Model model;

    public RegistrationHandler(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public String input(Scanner sc, MessageRequest mess){
        String userRequest;
        List<String> keyList = new ArrayList(Arrays.asList(mess.getKeys()));
        keyList.add(mess.getFormat());
        view.printWithLand(keyList.toArray(new String[0]));
        while(!(sc.hasNext()
                && (userRequest = sc.next()).matches(
                        view.getBundle().getString(mess.getFormat())))) {
            view.printWithLand(WrongRequest.WRONG_REQUEST.getKey());
        }
        return userRequest;
    }

}
