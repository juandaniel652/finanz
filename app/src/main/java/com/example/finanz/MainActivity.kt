package com.example.finanz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FinanzGreen = Color(0xFF059669)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FinanzApp()
        }
    }
}

@Composable
fun FinanzApp() {

    MaterialTheme {

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        // Etapa 5: abrirá el formulario
                    },
                    containerColor = FinanzGreen,
                    contentColor = Color.White
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar movimiento"
                    )
                }
            },
            bottomBar = {
                FinanzNavigationBar()
            }
        ) { innerPadding ->

            HomeScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun FinanzNavigationBar() {

    NavigationBar(
        modifier = Modifier.navigationBarsPadding()
    ) {

        NavigationBarItem(
            selected = true,
            onClick = {
                // Etapa futura: navegación
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBalanceWallet,
                    contentDescription = "Inicio"
                )
            },
            label = {
                Text("Inicio")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                // Etapa futura: pantalla de movimientos
            },
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "Movimientos"
                )
            },
            label = {
                Text("Movimientos")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                // Etapa futura: pantalla de categorías
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = "Categorías"
                )
            },
            label = {
                Text("Categorías")
            }
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Finanz",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            BalanceCard()

            Spacer(modifier = Modifier.height(20.dp))

            SummarySection()

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Movimientos",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            EmptyMovements()
        }
    }
}

@Composable
fun BalanceCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = FinanzGreen
        )
    ) {

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Text(
                text = "Saldo disponible",
                color = Color.White.copy(alpha = 0.85f),
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$0,00",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SummarySection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        SummaryItem(
            modifier = Modifier.weight(1f),
            title = "Ingresos",
            value = "$0,00",
            valueColor = FinanzGreen
        )

        SummaryItem(
            modifier = Modifier.weight(1f),
            title = "Gastos",
            value = "$0,00",
            valueColor = MaterialTheme.colorScheme.error
        )

        SummaryItem(
            modifier = Modifier.weight(1f),
            title = "Ahorro",
            value = "$0,00",
            valueColor = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun SummaryItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    valueColor: Color
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = value,
                color = valueColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun EmptyMovements() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.AccountBalanceWallet,
            contentDescription = null,
            modifier = Modifier.size(42.dp),
            tint = FinanzGreen.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "No hay movimientos todavía",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Agregá tu primer movimiento con el botón +",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}