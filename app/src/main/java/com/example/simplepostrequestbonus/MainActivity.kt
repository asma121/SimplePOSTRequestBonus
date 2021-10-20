package com.example.simplepostrequestbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var etname:EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etname=findViewById(R.id.etname)
        button=findViewById(R.id.button)

        button.setOnClickListener {
            var f = UsersDetails.Datum(etname.text.toString())
            addUserDetails(f, onResult = {
            })
        }
    }

    private fun addUserDetails(f :UsersDetails.Datum ,onResult: () -> Unit){
        val apiInterface = APIClient().getClinet()?.create(APIInterface::class.java)
        if (apiInterface != null) {
            apiInterface.addUserDetails(f)?.enqueue(object :
                Callback<UsersDetails.Datum?> {
                override fun onResponse(call: Call<UsersDetails.Datum?>, response: Response<UsersDetails.Datum?>) {
                    Toast.makeText(applicationContext,"user added", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<UsersDetails.Datum?>, t: Throwable) {
                    Toast.makeText(applicationContext,"Something went wrong", Toast.LENGTH_LONG).show()
                }

            })
        }
    }
}