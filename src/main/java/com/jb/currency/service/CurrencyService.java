package com.jb.currency.service;

import com.jb.currency.exceptions.InvalidCurrencyException;
import com.jb.currency.model.Currency;
import com.jb.currency.model.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope("prototype")
@RequiredArgsConstructor
@EnableScheduling
@Configuration
public class CurrencyService {
    private final RestTemplate restTemplate;
    final String baseUrl = "https://api.exchangerate-api.com/v4/latest/";
    private Map<String, Exchange> exchangeHashMap = new HashMap<>();

    public Currency moneyConvertor(String from, String to, double amount) {
        try {
            Exchange result = (getCacheResultRates(from) != null) ? getCacheResultRates(from) : getSiteResultRates(from);
            Double multiplyResult = result.getRates().get(to) * amount;
            return new Currency(from, to, amount, multiplyResult);
        } catch (Exception e){
            throw new InvalidCurrencyException("Please verify your currency symbol");
        }
    }

    private Exchange getCacheResultRates(String from) {
        System.out.println("form cache");
        return exchangeHashMap.get(from);
    }

    private Exchange getSiteResultRates(String from) throws URISyntaxException {
        System.out.println("from site");
        URI uri = new URI(baseUrl + from);
        ResponseEntity<Exchange> result = restTemplate.getForEntity(uri, Exchange.class);
        exchangeHashMap.put(from, result.getBody());
        return result.getBody();
    }

    @Scheduled(fixedDelay = 30000, initialDelay = 30000)
    private void deleteCacheMapping() {
        System.out.println("delete cache");
        exchangeHashMap.clear();
    }
}
