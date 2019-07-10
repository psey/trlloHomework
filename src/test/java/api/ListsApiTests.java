package api;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Board;
import com.trello.api.models.TrelloList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ListsApiTests {

    TrelloRestClient client = new TrelloRestClient();
    private String boardId;
    private String trelloListId;
    private String trelloListName = "List was created from List api test";

    @BeforeMethod
    public void createBoard() throws IOException {
        Board createdBoard = client.boardsService.createBoard("CREATED FROM LIST API TEST").execute().body();
        boardId = createdBoard.id;
        TrelloList trelloList = client.listsService.createList(boardId, trelloListName).execute().body();
        trelloListId = trelloList.id;
    }

    @AfterMethod
    public void deleteBoard() throws IOException {
        client.boardsService.deleteBoard(boardId).execute();
    }

    @Test
    public void createList() {
        Assert.assertEquals(trelloListId.length() > 0, true, "List wasn't created");
    }

    @Test
    public void getListById() throws IOException {
        TrelloList getList = client.listsService.getList(trelloListId).execute().body();
        Assert.assertEquals(getList.name, trelloListName, "Names of created card and found card are not the same");
    }

    @Test(priority = 2)
    public void updateList() throws IOException {
        TrelloList updList = new TrelloList("NEW NAME");
        updList.closed = true;
        TrelloList updatedList = client.listsService.updateList(trelloListId, updList).execute().body();
        Assert.assertNotEquals(updatedList.name, trelloListName, "Name wasn't changed");
    }

}
