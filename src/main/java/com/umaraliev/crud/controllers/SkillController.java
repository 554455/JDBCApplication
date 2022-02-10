package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.repository.Impl.SkillRepositoryImpl;
import com.umaraliev.crud.repository.SkillRepository;

import java.sql.SQLException;
import java.util.List;

public class SkillController {
    private final SkillRepository repo = new SkillRepositoryImpl();

    public Skill createSkill(String name) throws SQLException {
        Skill skill = new Skill();
        skill.setName(name);
        return repo.save(skill);
    }

    public Skill updateSkill(Integer id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        return repo.update(skill);
    }

    public List<Skill> getAll() throws SQLException, ClassNotFoundException {
        return repo.getAll();
    }

    public void deleteByIdSkill(Integer id) throws SQLException {
        repo.deleteById(id);
    }

    public Skill getById(Integer id) throws SQLException {
        return repo.getById(id);
    }
}