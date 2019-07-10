package com.trello.api.services;

import com.trello.api.models.Labels;
import retrofit2.Call;
import retrofit2.http.*;

public interface LabelsService {
    @GET("labels/{id}")
    Call<Labels> getLabel(@Path("id") String id);

    @PUT("labels/{id}")
    Call<Labels> updateLabel(@Path("id") String id, @Query("name") String name);

    @POST("labels")
    Call<Labels> createLabel(@Body Labels labels);

    @DELETE("labels/{id}")
    Call<Labels> deleteLabel(@Path("id") String id);

}
