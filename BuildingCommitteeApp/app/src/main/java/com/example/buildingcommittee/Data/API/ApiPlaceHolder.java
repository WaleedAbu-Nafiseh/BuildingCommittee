package com.example.buildingcommittee.Data.API;

import com.example.buildingcommittee.Data.Post;
import com.example.buildingcommittee.Data.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPlaceHolder {
    @GET("users")
    Call<List<User>> getUsers();
}
