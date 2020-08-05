package com.posrocket.assesment.services.validation;

import com.posrocket.assesment.model.Money;
import com.posrocket.assesment.model.TaxEntry;
import com.posrocket.assesment.model.Transaction;

import java.util.Collection;

public interface IValidationService {
    boolean validate(TaxEntry entry, Money money);

    boolean validate(Collection<TaxEntry> entries, Money money);

    boolean validate(Transaction transaction);
}
