package com.eniro.nautical.presentation.scene.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eniro.nautical.databinding.ItemMainMenuBinding
import com.eniro.nautical.util.visible

class MainMenuAdapter(private val items: List<MainMenuItem>): RecyclerView.Adapter<MainMenuAdapter.MainMenuHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuHolder {
        val itemBinding = ItemMainMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainMenuHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainMenuHolder, position: Int) {
        val item: MainMenuItem = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.count()

    class MainMenuHolder(private val binding: ItemMainMenuBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MainMenuItem) {
            binding.icon.setImageResource(item.icon)
            binding.title.setText(item.name)
            item.onSwitch?.let {
                binding.toggle.setOnCheckedChangeListener { _, isChecked -> it(isChecked) }
            } ?: binding.toggle.visible(false)
            binding.root.setOnClickListener {
                if (item.onSwitch == null || binding.toggle.isChecked) {
                    item.onClick()
                }
            }
        }
    }
}