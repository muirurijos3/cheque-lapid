package com.ke.chequelapid.controller;


import com.ke.chequelapid.domain.Cheque;
import com.ke.chequelapid.service.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cheques", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChequeController {

    @Autowired
    private ChequeService chequeService;

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseBody
    public Page<Cheque> getCheques(
            @RequestParam(name = "bank", required = false)String bank,
            @RequestParam(name = "customer", required = false)String customer,
            @RequestParam(name = "dateCreated", required = false)String dateCreated,
            @RequestParam(name = "dateOfDeposit", required = false)String dateOfDeposit,
            Pageable page){
        return chequeService.findAll(bank, customer,dateCreated,dateOfDeposit, page);
    }

    @RequestMapping(method = {RequestMethod.POST})
    @ResponseBody
    public Cheque saveCheque(@RequestBody Cheque cheque){
        return chequeService.save(cheque);
    }
}
