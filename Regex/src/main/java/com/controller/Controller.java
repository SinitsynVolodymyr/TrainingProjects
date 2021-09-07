package com.controller;

import com.model.Model;
import com.model.User;
import com.model.database.DBNoteBook;
import com.view.MessageRequest;
import com.view.View;
import com.view.WrongRequest;

import java.util.Scanner;

/**
 * The controller class from MVC model
 * @author SinitsynVolodymyr
 * @version 0.0.1
 * @since 0.0.1
 */
public class Controller {
    /** The model object from MVC model */
    private Model model;
    /** The view object from MVC model */
    private View view;
    /** The object that processes registration*/
    private RegistrationHandler regHandler;

    /**
     * Constructor of controller
     * @param model - The model object from MVC model
     * @param view - The view object from MVC model
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.regHandler = new RegistrationHandler(view, model);
    }

    /**
     * The user request handler method.
     * This method creates user object and adds this user in MVC model
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        User user = regHandler.registerUser(sc);
        model.getNoteBook().addUser(user);
    }

}
