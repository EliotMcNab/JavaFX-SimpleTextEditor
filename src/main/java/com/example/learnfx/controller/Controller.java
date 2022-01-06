package com.example.learnfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.learnfx.io.files.FileType.TXT;

public class Controller {

    @FXML
    private TextArea textEditArea;

    @FXML
    private Button loadButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button saveButton;


    private final TextEditor textEditor = new TextEditor();

    @FXML
    void loadButtonClicked(MouseEvent event) {
        textEditor.loadText(textEditArea);
    }

    @FXML
    void resetButtonClicked(MouseEvent event) { textEditor.resetText(textEditArea); }

    @FXML
    void saveButtonClicked(MouseEvent event) {
        textEditor.saveText(textEditArea, "test" + TXT.extension());
    }

    @FXML
    void textEditAreaClicked(MouseEvent event) {
        textEditor.selectAllText(textEditArea);
    }

    @FXML
    void textEditAreaKeyPress(KeyEvent event) {
        // TODO: implement key listener
        System.out.println(event.getCode().getCode());
    }
}
