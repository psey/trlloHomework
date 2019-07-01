package com.trello.api.models;

import java.util.List;

public class TrelloList {
    public String id;
    public String name;
    public Boolean closed;
    public List<Card> cards;
}

//TODO авторизация через куки. Если сделать, то +20 баллов на экзамене
//Todo апи колл на создание карты. ui - действия с картой. api - проверить