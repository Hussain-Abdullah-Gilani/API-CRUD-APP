package com.example.simpleget

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import android.view.LayoutInflater as LayoutInflater1


const val geturl="https://gorest.co.in/public/v2/"
const val posturl="https://gorest.co.in/public/v2/"
const val puturl="https://gorest.co.in/public/v2/"
const val delurl="https://gorest.co.in/public/v2/"
class MainActivity : AppCompatActivity() {


//    lateinit var Nothingimage: ImageView
//    lateinit var nothingtext: TextView
//
//
//    lateinit var Searchtext: SearchView
//    lateinit var CreateButton: ImageButton
//    lateinit var UpdateButton: ImageButton
//    lateinit var DeleteButton: Button
//    lateinit var recycler: RecyclerView
//
//    var allCountry = ArrayList<User>()
//    var filterCountry = ArrayList<User>()
//    var datalist: MutableList<User> = ArrayList()
//    lateinit var adapter: RecyclerAdapter

private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment= supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            navController=navHostFragment.navController
        setupActionBarWithNavController(navController)



//        recycler = findViewById(R.id.recycler)
//        recycler.layoutManager = LinearLayoutManager(this)
//
//        Searchtext = findViewById(R.id.searchbar)
//        CreateButton = findViewById(R.id.create_Button)
////        CreateButton=findViewById(R.id.create_button)
//
////        DeleteButton=findViewById(R.id.delete_button)
//
//        adapter = RecyclerAdapter(this, datalist)
//        nothingtext = findViewById(R.id.nothingtext)
//        Nothingimage = findViewById(R.id.nothingimg)
//
//        recycler.adapter = adapter
//
//
//
//
//        CreateButton.setOnClickListener {
//            val intent = Intent(this, CreateUser::class.java)
//            startActivity(intent)
//        }
//
//
//        val query = Searchtext.query
//
//        Searchtext.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//
//                adapter.filter.filter(p0)
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                Log.d("onQueryTextChange", "query: " + query)
//                adapter.filter.filter(p0)
//                return false
//            }
//
//
//        })
//
//        getall()

//    SearchButton.setOnClickListener(View.OnClickListener {
//           getUser(query)
//       })


//        CreateButton.setOnClickListener(View.OnClickListener {
//            createUser()
//        })
//
//        UpdateButton.setOnClickListener(View.OnClickListener {
//            UpdateUser()
//        })
//
//        DeleteButton.setOnClickListener(View.OnClickListener {
//            // Toast.makeText(this,query,Toast.LENGTH_LONG).show()
//            DelUser()
//        })


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }




//
//
//    @SuppressLint("NotifyDataSetChanged")
//    private fun posttoList(users: List<User>) {
//        datalist.addAll(users)
//        adapter.notifyDataSetChanged()
//
//    }
//
//    fun getall() {
//        val retro = Retrofit.Builder()
//            .baseUrl(geturl)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//        val service = retro.create(CountriesService::class.java)
//        val countryRequest = service.listUsers()
//
//        countryRequest.enqueue(object : Callback<List<User>> {
//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                if (response.code() == 200) {
//
//                    allCountry = response.body() as ArrayList<User>
//                    posttoList(allCountry)
//                }
//            }
//
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                Log.d("TAG", "on FAILURE!!!!")
//            }
//
//        })
//    }
//
//    fun DelUser() {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        val client = OkHttpClient.Builder()
//        client.addInterceptor(logging)
//
//
//        val retro = Retrofit.Builder()
//            .baseUrl(delurl)
//            .client(client.build())
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//        val service = retro.create(CountriesService::class.java)
//        val countryRequest = service.DelUser()
//
//        countryRequest.enqueue(object : Callback<UserName> {
//            override fun onResponse(call: Call<UserName>, response: Response<UserName>) {
//
//                Log.d("TAG", response.body().toString())
//
//            }
//
//            override fun onFailure(call: Call<UserName>, t: Throwable) {
//                Log.d("TAG", "NOOOOO")
//            }
//        })
//    }
//
//    fun UpdateUser() {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        val client = OkHttpClient.Builder()
//        client.addInterceptor(logging)
//
//        val retro = Retrofit.Builder()
//            .baseUrl(puturl)
//            .client(client.build())
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//        val service = retro.create(CountriesService::class.java)
//        val countryRequest = service.putUser("Abdullah", "hussain099999@gmail.com")
//
//        countryRequest.enqueue(object : Callback<UserName> {
//            override fun onResponse(call: Call<UserName>, response: Response<UserName>) {
//                Log.d("TAG", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<UserName>, t: Throwable) {
//                Log.d("TAG", "NOOOOO")
//            }
//        })
//    }
//
//    fun createUser() {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        val client = OkHttpClient.Builder()
//        client.addInterceptor(logging)
//
//
//        val retro = Retrofit.Builder()
//            .baseUrl(posturl)
//            .client(client.build())
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//        val service = retro.create(CountriesService::class.java)
//        val countryRequest =
//            service.addUser("Abdullah", "hussain0999@gmail.com", "Male", "inactive")
//
//        countryRequest.enqueue(object : Callback<UserName> {
//            override fun onResponse(call: Call<UserName>, response: Response<UserName>) {
//
//                Log.d("TAG", response.body().toString())
//
//            }
//
//            override fun onFailure(call: Call<UserName>, t: Throwable) {
//                Log.d("TAG", "NOOOOO")
//            }
//
//        })
//
//
//    }
//
//    fun getUser(query: CharSequence) {
//        Log.d("DATA", "out loop")
//        for (r in allCountry) {
//            Log.d("DATA", "in loop")
//            if (r.name == query) {
//
//                recycler.visibility = View.VISIBLE
//                nothingtext.visibility = View.INVISIBLE
//                Nothingimage.visibility = View.INVISIBLE
//                filterCountry.add(r)
//
//            }
//
//        }
//
//
//        posttoList(filterCountry)


//        val retro = Retrofit.Builder()
//            .baseUrl(geturl)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//
//        val service = retro.create(CountriesService::class.java)
//        val countryRequest = service.listCountries(query)
//
//        countryRequest.enqueue(object : Callback<List<User>>{
//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                if(response.code()==200) {
//                    names.clear()
//                    emails.clear()
//                    genders.clear()
//                    val allCountry = response.body()
//                    recycler.visibility=View.VISIBLE
//                    nothingtext.visibility=View.INVISIBLE
//                    Nothingimage.visibility=View.INVISIBLE
//                    Log.d("TAG", response.body().toString())
//                    if (response.body().toString() != "[]") {
//
//
//                            posttoList(allCountry!!)
//
//                    }
//                    else
//                    {
//                        recycler.visibility=View.INVISIBLE
//                        nothingtext.visibility=View.VISIBLE
//                        Nothingimage.visibility=View.VISIBLE
//                    }
//                }
//
//            }
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {
//
//                Log.d("TAG", "on FAILURE!!!!")
//            }
//
//        })
   // }
}





