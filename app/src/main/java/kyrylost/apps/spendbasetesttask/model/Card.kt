package kyrylost.apps.spendbasetesttask.model

import android.graphics.Bitmap

data class Card (
    val appLogoData: Bitmap,
    val details: String,
    val lastFourDigits: String
)