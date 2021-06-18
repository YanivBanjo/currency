package com.jb.currency.model;

import lombok.Data;

import java.util.Map;

@Data
public class Exchange {
    String provider;
    String WARNING_UPGRADE_TO_V6;
    String terms;
    String base;
    String date;
    int time_last_updated;
    Map<String, Double> rates;
}
