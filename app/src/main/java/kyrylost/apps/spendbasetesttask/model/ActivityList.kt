package kyrylost.apps.spendbasetesttask.model

data class ActivityList(
    val listOfDatesAndActivities: List<Pair<String, ActivityItemList>>
) {
    fun count() = listOfDatesAndActivities.count()
    fun get(index: Int) = listOfDatesAndActivities[index]
}
