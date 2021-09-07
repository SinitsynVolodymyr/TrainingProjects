package com.controller;

import com.model.Model;
import com.model.User;
import com.model.database.DBNoteBook;
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

    public User registerUser(Scanner sc){
        User user = new User();

        user.setName(input(sc,MessageRequest.INPUT_FIRSTNAME_FORMAT));
        user.setLogin(inputLogin(sc,MessageRequest.INPUT_LOGIN_FORMAT));


        /* //Disable unimportant fields
        user.setSurname(regHandler.input(sc,MessageRequest.INPUT_SURNAME_FORMAT));
        user.setPatronymic(regHandler.input(sc,MessageRequest.INPUT_PATRONYMIC_FORMAT));
        user.setNick(regHandler.input(sc,MessageRequest.INPUT_NICK_FORMAT));
        user.setComment(regHandler.input(sc,MessageRequest.INPUT_COMMENT_FORMAT));
        user.setGroupName(regHandler.input(sc,MessageRequest.INPUT_GROUP_FORMAT));
        user.setHomePhone(regHandler.input(sc,MessageRequest.INPUT_HOMEPHONE_FORMAT));
        user.setMobPhone(regHandler.input(sc,MessageRequest.INPUT_MOBPHONE_FORMAT));
        user.setSecMobPhone(regHandler.input(sc,MessageRequest.INPUT_SECPHONE_FORMAT));
        user.setEmail(regHandler.input(sc,MessageRequest.INPUT_EMAIL_FORMAT));
        user.setSkype(regHandler.input(sc,MessageRequest.INPUT_SKYPE_FORMAT));
        user.setCity(regHandler.input(sc,MessageRequest.INPUT_CITY_FORMAT));
        user.setAddressIndex(regHandler.input(sc,MessageRequest.INPUT_INDEX_FORMAT));
        user.setAddressStreet(regHandler.input(sc,MessageRequest.INPUT_STREET_FORMAT));
        user.setAddressHouseNum(regHandler.input(sc,MessageRequest.INPUT_HOUSENUM_FORMAT));
        user.setAddressFlatNum(regHandler.input(sc,MessageRequest.INPUT_FLATNUM_FORMAT));
        */
        return user;
    }



    /**
     * The input user request registration handler
     * @param sc - The console scanner
     * @param mess - The message request to user
     * @return The right user answer
     */
    private String input(Scanner sc, MessageRequest mess){
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

    private String inputLogin(Scanner sc, MessageRequest mess){
        String login = "";
        while (DBNoteBook.isConsistLogin(login = input(sc,mess))){
            view.printWithLand(WrongRequest.NOT_UNIQUE_LOGIN.getKey());
        }
        return login;
    }

}
