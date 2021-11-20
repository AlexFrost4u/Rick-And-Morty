package com.ronasit.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ronasit.core.ui.R

val gilroyFamily = FontFamily(
    Font(R.font.gilroy_bold, weight = FontWeight.Bold),
    Font(R.font.gilroy_medium, weight = FontWeight.Medium),
    Font(R.font.gilroy_regular, weight = FontWeight.Normal),
    Font(R.font.gilroy_semi_bold, weight = FontWeight.SemiBold)
)

@Immutable
object GilroyTypography {
    val title1: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 44.sp, fontWeight = FontWeight.Bold)
    val title2: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 28.sp, fontWeight = FontWeight.Bold)
    val title3: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 22.sp, fontWeight = FontWeight.Bold)
    val title4: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    val title5: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
    val bodyLarge: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 17.sp, fontWeight = FontWeight.Medium)
    val bodyLargeBold: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 17.sp, fontWeight = FontWeight.Bold)
    val bodyDefault: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    val bodyDefaultBold: TextStyle =
        TextStyle(fontFamily = gilroyFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    val bodySmall: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 13.sp, fontWeight = FontWeight.Medium)
    val bodySmallBold: TextStyle = TextStyle(fontFamily = gilroyFamily, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    val bodyExtraSmall: TextStyle =
        TextStyle(fontFamily = gilroyFamily, fontSize = 12.sp, fontWeight = FontWeight.Medium)
    val bodyExtraSmallBold: TextStyle =
        TextStyle(fontFamily = gilroyFamily, fontSize = 12.sp, fontWeight = FontWeight.Bold)
}
