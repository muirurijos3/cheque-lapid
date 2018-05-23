package com.ke.chequelapid.repository;

import com.ke.chequelapid.domain.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque,Long>, JpaSpecificationExecutor {
}
