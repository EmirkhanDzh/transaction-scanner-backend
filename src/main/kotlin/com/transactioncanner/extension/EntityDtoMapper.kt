package com.transactioncanner.extension

import com.transactioncanner.dto.OperatorDto
import com.transactioncanner.dto.OperatorResultDto
import com.transactioncanner.dto.RulesEngineResultDto
import com.transactioncanner.dto.SanctionDto
import com.transactioncanner.dto.TransactionDto
import com.transactioncanner.entity.Operator
import com.transactioncanner.entity.OperatorsResult
import com.transactioncanner.entity.RulesEngineResult
import com.transactioncanner.entity.Sanction
import com.transactioncanner.entity.Transaction

fun TransactionDto.toEntity() = Transaction(
    id = this.id,
    clientFrom = this.clientFrom,
    clientTo = this.clientTo,
    amount = this.amount,
    bankFrom = this.bankFrom,
    bankTo = this.bankTo,
    paySystemFrom = this.paySystemFrom,
    paySystemTo = this.paySystemTo,
    transferDate = this.transferDate,
    countryFrom = this.countryFrom,
    countryTo = this.countryTo,
    operatorResult = this.operatorResult?.toEntity(),
)

fun Transaction.toDto() = TransactionDto(
    id = this.id,
    clientFrom = this.clientFrom,
    clientTo = this.clientTo,
    amount = this.amount,
    bankFrom = this.bankFrom,
    bankTo = this.bankTo,
    paySystemFrom = this.paySystemFrom,
    paySystemTo = this.paySystemTo,
    transferDate = this.transferDate,
    countryFrom = this.countryFrom,
    countryTo = this.countryTo,
    operatorResult = this.operatorResult?.toDto(),
)

fun OperatorResultDto.toEntity() = OperatorsResult(
    id = this.id,
    isClear = this.isClear,
    comment = this.comment,
    operator = this.operator?.toEntity(),
    rulesEngineResult = this.rulesEngineResult?.toEntity(),
)

fun OperatorsResult.toDto() = OperatorResultDto(
    id = this.id,
    isClear = this.isClear,
    comment = this.comment,
    operator = this.operator?.toDto(),
    rulesEngineResult = this.rulesEngineResult?.toDto(),
)

fun OperatorDto.toEntity() = Operator(
    id = this.id,
    username = this.username,
    password = this.password,
)

fun Operator.toDto() = OperatorDto(
    id = this.id,
    username = this.username,
    password = this.password,
)

fun RulesEngineResultDto.toEntity() = RulesEngineResult(
    id = this.id,
    isClear = this.isClear,
    sanction = this.sanction?.toEntity(),
)

fun RulesEngineResult.toDto() = RulesEngineResultDto(
    id = this.id,
    isClear = this.isClear,
    sanction = this.sanction?.toDto(),
)

fun SanctionDto.toEntity() = Sanction(
    id = this.id,
    type = this.type,
    value = this.value,
    description = this.description,
)

fun Sanction.toDto() = SanctionDto(
    id = this.id,
    type = this.type,
    value = this.value,
    description = this.description,
)