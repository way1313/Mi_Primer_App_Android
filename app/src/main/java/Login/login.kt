import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.miprimerappandroid.R



// 1. Definimos el color personalizado (#004D41)
val CustomPrimaryColor = Color(0xFF004D41)

// 2. Creamos un tema personalizado para aplicar el color
@Composable
fun CustomTheme(content: @Composable () -> Unit) {
    val customColorScheme = lightColorScheme(
        primary = CustomPrimaryColor,
        primaryContainer = CustomPrimaryColor,
        onPrimary = Color.White
    )

    MaterialTheme(
        colorScheme = customColorScheme,
        content = content
    )
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Spacer un componente propio para separar un poco el logo de la parte de arriba
        Spacer(modifier = Modifier.height(70.dp))

        // Logotipo - Imagen
        Image(
            painter = painterResource(id = R.drawable.mi_logotipo),
            contentDescription = "Logotipo de la aplicación",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 24.dp)
        )

        // Título Principal
        Text(
            text = "Bienvenido a Voltt",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Inicia sesión para continuar",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Campo de Correo Electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = MaterialTheme.shapes.large, // <-- Redondeado de campo Correo
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Campo de Contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = MaterialTheme.shapes.large, // <-- Redondeado de campo Password
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            singleLine = true
        )

        // Botón de Iniciar Sesión (Adopta el color primary automáticamente)
        Button(
            onClick = { /* Lógica futura */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Iniciar Sesión",
                style = MaterialTheme.typography.titleMedium
            )
        }

        // Botón de Google
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = { /* Lógica futura */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Icono de Google",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Continuar con Google",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        // Cierre Botón de Google

        TextButton(
            onClick = { /* Lógica futura */ },
            modifier = Modifier.padding(top = 16.dp)
        ){
            Text(
                text = "¿Olvidaste tu contraseña?",
                color = CustomPrimaryColor // Aplicamos el color también al texto secundario
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    CustomTheme {
        LoginScreen()
    }
}
