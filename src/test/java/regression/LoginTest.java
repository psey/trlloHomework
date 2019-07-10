package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("REGRESSION")
@Feature("Login")
public class LoginTest extends BrowserFactory {
    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    BoardPage boardPage = new BoardPage();

    @Story("Login via user")
    @Test
    public void login() throws InterruptedException {
        loginPage.open();
        loginPage.login("ivanovamarichka+6@gmail.com", "mbA7PyNj4LWYKb5");
    }
}
