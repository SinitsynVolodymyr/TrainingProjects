package com;

import com.view.MessageRequest;
import com.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private RegistrationHandler regHandler;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.regHandler = new RegistrationHandler(view, model);
    }

    /**
     * The user request handler method
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        User user = new User();

        user.setSurname(regHandler.input(sc,MessageRequest.INPUT_SURNAME_FORMAT));
        user.setName(regHandler.input(sc,MessageRequest.INPUT_FIRSTNAME_FORMAT));
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

        model.addUser(user);
    }

}
