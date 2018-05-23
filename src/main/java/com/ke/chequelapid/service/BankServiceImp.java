package com.ke.chequelapid.service;

import java.util.List;

import com.ke.chequelapid.domain.Bank;
import com.ke.chequelapid.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImp implements BankService {

    @Autowired
    BankRepository bankRepository;

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}
