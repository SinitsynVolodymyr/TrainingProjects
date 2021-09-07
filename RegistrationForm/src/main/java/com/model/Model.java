package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The model class from MVC model
 * @author SinitsynVolodymyr
 * @version 0.0.2
 * @since 0.0.1
 */
public class Model {
    /** The users NoteBook */
    private NoteBook noteBook;

    /**
     * Constructor of Model
     * Init a NoteBook object
     */
    public Model() {
        this.noteBook = new NoteBook();
    }

    /**
     * Gets a NoteBook object
     * @return NoteBook with user list inside
     */
    public NoteBook getNoteBook() {
        return noteBook;
    }

}
