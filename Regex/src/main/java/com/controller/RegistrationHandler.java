package com.controller;

import com.model.Model;
import com.view.MessageRequest;
import com.view.View;
import com.view.WrongRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Handler of registration inputs
 * @author SinitsynVolodymyr
 * @version 0.0.1
 * @since 0.0.1
 */
public class RegistrationHandler {

    /** The view object from MVC model */
    private View view;
    /** The model object from MVC model */
    private Model model;

    /**
     * Constructor of the RegistrationHandler
     * @param view - The view object from MVC model
     * @param model - The model object from MVC model
     */
    public RegistrationHandler(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    /**
     * The input user request registration handler
     * @param sc - The console scanner
     * @param mess - The message request to user
     * @return The right user answer
     */
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
