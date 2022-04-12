package com.company.collection;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

/**
 * Экземпляр лабораторной работы
 */
public class LabWork {
    private Scanner scanner = new Scanner(System.in);
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float minimalPoint; //Значение поля должно быть больше 0
    private long averagePoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле не может быть null

    /**
     * Конструктор лабы, когда даны все параметры
     *
     * @param id           Id лабы. Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
     * @param name         Название лабы. Поле не может быть null, Строка не может быть пусто
     * @param coordinates  Координаты. Поле не может быть null
     * @param minimalPoint Минимальный балл. Поле не может быть null, Значение этого поля должно генерироваться автоматически
     * @param averagePoint Средний балл. Значение поля должно быть больше 0
     * @param difficulty   Сложность. Поле может быть null
     * @param discipline   Дисциплина. Поле не может быть null
     */
    public LabWork(long id,
                   String name,
                   Coordinates coordinates,
                   float minimalPoint,
                   long averagePoint,
                   String difficulty,
                   Discipline discipline) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.minimalPoint = minimalPoint;
        this.averagePoint = averagePoint;
        Difficulty tempDiff = Difficulty.VERY_EASY;
        tempDiff.setDifficultyOfLab(difficulty);
        this.difficulty = tempDiff;
        this.discipline = discipline;
    }

    /**
     * Создание лабы
     *
     * @param collectionManager коллекция
     */
    public LabWork(CollectionManager collectionManager) {
        creationDate = LocalDate.now();
        this.id = generateId(collectionManager);
        System.out.println("Для этого объекта был автоматически присвоен id – " + (this.id));
        this.name = enterName(collectionManager);
        this.coordinates = enterCoordinates(collectionManager);
        this.minimalPoint = enterMinimalPoint(collectionManager);
        this.averagePoint = enterAveragePoint(collectionManager);
        this.difficulty = enterDifficulty(collectionManager);
        this.discipline = enterDiscipline(collectionManager);
    }

    /**
     * Создание лабы с известным минимальным баллом
     *
     * @param collectionManager коллекция
     */
    public LabWork(CollectionManager collectionManager, float minimalPoint) {
        creationDate = LocalDate.now();
        this.id = generateId(collectionManager);
        System.out.println("Для этого объекта был автоматически присвоен id – " + (this.id));
        this.name = enterName(collectionManager);
        this.coordinates = enterCoordinates(collectionManager);
        this.minimalPoint = minimalPoint;
        this.averagePoint = enterAveragePoint(collectionManager);
        this.difficulty = enterDifficulty(collectionManager);
        this.discipline = enterDiscipline(collectionManager);
    }

    public LabWork(CollectionManager collectionManager, Long id) {
        creationDate = LocalDate.now();
        this.name = enterName(collectionManager);
        this.coordinates = enterCoordinates(collectionManager);
        this.minimalPoint = enterMinimalPoint(collectionManager);
        this.averagePoint = enterAveragePoint(collectionManager);
        this.difficulty = enterDifficulty(collectionManager);
    }

    /**
     * Создает id
     *
     * @param collectionManager коллекция
     * @return уникальный id
     */
    private long generateId(CollectionManager collectionManager) {
        return (collectionManager.getMaximalId() + 1);
    }

    /**
     * Пользовательский ввод названия лабы
     *
     * @param collectionManager коллекция
     * @return название
     */
    private String enterName(CollectionManager collectionManager) {
        System.out.print("Введите название лабы: ");
        name = scanner.nextLine();
        while (name == null || name.equals("")) {
            System.out.println("Значение не может быть null или пустым, попробуйте ещё раз");
            name = scanner.nextLine();
        }
        return (name);
    }

    /**
     * Пользовательский ввод сложности
     *
     * @param collectionManager коллекция
     * @return название
     */
    private Difficulty enterDifficulty(CollectionManager collectionManager) {
        Difficulty tempDifficulty = Difficulty.VERY_EASY;
        Difficulty[] difficulties = tempDifficulty.getDeclaringClass().getEnumConstants();
        System.out.println("Введите сложность лабы, доступные варианты сложности " + Arrays.toString(difficulties) + " Или оставьте пустую строку");
        String userDifficulty = scanner.nextLine();
        while (!isInEnum(userDifficulty, Difficulty.class) && !userDifficulty.equals("")) {
            System.out.println("Значение не в списке сложностей, попробуйте ещё раз. Список: " + Arrays.toString(difficulties));
            userDifficulty = scanner.nextLine();
        }
        if (userDifficulty.equals("")) {
            return null;
        } else {
            tempDifficulty.setDifficultyOfLab(userDifficulty);
            return (tempDifficulty);
        }
    }

    /**
     * Пользовательский ввод названия координат
     *
     * @param collectionManager коллекция
     * @return координаты
     */
    private Coordinates enterCoordinates(CollectionManager collectionManager) {
        Long x = null;
        int y = 0;
        System.out.print("Введите координату Long x(>-980): ");
        while (true) {
            try {
                x = Long.parseLong(scanner.nextLine());
                if (x <= -980) throw new UnsupportedOperationException();
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите координату Long x(>-980): ");
            }
        }
        System.out.print("Введите координату int y: ");
        while (true) {
            try {
                y = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите координату int y: ");
            }
        }
        Coordinates tempCoordinates = new Coordinates(x, y);
        return (tempCoordinates);
    }

    /**
     * Пользовательский ввод минимального балла
     *
     * @param collectionManager коллекция
     * @return минимальный балл
     */
    private float enterMinimalPoint(CollectionManager collectionManager) {
        System.out.print("Введите минимальный балл (>0): ");
        float tempMinimalPoint = 0.0F;
        while (true) {
            try {
                tempMinimalPoint = Float.parseFloat(scanner.nextLine());
                if (tempMinimalPoint <= 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите минимальный балл (>0): ");
            }
        }
        return (tempMinimalPoint);
    }

    /**
     * Пользовательский ввод минимального балла
     *
     * @param collectionManager коллекция
     * @return минимальный балл
     */
    private long enterAveragePoint(CollectionManager collectionManager) {
        long tempAveragePoint = 0;
        System.out.print("Введите средний балл (>0): ");
        while (true) {
            try {
                tempAveragePoint = Long.parseLong(scanner.nextLine());
                if (tempAveragePoint <= 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите средний балл (>0): ");
            }
        }
        return tempAveragePoint;
    }

    /**
     * Пользовательский ввод дисциплины
     *
     * @param collectionManager коллекция
     * @return экземпляр класса Discipline
     */
    private Discipline enterDiscipline(CollectionManager collectionManager) {
        String name; //Поле не может быть null, Строка не может быть пустой
        long lectureHours = 0;
        int practiceHours = 0;
        Long labsCount = null; //Поле может быть null
        System.out.print("Введите название дисциплины(обязательное поле): ");
        while (true) {
            try {
                name = (scanner.nextLine());
                if (Objects.equals(name, "") || name == null) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите название дисциплины(обязательное поле): ");
            }
        }
        System.out.print("Введите количество лекционных часов по этой дисциплине: ");
        while (true) {
            try {
                String line = scanner.nextLine();
                if (line.equals("")) {System.out.println("Вы не ввели поле. Оно будет пустым"); break;}
                lectureHours = Long.parseLong(line);
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите количество лекционных часов по этой дисциплине(или оставьте пустую строку): ");
            }
        }
        System.out.print("Введите количество практических часов по этой дисциплине: ");
        while (true) {
            try {
                String line = scanner.nextLine();
                if (line.equals("")) {System.out.println("Вы не ввели поле. Оно будет пустым"); break;};
                practiceHours = Integer.parseInt(line);
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите количество практических часов по этой дисциплине(или оставьте пустую строку): ");
            }
        }
        System.out.print("Введите количество лаб этой дисциплине: ");
        while (true) {
            try {
                String line = scanner.nextLine();
                if (line.equals("")) {System.out.println("Вы не ввели поле. Оно будет пустым"); break;}
                labsCount = Long.parseLong(line);
                break;
            } catch (Exception e) {
                System.out.print("Значение некорректно. Введите количество лаб этой дисциплине(или оставьте пустую строку): ");
            }
        }
        Discipline tempDiscipline = new Discipline(name, lectureHours, practiceHours, labsCount);
        return tempDiscipline;
    }


    /**
     * геттер id
     *
     * @return возвращает id
     */
    public long getId() {
        return id;
    }

    public float getMinimalPoint() {
        return minimalPoint;
    }

    public long getAveragePoint() {
        return averagePoint;
    }

    /**
     * @return описание лабы
     */
    @Override
    public String toString() {
        return "Название лабы: " + name + "\nID: " + id + "\nДата создания объекта коллекции: "
                + creationDate + "\nCoordinates X: " + coordinates.getX() + "\nCoordinates Y: " + coordinates.getY()
                + "\nМинимальный балл: " + minimalPoint + "\nСредний балл: " + averagePoint +
                "\nСложность: " + difficulty + "\nДисциплина: " + discipline;
    }

    /**
     * Сравнивает две лабы по id
     *
     * @param l2 вторая лаба
     * @return результат сравнения айдишников
     */
    public int compare(LabWork l2) {
        return (int) (this.id - l2.getId());
    }

    public String[] getAll() {
        return new String[]{String.valueOf(this.id), String.valueOf(this.name), String.valueOf(this.coordinates),
                String.valueOf(this.creationDate), String.valueOf(this.minimalPoint), String.valueOf(this.averagePoint),
                difficulty.getDifficultyOfLab(), discipline.getName(), String.valueOf(discipline.getLectureHours()),
                String.valueOf(discipline.getPracticeHours()), String.valueOf(discipline.getLabsCount())};
    }

    public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}