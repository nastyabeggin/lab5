package com.company.input;

import com.company.collection.CollectionManager;
import com.company.commands.*;
import com.company.commands.exceptions.NoSuchCommandException;
import com.company.util.FileOpener;
import com.company.util.User;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.*;

public class InputManager {
    public static void start(String[] args) throws FileNotFoundException, AccessDeniedException {
        String filename = String.join(" ", args);
        FileOpener fileOpener = new FileOpener();
        CollectionManager collection = new CollectionManager();
        fileOpener.processInputFile(filename, collection);
        User user = new User(collection);

        handleCommands(user, collection);
    }

    public static void handleCommands(User user, CollectionManager collection) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("# ");

                String[] input = scanner.nextLine().toLowerCase().split(" ");
                String inputParams = "";
                if (input.length > 1) {
                    inputParams = input[1];
                }
                String inputCommand = input[0];
                if (!user.hasCommand(inputCommand)) throw new NoSuchCommandException(inputCommand);
                else {
                    user.execCommand(inputCommand, inputParams, scanner);
                    collection.addToCommandHistory(inputCommand);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Неверная команда");
            } catch (NoSuchCommandException e) {
                System.out.println("Нет такой команды. Введите help для справки");
            } catch (NoSuchElementException e) {
                System.out.println("System.in закрыт");
                break;
            }
        }
    }
}