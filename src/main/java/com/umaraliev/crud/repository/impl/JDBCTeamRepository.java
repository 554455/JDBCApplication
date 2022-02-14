package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Team;
import com.umaraliev.crud.repository.TeamRepository;
import com.umaraliev.crud.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTeamRepository implements TeamRepository {

    private final static String GET_BY_ID = "SELECT * FROM team LEFT JOIN  developer d on team.developer_id = d.developer_id WHERE id = ?";
    private final static String GET_TEAM_ALL = "SELECT * FROM team LEFT JOIN  developer d on team.developer_id = d.developer_id";
    private final static  String TEAM_SAVE = "INSERT INTO team(name) values (?)";
    private final static String UPDATE_TEAM = "UPDATE team SET name = ? WHERE id = ?";
    private final static String DELETE_TEAM = "DELETE FROM team WHERE id = ?";


    @Override
    public Team getById(Integer integer) {
        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(GET_BY_ID)){

            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();

            return convertResultSetToTeam(resultSet);

        } catch (SQLException e) {
            System.out.println("IN get by id  exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();

        try(Statement statement = JDBCUtils.getConnectJDBC().createStatement()){

            ResultSet resultSet = statement.executeQuery(GET_TEAM_ALL);

            while(resultSet.next()) {

                Team team = new Team();

                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("name"));

                teams.add(team);

                List<String> teamList = new ArrayList<>();

                teamList.add(resultSet.getString("first_name"));
                teamList.add(resultSet.getString("last_name"));

                System.out.println("id: " + team.getId());
                System.out.println("name: " + team.getName());
                System.out.println("developer: " + teamList.toString());
                System.out.println("====================================================================================");
            }

        } catch (SQLException e) {
            System.out.println("IN exception: " + e.getMessage());
        }
        return teams;
    }

    @Override
    public Team save(Team team) {

        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(TEAM_SAVE)) {

            preparedStatement.setString(1, team.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN exception: " + e.getMessage());
        }
        return team;
    }

    @Override
    public Team update(Team team) {
        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(UPDATE_TEAM)) {

            preparedStatement.setString(1, team.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN exception: " + e.getMessage());
        }
        return team;
    }

    @Override
    public void deleteById(Integer integer) {
        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(DELETE_TEAM)) {

            preparedStatement.setInt(1, integer);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN delete exception: " + e.getMessage());
        }
    }

    private Team convertResultSetToTeam(ResultSet resultSet) {
        Team team = null;
        try {
            while(resultSet.next()) {
                team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("firstName"));
            }
        }catch (SQLException e) {
            System.out.println("IN convertResultSetToTeam error: " + e.getMessage());
        }

        return team;
    }

}
