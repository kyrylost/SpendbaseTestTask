package kyrylost.apps.spendbasetesttask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.databinding.ActivityViewHolderBinding
import kyrylost.apps.spendbasetesttask.model.ActivityList
import kyrylost.apps.spendbasetesttask.viewholders.ActivityViewHolder

class ActivityAdapter(
    private val activityList: ActivityList,
    private val context: Context
): RecyclerView.Adapter<ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        return ActivityViewHolder(
            ActivityViewHolderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = activityList.count()

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val item = activityList.get(position)
        holder.bind(item, context)
    }
}