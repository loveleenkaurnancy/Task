package com.kitkat.task

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kitkat.task.adapters.FirstAdapter
import com.kitkat.task.adapters.SecondAdapter
import com.kitkat.task.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var context : Context = this

    lateinit var rv_numbers1 : RecyclerView
    lateinit var rv_numbers2 : RecyclerView

    val arrayList1 = ArrayList<ItemModel>()
    val arrayList2 = ArrayList<ItemModel>()

    val firstPositions = ArrayList<Int>()
    val secondPositions = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_numbers1 = findViewById(R.id.rv_numbers1)
        rv_numbers2 = findViewById(R.id.rv_numbers2)

        for (i in 0 until 10) {
            val itemModel = ItemModel()
            itemModel.number = i
            itemModel.checked = false

            arrayList1.add(itemModel)
        }

        val firstAdapter = FirstAdapter(arrayList1, context)
        rv_numbers1.setLayoutManager(LinearLayoutManager(context))
        rv_numbers1.adapter = firstAdapter

        val secondAdapter = SecondAdapter(arrayList2, context)
        rv_numbers2.setLayoutManager(LinearLayoutManager(context))
        rv_numbers2.adapter = secondAdapter

        move_right.setOnClickListener {

            firstPositions.sortDescending()

            for (i in 0 until firstPositions.size) {

                arrayList1.removeAt(firstPositions[i])

            }


            firstAdapter.notifyDataSetChanged()
            secondAdapter.notifyDataSetChanged()

            firstPositions.clear()

        }

        move_left.setOnClickListener {

            secondPositions.sortDescending()

            for (i in 0 until secondPositions.size) {

                arrayList2.removeAt(secondPositions[i])

            }

            firstAdapter.notifyDataSetChanged()
            secondAdapter.notifyDataSetChanged()

            secondPositions.clear()

        }

    }

    fun leftHolder(position: Int, number : Int) {

        firstPositions.add(position)

        val itemModel = ItemModel()
        itemModel.number = number
        itemModel.checked = false

        arrayList2.add(itemModel)

    }

    fun rightHolder(position: Int, number : Int) {

        secondPositions.add(position)

        val itemModel = ItemModel()
        itemModel.number = number
        itemModel.checked = false

        arrayList1.add(itemModel)

    }

}