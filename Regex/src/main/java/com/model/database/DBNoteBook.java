package com.model.database;

/**
 * Emulation of database process
 */
public enum DBNoteBook {
    /** The fields of database */
    USER_ONE("misha_kko", "Misha"),
    USER_TWO("NataXa0512", "Natasha"),
    USER_THREE("dimoon3388", "Dima");

    /**
     * Checking if consist user login in database
     * @param checkLogin - check login
     * @return true - this login is included in database
     */
    public static boolean isConsistLogin(String checkLogin){
        for (DBNoteBook userTMP: DBNoteBook.values()){
            if (userTMP.login.equals(checkLogin)){
                return true;
            }
        }
        return false;
    }

    /** user's login */
    private final String login;
    /** user's firstName */
    private final String firstName;

    /**
     * Constructor
     * @param login - login of user
     * @param firstName - firstname of user
     */
    private DBNoteBook(String login, String firstName) {
        this.login = login;
        this.firstName = firstName;
    }

    /**
     * Gets login
     * @return the user's login
     */
    public String login() {
        return login;
    }

    /**
     * Gets firstname
     * @return user's firstname
     */
    public String firstName() {
        return firstName;
    }


}
