package com.posrocket.assesment.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Tender {
    @Getter
    private String type;
    @Getter
    private String name;
    @Getter
    private Money totalMoney;
}
