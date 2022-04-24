package com.scooty.scooty.repository;

import com.scooty.scooty.table.Transaction;
import liquibase.pro.packaged.id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, id> {

}
