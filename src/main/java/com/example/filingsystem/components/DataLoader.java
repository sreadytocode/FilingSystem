package com.example.filingsystem.components;

import com.example.filingsystem.models.File;
import com.example.filingsystem.models.Folder;
import com.example.filingsystem.models.User;
import com.example.filingsystem.repositories.FileRepository;
import com.example.filingsystem.repositories.FolderRepository;
import com.example.filingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {

        User raquel = new User("Raquel");
        userRepository.save(raquel);

        User sara = new User("Sara");
        userRepository.save(sara);

        Folder recipes = new Folder("Collection of Recipes", raquel);
        folderRepository.save(recipes);

        Folder harryPotterBooks = new Folder("Harry Potter Collection", sara);
        folderRepository.save(harryPotterBooks);

        File ramen = new File("Ramen", "ppt", "5MB", recipes);
        fileRepository.save(ramen);

        File orderOfThePhoenix = new File("Order of the Phoenix", "epb", "10MB", harryPotterBooks);
        fileRepository.save(orderOfThePhoenix);

    }
}
