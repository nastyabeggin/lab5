package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;
import com.company.commands.exceptions.ParamException;

/**
 * Команда, которая обновляет экземпляр коллекции
 */
public class UpdateIdCommand extends AbstractCommand {
    public UpdateIdCommand(CollectionManager collectionManager) {
        super("update", "обновить значение элемента коллекции, id которого равен заданному", collectionManager, "{Id(long)}");
    }

    @Override
    public void execute(String params) throws CommandException {
        try {
            long userId = Long.parseLong(params);
            collectionManager.update(userId);
        } catch (Exception e) {
            throw new ParamException();
        }
    }
}
