package com.example.learnfx.io.files;

public enum Directories {

    EXPORT("src/export/"),
    IMAGES("src/export/images/"),
    TEXT_FILES("src/export/text/");

    private final String path;

    Directories(String path) {
        this.path = path;
    }

    public String pathTo() {
        return path;
    }

}
