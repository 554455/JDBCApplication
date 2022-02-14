package com.umaraliev.crud.view;

import com.umaraliev.crud.controller.TeamController;
import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Team;

import java.util.List;
import java.util.Scanner;

public class TeamView {

    private final TeamController teamController = new TeamController();
    private final Scanner id = new Scanner(System.in);
    private final Scanner name = new Scanner(System.in);

    public void create() {
        System.out.println("Enter name team");
        String nameTeam = name.nextLine();
        Team team = teamController.create(nameTeam);
    }

    public void getAll() {
        List<Team> teamList = teamController.teamList();
    }

    public void update() {
        System.out.println("Enter id team");
        Integer idTeam = id.nextInt();
        System.out.println("Enter  name team");
        String nameTeam = name.nextLine();
        Team team =  teamController.update(idTeam, nameTeam);
        System.out.println("You have entered: " + team);
    }

    public void delete() {
        System.out.println("Enter id team");
        Integer idTeam = id.nextInt();
        teamController.delete(idTeam);
    }

    public void getById() {
        System.out.println("Enter id team");
        Integer idTeam = id.nextInt();
        Team team = teamController.getById(idTeam);
        System.out.println(team.toString());
    }
}
