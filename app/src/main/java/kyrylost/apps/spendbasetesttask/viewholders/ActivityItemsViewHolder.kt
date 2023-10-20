package kyrylost.apps.spendbasetesttask.viewholders

import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.R
import kyrylost.apps.spendbasetesttask.databinding.ActivityItemsViewHolderBinding
import kyrylost.apps.spendbasetesttask.model.ActivityItem


class ActivityItemsViewHolder(
    private val binding: ActivityItemsViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemData: ActivityItem) {
        itemData.apply {
            binding.receiver.text = paymentReceiver

            if (!isPaymentAccepted) {
                binding.declinedCircle.visibility = View.VISIBLE
                binding.declined.visibility = View.VISIBLE

                binding.transactionCurrency.paintFlags =
                    binding.transactionCurrency.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                binding.transactionCurrency.setTextColor(Color.parseColor("#FF7E8493"))
            }

            else {
                binding.transactionStatus.visibility = View.VISIBLE
                if (!isReceiptAdded) {
                    binding.transactionStatus.setImageResource(R.drawable.receipt_not_added)
                }
            }

            binding.transactionCurrency.text = paymentAmount

        }
    }

}