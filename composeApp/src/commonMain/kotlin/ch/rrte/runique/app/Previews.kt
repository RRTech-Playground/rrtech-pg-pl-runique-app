package ch.rrte.runique.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ch.rrte.app.examples.hellofuture.HelloFutureComposable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun RuniquePreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        HelloFutureComposable()
    }
}