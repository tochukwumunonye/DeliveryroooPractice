package com.tochukwu.deliveryrooopractice.data.model

data class Applicable(
    val code: String,
    val contractData: ContractData,
    val grouping: String,
    val inputElements: List<InputElement>,
    val label: String,
    val links: LinksX,
    val method: String,
    val operationType: String,
    val recurrence: String,
    val redirect: Boolean,
    val registration: String,
    val selected: Boolean
)