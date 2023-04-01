package com.transactioncanner.engine

import com.transactioncanner.dao.SanctionRepository
import com.transactioncanner.dao.TransactionDao
import com.transactioncanner.dao.TransactionRepository
import com.transactioncanner.entity.RulesEngineResult
import com.transactioncanner.entity.Sanction
import com.transactioncanner.entity.Transaction
import com.transactioncanner.scanner.Scanner
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class TransactionScannerHandler(
    private val transactionDao: TransactionDao,
    private val transactionRepository: TransactionRepository,
    private val sanctionRepository: SanctionRepository,
    private val scanners: List<Scanner>
) {

    @Transactional
    fun handle() {
        val transactionIds = transactionDao.getTransactionIdsToScan()

        val transactions = transactionRepository.findAllById(transactionIds)

        val sanctions = sanctionRepository.findAll()

        transactions.map {
            handleTransaction(it, sanctions)
        }

        transactionRepository.saveAll(transactions)
    }

    private fun handleTransaction(transaction: Transaction, sanctions: List<Sanction>) {
        val detectedSanctions = mutableSetOf<Sanction>()

        scanners.map {
            detectedSanctions.addAll(it.scan(transaction, sanctions))
        }
        val result = RulesEngineResult()

        result.isClear = detectedSanctions.isEmpty()

        if (detectedSanctions.isNotEmpty()) {
            result.sanction = detectedSanctions.first()
        }

        checkNotNull(transaction.operatorResult).rulesEngineResult = result
    }
}