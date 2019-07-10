package com.trello.api.models;

import java.util.List;

public class TrelloList {
    public String id;
    public String name;
    public String idBoard;
    public Boolean subscribed;
    public Boolean closed;
    public List<Card> cards;

    public TrelloList() {
    }

    public TrelloList(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TrelloList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", subscribed=" + subscribed +
                ", closed=" + closed +
                ", cards=" + cards +
                '}';
    }
}

//TODO авторизация через куки. Если сделать, то +20 баллов на экзамене
//Todo апи колл на создание карты. ui - действия с картой. api - проверить