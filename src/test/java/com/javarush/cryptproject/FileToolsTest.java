package com.javarush.cryptproject;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileToolsTest {

    @Test
    void openFile() {
        File file = new File("test1.txt");
        File folder = new File("D:\\Study\\JavaRushUni\\1. Module_Zero\\ProjectCrypt");
        System.out.println("file.getAbsolutePath : " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath : " + folder.getAbsolutePath());
        System.out.println("-------------");

        System.out.println("file.isAbsolute : " + file.isAbsolute());
        System.out.println("folder.isAbsolute : " + folder.isAbsolute());
        System.out.println("-------------");

        System.out.println("file.isDirectory : " + file.isDirectory());
        System.out.println("folder.isDirectory : " + folder.isDirectory());
        System.out.println("-------------");

        System.out.println("file.exists : " + file.exists());
        System.out.println("folder.exists : " + folder.exists());
        System.out.println("-------------");
    }

}
