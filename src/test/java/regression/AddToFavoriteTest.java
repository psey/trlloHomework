package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToFavoriteTest extends BrowserFactory {
    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    BoardPage boardPage = new BoardPage();

    @Test
    public void addToFavorite(){
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
        boardsPage.openBoard("trellotestboard");
        boardPage.clickOnFavoriteBtn();
        Assert.assertTrue(boardPage.isAddedToFav(), "The board wasn't added to favorite");
        boardPage.clickOnFavoriteBtn();
    }

}
