package com.jsstech.recyclerviewimage.RecyclerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jsstech.recyclerviewimage.MainActivity
import com.jsstech.recyclerviewimage.Model.RecyclerModel
import com.jsstech.recyclerviewimage.R

class RecyclerViewAdapter(var context: Context, var imageItemsList: MutableList<RecyclerModel>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    lateinit var onItemClickInterface:OnItemClickInterface
    //lateinit var onItemClick:OnItemClick


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.custom_itemview, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.txtname.text = imageItemsList[position].name
        //First way to bind image
        holder.imageV.setImageResource(imageItemsList[position].image)

        /*  //bind image also like this(second way)
          //holder.bindView(imageItemsList[position])
   */
        holder.itemView.setOnClickListener {
            onItemClickInterface.onClick(position)
        }

    }

    override fun getItemCount(): Int {
        return imageItemsList.size
    }




//

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtname = itemView.findViewById<TextView>(R.id.txtV_personName)
        var imageV = itemView.findViewById<ImageView>(R.id.imgV)

        /*  //bind image also like this(Second way)
          //create function & then call that function in OnBindViewHolder

          fun bindView(image:RecyclerModel){
              imageV.setImageResource(image.image)
          }
  */

    }
    interface OnItemClickInterface{
        fun onClick(position: Int)
    }

fun setOnClickListener(onItemClickInterface: MainActivity){
    this.onItemClickInterface=onItemClickInterface
}
    }




