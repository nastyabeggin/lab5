package com.company.util;

import com.company.collection.CollectionManager;
import com.company.commands.Command;
import com.company.commands.special.*;
import com.company.commands.exceptions.ParamException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс пользователя, который вызывает выполнение команд
 */
public class User {

    HashMap<String, Command> commandMap = new HashMap<String, Command>();

    public void addCommand(Command command) {
        commandMap.put(command.getName(), command);
    }

    public boolean hasCommand(String commandName) {
        return commandMap.containsKey(commandName);
    }

    public Collection<Command> getAllCommands() {
        return commandMap.values();
    }

    public void execCommand(String commandName, String commandParameters, Scanner scanner) {
        while (true){
            try {
                commandMap.get(commandName).execute(commandParameters);
                break;
            } catch (ParamException e) {
                System.out.println("Неверные параметры команды, повторите ввод. Параметр имеет тип " + commandMap.get(commandName).getParams());
                commandParameters = scanner.nextLine().split(" ")[0];
            }
        }
    }

    public User(CollectionManager collectionManager) {
        addCommand(new AddCommand(collectionManager));
        addCommand(new ShowCommand(collectionManager));
        addCommand(new HelpCommand(collectionManager));
        addCommand(new AddIfMinCommand(collectionManager));
        addCommand(new AverageOfAveragePointCommand(collectionManager));
        addCommand(new ClearCommand(collectionManager));
        addCommand(new CountLessThanAveragePointCommand(collectionManager));
        addCommand(new ExitCommand(collectionManager));
        addCommand(new HistoryCommand(collectionManager));
        addCommand(new InfoCommand(collectionManager));
        addCommand(new RemoveLowerCommand(collectionManager));
        addCommand(new RemoveByIdCommand(collectionManager));
        addCommand(new RemoveAllByMinimalPointCommand(collectionManager));
        addCommand(new UpdateIdCommand(collectionManager));
        addCommand(new SaveCommand(collectionManager));
        addCommand (new ExecuteScriptCommand(collectionManager));
    }

}
