package kyrylost.apps.spendbasetesttask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.viewholders.CardViewHolder
import kyrylost.apps.spendbasetesttask.model.CardsList
import kyrylost.apps.spendbasetesttask.databinding.MyCardsItemBinding

class CardAdapter(
    private val cardsList: CardsList
) : RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            MyCardsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardsList.get(position)
        holder.bind(cardItem)
    }

    override fun getItemCount(): Int = cardsList.count()

}