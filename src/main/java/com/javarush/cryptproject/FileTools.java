package com.javarush.cryptproject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTools {

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    CryptTools cryptTools = new CryptTools();

    public void readFileAndEncrypt() throws IOException {
        System.out.println("Starting encrypting...");
        System.out.println("Please enter the path for text file to encrypt : ");
        File filePath = new File(READER.readLine());
        FileInputStream inputStream = new FileInputStream(filePath);
        int len = inputStream.available();
        byte[] data = new byte[len];
        inputStream.read(data);
        String text = new String(data);
        System.out.println("Text was read !");
        System.out.println("Please enter the path for encrypting the file : ");
        File fileOutputText = null;
        try {
            fileOutputText = new File(READER.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputText, true);
            System.out.println("Pleas enter the key (1-10): ");
            int key = Integer.parseInt(READER.readLine());
            String newText = cryptTools.encryptString(text, key);
            byte[] nTextByt = newText.getBytes();
            fileOutputStream.write(nTextByt);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------");
        System.out.println(" File was encrypted !");
        System.out.println("----------------------");
    }

    public void readFileAndDecrypt() throws IOException {
        System.out.println("Please enter the path for encrypted file : ");
        File fileRawText = null;
        try {
            fileRawText = new File(READER.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileRawText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int len = inputStream.available();
        byte[] data = new byte[len];
        inputStream.read(data);
        String text = new String(data);
        System.out.println("Text was read !");
        System.out.println("Please enter the path for decrypted file : ");
        File fileOutputText = new File(READER.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputText, true);
        System.out.println("Pleas enter the key : ");
        int key = Integer.parseInt(READER.readLine());
        String newText = cryptTools.decryptString(text, key);
        byte[] nTextByt = newText.getBytes();
        fileOutputStream.write(nTextByt);
        fileOutputStream.close();
        System.out.println("----------------------");
        System.out.println(" File was decrypted !");
        System.out.println("----------------------");
    }

    public void readFileAndProcessBrutForce() throws IOException {
        System.out.println("Please enter the path for encrypted file : ");
        File fileRawText = null;
        try {
            fileRawText = new File(READER.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileRawText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int len = inputStream.available();
        byte[] data = new byte[len];
        inputStream.read(data);
        String text = new String(data);
        System.out.println("Text was read !");
        String dectryptedText = "";
        int key = cryptTools.checkPartOfText(text);
        System.out.println("Please enter the path for brut file : ");
        File fileOutputText = new File(READER.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputText, true);
        String newText = cryptTools.decryptString(text, key);
        byte[] nTextByt = newText.getBytes();
        fileOutputStream.write(nTextByt);
        fileOutputStream.close();
        System.out.println("----------------------");
        System.out.println(" File was hacked with brut force!");
        System.out.println("----------------------");
    }

    public void readFileAndProcessStatAnalyze() throws IOException {
        System.out.println("Please enter the path for encrypted file : ");
        String textFromEncFile = getTextFromFile();
        System.out.println("Please enter the path for statistic file : ");
        String textFromStatFile = getTextFromFile();
        int key = cryptTools.analyseText(textFromEncFile, textFromStatFile);
        System.out.println("Please enter the path for saving file after analysis : ");
        File fileOutputText = new File(READER.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputText, true);
        String newText = cryptTools.decryptString(textFromEncFile, key);
        byte[] nTextByt = newText.getBytes();
        fileOutputStream.write(nTextByt);
        fileOutputStream.close();
        System.out.println("----------------------");
        System.out.println(" File was hacked with analysis !");
        System.out.println("----------------------");
    }

    public String getTextFromFile() {
        File fileRawText = null;
        try {
            fileRawText = new File(READER.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileRawText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int len = 0;
        try {
            len = inputStream.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[len];
        try {
            inputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = new String(data);
        System.out.println("Text was read !");
        return text;
    }

    public String getFileContent(String filePath) {
        Path path = Path.of(filePath);
        try {
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
