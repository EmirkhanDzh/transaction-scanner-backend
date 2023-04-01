package com.transactioncanner.scanner

import com.transactioncanner.entity.Sanction
import com.transactioncanner.entity.Transaction
import org.springframework.stereotype.Component

@Component
class PaySystemScannerImpl : Scanner {
    companion object {
        const val TYPE = "PaySystemSanctionList"
    }

    override fun sanctionIndicator(tr: Transaction, s: Sanction): Boolean {
        return s.type == TYPE && (s.value == tr.paySystemTo || s.value == tr.paySystemFrom)
    }


}