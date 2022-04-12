package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.collection.LabWork;
import com.company.commands.exceptions.CommandException;

/**
 * Команда, очищающая коллекцию
 */
public class ClearCommand extends AbstractCommand {
    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию", collectionManager, "");
    }

    @Override
    public void execute(String commandParameters) {
        collectionManager.clear();
    }
}
