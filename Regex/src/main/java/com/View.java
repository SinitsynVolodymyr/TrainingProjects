package com;

import java.util.Locale;

public class View {

    private Land land = Land.EN;

    public View() {
    }

    public View(Land land) {
        this.land = land;
    }


    enum Land{

        EN(new Locale("en")),
        UA(new Locale("UA","ua"));

        private Locale locale;

        private Land(Locale locale){
            this.locale = locale;
        }

        public Locale getLocale() {
            return locale;
        }
    }

}


