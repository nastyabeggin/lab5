package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;

/**
 * Команда, завершающая программу (без сохранения)
 */
public class ExitCommand extends AbstractCommand {
    public ExitCommand(CollectionManager collectionManager) {
        super("exit", "завершить программу (без сохранения в файл)", collectionManager, "");
    }

    @Override
    public void execute(String commandParameters) {
        System.exit(0);
    }
}
