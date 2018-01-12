package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.utils.Security;


import java.sql.*;

public class JdbcUserService implements UserService{


    private ConnectionManager connectionManager;


    public JdbcUserService (ConnectionManager connectionManager){
        this.connectionManager = connectionManager;
    }


    @Override
    public boolean authenticate(String username, String password) {
        try {


            String query = "SELECT user_name, password FROM users WHERE user_name =? AND password =?";

            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);

            statement.setString(1,username);
            statement.setString(2, Security.getHash(password));


            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return true;
            }
            if (statement != null){
                statement.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public void addUser(User user) {


        try {

            String query = "INSERT INTO users (user_name, password, email) VALUES (?,?,?)";
            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());



            statement.executeUpdate();

            if (statement != null){
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User findByName(String username) {
        User user = null;
        try {

        Statement statement = connectionManager.getConnection().createStatement();
        String query = "SELECT * FROM users WHERE user_name = " + "\"" + username + "\";";
        ResultSet resultSet = null;

             resultSet = statement.executeQuery(query);

        if(resultSet.next()){

            String usernameValue = resultSet.getString("user_name");
            String passwordValue = resultSet.getString("password");
            String emailValue = resultSet.getString("email");

            user = new User(usernameValue,passwordValue,emailValue);

        }
        if(statement != null){
            statement.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }


        return user;
    }

    @Override
    public int count() {

        int result = 0;
        try {
            Statement statement = null;

            statement = connectionManager.getConnection().createStatement();


            String query = "SELECT COUNT(*) FROM users";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }

        return 0;
    }
}
