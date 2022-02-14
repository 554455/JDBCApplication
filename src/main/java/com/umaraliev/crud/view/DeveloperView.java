package com.umaraliev.crud.view;

import com.umaraliev.crud.controller.DeveloperController;
import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Skill;

import java.util.List;
import java.util.Scanner;

public class DeveloperView {

    private final DeveloperController developerController = new DeveloperController();
    private final Scanner scannerId = new Scanner(System.in);
    private final Scanner firstName = new Scanner(System.in);
    private final Scanner lastName = new Scanner(System.in);

    public void create() {
        System.out.println("Enter first name developer");
        String first = firstName.nextLine();
        System.out.println("Enter last name developer");
        String last = lastName.nextLine();
        Developer developer = developerController.create(first, last);
    }

    public void getAll() {
        List<Developer> developerList = developerController.developerList();
    }

    public void update() {
        System.out.println("Enter id developer");
        Integer id = scannerId.nextInt();
        System.out.println("Enter first name developer");
        String first = firstName.nextLine();
        System.out.println("Enter last name developer");
        String last = firstName.nextLine();
        Developer developer = developerController.update(id, first, last);
        System.out.println("You have entered: " + developer);
    }

    public void delete() {
        System.out.println("Enter id developer");
        Integer id = scannerId.nextInt();
        developerController.delete(id);
    }

    public void getById() {
        System.out.println("Enter id developer");
        Integer id = scannerId.nextInt();
        Developer developer = developerController.getById(id);
        System.out.println(developer.toString());
    }
}
