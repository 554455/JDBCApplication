package com.umaraliev.crud.repository.Impl;

import com.umaraliev.crud.connection.JDBCConnection;
import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.repository.SkillRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SkillRepositoryImpl implements SkillRepository {
    private final JDBCConnection connection = new JDBCConnection();
    private ResultSet resultSet;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private List<Skill> skillList = new ArrayList();

    public Skill getById(Integer integer) throws SQLException {
        Skill skill = null;

        try {

            preparedStatement = connection.getConnectJDBC().prepareStatement("SELECT SkillID FROM WHERE SkillID = ?");
            preparedStatement.setInt(1, integer);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                skill.setId(resultSet.getInt("SkillId"));
                skill.setName(resultSet.getString("SkillName"));
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return skill;
    }

    public List<Skill> getAll() throws SQLException {

        try {

            String sql = "SELECT * FROM skill";

            Skill skill = new Skill();

            statement = connection.getConnectJDBC().createStatement();

            resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {

                skill.setId(resultSet.getInt("SkillId"));
                skill.setId(resultSet.getInt("DeveloperId"));
                skill.setName(resultSet.getString("SkillName"));

                skillList.add(skill);

                System.out.println("SkillId: " + skill.getId());
                System.out.println("SkillName: " + skill.getName());
                System.out.println("====================================================================================");
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return skillList;
    }

    public Skill save(Skill skill) throws SQLException {

        try {
            preparedStatement = connection.getConnectJDBC().prepareStatement(" insert into skill(developerid, skillname) VALUES (?, ?)");
            preparedStatement.setInt(1, generateNewId(skillList));
            preparedStatement.setString(2, skill.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return skill;
    }

    public Skill update(Skill skill) {

        try {

            preparedStatement = connection.getConnectJDBC().prepareStatement("UPDATE skill set SkillName = ? where SkillId = ?");
            preparedStatement.setString(1, skill.getName());
            preparedStatement.setInt(2, skill.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public void deleteById(Integer integer) throws SQLException {

        try {
            preparedStatement = connection.getConnectJDBC().prepareStatement("DELETE from skill where SkillId = ?");
            preparedStatement.setInt(1, integer);

            preparedStatement.executeUpdate();

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    private Integer generateNewId(List<Skill> skills) {
        Skill skillWithMaxId = (Skill)skills.stream().max(Comparator.comparing(Skill::getId)).orElse((Skill)null);
        Objects.nonNull(skillWithMaxId);
        return Objects.nonNull(skillWithMaxId) ? skillWithMaxId.getId() + 1 : 1;
    }
}

