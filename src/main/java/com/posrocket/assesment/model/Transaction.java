package com.posrocket.assesment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

@ToString
public class Transaction {
    @Getter
    @SerializedName("_id")
    @JsonProperty("_id")
    private String id;
    @Getter
    private String businessId;
    @Getter
    private String locationId;
    @Getter
    private String transactionId;
    @Getter
    private String receiptId;
    @Getter
    private String serialNumber;
    @Getter
    private String diningOption;
    @Getter
    private String creationTime;
    @Getter
    private Money discountMoney;
    @Getter
    private Money additiveTaxMoney;
    @Getter
    private Money inclusiveTaxMoney;
    @Getter
    private Money refundedMoney;
    @Getter
    private Money taxMoney;
    @Getter
    private Money tipMoney;
    @Getter
    private Money totalCollectedMoney;
    @Getter
    private Person creator;
    @Getter
    private Collection<TaxEntry> taxes;
    @Getter
    private Tender tender;
    @Getter
    private Collection<Item> itemization;
}
