package ch.rrte.runique.app.shell.presentation.app_shell

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import ch.rrte.app.examples.hellofuture.HelloFutureComposable

@Composable
fun AppShell() {
    MaterialTheme {
        HelloFutureComposable()
    }
}