package kyrylost.apps.spendbasetesttask.model

data class TransactionList(
    val transactionList: List<Transaction>
) {
    fun count() = transactionList.count()
    fun get(index: Int) = transactionList[index]
}