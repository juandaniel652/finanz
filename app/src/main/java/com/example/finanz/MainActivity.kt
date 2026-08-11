package com.example.finanz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Category

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
                        // Más adelante abrirá el formulario
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar movimiento"
                    )
                }
            },
            bottomBar = {
                NavigationBar {

                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.AccountBalanceWallet,
                                contentDescription = "Inicio"
                            )
                        },
                        label = {
                            Text("Inicio")
                        }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.List,
                                contentDescription = "Movimientos"
                            )
                        },
                        label = {
                            Text("Movimientos")
                        }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.Category,
                                contentDescription = "Categorías"
                            )
                        },
                        label = {
                            Text("Categorías")
                        }
                    )
                }
            }
        ) { innerPadding ->

            HomeScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
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
                .padding(24.dp)
        ) {

            Text(
                text = "Finanz",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Saldo",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = "$0,00",
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                SummaryItem(
                    title = "Ingresos",
                    value = "$0,00"
                )

                SummaryItem(
                    title = "Gastos",
                    value = "$0,00"
                )

                SummaryItem(
                    title = "Ahorro",
                    value = "$0,00"
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Movimientos",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "No hay movimientos todavía.",
                style = MaterialTheme.typography.bodyLarge
            )

            TextButton(
                onClick = {}
            ) {
                Text("Agregar movimiento")
            }
        }
    }
}

@Composable
fun SummaryItem(
    title: String,
    value: String
) {

    Column(
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = value,
            fontSize = 16.sp
        )
    }
}