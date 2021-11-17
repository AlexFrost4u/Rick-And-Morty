package com.ronasit.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Immutable
data class AppCustomColors(
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
data class AppCustomTypography(
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

val LocalCustomColors = staticCompositionLocalOf {
    AppCustomColors(
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

val LocalCustomTypography = staticCompositionLocalOf {
    AppCustomTypography(
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
fun CustomTheme() {
    val customColors = AppCustomColors(
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
    val customTypography = AppCustomTypography(
        title1 = CustomTypography.title1,
        title2 = CustomTypography.title2,
        title3 = CustomTypography.title3,
        title4 = CustomTypography.title4,
        title5 = CustomTypography.title5,
        bodyLarge = CustomTypography.bodyLarge,
        bodyLargeBold = CustomTypography.bodyLargeBold,
        bodyDefault = CustomTypography.bodyDefault,
        bodyDefaultBold = CustomTypography.bodyDefaultBold,
        bodySmall = CustomTypography.bodySmall,
        bodySmallBold = CustomTypography.bodySmallBold,
        bodyExtraSmall = CustomTypography.bodyExtraSmall,
        bodyExtraSmallBold = CustomTypography.bodyExtraSmallBold
    )

}

object CustomTheme {
    val colors: AppCustomColors
        @Composable
        get() = LocalCustomColors.current
    val typography: AppCustomTypography
        @Composable
        get() = LocalCustomTypography.current
}

@Composable
fun RickAndMortyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
