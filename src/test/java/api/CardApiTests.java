package api;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Board;
import com.trello.api.models.Card;
import com.trello.api.models.TrelloList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CardApiTests {

    TrelloRestClient client = new TrelloRestClient();
    private String boardId;
    private String cardId;
    private String cardName = "Created card from api test";

    @BeforeMethod
    public void setupCard() throws IOException {
        Board createdBoard = client.boardsService.createBoard("CREATED FROM CARD API TEST").execute().body();
        boardId = createdBoard.id;
        TrelloList createdList = client.listsService.createList(boardId, "CREATED FROM CARD API TEST").execute().body();
        String listId = createdList.id;
        Card card = new Card();
        card.name = cardName;
        Card createdCard = client.cardsService.createCard(listId, card).execute().body();
        cardId = createdCard.id;

    }

    @AfterMethod
    public void deleteBoard() throws IOException {
        client.boardsService.deleteBoard(boardId).execute();
    }

    @Test
    public void createCard() {
        Assert.assertTrue(cardId.length() > 0, "Card wasn't created");
    }

    @Test(dependsOnMethods = "createCard")
    public void getCardById() throws IOException {
        Card card = client.cardsService.getCard(cardId).execute().body();
        Assert.assertEquals(card.id, cardId, "Id of created and actual cards are not equal");

    }

    @Test(priority = 1)
    public void updateCard() throws IOException {
        Card updatedCard = client.cardsService.updateCard(cardId, "new name").execute().body();
        Assert.assertNotEquals(updatedCard.name, cardName, "Card name wasn't updated");
    }

    @Test(priority = 2)
    public void deleteCard() throws IOException {
        int deletedCode = client.cardsService.deleteCard(cardId).execute().code();
        Assert.assertEquals(deletedCode, 200, "Card wasn't deleted");

    }

}
