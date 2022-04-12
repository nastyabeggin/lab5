package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;

/**
 * Команда сохраняет коллекцию в файл
 */
public class SaveCommand extends AbstractCommand{
    public SaveCommand(CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл", collectionManager, "");
    }

    @Override
    public void execute(String params) throws CommandException {
        collectionManager.saveToFile();
    }
}
