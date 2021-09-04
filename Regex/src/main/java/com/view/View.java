package com.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The view class from MVC model
 * @author SinitsynVolodymyr
 * @version 0.0.2
 * @since 0.0.1
 */
public class View {
    /** The locale value  */
    private Land land = Land.EN;
    /** The bundle value  */
    private ResourceBundle bundle;

    /**
     * Constructor - create a default view object
     * land parameter is EN
     */
    public View() {
        initBundle();
    }

    /**
     * Constructor - create a view object which the follow parameter
     * @param land - the locale value
     */
    public View(Land land) {
        this.land = land;
        initBundle();
    }

    /**
     * Init the bundle parameter
     */
    private void initBundle(){
        bundle = ResourceBundle.getBundle(
                "land"
                ,land.getLocale());
    }

    /**
     * Shows the message to user
     * @param mess - display massage
     */
    public void print(String mess){System.out.println(mess);}

    /**
     * Constructs the concatenation message by using bungle and shows it to user
     * @param keys - keys of bundle
     */
    public void printWithLand(String[] keys){
        StringBuffer strLine = new StringBuffer();
        for (String keyTmp : keys) {
            strLine.append(bundle.getString(keyTmp));
            strLine.append(" ");
        }
        print(strLine.toString());
    }

    /**
     * Shows a bundle message
     * @param key - key of bundle
     */
    public void printWithLand(String key){
        String strLine = bundle.getString(key);
        print(strLine);
    }

    /**
     * Gets the locale
     * @return - current locale
     */
    public Land getLand() {
        return land;
    }

    /**
     * Gets the bundle
     * @return - The current ResourceBundle
     */
    public ResourceBundle getBundle() {
        return bundle;
    }

    /**
     * The object that characterizes a local
     * @author SinitsynVolodymyr
     * @version 0.0.1
     * @since 0.0.1
     */
    public enum Land{
        /**
         * List of local
         */
        EN(new Locale("en")),
        UA(new Locale("ua", "UA"));

        /**
         * Current local
         */
        private Locale locale;

        /**
         * Private constructor
         * @param locale - necessary locale
         */
        private Land(Locale locale){
            this.locale = locale;
        }

        /**
         * Gets the current local
         * @return - The current local
         */
        public Locale getLocale() {
            return locale;
        }
    }

}


