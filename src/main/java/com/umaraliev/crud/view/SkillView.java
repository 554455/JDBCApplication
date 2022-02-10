package com.umaraliev.crud.view;

import com.umaraliev.crud.controllers.SkillController;
import com.umaraliev.crud.model.Skill;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SkillView {
    private final SkillController controller = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void createSkill() throws SQLException {
        System.out.println("Enter name skill");
        String name = scanner.nextLine();
        Skill s = controller.createSkill(name);
    }

    public void updateSkill(){
        System.out.println("Enter id skill");
        Integer id = scanner.nextInt();
        System.out.println("Enter name skill");
        String name = scanner.nextLine();
        Skill s = controller.updateSkill(id, name);
        System.out.println("You have entered: " + s);
    }

    public void getAll() throws SQLException, ClassNotFoundException {
        List<Skill> s = controller.getAll();
    }

    public void getById() throws SQLException {
        System.out.println("Enter id skill");
        Integer id = scanner.nextInt();
        Skill s = controller.getById(id);
        System.out.println(s.toString());
    }

    public void deleteByIdSkill() throws SQLException {
        System.out.println("Enter id skill");
        Integer id = scanner.nextInt();
        System.out.println("Deleted user with id: "
                + controller.getById(id).getId()
                + " and name: " + controller.getById(id).getName());
    }
}