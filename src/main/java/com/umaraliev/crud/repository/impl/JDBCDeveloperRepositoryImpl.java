package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.repository.DeveloperRepository;
import com.umaraliev.crud.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDeveloperRepositoryImpl implements DeveloperRepository {

    private final static String GET_BY_ID = "select * from developer LEFT JOIN skill s on developer.skill_id = s.skill_id WHERE developer_id = ?";
    private final static String GET_DEVELOPER_ALL = "SELECT * FROM developer LEFT JOIN skill s on developer.skill_id = s.skill_id";
    private final static String GET_DEVELOPER_SAVE = "INSERT INTO developer(first_name, last_name) VALUES (?, ?)";
    private final static String UPDATE_DEVELOPER = "UPDATE developer SET first_name = ?, last_name = ? WHERE developer_id = ?";
    private final static String DELETE_DEVELOPER = "DELETE FROM developer WHERE developer_id = ?";

    @Override
    public Developer getById(Integer integer) {
        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(GET_BY_ID)){

            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();

            return convertResultSetToDeveloper(resultSet);

        } catch (SQLException e) {
            System.out.println("IN get by id exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Developer> getAll() {

        List<Developer> developerList = new ArrayList<>();

        try(Statement statement = JDBCUtils.getConnectJDBC().createStatement()){

            ResultSet resultSet = statement.executeQuery(GET_DEVELOPER_ALL);

            while(resultSet.next()) {

                Developer developer = new Developer();

                developer.setId(resultSet.getInt("developer_id"));
                developer.setFirstName(resultSet.getString("first_name"));
                developer.setLastName(resultSet.getString("last_name"));

                developerList.add(developer);

                List<String> skillList = new ArrayList<>();

                skillList.add(resultSet.getString("skill_name"));

                System.out.println("id: " + developer.getId());
                System.out.println("firstName: " + developer.getFirstName());
                System.out.println("lastName: " + developer.getLastName());
                System.out.println("skill: " + skillList.toString());
                System.out.println("====================================================================================");
            }

        } catch (SQLException e) {
            System.out.println("IN exception: " + e.getMessage());
        }
        return developerList;
    }

    @Override
    public Developer save(Developer developer) {

        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(GET_DEVELOPER_SAVE)) {

            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN exception: " + e.getMessage());
        }
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(UPDATE_DEVELOPER)) {

            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setInt(3, developer.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN exception: " + e.getMessage());
        }
        return developer;
    }

    @Override
    public void deleteById(Integer integer) {
        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(DELETE_DEVELOPER)) {

            preparedStatement.setInt(1, integer);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN delete exception: " + e.getMessage());
        }
    }

    private Developer convertResultSetToDeveloper(ResultSet resultSet) {
        Developer developer = null;
        try {
            while(resultSet.next()) {
                developer = new Developer();
                developer.setId(resultSet.getInt("developer_id"));
                developer.setFirstName(resultSet.getString("first_name"));
                developer.setLastName(resultSet.getString("last_name"));
            }
        }catch (SQLException e) {
            System.out.println("IN convertResultSetToDeveloper error: " + e.getMessage());
        }

        return developer;
    }
}
