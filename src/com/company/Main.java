package com.company;


import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import com.company.input.InputManager;


/**
 * Основной класс Main консольного приложения. Содержит метод "main".
 * @author nastyabeggin
 * @version 1.0.0
 */
public class Main {
    /**
     * Метод main. Стартовая точка приложения
     * @param args - массив аргументов.
     * @throws FileNotFoundException вызывает исключение.
     */
    public static void main(String[] args) throws FileNotFoundException, AccessDeniedException {
        InputManager.start(args);
    }
}


