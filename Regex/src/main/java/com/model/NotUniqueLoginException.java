package com.model;

/**
 * The checked exception
 * @author VolodymyrSinitsyn
 * @version 0.0.1
 * @since 0.0.3
 */
public class NotUniqueLoginException extends Exception{
    /** not unique login */
    private final String login;

    /**
     * Constructor of exception
     * @param login - not unique login
     */
    public NotUniqueLoginException(String login) {
        this.login = login;
    }

    /**
     * Custom showing message
     * @return
     */
    @Override
    public String getMessage() {
        return "The login: "+login+" exists in a DataBase";
    }

    /**
     * Gets the login
     * @return not unique login
     */
    public String getLogin() {
        return login;
    }

}
