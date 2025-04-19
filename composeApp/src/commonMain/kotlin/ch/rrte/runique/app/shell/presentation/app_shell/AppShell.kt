package ch.rrte.runique.app.shell.presentation.app_shell

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ch.rrte.app.examples.hellofuture.HelloFutureComposable
import ch.rrte.runique.app.core.presentation.designsystem.RuniqueTheme

@Composable
fun AppShell() {
    RuniqueTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HelloFutureComposable()
        }
    }
}