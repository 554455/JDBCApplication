package com.umaraliev.crud.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    private final SkillView skillView = new SkillView();

    public int getNumbers() {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        return numbers;
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
        } catch (InputMismatchException | SQLException | ClassNotFoundException i) {
            System.out.println("Incorrect argument");
            getNumbers();
        }
    }
}