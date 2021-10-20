package com.example.simplepostrequestbonus

import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

   // @Headers("Content-Type: application/json")
    @POST("/custom-people/")
    fun addUserDetails(@Body userdata:UsersDetails.Datum): Call<UsersDetails.Datum>

}