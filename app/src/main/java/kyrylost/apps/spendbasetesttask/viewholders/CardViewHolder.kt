package kyrylost.apps.spendbasetesttask.viewholders

import androidx.recyclerview.widget.RecyclerView
import kyrylost.apps.spendbasetesttask.model.Card
import kyrylost.apps.spendbasetesttask.databinding.MyCardsItemBinding

class CardViewHolder (
    private val binding: MyCardsItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemData: Card) {
        binding.appLogo.setImageBitmap(itemData.appLogoData)
        binding.details.text = itemData.details
        binding.cardNumberLastFour.text = itemData.lastFourDigits
    }

}