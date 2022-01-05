module com.example.learnfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.learnfx to javafx.fxml;
    exports com.example.learnfx;
    exports com.example.learnfx.controller;
    opens com.example.learnfx.controller to javafx.fxml;
}