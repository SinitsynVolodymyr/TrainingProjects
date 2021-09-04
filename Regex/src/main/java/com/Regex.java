package com;

import com.view.View;

/**
 * The object of the program start
 */
public class Regex {

    /**
     * The program start method
     * @param args - system arguments (are ignored in this program)
     */
    public static void main(String[] args) {
        View view = new View(View.Land.UA);
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }

}
