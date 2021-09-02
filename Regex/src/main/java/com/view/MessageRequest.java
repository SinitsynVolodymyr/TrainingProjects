package com.view;

public enum MessageRequest {

    INPUT_SURNAME_FORMAT(
            new String[]{"input.data", "input.surname", "input.format"}
            ,"format.surname"),
    INPUT_FIRSTNAME_FORMAT(
            new String[]{"input.data", "input.firstname", "input.format"}
            ,"format.firstname"),
    INPUT_PATRONYMIC_FORMAT(
            new String[]{"input.data", "input.patronymic", "input.format"}
            ,"format.patronymic"),
    INPUT_NICK_FORMAT(
            new String[]{"input.data", "input.nick", "input.format"}
            ,"format.nick"),
    INPUT_COMMENT_FORMAT(
            new String[]{"input.data", "input.comment", "input.format"}
            ,"format.comment"),
    INPUT_GROUP_FORMAT(
            new String[]{"input.data", "input.group", "input.format"}
            ,"format.group"),
    INPUT_HOMEPHONE_FORMAT(
            new String[]{"input.data", "input.homePhone", "input.format"}
            ,"format.homePhone"),
    INPUT_MOBPHONE_FORMAT(
            new String[]{"input.data", "input.mobPhone", "input.format"}
            ,"format.mobPhone"),
    INPUT_SECPHONE_FORMAT(
            new String[]{"input.data", "input.secMobPhone", "input.format"}
            ,"format.secMobPhone"),
    INPUT_EMAIL_FORMAT(
            new String[]{"input.data", "input.e-mail", "input.format"},
            "format.e-mail"),
    INPUT_SKYPE_FORMAT(
            new String[]{"input.data", "input.skype", "input.format"}
            ,"format.skype"),
    INPUT_INDEX_FORMAT(
            new String[]{"input.data", "input.address.index", "input.format"}
            ,"format.address.index"),
    INPUT_CITY_FORMAT(
            new String[]{"input.data", "input.address.city", "input.format"}
            ,"format.address.city"),
    INPUT_STREET_FORMAT(
            new String[]{"input.data", "input.address.street", "input.format"}
            ,"format.address.street"),
    INPUT_HOUSENUM_FORMAT(
            new String[]{"input.data", "input.address.houseNum", "input.format"}
            ,"format.address.houseNum"),
    INPUT_FLATNUM_FORMAT(
            new String[]{"input.data", "input.address.flatNum", "input.format"}
            ,"format.address.flatNum"),
    ;

    private String keys[];
    private String format;


    MessageRequest(String[] keys, String format) {
        this.keys = keys;
        this.format = format;
    }

    public String[] getKeys() {
        return keys;
    }

    public String getFormat() {
        return format;
    }
}
