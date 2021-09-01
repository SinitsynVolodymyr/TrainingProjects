package com;

import java.util.Locale;

public class View {


    enum Land{

        EN(new Locale("en")),UA(new Locale("UA","ua"));

        private Locale locale;

        private Land(Locale locale){
            this.locale = locale;
        }

        public Locale getLocale() {
            return locale;
        }
    }

}


