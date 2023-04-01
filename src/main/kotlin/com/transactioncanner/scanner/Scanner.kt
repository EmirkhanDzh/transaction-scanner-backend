package com.transactioncanner.scanner

import com.transactioncanner.entity.Sanction
import com.transactioncanner.entity.Transaction

interface Scanner {
    fun scan(tr: Transaction, sanctions: List<Sanction>): List<Sanction> {

        return sanctions.filter { s ->
            sanctionIndicator(tr, s)
        }
    }

    fun sanctionIndicator(tr: Transaction, s: Sanction): Boolean
}