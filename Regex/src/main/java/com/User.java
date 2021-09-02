package com;

public class User {

    String surname;
    String name;
    String patronymic;
    String nick;
    String comment;
    String groupName;
    String mobPhone;
    String homePhone;
    String secMobPhone;
    String email;
    String skype;
    String city;
    Address address;

    public User() {
        this.address = new Address();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getSecMobPhone() {
        return secMobPhone;
    }

    public void setSecMobPhone(String secMobPhone) {
        this.secMobPhone = secMobPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddressIndex(String index) {
        this.address.setIndex(index);
    }

    public void setAddressStreet(String index) {
        this.address.setStreet(index);
    }

    public void setAddressHouseNum(String index) {
        this.address.setHouseNum(index);
    }

    public void setAddressFlatNum(String index) {
        this.address.setFlatNum(index);
    }


    public class Address{
        private String index;
        private String street;
        private String houseNum;
        private String flatNum;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHouseNum() {
            return houseNum;
        }

        public void setHouseNum(String houseNum) {
            this.houseNum = houseNum;
        }

        public String getFlatNum() {
            return flatNum;
        }

        public void setFlatNum(String flatNum) {
            this.flatNum = flatNum;
        }
    }
}
