package com.transactioncanner.dao;

import com.transactioncanner.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
    fun findAllByOperatorResult_OperatorId(operatorId: Long): List<Transaction>
//    fun findAllById
}