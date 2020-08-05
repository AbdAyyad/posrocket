package com.posrocket.assesment.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

@ToString
public class Item {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String quantity;
    @Getter
    private Money totalMoney;
    @Getter
    private Money singleQuantityMoney;
    @Getter
    private Money grossSalesMoney;
    @Getter
    private Money discountMoney;
    @Getter
    private Money netSalesMoney;
    @Getter
    private Collection<TaxEntry> taxes;
    @Getter
    private Category category;
    @Getter
    private Variation variation;
    @Getter
    private Collection<String> discounts;
    @Getter
    private Collection<Modifier> modifiers;
}
