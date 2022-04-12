package com.company.commands.special;

import com.company.commands.*;

import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;

/**
 * Команда выводит информацию об элементах коллекции
 */
public class ShowCommand extends AbstractCommand{
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", collectionManager, "");
    }

    @Override
    public void execute(String params) throws CommandException {
        collectionManager.objectsInfo();
    }
}
