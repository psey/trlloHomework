package com.trello.api.models;

public class Board {
    public String id;
    public String name;
    public String desc;
    public String url;

    public Board() {

    }

    public Board(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
