package com.ronasit.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Immutable
data class AppColor(
    val primary: Color,
    val primaryTap: Color,
    val white: Color,
    val grayLight: Color,
    val grayNormal: Color,
    val grayDark: Color,
    val blackElements: Color,
    val blackCard: Color,
    val blackBG: Color
)

@Immutable
data class AppTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val title5: TextStyle,
    val bodyLarge: TextStyle,
    val bodyLargeBold: TextStyle,
    val bodyDefault: TextStyle,
    val bodyDefaultBold: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallBold: TextStyle,
    val bodyExtraSmall: TextStyle,
    val bodyExtraSmallBold: TextStyle
)

fun darkColors(): AppColor = AppColor(
    primary = ChristiLight,
    primaryTap = ChristiDark,
    white = White,
    grayLight = Concrete,
    grayNormal = Loblolly,
    grayDark = OsloGray,
    blackElements = Mirage,
    blackCard = EbonyClay,
    blackBG = BlackPearl
)

fun gilroyTypography(): AppTypography = AppTypography(
    title1 = GilroyTypography.title1,
    title2 = GilroyTypography.title2,
    title3 = GilroyTypography.title3,
    title4 = GilroyTypography.title4,
    title5 = GilroyTypography.title5,
    bodyLarge = GilroyTypography.bodyLarge,
    bodyLargeBold = GilroyTypography.bodyLargeBold,
    bodyDefault = GilroyTypography.bodyDefault,
    bodyDefaultBold = GilroyTypography.bodyDefaultBold,
    bodySmall = GilroyTypography.bodySmall,
    bodySmallBold = GilroyTypography.bodySmallBold,
    bodyExtraSmall = GilroyTypography.bodyExtraSmall,
    bodyExtraSmallBold = GilroyTypography.bodyExtraSmallBold
)

val LocalColors = staticCompositionLocalOf {
    AppColor(
        primary = Color.Unspecified,
        primaryTap = Color.Unspecified,
        white = Color.Unspecified,
        grayLight = Color.Unspecified,
        grayNormal = Color.Unspecified,
        grayDark = Color.Unspecified,
        blackElements = Color.Unspecified,
        blackCard = Color.Unspecified,
        blackBG = Color.Unspecified
    )
}

val LocalTypography = staticCompositionLocalOf {
    AppTypography(
        title1 = TextStyle.Default,
        title2 = TextStyle.Default,
        title3 = TextStyle.Default,
        title4 = TextStyle.Default,
        title5 = TextStyle.Default,
        bodyLarge = TextStyle.Default,
        bodyLargeBold = TextStyle.Default,
        bodyDefault = TextStyle.Default,
        bodyDefaultBold = TextStyle.Default,
        bodySmall = TextStyle.Default,
        bodySmallBold = TextStyle.Default,
        bodyExtraSmall = TextStyle.Default,
        bodyExtraSmallBold = TextStyle.Default
    )
}

@Composable
fun RickAndMortyTheme(
    content: @Composable () -> Unit
) {
    @Suppress
    val rickAndMortyColors = darkColors()

    @Suppress
    val rickAndMortyTypography = gilroyTypography()

    CompositionLocalProvider(
        LocalColors provides rickAndMortyColors,
        LocalTypography provides rickAndMortyTypography,
        content = content
    )
}

@Suppress
object RickAndMortyTheme {
    @Suppress
    val colors: AppColor
        @Composable
        get() = LocalColors.current

    @Suppress
    val typography: AppTypography
        @Composable
        get() = LocalTypography.current
}
