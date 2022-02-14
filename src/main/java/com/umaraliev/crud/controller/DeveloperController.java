package com.umaraliev.crud.controller;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.repository.DeveloperRepository;
import com.umaraliev.crud.repository.impl.JDBCDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {

    private DeveloperRepository developerRepository;

    public DeveloperController() {
        developerRepository = new JDBCDeveloperRepositoryImpl();
    }

    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer create(String firstName, String lastName) {
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        return developerRepository.save(developer);
    }

    public List<Developer> developerList() {
        return developerRepository.getAll();
    }

    public Developer update(Integer id, String firstName, String lastName) {
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        return developerRepository.update(developer);
    }

    public void delete(Integer id){
        developerRepository.deleteById(id);
    }

    public Developer getById(Integer id) {
        return developerRepository.getById(id);
    }
}
