package com.umaraliev.crud.controller;

import com.umaraliev.crud.model.Team;
import com.umaraliev.crud.repository.TeamRepository;
import com.umaraliev.crud.repository.impl.JDBCTeamRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TeamControllerTest {

    @Mock
    private TeamRepository teamRepository = mock(JDBCTeamRepository.class);
    @InjectMocks
    private TeamController teamController = new TeamController(teamRepository);
    private Team teamOne;
    private Team team;

    @Test
    public void create() {

        team = new Team();
        team.setName("artek");

        when(teamRepository.save(any(Team.class))).thenReturn(team);
        Team createTeam = teamController.create("arek");
        assertNotNull(createTeam);
        assertEquals("artek", createTeam.getName());
    }

    @Test
    public void teamList() {

        teamOne = new Team();

        teamOne.setName("artek");

        team = new Team();

        team.setName("vartek");

        List<Team> teamList = new ArrayList<>();

        teamList.add(teamOne);
        teamList.add(team);

        when(teamController.teamList()).thenReturn(teamList);
        assertNotNull(teamList);

    }

    @Test
    public void update() {

        team = new Team();

        team.setName("artec");

        when(teamRepository.update(team)).thenReturn(team);
        assertEquals("artec", team.getName());
    }

    @Test
    public void delete() {

        teamRepository.deleteById(anyInt());

        verify(teamRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {

        List<Team> teamList = new ArrayList<>();
        teamList.add(teamOne);
        teamList.add(team);

        when(teamRepository.getById(1)).thenReturn(teamOne);
    }
}