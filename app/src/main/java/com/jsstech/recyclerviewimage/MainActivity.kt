package com.jsstech.recyclerviewimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jsstech.recyclerviewimage.Model.RecyclerModel
import com.jsstech.recyclerviewimage.RecyclerAdapters.RecyclerViewAdapter

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClickInterface {
    lateinit var recyclerView: RecyclerView
    val imageItemsList: MutableList<RecyclerModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerview)

//        val imageItemsList: MutableList<RecyclerModel> = mutableListOf()
        imageItemsList.add(RecyclerModel("Gulabjamun", R.drawable.gulajam))
        imageItemsList.add(RecyclerModel("Jalebi", R.drawable.jalebi))
        imageItemsList.add(RecyclerModel("Kaju-Katli", R.drawable.kaju))
        imageItemsList.add(RecyclerModel("Laddoo", R.drawable.laddoo))
        imageItemsList.add(RecyclerModel("Imarati", R.drawable.imarti))
        imageItemsList.add(RecyclerModel("Sandesh", R.drawable.sandesh))
        imageItemsList.add(RecyclerModel("logo", R.drawable.logo))


        var recyclerViewAdapter = RecyclerViewAdapter(this, imageItemsList)

        //for LinearLayout
        // recyclerView.layoutManager = LinearLayoutManager(this)

        //forStaggered Layout
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//
        recyclerView.adapter = recyclerViewAdapter


recyclerViewAdapter.setOnClickListener(this)


    }

    override fun onClick(position: Int) {
        Toast.makeText(this, imageItemsList[position].name,Toast.LENGTH_LONG).show()
    }


}
