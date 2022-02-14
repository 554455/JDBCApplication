package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.utils.JDBCUtils;
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

public class JdbcSkillRepositoryImpl implements SkillRepository {

    private List<Skill> skillList = new ArrayList<>();

    private final static String GET_SKILL_BY_ID_QUERY = "SELECT * FROM WHERE skill_id = ?";
    private final static String Get_SKILL_ALL = "SELECT * FROM skill";
    private final static String SKILL_SAVE = "INSERT INTO skill(developer_id, skill_name) VALUES (?, ?)";
    private final static String SKILL_UPDATE = "UPDATE skill set skill_name = ? where skill_id = ?";
    private final static String DELETE_BY_ID = "DELETE FROM skill WHERE skill_id = ?";

    public Skill getById(Integer integer){
        try(PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(GET_SKILL_BY_ID_QUERY)) {

            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();

            return convertResultSetToSkill(resultSet);

        } catch (SQLException e) {
            System.out.println("IN getById exception: " + e.getMessage());
            return null;
        }
    }

    public List<Skill> getAll() {

        try (Statement statement = JDBCUtils.getConnectJDBC().createStatement()){

            ResultSet resultSet = statement.executeQuery(Get_SKILL_ALL);


            while(resultSet.next()) {

                Skill skill = new Skill();

                skill.setId(resultSet.getInt("skill_id"));
                skill.setId(resultSet.getInt("developer_id"));
                skill.setName(resultSet.getString("skill_name"));

                skillList.add(skill);

                System.out.println("SkillId: " + skill.getId());
                System.out.println("SkillName: " + skill.getName());
                System.out.println("====================================================================================");
            }
        } catch (SQLException e) {
            System.out.println("IN getAll exception: " + e.getMessage());
        }

        return skillList;
    }

    public Skill save(Skill skill){

        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(SKILL_SAVE)){

            preparedStatement.setInt(1, generateNewId(skillList));
            preparedStatement.setString(2, skill.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN save exception: " + e.getMessage());
        }

        return skill;
    }

    public Skill update(Skill skill) {

        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(SKILL_UPDATE)){

            preparedStatement.setString(1, skill.getName());
            preparedStatement.setInt(2, skill.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN update exception: " + e.getMessage());
        }

        return skill;
    }

    public void deleteById(Integer integer){

        try (PreparedStatement preparedStatement = JDBCUtils.getConnectJDBC().prepareStatement(DELETE_BY_ID)){

            preparedStatement.setInt(1, integer);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("IN delete exception: " + e.getMessage());
        }

    }

    private Integer generateNewId(List<Skill> skills) {
        Skill skillWithMaxId = (Skill)skills.stream().max(Comparator.comparing(Skill::getId)).orElse((Skill)null);
        Objects.nonNull(skillWithMaxId);
        return Objects.nonNull(skillWithMaxId) ? skillWithMaxId.getId() + 1 : 1;
    }

    private Skill convertResultSetToSkill(ResultSet resultSet) {
        Skill skill = null;
        try {
            while(resultSet.next()) {
                skill = new Skill();
                skill.setId(resultSet.getInt("skill_id"));
                skill.setName(resultSet.getString("skill_name"));
            }
        }catch (SQLException e) {
            System.out.println("IN convertResultSetToSkill error: " + e.getMessage());
        }

        return skill;
    }
}

