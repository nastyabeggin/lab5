package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;
import com.company.commands.exceptions.ParamException;

import java.util.Objects;

/**
 * Команда, удаляющая элемент коллекции по id
 */
public class RemoveByIdCommand extends AbstractCommand {
    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id", collectionManager, "{id (long)}");
    }

    @Override
    public void execute(String commandParameters) throws CommandException {
        if (Objects.equals(commandParameters, "")) throw new ParamException();
        try {
            long userId = Long.parseLong(commandParameters);
            collectionManager.removeIf(labWork -> labWork.getId() == userId);
        } catch (Exception e) {
            throw new ParamException();
        }
    }
}

