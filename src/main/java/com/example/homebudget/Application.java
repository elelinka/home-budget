package com.example.homebudget;

import com.example.homebudget.dao.TransactionDao;
import com.example.homebudget.factory.ConnectionFactory;
import com.example.homebudget.model.Transaction;
import com.example.homebudget.model.type.TransactionType;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Transaction transaction = new Transaction(TransactionType.INCOME, "ze zlecenia", new BigDecimal(2500), "2019-09-28");
        Transaction transaction1 = new Transaction(TransactionType.EXPENSE, "za wodę", new BigDecimal(500), "2019-09-28");
        TransactionDao dao = new TransactionDao(new ConnectionFactory());
        dao.save(transaction);
        dao.save(transaction1);

        TransactionType type = TransactionType.INCOME;
        List<Transaction> transactionsFromDb = dao.read(type);
        for (Transaction t : transactionsFromDb) {
            System.out.println(transactionsFromDb);
        }

        int updatedRows = dao.update(1, "wynagrodzenie");
        System.out.println(updatedRows);

        int deletedRows = dao.delete(2);
        System.out.println(deletedRows);

        dao.close();
    }
}
