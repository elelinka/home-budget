package com.example.homebudget.dao;

import com.example.homebudget.factory.ConnectionFactory;
import com.example.homebudget.model.Transaction;
import com.example.homebudget.model.type.TransactionType;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TransactionDao {

    private Connection connection;

    public TransactionDao(ConnectionFactory connectionFactory) throws SQLException, ClassNotFoundException {
        connection = connectionFactory.createConnection();
    }

    public void save(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions(type, description, amount, date) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(transaction.getType()));
        preparedStatement.setString(2, transaction.getDescription());
        preparedStatement.setBigDecimal(3, transaction.getAmount());
        preparedStatement.setString(4, transaction.getDate());

        preparedStatement.executeUpdate();
    }

    public List<Transaction> read(TransactionType type) throws SQLException {
        String query = "SELECT * FROM transactions WHERE type = ?";
        List<Transaction> transactions = new LinkedList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(type));

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String typeFromDb = resultSet.getString(2);
            String description = resultSet.getString(3);
            BigDecimal amount = resultSet.getBigDecimal(4);
            String date = resultSet.getString(5);

            Transaction transaction = new Transaction();
            transaction.setId(id);
            transaction.setType(TransactionType.valueOf(typeFromDb));
            transaction.setDescription(description);
            transaction.setAmount(amount);
            transaction.setDate(date);

            transactions.add(transaction);

            return transactions;
        }
        return null;
    }

    public int update(long id, String description) throws SQLException {
        String query = "UPDATE transactions SET description = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, description);
        preparedStatement.setLong(2, id);

        return preparedStatement.executeUpdate();
    }

    public int delete(long id) throws SQLException {
        String query = "DELETE FROM transactions WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);

        return preparedStatement.executeUpdate();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
