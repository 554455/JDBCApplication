package com.umaraliev.crud.view;

import com.umaraliev.crud.model.Developer;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    private final SkillView skillView = new SkillView();
    private final DeveloperView developerView = new DeveloperView();
    private final TeamView teamView = new TeamView();

    public int getNumbers() {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        return numbers;
    }


    public void MenuMain() {

        System.out.println("Menu main \n"
                + "Select actions \n"
                + 1 + " - Menu skill \n"
                + 2 + " - Menu developer \n"
                + 3 + " - Menu team \n"
                + 4 + " - Go back");
        try {
            switch (getNumbers()) {
                case 1:
                    MenuSkill();
                    MenuMain();
                case 2:
                    MenuDeveloper();
                    MenuMain();
                case 3:
                    MenuTeam();
                    MenuMain();
                case 4:
                    skillView.deleteByIdSkill();
                    MenuMain();
                default:
                    System.out.println("You chose the wrong number");
                    getNumbers();
            }
        } catch (InputMismatchException  i) {
            System.out.println("Incorrect argument");
            getNumbers();
        }
    }

    public void MenuSkill() {

        System.out.println("Menu skill \n"
                + "Select actions \n"
                + 1 + " - Create skill \n"
                + 2 + " - Read skill \n"
                + 3 + " - Update skill \n"
                + 4 + " - Delete skill \n"
                + 5 + " - Go back");
        try {
            switch (getNumbers()) {
                case 1:
                    skillView.createSkill();
                    MenuSkill();
                case 2:
                    skillView.getAll();
                    MenuSkill();
                case 3:
                    skillView.getById();
                    MenuSkill();
                case 4:
                    skillView.updateSkill();
                    MenuSkill();
                case 5:
                    skillView.deleteByIdSkill();
                    MenuSkill();
                default:
                    System.out.println("You chose the wrong number");
                    getNumbers();
            }
        } catch (InputMismatchException | SQLException i) {
            System.out.println("Incorrect argument");
            getNumbers();
        }
    }

    public void MenuDeveloper() {

        System.out.println("Menu developer \n"
                + "Select actions \n"
                + 1 + " - Create developer \n"
                + 2 + " - Read developer \n"
                + 3 + " - Update developer \n"
                + 4 + " - Delete developer \n"
                + 5 + " - Go back");
        try {
            switch (getNumbers()) {
                case 1:
                    developerView.create();
                    MenuDeveloper();
                case 2:
                    developerView.getAll();
                    MenuDeveloper();
                case 3:
                    developerView.update();
                    MenuDeveloper();
                case 4:
                    developerView.delete();
                    MenuDeveloper();
                case 5:
                    MenuDeveloper();
                default:
                    System.out.println("You chose the wrong number");
                    getNumbers();
            }
        } catch (InputMismatchException i) {
            System.out.println("Incorrect argument");
            getNumbers();
        }
    }

    public void MenuTeam() {

        System.out.println("Menu Team \n"
                + "Select actions \n"
                + 1 + " - Create team \n"
                + 2 + " - Read team \n"
                + 3 + " - Update team \n"
                + 4 + " - Delete team \n"
                + 5 + " - Go back");
        try {
            switch (getNumbers()) {
                case 1:
                    teamView.create();
                    MenuTeam();
                case 2:
                    teamView.getAll();
                    MenuTeam();
                case 3:
                    teamView.update();
                    MenuTeam();
                case 4:
                    teamView.delete();
                    MenuTeam();
                case 5:
                    MenuMain();
                default:
                    System.out.println("You chose the wrong number");
                    getNumbers();
            }
        } catch (InputMismatchException i) {
            System.out.println("Incorrect argument");
            getNumbers();
        }
    }
}