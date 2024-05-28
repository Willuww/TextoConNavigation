package mx.edu.uttt.navigationcomponent.detalles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PantallaDetalle(body: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Pantalla de Detalles")
        Text(text = "Body : $body", color = Color.Red)
    }
}