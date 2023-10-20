package kyrylost.apps.spendbasetesttask.model

data class CardsList(
    val cardsList: List<Card>
) {
    fun count() = cardsList.count()
    fun get(index: Int) = cardsList[index]
}
