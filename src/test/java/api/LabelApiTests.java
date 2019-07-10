package api;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Board;
import com.trello.api.models.Labels;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LabelApiTests {

    TrelloRestClient client = new TrelloRestClient();
    private String boardId;
    private String labelId;
    private String color = "sky";
    private String labelName = "Label created from API test";

    @BeforeMethod
    public void setupCard() throws IOException {
        Board createdBoard = client.boardsService.createBoard("CREATED FROM LABEL API TEST").execute().body();
        boardId = createdBoard.id;
        Labels labels = new Labels(labelName, color, boardId);
        Labels createdLabel = client.labelsService.createLabel(labels).execute().body();
        labelId = createdLabel.id;
    }

    @AfterMethod
    public void deleteBoard() throws IOException {
        client.boardsService.deleteBoard(boardId).execute();
    }

    @Test
    public void getLabel() throws IOException {
        String getLabelName = client.labelsService.getLabel(labelId).execute().body().name;
        Assert.assertEquals(getLabelName, labelName, "Names are now the same");
    }

    @Test
    public void updateLabel() throws IOException {
        Labels updLabel = client.labelsService.updateLabel(labelId, "NEW NAME").execute().body();
        Assert.assertNotEquals(updLabel.name, labelName, "Label name wasn't changed");
    }

    @Test(priority = 2)
    public void deleteLabel() throws IOException {
        int deletedLabelCode = client.labelsService.deleteLabel(labelId).execute().code();
        Assert.assertEquals(deletedLabelCode, 200, "Label wasn't deleted");
    }

}
