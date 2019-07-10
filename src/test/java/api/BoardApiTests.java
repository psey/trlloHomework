package api;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BoardApiTests {

    TrelloRestClient client = new TrelloRestClient();
    private String id;

    @BeforeMethod
    public void getBoardId() throws IOException {
        Board createdBoard = client.boardsService.createBoard("NEW BOARD API TEST2").execute().body();
        id = createdBoard.id;
    }

    @Test
    public void createBoard() throws IOException {
        Assert.assertTrue(id.length() > 0, "No id found");
        client.boardsService.deleteBoard(id).execute();

    }

    @Test
    public void deleteBoard() throws IOException {
        client.boardsService.deleteBoard(id).execute();
        Assert.assertEquals(client.boardsService.getBoard(id).execute().body(), null, "Board wasn't deleted");
    }

    @Test
    public void getBoard() throws IOException, InterruptedException {
        int code = client.boardsService.getBoard(id).execute().code();
        Assert.assertEquals(code, 200, "Code is not 200");
        client.boardsService.deleteBoard(id).execute();
    }

    @Test
    public void updateBoard() throws IOException {
        Board board = new Board("UPDATED NAME");
        Board createdBoard = client.boardsService.updateBoard(id, board).execute().body();
        Assert.assertTrue(createdBoard.name.equals("UPDATED NAME"), "Name is not changed");
        client.boardsService.deleteBoard(id).execute();

    }

}
