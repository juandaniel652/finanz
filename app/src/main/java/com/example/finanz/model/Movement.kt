package com.example.finanz.model

enum class MovementType {
    INCOME,
    EXPENSE
}

data class Movement(
    val id: Long = 0L,
    val type: MovementType,
    val amount: Long,
    val category: String,
    val date: Long,
    val description: String = "",
    val notes: String = ""
)
