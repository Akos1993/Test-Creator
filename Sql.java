package com.akos;

import java.sql.*;
import java.util.Map;

public class Sql {
    private Connection c = null;
    private Statement statement = null;

    public void fillQuestionDB(Questions questions, Person person) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Test_DB.db");
            c.setAutoCommit(false);

            statement = c.createStatement();
            String sql = "INSERT INTO Tests (Name,Creator) VALUES (" + questions.getName() + "," +
                   person.getName() + ");";
            statement.executeUpdate(sql);
            sql = "SELECT Test_ID FROM Tests WHERE Name IS '" + questions.getName() + "' LIMIT 1;";
            ResultSet testID = statement.executeQuery(sql);
            for (Map.Entry<String, Map<String,Boolean>> map :questions.getAnswers().entrySet()) {
                sql = "INSERT INTO Test_Questions (Test_ID,Question) VALUES (" +testID + map.getKey() + ");";
                statement.executeUpdate(sql);
            }
        } catch (Exception e) {

        }
    }
}
