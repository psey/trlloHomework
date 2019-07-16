package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import org.testng.annotations.Test;

import java.io.IOException;

public class TryTrelloApi {

    TrelloRestClient client = new TrelloRestClient();


    @Test
    public void callIt() throws IOException, InterruptedException {
        Card card = new Card();
        card.name = "My New CARD 2";
        Card createdCard = client.cardsService.createCard("5d2dd38351e17317fd3d435e", card).execute().body();
        client.cardsService.deleteCard(createdCard.id).execute();
        System.out.println(createdCard.id);
        System.out.println(client.cardsService.getMembers(createdCard.id, "all").execute().body());
        System.out.println(client.cardsService.getMembers("5d2de070650d9d14bc8c975a", "all").execute().body());
        //     System.out.println();

    }
}
