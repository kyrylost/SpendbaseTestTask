package kyrylost.apps.spendbasetesttask.model

import android.graphics.Bitmap

data class Transaction (
    val appLogoData: Bitmap,
    val details: String,
    val lastFourDigits: String,
    val transactionCurrency: String,
    val isReceiptAdded: Boolean
)