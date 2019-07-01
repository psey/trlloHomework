package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardActionsTest extends BrowserFactory {
    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    BoardPage boardPage = new BoardPage();

    @Test
    public void createNewBoard() {
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
        boardsPage.clickOnAddNewBoard();
        boardPage.setDefNameForBoard();
        boardPage.clickOnCreateNewBoardBtn();
        boardPage.waitForBtnLoaderDisappearance();
        Assert.assertTrue(boardPage.isOpened(), "page wasn't opened");
    }

    @Test
    public void addBoardToFavorite(){
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
        boardsPage.openBoard(boardPage.boardName.toLowerCase());
        boardPage.clickOnFavoriteBtn();
        Assert.assertTrue(boardPage.isAddedToFav(), "The board wasn't added to favorite");
        boardPage.clickOnFavoriteBtn();
    }


    @Test
    public void makeBoardPublic(){
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
        boardsPage.openBoard(boardPage.boardName.toLowerCase());
        boardPage.makeBoardPublic();
        String boardLink = boardPage.getLink();
        boardPage.logout();
        driver().get(boardLink);
        Assert.assertTrue(boardPage.isMenuPresent(), "Menu isn't opened");

    }

    @Test
    public void makeBoardPrivate(){
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
        boardsPage.openBoard(boardPage.boardName.toLowerCase());
        boardPage.makeBoardPrivate();
        String boardLink = boardPage.getLink();
        boardPage.logout();
        driver().get(boardLink);
        Assert.assertEquals(boardPage.isMenuPresent(), false,"Board is private");

    }

    @Test
    public void deleteBoard(){
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
        boardsPage.openBoard(boardPage.boardName.toLowerCase());
        boardPage.deleteBoard();
    }


}
