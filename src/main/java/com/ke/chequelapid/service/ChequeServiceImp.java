package com.ke.chequelapid.service;

import com.ke.chequelapid.domain.Cheque;
import com.ke.chequelapid.repository.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.ke.chequelapid.specification.ChequeSpecification.findChequeByParams;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class ChequeServiceImp implements ChequeService {

    @Autowired
    ChequeRepository chequeRepository;

    @Override
    public Page<Cheque> findAll(String bank, String customer, String datecreated, String dateOfDeposit, Pageable pageable) {
        //If nothing is returned by method
        return chequeRepository.findAll(where(findChequeByParams(bank, customer, datecreated, dateOfDeposit)), pageable);
    }

    @Override
    public Cheque save(Cheque cheque) {
        return chequeRepository.save(cheque);
    }
}
