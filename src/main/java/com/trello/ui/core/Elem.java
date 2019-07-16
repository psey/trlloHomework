package com.trello.ui.core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.trello.ui.core.BrowserFactory.getWebDriverWait;

public class Elem {
    //TODO базовые действия с элемом, которые необходимы для работы ос страницей

    private By by;
    private String name;

    public Elem(By by, String name){
        this.by = by;
        this.name = name;
    }


    public Elem(By by){
        this(by, "");
    }

    @Step
    public WebElement find(){
        return getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Step
    public void click(){
        find().click();
    }

    @Step
    public String getText(String attribute) {
        return find().getAttribute(attribute);
    }

    @Step
    public void type(String text){
        find().clear();
        find().sendKeys(text);
    }

    public void pressEnter() {
        find().sendKeys(Keys.ENTER);
    }

    public boolean isPresent(){
        try {
            getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public boolean isNotPresent(){
        try {
            getWebDriverWait(10).until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }



}
