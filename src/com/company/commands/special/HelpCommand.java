package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.commands.exceptions.CommandException;
import com.company.util.User;

/**
 * Выводит доступные команды и справку
 */
public class HelpCommand extends AbstractCommand{
    public HelpCommand(CollectionManager collectionManager) {
        super("help", "вывести справку по доступным командам", collectionManager, "");
    }

    @Override
    public void execute(String params) throws CommandException {
        User tempUser = new User(collectionManager);
        System.out.println("\tСписок доступных команд\t");
        for(Command command : tempUser.getAllCommands()){
            System.out.println(command.getName() + "\t-\t" + command.getDescription());
        }
    }
}
