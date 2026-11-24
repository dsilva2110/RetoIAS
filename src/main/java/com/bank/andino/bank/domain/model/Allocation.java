package com.bank.andino.bank.domain.model;

import com.bank.andino.bank.domain.model.enums.AllocationConcept;

import java.math.BigDecimal;
import java.util.UUID;

public class Allocation {

    private UUID id;

    private UUID paymentId;

    private AllocationConcept concept;

    private BigDecimal amount;
}
