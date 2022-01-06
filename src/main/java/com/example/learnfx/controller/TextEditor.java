package com.example.learnfx.controller;

import com.example.learnfx.io.files.FileType;
import com.example.learnfx.io.files.read.FileReader;
import com.example.learnfx.io.files.write.FileWriter;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class TextEditor {

    // used to load and save files in the editor
    private final FileChooser fileChooser = initialiseFileChooser();

    // whether the user is currently writing in the editor
    private boolean editorFocused = false;

    // =====================================
    //               BUTTONS
    // =====================================

    /**
     * Called when pressing the reset button in the editor
     * @param textArea (TextArea): the textArea being affected
     */
    public void resetText(TextArea textArea) {
        textArea.setText("...");
    }

    /**
     * Called when pressing the save button in the editor
     * @param textArea (TextArea): the textArea being affected
     */
    public void saveText(TextArea textArea, String path) {
        fileChooser.setTitle("Save File");

        // the types of files which can be saved to by the user
        FileChooser.ExtensionFilter anyFilter = new FileChooser.ExtensionFilter("ALL FILES (*)", "*");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("TXT (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().addAll(txtFilter, anyFilter);
        // by default, text files are saved
        fileChooser.setSelectedExtensionFilter(txtFilter);

        // the file which the user wishes to save
        File fileToSave = fileChooser.showSaveDialog(new Stage());

        // if the user hasn't specified any file, does not save it
        if (fileToSave == null) return;

        // gets the file format which the user selected
        final String fileFormat = fileChooser.getSelectedExtensionFilter().getExtensions().get(0);

        // saves the file under the selected format
        switch (fileFormat) {
            case "*.txt" -> FileWriter.writeText(fileToSave, textArea.getText(), FileType.TXT);
            default -> FileWriter.writeText(fileToSave, textArea.getText(), FileType.ALL_FILE_TYPE);
        }
    }

    /**
     * Called when pressing the load button in the editor
     * @param textArea (TextArea): the textArea being affected
     */
    public void loadText(TextArea textArea) {
        fileChooser.setTitle("Load File");

        // the types of files which can be loaded
        FileChooser.ExtensionFilter anyFilter = new FileChooser.ExtensionFilter("ALL FILES (*)", "*");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("TXT (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().addAll(anyFilter, txtFilter);
        // by default, only text file can be opened
        fileChooser.setSelectedExtensionFilter(txtFilter);

        // the file which the user has loaded
        File fileToLoad = fileChooser.showOpenDialog(new Stage());

        // if the user hasn't selected a file, does not load it
        if (fileToLoad == null) return;

        // load the file selected buy the user
        textArea.setText(FileReader.readText(fileToLoad));
    }

    // =====================================
    //              SHORTCUTS
    // =====================================

    /**
     * Called when the user clicks in the editor text area
     * @param textEditArea (TextArea): the textArea being affected
     */
    public void selectAllText(TextArea textEditArea) {
        if (editorFocused) return;

        textEditArea.selectAll();
        editorFocused = true;
    }

    // =====================================
    //             FILE CHOOSER
    // =====================================

    /**
     * Initialises the file chooser used to load and save files in the editor
     * @return (FileChooser): the FileChooser used by the editor
     */
    private FileChooser initialiseFileChooser() {

        // the file chooser
        FileChooser fileChooser = new FileChooser();

        // sets the initial directory to tbe the user's home directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // returns the file chooser with the correct initial directory
        return fileChooser;
    }

}
