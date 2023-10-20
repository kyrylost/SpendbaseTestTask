package kyrylost.apps.spendbasetesttask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.databinding.RecentTransactionsItemBinding
import kyrylost.apps.spendbasetesttask.model.TransactionList
import kyrylost.apps.spendbasetesttask.viewholders.TransactionViewHolder

class TransactionAdapter(
    private val transactionList: TransactionList
) : RecyclerView.Adapter<TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            RecentTransactionsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactionList.get(position)
        holder.bind(transaction)
    }

    override fun getItemCount(): Int = transactionList.count()

}