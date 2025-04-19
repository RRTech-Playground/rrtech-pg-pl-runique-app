package ch.rrte.runique.app.core.presentation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font

import rrtech_pg_pl_runique_app.modules.core.presentation.designsystem.generated.resources.Res
import rrtech_pg_pl_runique_app.modules.core.presentation.designsystem.generated.resources.poppins_bold
import rrtech_pg_pl_runique_app.modules.core.presentation.designsystem.generated.resources.poppins_light
import rrtech_pg_pl_runique_app.modules.core.presentation.designsystem.generated.resources.poppins_medium
import rrtech_pg_pl_runique_app.modules.core.presentation.designsystem.generated.resources.poppins_regular
import rrtech_pg_pl_runique_app.modules.core.presentation.designsystem.generated.resources.poppins_semibold

@Composable
fun Typography(): Typography {

    val Poppins = FontFamily(
        Font(
            resource = Res.font.poppins_light,
            weight = FontWeight.Light,
        ),
        Font(
            resource = Res.font.poppins_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.poppins_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resource = Res.font.poppins_semibold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resource = Res.font.poppins_bold,
            weight = FontWeight.Bold
        ),
    )

    return Typography(
        bodySmall = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 20.sp,
            color = RuniqueGray
        ),
        bodyMedium = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 24.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = RuniqueWhite
        )
    )
}