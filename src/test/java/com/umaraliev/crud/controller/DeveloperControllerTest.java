package com.umaraliev.crud.controller;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.repository.impl.JDBCDeveloperRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperControllerTest {

    @Mock
    private JDBCDeveloperRepositoryImpl jdbcDeveloperRepository;
    private Developer developerOne;
    private Developer developer;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void setUp(){
        jdbcDeveloperRepository = mock(JDBCDeveloperRepositoryImpl.class);
    }

    @Test
    public void create() {

        developer = new Developer();
        developer.setId(2);
        developer.setFirstName("Andrei");
        developer.setLastName("Komarov");

        when(jdbcDeveloperRepository.save(developer)).thenReturn(developer);

        Developer developerMock = jdbcDeveloperRepository.save(developer);

        assertNotNull(developerMock);

        assertEquals("Andrei", developerMock.getFirstName());
    }

    @Test
    public void developerList() {

        developerOne = new Developer();
        developerOne.setId(1);
        developerOne.setFirstName("Peter");
        developerOne.setLastName("Romanenko");

        developer = new Developer();
        developer.setId(2);
        developer.setFirstName("Andrei");
        developer.setLastName("Komarov");

        List<Developer> developerList = new ArrayList<>();

        developerList.add(developerOne);
        developerList.add(developer);


        when(jdbcDeveloperRepository.getAll()).thenReturn(developerList);

    }

    @Test
    public void update() {

        developer = new Developer();
        developer.setId(2);
        developer.setFirstName("Andrei");
        developer.setLastName("Komarov");

        when(jdbcDeveloperRepository.update(developer)).thenReturn(developer);
    }

    @Test
    public void delete() {

        jdbcDeveloperRepository.deleteById(anyInt());

        verify(jdbcDeveloperRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {

        List<Developer> developerList = new ArrayList<>();
        developerList.add(developerOne);
        developerList.add(developer);

        when(jdbcDeveloperRepository.getAll()).thenReturn(developerList);

        when(jdbcDeveloperRepository.getById(1)).thenReturn(developerOne);
    }
}