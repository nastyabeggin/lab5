package com.company.commands.special;

import com.company.commands.*;
import com.company.collection.CollectionManager;
import com.company.collection.LabWork;
import com.company.commands.exceptions.CommandException;

import java.util.List;

/**
 * Команда выводит среднее значение среднего балла по всем лабам
 */
public class AverageOfAveragePointCommand extends AbstractCommand {
    public AverageOfAveragePointCommand(CollectionManager collectionManager) {
        super("average_of_average_point", "вывести среднее значение поля averagePoint для всех элементов коллекции",
                collectionManager, "");
    }

    @Override
    public void execute(String commandParameters) {
        long sum = 0;
        for (LabWork labWork : collectionManager) {
            sum += (labWork.getAveragePoint());
        }
        System.out.println(sum / collectionManager.size());
    }
}
