package com.trello.api.models;

public class Labels {
    public String id;
    public String name;
    public String idBoard;
    public String filds;
    public String color;

    public Labels() {

    }

    public Labels(String name, String color, String idBoard) {
        this.name = name;
        this.color = color;
        this.idBoard = idBoard;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", filds='" + filds + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
