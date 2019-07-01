package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.driver;

public class BoardPage {

    private Elem favIcon = new Elem(By.xpath("//*[contains(@class, 'board-header')]/a"));
    private Elem favIconAdded = new Elem(By.xpath("//*[contains(@class, 'board-header')]/a[contains(@class, 'enabled')]"));
    private Elem createNewBoardForm = new Elem(By.xpath("//form[@class = 'create-board-form']"));
    private Elem formInput = new Elem(By.xpath("//*[contains(@class, 'subtle-input')]"));
    private Elem createNewBoardBtn = new Elem(By.xpath("//*[@type = 'submit']"));
    private Elem loaderOnBtn = new Elem(By.xpath("//*[@type = 'submit']/span[contains(@class, 'logo-loading')]"));
    private Elem showMenuBtn = new Elem(By.xpath("//*[contains(@class, 'mod-show-menu')]"));
    private Elem moreElemMenuBtn = new Elem(By.xpath("//*[@class = 'board-menu-navigation']/li[5]"));
    private Elem closeBoardMenuBtn = new Elem(By.xpath("//*[contains(@class, 'js-close-board')]"));
    private Elem closeBtn = new Elem(By.xpath("//*[@value = 'Close']"));
    private Elem deleteLink = new Elem(By.xpath("//*[@class = 'delete-container']/a"));
    private Elem deleteBtn = new Elem(By.xpath("//*[@value = 'Delete']"));
    private Elem afterDeleteMsg = new Elem(By.xpath("//h1"));
    private Elem permissionBtn = new Elem(By.xpath("//*[@id = 'permission-level']"));
    private Elem privatePermission = new Elem(By.xpath("//*[@name= 'private']"));
    private Elem publicPermission = new Elem(By.xpath("//*[@name= 'public']"));
    private Elem publicConfirmBtn = new Elem(By.xpath("//*[contains(@class, 'confirmation-button')]"));
    private Elem boardLink = new Elem(By.xpath("//*[@class = 'u-gutter']/input"));
    private Elem logoutMenu = new Elem(By.xpath("//*[contains(@class, 'member-menu')]"));
    private Elem logoutBtn = new Elem(By.xpath("//*[contains(@data-test-id, 'logout')]"));
    private Elem boardMenu = new Elem(By.xpath("//*[@class = 'board-menu-tab-content']"));
    private Elem backMenuBtn = new Elem(By.xpath("//*[contains(@class, 'icon-back')]"));

    public String boardName = "BoardForTest";

    public void open(){

    }

    public boolean isOpened(){
        return driver().getCurrentUrl().contains(boardName.toLowerCase());
    }

    public void clickOnFavoriteBtn(){
        favIcon.click();
    }

    public boolean isAddedToFav(){
        return favIconAdded.isPresent();
    }

    public void setDefNameForBoard(){
        Assert.assertTrue(createNewBoardForm.isPresent(), "Create new board form wasn't opened");
        formInput.type(boardName);
    }

    public void clickOnCreateNewBoardBtn(){
        createNewBoardBtn.click();
    }

    public void waitForBtnLoaderDisappearance(){
        loaderOnBtn.isNotPresent();
    }

    public void deleteBoard(){
        moreElemMenuBtn.click();
        closeBoardMenuBtn.click();
        closeBtn.click();
        deleteLink.click();
        deleteBtn.click();
    }

    public void makeBoardPublic(){
        permissionBtn.click();
        publicPermission.click();
        publicConfirmBtn.click();


    }

    public void makeBoardPrivate(){
        permissionBtn.click();
        privatePermission.click();

    }

    public String getLink(){
        try {
            moreElemMenuBtn.click();
            return boardLink.getText("defaultValue");
        } catch (Exception e){
            backMenuBtn.click();
            moreElemMenuBtn.click();
            return boardLink.getText("defaultValue");
        }

    }

    public void logout(){
        logoutMenu.click();
        logoutBtn.click();
        Assert.assertTrue(driver().getCurrentUrl().equals("https://trello.com/logged-out"),"Not logout page");

    }

    public boolean isMenuPresent(){
        return boardMenu.isPresent();
    }



}
