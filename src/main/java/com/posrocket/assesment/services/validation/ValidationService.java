package com.posrocket.assesment.services.validation;

import com.posrocket.assesment.Constants;
import com.posrocket.assesment.model.Money;
import com.posrocket.assesment.model.TaxEntry;
import com.posrocket.assesment.model.Transaction;
import com.posrocket.assesment.utils.ConfigurationUtil;

import java.util.Collection;
import java.util.Optional;

public class ValidationService implements IValidationService {
    private static final double MAX_ERROR_ALLOWED = Double.parseDouble(ConfigurationUtil.getConfig(Constants.Configurations.MAX_ERROR_KEY));

    @Override
    public boolean validate(TaxEntry entry, Money money) {
        double expectedTax = money.getAmount() * entry.getRate();
        return expectedTax - entry.getAppliedMoney().getAmount() <= MAX_ERROR_ALLOWED;
    }

    @Override
    public boolean validate(Collection<TaxEntry> entries, Money money) {
        Optional<Boolean> result = entries
                .stream()
                .map(entry -> validate(entry, money))
                .reduce((a, b) -> a && b);
        if (result.isEmpty()) {
            throw new RuntimeException("no taxes");
        }
        return result.get();
    }

    @Override
    public boolean validate(Transaction transaction) {
        Optional<Boolean> result = transaction
                .getItemization()
                .stream()
                .map(item -> validate(item.getTaxes(), item.getNetSalesMoney()))
                .reduce((a, b) -> a && b);
        if (result.isEmpty()) {
            throw new RuntimeException("empty transaction");
        }
        return result.get();
    }
}
