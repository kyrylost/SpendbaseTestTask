package kyrylost.apps.spendbasetesttask.viewholders

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.R
import kyrylost.apps.spendbasetesttask.databinding.RecentTransactionsItemBinding
import kyrylost.apps.spendbasetesttask.model.Transaction

class TransactionViewHolder(
    private val binding: RecentTransactionsItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(itemData: Transaction) {
        binding.appLogo.setImageBitmap(itemData.appLogoData)
        binding.details.text = itemData.details
        binding.cardNumberLastFour.text = "••" + itemData.lastFourDigits
        binding.transactionCurrency.text = itemData.transactionCurrency

        if (itemData.isReceiptAdded) {
            binding.transactionStatus.setImageResource(R.drawable.receipt_added)
        }
        else {
            binding.transactionStatus.setImageResource(R.drawable.receipt_not_added)
        }

        if (itemData.transactionCurrency[0] != '–') {
            binding.transactionCurrency.setTextColor(Color.parseColor("#FF00AC4F"))
        }
    }

}