package com.jb.currency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    String fromCurrency;
    String toCurrency;
    double amount;
    Double result;
}
