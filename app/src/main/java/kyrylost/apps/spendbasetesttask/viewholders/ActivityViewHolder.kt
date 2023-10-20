package kyrylost.apps.spendbasetesttask.viewholders

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.adapters.ActivityItemsAdapter
import kyrylost.apps.spendbasetesttask.databinding.ActivityViewHolderBinding
import kyrylost.apps.spendbasetesttask.model.ActivityItemList

class ActivityViewHolder(
    private val binding: ActivityViewHolderBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(itemData: Pair<String, ActivityItemList>, context: Context) {
        itemData.apply {
            binding.date.text = first
            val adapter = ActivityItemsAdapter(second)
            binding.activityItemsRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.activityItemsRecyclerView.adapter = adapter
        }
    }
}