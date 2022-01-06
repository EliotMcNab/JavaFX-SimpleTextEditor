package com.example.learnfx.io.files;

public enum Directories {


    EXPORT("src/export/"),
    IMAGES("src/export/images/"),
    ICONS("src/main/resources/com/learnfx/icons/");

    private final String path;

    Directories(String path) {
        this.path = path;
    }

    public String pathTo() {
        return path;
    }

}
