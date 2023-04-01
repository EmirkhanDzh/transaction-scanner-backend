package com.transactioncanner.dao

import com.transactioncanner.entity.Operator
import org.springframework.data.jpa.repository.JpaRepository

interface OperatorRepository: JpaRepository<Operator, Long>