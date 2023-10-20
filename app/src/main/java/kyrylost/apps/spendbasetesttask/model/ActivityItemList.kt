package kyrylost.apps.spendbasetesttask.model

data class ActivityItemList(
    val listOfActivityItems: List<ActivityItem>
) {
    fun count() = listOfActivityItems.count()
    fun get(index: Int) = listOfActivityItems[index]
}
