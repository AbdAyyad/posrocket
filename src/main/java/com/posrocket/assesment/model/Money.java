package com.posrocket.assesment.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Money {
    @Getter
    private String currency;
    @Getter
    private int amount;
}
