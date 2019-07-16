package regression;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.Members;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import junk.CookieStorage;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CardActions extends BrowserFactory {
    CookieStorage cookieStorage = new CookieStorage();

    public TrelloRestClient client = new TrelloRestClient();
    Gson gson = new Gson();
    OkHttpClient client2 = new OkHttpClient.Builder().cookieJar(cookieStorage).build();
    private String boardId;


    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();
    private String cardURL;

    Card card = new Card("Test_Card_"+new Date().getTime());


    @BeforeTest
    public void prepareData() throws IOException {
        boardId = client.boardsService.createBoard("Board for Card actions homework").execute().body().id;
        String listId = client.listsService.createList(boardId, "List for Card actions homework").execute().body().id;
        card = client.cardsService.createCard(listId, card).execute().body();
        cardURL = card.url;

        client2.newCall(new Request.Builder().url("https://trello.com").build()).execute().body().string();

        // authentication
        FormBody formData = new FormBody.Builder()
                .add("method", "password")
                .add("factors[user]", "ivanovamarichka+6@gmail.com")
                .add("factors[password]", "mbA7PyNj4LWYKb5")
                .build();
        Request request = new Request.Builder().url("https://trello.com/1/authentication").post(formData).build();
        String response = client2.newCall(request).execute().body().string();
        System.out.println("RESPONSE: " + response);
        Map<String, String> map = gson.fromJson(response, new TypeToken<Map<String, String>>() {
        }.getType());
        String code = map.get("code");
        System.out.println("CODE: " + code);


        // authorization/session
        String dsc = cookieStorage.cookies.stream().filter(cookie -> cookie.name().equals("dsc")).findFirst().get().value();
        FormBody sessionFormData = new FormBody.Builder()
                .add("authentication", code)
                .add("dsc", dsc)
                .build();
        Request requestSession = new Request.Builder().url("https://trello.com/1/authorization/session").post(sessionFormData).build();
        response = client2.newCall(requestSession).execute().body().string();
        System.out.println(response);


        // SELENIUM
        driver().get("https://trello.com");

        for (Cookie cookie : cookieStorage.cookies) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.name(), cookie.value());
            driver().manage().addCookie(seleniumCookie);
        }

        driver().navigate().refresh();
        cardPage.open(cardURL);

    }

    @AfterMethod
    public void setTimeOut() throws InterruptedException {
        Thread.sleep(2000);
    }


    // AFTER METHOD
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }


    @Test
    public void addMemberToCard() throws IOException {
        List<Members> member = client.cardsService.getMembers(card.id, "all").execute().body();
        assertEquals(member.size(), 0, "Member List isn't empty");
        System.out.println(client.cardsService.getMembers(card.id, "all").execute().body());
        System.out.println(card.id);
        cardPage.addMember();

        member = client.cardsService.getMembers(card.id, "all").execute().body();
        assertEquals(member.size(), 1, "Member wasn't added to the Card");

        System.out.println(member.size());
        member.forEach(members -> {
            System.out.println(members.id);
        });
        System.out.println();
        // TODO API TEST MEMBER
    }


    @Test
    public void addLabelsToCard() {
        //   cardPage.open(cardURL);
        cardPage.addLabel("blue");
        //TODO API LABEL

    }

    @Test
    public void addCheckListToCard() {
        //    cardPage.open(cardURL);
        cardPage.addChecklist("New name");

        // TODO API CHECKLIST
        // TODO DELETE CHECKLIST
    }

    @Test
    public void addDescription() {
        //    cardPage.open(cardURL);
        cardPage.fillDescription("DESCRIPTION");
        //TODO API

    }

    @Test
    public void addComment() {
        //    cardPage.open(cardURL);
        cardPage.addComment("COMMENT TEXT");
    }

    @Test
    public void addDate() {
        //    cardPage.open(cardURL);
        cardPage.setDate("10/16/2019");
    }

    @Test
    public void addAttachmentLink() {
        //   cardPage.open(cardURL);
        cardPage.addAttach("https://marikatestqa8.airslate.com/login");
    }

    @Test
    public void copyCard() {
        //    cardPage.open(cardURL);
        cardPage.copyCard("This card was copied");
    }

    @Test(enabled = false)
    public void watchOrUnwatchCard() {
        //TODO API REQUEST WATCHERS
        //  cardPage.open(cardURL);
        cardPage.clickOnWatchCard();
    }

    @Test
    public void moveToOtherList() {
        //   cardPage.open(cardURL);
        cardPage.moveCardToOtherList(2);
    }

    @Test(priority = 1)
    public void archiveCard() {
        //   cardPage.open(cardURL);
        cardPage.archiveCard();
    }

    @Test
    public void renameCard() {
        //  cardPage.open(cardURL);
        cardPage.renameCard("piy piy");
    }

}
