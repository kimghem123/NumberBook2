package com.example.numberbook2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numberBookList = ArrayList<NumberBook>()

        for(i in 1 until 20){
            numberBookList.add(NumberBook("${i}",""+i+"번째 사람","01000000000"))
        }

        val adapter = RecyclerViewAdapter(numberBookList, LayoutInflater.from(this))

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class RecyclerViewAdapter(
    val itemList: ArrayList<NumberBook>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val numberBookName: TextView
        val numberBookNum: TextView

        init {
            numberBookName =itemView.findViewById(R.id.numberBook_name)
            numberBookNum = itemView.findViewById(R.id.numberBook_listNum)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numberBookName.setText(itemList.get(position).name)
        holder.numberBookNum.setText(itemList.get(position).number)
        holder.itemView.setOnClickListener{
            val intentName = itemList.get(position).name
            val intentNumber = itemList.get(position).phoneNum
            val intent = Intent(holder.itemView.context,InnerActivity::class.java)
            intent.apply {
                this.putExtra("name",intentName)
                this.putExtra("phoneNum",intentNumber)
            }
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

class NumberBook(val number:String, val name:String, val phoneNum: String){

}