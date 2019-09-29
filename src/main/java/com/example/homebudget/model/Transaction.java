package com.example.homebudget.model;

import com.example.homebudget.model.type.TransactionType;

import java.math.BigDecimal;

public class Transaction {

    private long id;
    private TransactionType type;
    private String description;
    private BigDecimal amount;
    private String date;

    public Transaction() {
    }

    public Transaction(TransactionType type, BigDecimal amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(TransactionType type, String description, BigDecimal amount, String date) {
        this(type, amount, date);
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
