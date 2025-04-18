package ch.rrte.runique.app.shell

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ch.rrte.runique.app.shell.components.HelloFutureComposable

@Composable
fun AppShell() {
    MaterialTheme {
        HelloFutureComposable()
    }
}