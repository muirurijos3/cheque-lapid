package com.ke.chequelapid.controller;

import java.util.List;

import com.ke.chequelapid.domain.Bank;
import com.ke.chequelapid.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "banks", produces = MediaType.APPLICATION_JSON_VALUE)
public class BankController {

    @Autowired
    private BankService bankService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "bank", method = {RequestMethod.GET})
    @ResponseBody
    public List<Bank> getBanks(){
        return bankService.getAllBanks();
    }
}
