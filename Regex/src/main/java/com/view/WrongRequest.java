package com.view;

/** The object that characterizes a wrong request massage
 * @author SinitsynVolodymyr
 * @version 0.0.1
 * @since 0.0.1
 */
public enum WrongRequest {

    /** Key of wrong request */
    WRONG_REQUEST("input.wrong"),;

    /** The bundle key */
    String keys;

    /**
     * Constructor of WrongRequest
     * @param keys - key of request error
     */
    WrongRequest(String keys) {
        this.keys = keys;
    }

    /**
     * Gets the bundle key
     * @return - the wrong message of bundle key
     *
     */
    public String getKey() {
        return keys;
    }

}
