package com.example.learnfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import static com.example.learnfx.io.files.FileType.TXT;

public class Controller {

    @FXML
    private TextArea textEditArea;

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
