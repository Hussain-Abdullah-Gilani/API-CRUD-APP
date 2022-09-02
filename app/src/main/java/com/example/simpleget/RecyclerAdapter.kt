package com.example.simpleget

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleget.databinding.FragmentListBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RecyclerAdapter(internal var context:Context,internal var UserList:List<User> ):
RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(), Filterable
{
    internal var FilterList:MutableList<User>
    private lateinit var navController: NavController
    lateinit var binding: FragmentListBinding


    init {

        this.FilterList= UserList as MutableList<User>


    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)
    {


        val name: TextView=itemView.findViewById(R.id.Name)
        val email: TextView=itemView.findViewById(R.id.Email)
        val gender: TextView=itemView.findViewById(R.id.Gender)

        val delete: ImageButton=itemView.findViewById(R.id.deletebtn)


        init{



            delete.setOnClickListener{v:View->

                val position:Int=adapterPosition
                val logging= HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val client= OkHttpClient.Builder()
                client.addInterceptor(logging)

                val retro = Retrofit.Builder()
                    .baseUrl(delurl)
                    .client(client.build())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                val service = retro.create(CountriesService::class.java)
                val countryRequest = service.DelUser()

                countryRequest.enqueue(object : Callback<UserName> {
                    override fun onResponse(call: Call<UserName>, response: Response<UserName>) {

                        Log.d("TAG",response.body().toString())
                    }
                    override fun onFailure(call: Call<UserName>, t: Throwable) {
                        Log.d("TAG","NOOOOO")
                    }
                })
            }



        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)


        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.name.text=FilterList[position].name
        holder.email.text=FilterList[position].email
        holder.gender.text=FilterList[position].gender


        holder.delete.setOnClickListener{
            FilterList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, FilterList.size)
        }


        holder.itemView.setOnClickListener{

            val args= Bundle()
            args.putString("Operation","Update")
            args.putString("Name",FilterList[position].name)
            args.putString("Email",FilterList[position].email)
            args.putString("Gender",FilterList[position].gender)

            navController=Navigation.findNavController(holder.itemView)
            //findNavController(R.id.fragmentContainerView).navigate(R.id.action_listFragment_to_operation,args)
            navController!!.navigate(R.id.action_listFragment_to_operation,args)
        }



    }

    override fun getItemCount(): Int {
        return FilterList.size
    }

    override fun getFilter(): Filter {
        return  object:Filter()
        {

            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch=p0.toString()
                if(charSearch.isEmpty())
                    FilterList= UserList as MutableList<User>
                else
                {
                   val resultList=ArrayList<User>()
                   for(row in UserList)
                   {
                       if(row.name!!.toLowerCase().contains(charSearch.toLowerCase()))
                           resultList.add(row)
                   }
                    FilterList=resultList
                }



                val filterResult=Filter.FilterResults()
                filterResult.values=FilterList

                if(filterResult.count==0)
                {
                    binding.nothingimg.visibility=View.VISIBLE
                    binding.nothingtext.visibility=View.VISIBLE
                }


                return filterResult

            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                FilterList= (p1!!.values as List<User>).toMutableList()
                notifyDataSetChanged()
            }
        }

    }


}