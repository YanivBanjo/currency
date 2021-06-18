package com.jb.currency.controller;

import com.jb.currency.model.Currency;
import com.jb.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("money")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("convert")
    @ResponseStatus(HttpStatus.OK)
    public Currency convertMoney(@RequestParam String from, @RequestParam String to, @RequestParam double amount) throws URISyntaxException {

        return currencyService.moneyConvertor(from, to, amount);
    }
}
