package ru.fafurin.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static final String FILE_ATTACK = "src/main/resources/attack.txt";
    public static final String FILE_COMMENTS = "src/main/resources/comments.txt";

    /**
     * Записать строки из файла в список
     *
     * @param fileName - путь к файлу для чтения
     * @return список строк из файла
     */
    public static List<String> setListFromFile(String fileName) {
        List<String> phrases = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                phrases.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return phrases;
    }
}
