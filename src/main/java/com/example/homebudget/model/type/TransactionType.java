package com.example.homebudget.model.type;

public enum TransactionType {
    INCOME("przychod"),
    EXPENSE("wydatek");

    private String name;

    private TransactionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
