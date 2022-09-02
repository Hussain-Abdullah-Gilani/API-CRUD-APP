package com.example.simpleget

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.simpleget.databinding.FragmentOperationBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class Operation : Fragment() {

    internal lateinit var radioGroup: RadioGroup
    lateinit var binding:FragmentOperationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG","ONCREATEOPERATIONS")
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOperationBinding.inflate(inflater,container,false)
        //val root = inflater.inflate(R.layout.fragment_operation, container, false)

        var info:OperationsModel=OperationsModel("","")






        binding.createfr.text=arguments?.getString("Operation")

        if (arguments?.getString("Operation") == "Update") {
            val convertname: String? = arguments?.getString("Name")
            val convertemail: String? = arguments?.getString("Email")
            val convertgender: String? = arguments?.getString("Gender")




            info=OperationsModel(convertname.toString(),convertemail.toString())
            binding.info=info

            val gender: String


            if (convertgender == "male") {
                binding.Malechk.isChecked = true
            } else if (convertgender == "female") {
                binding.Femalechk.isChecked = true
            }

            binding.createfr.setOnClickListener {

                if (info.getname()== "" || info.getemail() == "" || (!binding.Malechk.isChecked && !binding.Femalechk.isChecked)) {
                    Toast.makeText(context, "Please Fill All the Data", Toast.LENGTH_SHORT).show()
                }

                else
                {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BODY
                    val client = OkHttpClient.Builder()
                    client.addInterceptor(logging)

                    val retro = Retrofit.Builder()
                    .baseUrl(puturl)
                    .client(client.build())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    val service = retro.create(CountriesService::class.java)
                    val countryRequest = service.putUser("Abdullah", "hussain099999@gmail.com")

                    countryRequest.enqueue(object : Callback<UserName> {
                    override fun onResponse(call: Call<UserName>, response: Response<UserName>) {
                    Log.d("TAG", response.body().toString())
                        Toast.makeText(context, "User Updated SuccessFully", Toast.LENGTH_SHORT).show()
                 }

            override fun onFailure(call: Call<UserName>, t: Throwable) {
                Toast.makeText(context, "User Updated SuccessFully", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "NOOOOO")
            }
        })
                }

            }

        }

        if (arguments?.getString("Operation") == "Create") {

            binding.createfr.setOnClickListener {
                var gender:String="h"
                if (info.getname()== "" || info.getemail() == "" || (!binding.Malechk.isChecked && !binding.Femalechk.isChecked)) {
                    Toast.makeText(context, "Please Fill All the Data", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BODY
                    val client = OkHttpClient.Builder()
                    client.addInterceptor(logging)
                    if(binding.Malechk.isChecked==true)
                    {
                        gender="male"
                    }
                    else if(binding.Femalechk.isChecked==true)
                    {
                        gender="female"
                    }


                    val retro = Retrofit.Builder()
                        .baseUrl(posturl)
                        .client(client.build())
                        .addConverterFactory(MoshiConverterFactory.create())
                        .build()
                    val service = retro.create(CountriesService::class.java)

                    val countryRequest =
                        service.addUser(
                            binding.Namefr.text.toString(),
                            binding.Emailfr.text.toString(),
                            gender,
                            "active"
                        )

                    countryRequest.enqueue(object : Callback<UserName> {
                        override fun onResponse(
                            call: Call<UserName>,
                            response: Response<UserName>
                        ) {
                            Toast.makeText(
                                context,
                                "Creating User Successfully",
                                Toast.LENGTH_LONG
                            )
                                .show()
                            Log.d("TAG", response.body().toString())

                        }

                        override fun onFailure(call: Call<UserName>, t: Throwable) {
                            Toast.makeText(context, "Create User Failed", Toast.LENGTH_LONG)
                                .show()
                            Log.d("TAG", "NOOOOO")
                        }

                    })
                }

            }
        }


        return binding.root
    }
    override fun onPause() {
        Log.d("TAG","ONPAUSEOPERATIONS")
        super.onPause()
    }

    override fun onResume() {
        Log.d("TAG","ONRESUMEOPERATIONS")
        super.onResume()
    }

    override fun onAttach(context: Context) {
        Log.d("TAG","ONATTACHOPERATIONS")
        super.onAttach(context)
    }

    override fun onDestroy() {
        Log.d("TAG","ONDESTROYOPERATIONS")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d("TAG","ONDESTROYVIEWOPERATIONS")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("TAG","ONDETACHOPERATIONS")
        super.onDetach()
    }
}



