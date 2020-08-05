package com.posrocket.assesment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
public class TaxEntry {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private double rate;
    @Getter
    private String inclusionType;
    @Getter
    @JsonProperty("is_custom_amount")
    private boolean isCustomAmount;
    @Getter
    private Money appliedMoney;
}
