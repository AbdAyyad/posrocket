package com.posrocket.assesment.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Variation {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String pricingType;
    @Getter
    private Money priceMoney;
}
