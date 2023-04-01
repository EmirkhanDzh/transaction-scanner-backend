package com.transactioncanner.scanner

import com.transactioncanner.entity.Sanction
import com.transactioncanner.entity.Transaction
import org.springframework.stereotype.Component

@Component
class ClientScannerImpl : Scanner {
    companion object {
        const val TYPE = "ClientSanctionList"
    }

    override fun sanctionIndicator(tr: Transaction, s: Sanction): Boolean {
        return s.type == TYPE && (s.value == tr.clientTo || s.value == tr.clientFrom)
    }
}