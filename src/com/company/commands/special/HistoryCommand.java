package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;

/**
 * Команда, которая выводит последние 5 команд
 */
public class HistoryCommand extends AbstractCommand{
    public HistoryCommand(CollectionManager collectionManager) {
        super("history", "вывести последние 5 команд (без их аргументов)", collectionManager, "");
    }

    @Override
    public void execute(String params) throws CommandException {
        System.out.println(collectionManager.getCommandHistory());
    }
}
