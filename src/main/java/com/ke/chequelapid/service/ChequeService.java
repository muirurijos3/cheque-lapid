package com.ke.chequelapid.service;

import com.ke.chequelapid.domain.Cheque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChequeService {
    Page<Cheque> findAll(String bank, String customer, String datecreated, String dateOfDeposit, Pageable pageable);

    Cheque save(Cheque cheque);
}
