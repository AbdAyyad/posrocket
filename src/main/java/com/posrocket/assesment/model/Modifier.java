package com.posrocket.assesment.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Modifier {
    @Getter
    private String name;
    @Getter
    private String id;
    @Getter
    private int quantity;
    @Getter
    private Money applied_money;
}
