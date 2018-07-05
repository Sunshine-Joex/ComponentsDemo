package com.example.main_module

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.main_module.bean.GithubBean
import kotlinx.android.synthetic.main.layout.view.*

class TestAdapter(val data: List<GithubBean>) : RecyclerView.Adapter<TestAdapter.GithubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.layout, parent, false)

        return GithubViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(data[position])
    }


    class GithubViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: GithubBean) {
            binding.root.tv.setOnClickListener {
//                 Toast.makeText(it.context,data.who,Toast.LENGTH_SHORT).show()
            }
            binding.setVariable(BR.data, data)
            binding.executePendingBindings()
        }
    }

}