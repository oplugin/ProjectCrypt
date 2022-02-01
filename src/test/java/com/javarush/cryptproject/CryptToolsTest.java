package com.javarush.cryptproject;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.BatchUpdateException;

import static org.junit.jupiter.api.Assertions.*;

class CryptToolsTest {


    @Test
    void writeFile() throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно! —\n" +
                "Вот последняя правда, открытая мной.\n" +
                "—  Омар Хайям, 518 цитат";

        FileWriter writer = null;

        try {
            writer = new FileWriter("test1.txt");
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            System.out.println("File was written!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    @Test
    void FileReader() throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader("test1.txt");
            int character = 0;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("");
            System.out.println("Reader done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    void askUser_for_path() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the path for the file for encryption: ");
        try {
            String pathForFileToEncript = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    void crypt() {
        String encrString = "Я закодирован кодом. А теперь хочу раскрыть свой секрет, а может нет ?";

        CryptTools cryptTools = new CryptTools();
        String cryptString = cryptTools.encryptString(encrString, 3);
        System.out.println(cryptString);

    }

}
