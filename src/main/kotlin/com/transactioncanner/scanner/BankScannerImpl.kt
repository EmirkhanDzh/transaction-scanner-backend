package com.transactioncanner.scanner

import com.transactioncanner.entity.Sanction
import com.transactioncanner.entity.Transaction
import org.springframework.stereotype.Component

@Component
class BankScannerImpl : Scanner {
    companion object {
        const val TYPE = "BankSanctionList"
    }
    override fun sanctionIndicator(tr: Transaction, s: Sanction): Boolean {
        return s.type == TYPE && (s.value == tr.bankTo || s.value == tr.bankFrom)
    }
}