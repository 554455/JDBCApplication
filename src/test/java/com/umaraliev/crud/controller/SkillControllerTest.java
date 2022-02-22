package com.umaraliev.crud.controller;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.repository.DeveloperRepository;
import com.umaraliev.crud.repository.SkillRepository;
import com.umaraliev.crud.repository.impl.JDBCDeveloperRepositoryImpl;
import com.umaraliev.crud.repository.impl.JdbcSkillRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SkillControllerTest {

    @Mock
    private SkillRepository skillRepository = mock(JdbcSkillRepositoryImpl.class);
    @InjectMocks
    private SkillController skillController = new SkillController(skillRepository);
    private Skill skillOne;
    private Skill skill;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createSkill() {

        skill = new Skill();

        skill.setId(1);
        skill.setName("Soft skill");

        when(skillRepository.save(any(Skill.class))).thenReturn(skill);

        Skill createSkill = skillController.createSkill("skill");
        assertNotNull(createSkill);
        assertEquals("skill", createSkill.getName());
    }

    @Test
    public void updateSkill() {

        skill = new Skill();

        skill.setId(1);
        skill.setName("Soft skill");

        when(skillRepository.update(any(Skill.class))).thenReturn(skill);
        assertEquals("Soft skill", skill.getName());
    }

    @Test
    public void getAll() {

        skillOne = new Skill();
        skill = new Skill();

        skillOne.setName("Soft skill");
        skill.setName("skill");

        List<Skill> skillList = new ArrayList<>();

        skillList.add(skillOne);
        skillList.add(skill);

        when(skillRepository.getAll()).thenReturn(skillList);

        assertNotNull(skillList);
    }

    @Test
    public void deleteByIdSkill() {

        skillRepository.deleteById(anyInt());

        verify(skillRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {

        List<Skill> skillList = new ArrayList<>();

        skillList.add(skillOne);
        skillList.add(skill);

        when(skillRepository.getById(1)).thenReturn(skillOne);
    }
}