package com.company.commands.special;

import com.company.commands.*;

import com.company.collection.CollectionManager;
import com.company.collection.LabWork;
import com.company.commands.exceptions.CommandException;
import com.company.commands.exceptions.ParamException;

import java.util.Objects;

/**
 * Команда, удаляющая из коллекции все элементы, значение поля minimalPoint которого = данному
 */
public class RemoveAllByMinimalPointCommand extends AbstractCommand {
    public RemoveAllByMinimalPointCommand(CollectionManager collectionManager) {
        super("remove_all_by_minimal_point", "удалить из коллекции все элементы, значение поля minimalPoint которого эквивалентно заданному", collectionManager, "{minimalPoint (float)}");
    }

    @Override
    public void execute(String commandParameters) throws CommandException {
        if (Objects.equals(commandParameters, "")) throw new ParamException();
        try {
            float userMinimalPoint = Float.parseFloat(commandParameters);
            collectionManager.removeIf(labWork -> labWork.getMinimalPoint() == userMinimalPoint);
        } catch (Exception e) {
            throw new ParamException();
        }
    }
}

