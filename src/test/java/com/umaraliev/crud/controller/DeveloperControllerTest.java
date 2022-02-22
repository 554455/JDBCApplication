package com.umaraliev.crud.controller;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.repository.DeveloperRepository;
import com.umaraliev.crud.repository.impl.JDBCDeveloperRepositoryImpl;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperControllerTest {

    @Mock
    private DeveloperRepository developerRepository = mock(JDBCDeveloperRepositoryImpl.class);
    @InjectMocks
    private DeveloperController developerController = new DeveloperController(developerRepository);
    private Developer developerOne;
    private Developer developer;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create() {

        developer = new Developer();
        developer.setId(2);
        developer.setFirstName("Andrei");
        developer.setLastName("Komarov");

        when(developerRepository.save(any(Developer.class))).thenReturn(developer);
        Developer createdDeveloper = developerController.create("Andrei", "Komarov");
        assertNotNull(createdDeveloper);
        assertEquals("Andrei", createdDeveloper.getFirstName());
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


        when(developerRepository.getAll()).thenReturn(developerList);
        assertNotNull(developerList);

    }

    @Test
    public void update() {

        developer = new Developer();
        developer.setId(2);
        developer.setFirstName("Andrei");
        developer.setLastName("Komarov");

        when(developerRepository.update(developer)).thenReturn(developer);
        assertEquals("Andrei", developer.getFirstName());
    }

    @Test
    public void delete() {

        developerRepository.deleteById(anyInt());

        verify(developerRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {

        List<Developer> developerList = new ArrayList<>();
        developerList.add(developerOne);
        developerList.add(developer);

        when(developerRepository.getAll()).thenReturn(developerList);
        when(developerRepository.getById(1)).thenReturn(developerOne);
    }
}
