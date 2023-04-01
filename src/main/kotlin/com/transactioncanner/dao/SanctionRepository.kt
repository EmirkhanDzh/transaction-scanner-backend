package com.transactioncanner.dao;

import com.transactioncanner.entity.Sanction
import org.springframework.data.jpa.repository.JpaRepository

interface SanctionRepository : JpaRepository<Sanction, Long> {
}