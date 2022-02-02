package com.javarush.cryptproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApplicationRun {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    FileTools fileTools = new FileTools();

    public void runQuestanarie() throws IOException {
        System.out.println("----------------------");
        System.out.println("1. Encrypt the text");
        System.out.println("2. Decrypt the text");
        System.out.println("3. Make brut force decoding of the text");
        System.out.println("4. Make stat analysis for decoding the text");
        System.out.println("0. Exit from app");
        System.out.println("----------------------");
        System.out.println("Please choose action by entering the number");
        System.out.println("----------------------");

        while (true) {
            int userRequest = Integer.parseInt(READER.readLine());
            if (userRequest == 1) {
                fileTools.readFileAndEncrypt();

            } else if (userRequest == 2) {
                fileTools.readFileAndDecrypt();

            } else if (userRequest == 3) {
                fileTools.readFileAndProcessBrutForce();

            } else if (userRequest == 4) {
                fileTools.readFileAndProcessStatAnalyze();

            } else if (userRequest == 0) {
                System.exit(0);

            } else {
                System.out.println("Please enter valid number !");
            }
        }
    }
}
