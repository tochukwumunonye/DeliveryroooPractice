package com.tochukwu.deliveryrooopractice.data.model

data class Payment(
    val identification: Identification,
    val integrationType: String,
    val interaction: Interaction,
    val links: Links,
    val networks: Networks,
    val operation: String,
    val operationType: String,
    val payment: PaymentX,
    val resultCode: String,
    val resultInfo: String,
    val returnCode: ReturnCode,
    val status: Status,
    val style: Style,
    val timestamp: String
)