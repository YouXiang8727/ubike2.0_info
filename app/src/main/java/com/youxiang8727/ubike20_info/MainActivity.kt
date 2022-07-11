package com.youxiang8727.ubike20_info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.youxiang8727.ubike20_info.databinding.ActivityMainBinding
import com.youxiang8727.ubike20_info.model.UbikeResponse
import com.youxiang8727.ubike20_info.service.UbikeDataService
import com.youxiang8727.ubike20_info.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecyclerViewUbikeResponseAdapter()
        binding.recyclerViewUbikeDataList.layoutManager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        binding.recyclerViewUbikeDataList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        binding.recyclerViewUbikeDataList.adapter = adapter

        startService(Intent(this, UbikeDataService::class.java))
    }

    inner class RecyclerViewUbikeResponseAdapter: RecyclerView.Adapter<RecyclerViewUbikeResponseAdapter.ViewHolder>(){
        private var ubikeResponseList = listOf<UbikeResponse>()

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvSna: TextView = itemView.findViewById(R.id.tv_sna)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ubike_data, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvSna.text = ubikeResponseList[position].sna
        }

        override fun getItemCount(): Int {
            return ubikeResponseList.size
        }

        fun setData(data: List<UbikeResponse>){
            ubikeResponseList = data
            notifyDataSetChanged()
        }
    }
}