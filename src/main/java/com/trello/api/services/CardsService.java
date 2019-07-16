package com.trello.api.services;

import com.trello.api.models.Card;
import com.trello.api.models.Members;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CardsService {

    @POST("cards")
    Call<Card> createCard(@Query("idList") String idList, @Body Card card);

    @GET("cards/{id}")
    Call<Card> getCard(@Path("id") String id);

    @DELETE("cards/{id}")
    Call<ResponseBody> deleteCard(@Path("id") String id);
    //204

    @PUT("cards/{id}")
    Call<Card> updateCard(@Path("id") String id, @Query("name") String name);

    @GET("cards/{id}/members")
    Call<List<Members>> getMembers(@Path("id") String id, @Query("fields") String fields);


// todo все зависят от логина и открытия карточки
}
