package com.example.simpleget

import retrofit2.Call
import retrofit2.http.*

interface CountriesService {
    @GET("users")
    fun listUsers(): Call<List<User>>


    @GET("users")
    fun listCountries(@Query("name") searchtext: CharSequence): Call<ArrayList<User>>


    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json", "Authorization: Bearer 93a893a16099d11c237943d7c7cf2c56b3ebdb3e9329e80e12bd9d425ef98dda")
    fun addUser(@Query("name") name: String,
                @Query("email") email:String,
                @Query("gender") gender:String,
                @Query("status") status:String,
    ): Call<UserName>

    @PUT("users/8")
    @Headers("Accept:application/json", "Content-Type:application/json", "Authorization: Bearer 93a893a16099d11c237943d7c7cf2c56b3ebdb3e9329e80e12bd9d425ef98dda")
    fun putUser(@Query("name") name: String,
                @Query("email") email:String,

    ): Call<UserName>

    @DELETE("users/8")
    @Headers("Accept:application/json", "Content-Type:application/json", "Authorization: Bearer 93a893a16099d11c237943d7c7cf2c56b3ebdb3e9329e80e12bd9d425ef98dda")
    fun DelUser(): Call<UserName>
}