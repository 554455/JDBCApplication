package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.utils.JDBCUtils;
import com.umaraliev.crud.model.Skill;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

public class JdbcSkillRepositoryImplTest {

    private JDBCUtils connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Skill skill;

    @Before
    public void setUp() throws Exception {
      connection = new JDBCUtils();
      statement = connection.getConnectJDBC().createStatement();
      skill = new Skill();
    }

    @Test
    public void getById() {

        String sql = "SELECT * from skill where SkillId = 1";

        try {

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                skill.setId(resultSet.getInt(1));
                assertNotNull(skill.getId());
                assertThat(skill.getId()).isEqualTo(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {

        String sql = "SELECT * FROM skill";

        try {

            resultSet = statement.executeQuery(sql);

            assertNotNull(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void save() {

        String sql = " insert into skill(skillid, developerid, skillname) VALUES (4, 4, 'comeSkill');";

        String sqlSelect = "DELETE from skill where SkillId = 4";

        try {

            statement.executeQuery(sql);

            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()){
                skill.setId(resultSet.getInt(1));
                skill.setName(resultSet.getString(3));
                assertThat(skill.getId()).isEqualTo(4);
                assertThat(skill.getName()).isEqualTo("comeSkill");
            }

        } catch (SQLException var4) {
            var4.printStackTrace();
        }


    }

    @Test
    public void update() {
        //TODO Add text using mackito
    }


    @Test
    public void deleteById() {

        String sql = "DELETE from skill where SkillId = 4";

        String sqlSelect = "SELECT * from skill where SkillId = 4";

        try {

            statement.addBatch(sql);
            statement.addBatch(sqlSelect);

            statement.executeBatch();

            while (resultSet.next()){
                skill.setId(resultSet.getInt(1));
            }
            assertNotNull(resultSet);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }
}
