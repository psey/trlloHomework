package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.trello.ui.core.BrowserFactory.driver;
import static com.trello.ui.core.BrowserFactory.get;

public class CardPage {
    String[] checklistItems = {"item1", "item2", "item3"};
    private Elem fakeDescr = new Elem(By.xpath("//a[contains(@class, 'description')]"));
    private Elem descriptionArea = new Elem(By.xpath("//textarea[contains(@class, 'card-description')]"));
    private Elem commentArea = new Elem(By.xpath("//textarea[contains(@class, 'comment-box-input')]"));
    private Elem addCommentBtn = new Elem(By.xpath("//input[contains(@class, 'js-add-comment')]"));
    private Elem detailsBtn = new Elem(By.xpath("//*[@class = 'window-module-title-options']/a[not(contains(@class, 'hide'))]"));
    private Elem saveDescrBtn = new Elem(By.xpath("//*[contains(@class, 'description-edit')]//*[contains(@class, 'js-save-edit')]"));
    private Elem cancelDescrBtn = new Elem(By.xpath("//*[contains(@class, 'description-edit')]//*[contains(@class, 'cancel')]"));
    // private Elem searchMemberInput = new Elem(By.xpath("//*[contains(@class, 'js-search-mem')]"));
    private Elem closePopupBtn = new Elem(By.xpath("//*[contains(@class, 'pop-over')]/a"));
    private Elem checklistPopup = new Elem(By.xpath("//*[@id = 'id-checklist']"));
    private Elem addChecklistBtn = new Elem(By.xpath("//*[contains(@class, 'js-add-checklist') and (@type ='submit')]"));
    private Elem addChecklistItemInput = new Elem(By.xpath("//*[@class = 'checklist']//textarea[@placeholder = 'Add an item']"));
    private Elem addChecklistItemBtn = new Elem(By.xpath("//*[contains(@class, 'js-add-checklist')and (@value ='Add')]"));
    private Elem memberElem = new Elem(By.xpath("//div[@class ='no-back']//a[contains(@class, 'member')]"));
    private Elem dateInput = new Elem(By.xpath("//input[contains(@class, 'datepicker-select-input') and(@placeholder = 'Enter date')]"));
    private Elem datepickerSaveBtn = new Elem(By.xpath("//div[@class = 'datepicker-confirm-btns']/input[@type = 'submit']"));
    private Elem attachmentLink = new Elem(By.xpath("//*[@id = 'addLink']"));
    private Elem attachBtn = new Elem(By.xpath("//*[@value = 'Attach']"));
    private Elem nameForCopiedCard = new Elem(By.xpath("//form/textarea[@name= 'name']"));
    private Elem createCopiedCardBtn = new Elem(By.xpath("//form//*[@value ='Create Card']"));
    private Elem showDetailsBtn = new Elem(By.xpath("//*[contains(@class, 'js-show-details')]"));
    private Elem cardName = new Elem(By.xpath("//*[@class ='window-title']/textarea"));

    public void renameCard(String newName) {
        cardName.click();
        cardName.type(newName);
        cardName.pressEnter();

    }

    public Integer showDetailsInfo() {
        showDetailsBtn.click();
        List<WebElement> list = driver().findElements(By.xpath("//div[contains(@class, 'js-list-actions')]/div"));
        return list.size();
    }

    public void setDate(String date) {
        //TODO add validation
        selectAction(CardSidebar.DUEDATE.getType()).click();

        dateInput.type(date);
        datepickerSaveBtn.click();
    }

    public void fillDescription(String desc) {
        fakeDescr.click();
        descriptionArea.type(desc);
        saveDescrBtn.click();
    }

    public void addComment(String comment) {
        commentArea.click();
        commentArea.type(comment);
        addCommentBtn.click();
    }

    public void fillChecklistWithvalues() {
        for (String item : checklistItems) {
            addChecklistItemInput.type(item);
            addChecklistItemBtn.click();

        }
    }

    public Elem selectAction(String elem) {
        return new Elem(By.xpath("//*[@class = 'window-sidebar']//*[@class = 'u-clearfix']/a[@title ='" + elem + "']"));
    }

    public void addChecklist(String checklistname) {
        selectAction(CardSidebar.CHECKLIST.getType()).click();
        checklistPopup.type(checklistname);
        addChecklistBtn.click();
        fillChecklistWithvalues();
        Elem cancel = new Elem(By.xpath("//*[contains(@class, 'checklist-add-controls')]/a[contains(@class, 'cancel')]"));
        cancel.click();

    }


    public void addLabel(String color) {
        selectAction(CardSidebar.LABELS.getType()).click();
        selectColorForLabel(color).click();
        clickClosePopupBtn();
    }

    public void addAttach(String link) {
        selectAction(CardSidebar.ATTACHMENT.getType()).click();
        attachmentLink.click();
        attachmentLink.type(link);
        attachBtn.click();

    }

    public void copyCard(String newCardName) {
        selectAction(CardSidebar.COPY.getType()).click();
        nameForCopiedCard.click();
        nameForCopiedCard.type(newCardName);
        createCopiedCardBtn.click();
    }

    public void clickOnWatchCard() {
        selectAction(CardSidebar.WATCH.getType()).click();
    }

    public void moveCardToOtherList(int num) {
        selectAction(CardSidebar.MOVE.getType()).click();
        Elem listDD = new Elem(By.xpath("//*[@class = 'js-select-list']"));
        listDD.click();
        Elem number = new Elem(By.xpath("//*[@class = 'js-select-list']/option[" + num + "]"));
        number.click();
        Elem moveBtn = new Elem(By.xpath("//*[@value = 'Move']"));
        moveBtn.click();

    }

    public Elem selectColorForLabel(String color) {
        return new Elem(By.xpath("//*[contains(@class, 'card-label-" + color + "')]"));
    }

    public void addMember() {
        selectAction(CardSidebar.MEMBERS.getType()).click();
        memberElem.click();
        closePopupBtn.click();
    }

    public void archiveCard() {
        selectAction(CardSidebar.ARCHIVE.getType()).click();
    }

    public void clickClosePopupBtn() {
        closePopupBtn.click();
    }

    public void click(Elem elem) {
        elem.click();
    }

    public void open(String cardUrl){
        get(cardUrl);
    }



    public void move(String listName){

    }

    public enum CardSidebar {
        MEMBERS("Members"),
        LABELS("Labels"),
        CHECKLIST("Checklist"),
        DUEDATE("Due Date"),
        ATTACHMENT("Attachment"),

        MOVE("Move"),
        COPY("Copy"),
        WATCH("Watch"),
        ARCHIVE("Archive"),
        SHARE("Share");

        private String type;

        CardSidebar(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }


}


