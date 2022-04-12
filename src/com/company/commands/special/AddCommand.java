package com.company.commands.special;

import com.company.collection.CollectionManager;
import com.company.collection.LabWork;
import com.company.commands.*;


import java.util.Collection;

/** Добавляет элемент в коллекцию
 *
 */
/* add {element} : добавить новый элемент в коллекцию */
public class AddCommand extends AbstractCommand {
    public AddCommand(CollectionManager collectionManager) {
        super("add", "добавить новый элемент в коллекцию", collectionManager, "{LabWork}");
    }

    @Override
    public void execute(String commandParameters) {
        LabWork newLabWork = collectionManager.generateNew();
        collectionManager.add(newLabWork);
    }
}
