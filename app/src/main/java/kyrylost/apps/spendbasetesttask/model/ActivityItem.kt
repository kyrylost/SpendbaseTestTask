package kyrylost.apps.spendbasetesttask.model

data class ActivityItem (
    val isPaymentAccepted: Boolean,
    val paymentReceiver: String,
    val isReceiptAdded: Boolean,
    val paymentAmount: String
)