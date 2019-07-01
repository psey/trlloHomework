package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BoardsPage {
    private static final String PATH = "rina689/boards";
    private Elem addNewBoardBtn = new Elem(By.xpath("//*[contains(@class, 'mod-add')]"));


    public Elem boardByUrlName(String urlName){
        // return new Elem(By.cssSelector(".board-title[href *='" + urlName+"']"));
        return new Elem(By.xpath("//*[@class = 'board-tile'][contains(@href, '"+ urlName + "')]"));
        //*[@class = 'board-tile'][contains(@href, 'trellotestboard')]
    }

    public void open(){

    }

    public void isOpened(){

    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }

    public void clickOnAddNewBoard(){
        addNewBoardBtn.click();
    }


}
