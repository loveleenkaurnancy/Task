package com.kitkat.task.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kitkat.task.MainActivity
import com.kitkat.task.R
import com.kitkat.task.model.ItemModel
import kotlinx.android.synthetic.main.layout_item.view.*

class FirstAdapter(
    private val mValues: ArrayList<ItemModel>,
    private val mContext: Context
) : RecyclerView.Adapter<FirstAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    var selected : Int = -1

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        if(item.checked) {
            holder.ic_tick.visibility = View.VISIBLE
        }
        else {
            holder.ic_tick.visibility = View.INVISIBLE
        }

        holder.current_port.text = item.number.toString()

        holder.relativeLayout.setOnClickListener {

            if(!item.checked)
            {
                item.checked = true
                holder.ic_tick.visibility = View.VISIBLE

            }
            else {
                item.checked = false
                holder.ic_tick.visibility = View.INVISIBLE

            }

            (mContext as MainActivity).leftHolder(position, item.number!!.toInt())

        }

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val relativeLayout: RelativeLayout = mView.relativeLayout
        val current_port: TextView = mView.number
        val ic_tick: ImageView = mView.ic_tick


        override fun toString(): String {
            return super.toString() + " wallet "
        }
    }

}