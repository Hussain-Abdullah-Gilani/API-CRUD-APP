package com.example.simpleget

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleget.databinding.FragmentListBinding
import com.example.simpleget.databinding.FragmentOperationBinding
import okhttp3.internal.userAgent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ListFragment : Fragment() {
    var allCountry = ArrayList<User>()
    var filterCountry = ArrayList<User>()
    private val datalist: MutableList<User> = mutableListOf()
    lateinit var adapter: RecyclerAdapter

//    lateinit var Nothingimage: ImageView
//    lateinit var nothingtext: TextView


    lateinit var Searchtext: SearchView

    //    lateinit var CreateButton: ImageButton
//    lateinit var UpdateButton: ImageButton
//    lateinit var DeleteButton: Button
    lateinit var recycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG","ONCREATELIST")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TAG","ONCREATEVIEWLIST")
        // Inflate the layout for this fragment

        val root = inflater.inflate(R.layout.fragment_list, container, false)
        var create: ImageButton = root.findViewById(R.id.create_Button)



        create.setOnClickListener {

            val args = Bundle()
            args.putString("Operation", "Create")

            findNavController().navigate(R.id.action_listFragment_to_operation, args)
        }





        recycler = root.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


        Searchtext = root.findViewById(R.id.searchbar)
        //CreateButton=root.findViewById(R.id.create_Button)

        val query = Searchtext.query
        Searchtext.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {

                adapter.filter.filter(p0)


                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                Log.d("onQueryTextChange", "query: " + query)

                adapter.filter.filter(p0)
                return false
            }


        })
        Log.d("TAG", "Getall function called")
        datalist.clear()
        getall()

        return root
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun posttoList(users: List<User>) {
        datalist.addAll(users)
        adapter = RecyclerAdapter(requireContext(), datalist)
        recycler.adapter = adapter

    }

    fun getall() {

        val retro = Retrofit.Builder()
            .baseUrl(geturl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retro.create(CountriesService::class.java)
        val countryRequest = service.listUsers()

        countryRequest.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.code() == 200) {

                    allCountry = response.body() as ArrayList<User>
                    posttoList(allCountry)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("TAG", "on FAILURE!!!!")
            }

        })
    }

    override fun onPause() {
        Log.d("TAG","ONPAUSELIST")
        super.onPause()
    }

    override fun onResume() {
        Log.d("TAG","ONRESUMELIST")
        super.onResume()
    }

    override fun onAttach(context: Context) {
        Log.d("TAG","ONATTACHLIST")
        super.onAttach(context)
    }

    override fun onDestroy() {
        Log.d("TAG","ONDESTROYLIST")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d("TAG","ONDESTROYVIEWLIST")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("TAG","ONDETACHLIST")
        super.onDetach()
    }


}