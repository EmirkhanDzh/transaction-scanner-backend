package com.transactioncanner.dao;

import com.transactioncanner.entity.OperatorsResult
import org.springframework.data.jpa.repository.JpaRepository

interface OperatorsResultRepository : JpaRepository<OperatorsResult, Long> {
}