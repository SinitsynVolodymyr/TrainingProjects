package com;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The view class from MVC model
 * @author SinitsynVolodymyr
 * @version 0.0.1
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
     * @param keys
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
     * Gets the locale
     * @return
     */
    public Land getLand() {
        return land;
    }

    /**
     * The object that characterizes a local
     * @author SinitsynVolodymyr
     * @version 0.0.1
     * @since 0.0.1
     */
    enum Land{
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
         * @return
         */
        public Locale getLocale() {
            return locale;
        }
    }

}


