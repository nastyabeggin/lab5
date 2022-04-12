package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;

/**
 * Выводит информацию о коллекции
 */
public class InfoCommand extends AbstractCommand{
    public InfoCommand(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции", collectionManager, "");
    }

    @Override
    public void execute(String params) throws CommandException {
        System.out.println(collectionManager.getInfo());
    }
}
