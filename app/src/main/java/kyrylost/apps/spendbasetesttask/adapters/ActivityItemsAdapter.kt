package kyrylost.apps.spendbasetesttask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.databinding.ActivityItemsViewHolderBinding
import kyrylost.apps.spendbasetesttask.model.ActivityItemList
import kyrylost.apps.spendbasetesttask.viewholders.ActivityItemsViewHolder

class ActivityItemsAdapter(
    private val listOfActivityItems: ActivityItemList
): RecyclerView.Adapter<ActivityItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityItemsViewHolder {
        return ActivityItemsViewHolder(
            ActivityItemsViewHolderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = listOfActivityItems.count()

    override fun onBindViewHolder(holder: ActivityItemsViewHolder, position: Int) {
        val item = listOfActivityItems.get(position)
        holder.bind(item)
    }
}