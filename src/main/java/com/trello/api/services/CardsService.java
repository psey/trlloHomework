package com.trello.api.services;

import com.trello.api.models.Card;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

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

// todo все зависят от логина и открытия карточки
}
