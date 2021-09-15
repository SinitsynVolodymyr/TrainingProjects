package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 25.01.2016.
 */
public class DriverLicense {
    public enum Category { A,B,C,D,E}
    private List<Category> categories = new ArrayList<Category>();

    private Date fromDate;
    private Date expires;

    public DriverLicense() {
    }

    public DriverLicense(Date expires, List<Category> categories, Date fromDate) {
        this.expires = expires;
        this.categories = categories;
        this.fromDate = fromDate;
    }
    public DriverLicense(Date expires, Category category, Date fromDate) {
        this.expires = expires;
        this.categories.add( category );
        this.fromDate = fromDate;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "DriverLicense{" +
                "categories=" + categories +
                ", fromDate=" + fromDate +
                ", expires=" + expires +
                '}';
    }
}
