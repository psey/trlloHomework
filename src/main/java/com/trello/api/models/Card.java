package com.trello.api.models;

public class Card {
    public String id;
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;
    // @SerializeName
    // рефлексия - можно посомтреть приватную переменную в чужом классе
    public Card(){}

    public Card(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

