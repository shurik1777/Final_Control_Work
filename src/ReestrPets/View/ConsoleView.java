package ReestrPets.View;

import ReestrPets.Controll.WorkAnimal;
import ReestrPets.Counter;
import ReestrPets.Model.AnimalType;
import ReestrPets.Model.Command;
import ReestrPets.Model.ParentAnimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Класс ConsoleView представляет консольный интерфейс для работы с реестром животных.
 * Реализует интерфейс InterView.
 */
public class ConsoleView implements InterView {
    public static final int SIZE_LINE = 80;
    public static final String ROW_FORMAT = "%-6d%-16s%-20s%-20d%-20s";
    public static final String COLUMN_HEADER_FORMAT = "%-6s%-16s%-20s%-20s%-20s";
    private final WorkAnimal kennelAccounting;
    private Scanner scanner;

    public ConsoleView(WorkAnimal kennelAccounting) {
        this.kennelAccounting = kennelAccounting;
        scanner = new Scanner(System.in);
    }

    record AnimalData(String name, LocalDate birthDate, AnimalType animalGenius) {
    }

    /**
     * Метод отображает реестр животных в консоли.
     */
    public void showKennelRegistry() {
        clearConsole();
        printLineWithSymbol("=", SIZE_LINE);
        printCaption("Меню", " ");
        printLineWithSymbol("=", SIZE_LINE);
        printRegistryHeader();
        printLineWithSymbol("-", SIZE_LINE);

        List<ParentAnimal> animals = kennelAccounting.getAnimals();
        for (int i = 0; i < animals.size(); i++) {
            var item = animals.get(i);
            String row = String.format(ROW_FORMAT, i + 1, item.getName(), item.getBurthDateAsString(), item.getAge(),
                    item.getAnimalGenius().getTitle());
            printLine(row);
        }
        printLineWithSymbol("-", SIZE_LINE);
    }

    /**
     * Метод отображает главное меню с возможностью выбора действия.
     *
     * @return Выбранное действие из главного меню.
     */
    public MainMenuCommand showMainMenuWithResult() {
        String menu = String.format(
                "%d-[%s]\t%d-[%s]\t%d-[%s]\t%d-[%s]\n",
                MainMenuCommand.ADD_ANIMAL.ordinal(),
                MainMenuCommand.ADD_ANIMAL.getTag(),
                MainMenuCommand.SHOW_SKILLS.ordinal(),
                MainMenuCommand.SHOW_SKILLS.getTag(),
                MainMenuCommand.REMOVE_ANIMAL.ordinal(),
                MainMenuCommand.REMOVE_ANIMAL.getTag(),
                MainMenuCommand.EXIT.ordinal(),
                MainMenuCommand.EXIT.getTag());
        printLineWithSymbol("=", SIZE_LINE);
        printLine("Действия:");
        printLine(menu);
        while (true) {
            try {
                System.out.printf("%s (%d - %d): ", "Выберите действие: ", MainMenuCommand.ADD_ANIMAL.ordinal(),
                        MainMenuCommand.EXIT.ordinal());
                scanner = new Scanner(System.in);
                return MainMenuCommand.values()[scanner.nextInt()];
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                printLine("Некоректное действие!");
            }
        }
    }

    /**
     * Метод отображает диалог добавления нового животного.
     *
     * @return Возвращает true, если животное успешно добавлено, иначе false.
     */
    public boolean showAddAnimalDialog() {
        String infoMessage = "Введите параметры животного в виде строки через пробел: \"имя день_рождения род_животного\"\n" +
                "день рождения имеет вид: 12-03-2022: \n" +
                "род животного может принимать значения: " + Arrays.asList(AnimalType.values());
        System.out.println(infoMessage);
        while (true) {
            Counter counter = new Counter();
            try (counter) {
                System.out.print("Ввод: ");
                scanner = new Scanner(System.in);
                String inputData = scanner.nextLine();
                AnimalData parsedData = parceAnimalData(inputData);
                counter.add();
                return kennelAccounting.createAnimal(parsedData.name, parsedData.birthDate, parsedData.animalGenius);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты рождения");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * Метод отображает детальную информацию о животном.
     */
    public void showDetailInfoAnimalDialog() {
        String infoMessage = String.format("Введите номер животного (1 - %d)", kennelAccounting.getAnimals().size());
        System.out.println(infoMessage);
        while (true) {
            try {
                scanner = new Scanner(System.in);
                int animalNumber = scanner.nextInt();
                ParentAnimal animal = kennelAccounting.getAnimals().get(animalNumber - 1);
                showAnimalInfo(animal);

                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Запись с таким номером отсутствует");
            }
        }
    }

    /**
     * Метод отображает информацию о животном и предоставляет опции для добавления умений.
     *
     * @param animal Животное, для которого отображается информация.
     */
    public void showAnimalInfo(ParentAnimal animal) {
        while (true) {
            printAnimalInfo(animal);
            AddSkillMenuCommand code = showAddSkillMenu(animal);
            switch (code) {
                case ADD_SKILL -> {
                    boolean result = showAddSkillDialog(animal);
                    String resMessage = result ? "Команда добавлена" : "Ошибка при добавлении команды";
                    System.out.println(resMessage);
                    if (!result) return;
                }
                case EXIT -> {
                    return;
                }
            }
        }
    }

    /**
     * Отображает меню для добавления умения животному и возвращает выбранный AddSkillMenuCommand.
     *
     * @param animal Объект ParentAnimal, для которого добавляется умение.
     * @return Выбранный AddSkillMenuCommand.
     */
    public AddSkillMenuCommand showAddSkillMenu(ParentAnimal animal) {
        String menu = String.format(
                "%d-[%s]\t%d-[%s]\n",
                AddSkillMenuCommand.ADD_SKILL.ordinal(), AddSkillMenuCommand.ADD_SKILL.getTag(),
                AddSkillMenuCommand.EXIT.ordinal(), AddSkillMenuCommand.EXIT.getTag());
        printLineWithSymbol("=", SIZE_LINE);
        printLine("Действия:");
        printLine(menu);
        while (true) {
            try {
                System.out.printf("%s (%d - %d): ", "Выберите действие: ", AddSkillMenuCommand.ADD_SKILL.ordinal(),
                        AddSkillMenuCommand.EXIT.ordinal());
                scanner = new Scanner(System.in);
                return AddSkillMenuCommand.values()[scanner.nextInt()];
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                printLine("Некорректное действие!");
            }
        }
    }

    /**
     * Отображает диалог добавления умения животному.
     *
     * @param animal Объект ParentAnimal, для которого добавляется умение.
     * @return Результат добавления умения животному.
     */
    public boolean showAddSkillDialog(ParentAnimal animal) {
        System.out.println("Введите данные в виде \"команда <:описание>\"");
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isBlank()) return false;
        String[] skillData = input.split(":");
        if (skillData.length == 1) {
            animal.learnSkill(new Command(skillData[0]));
        } else if (skillData.length == 2) {
            animal.learnSkill(new Command(skillData[0], skillData[1]));
        } else {
            System.out.println("Слишком много параметров");
            return false;
        }
        return true;
    }

    /**
     * Отображает диалог удаления животного и возвращает результат.
     *
     * @return Результат удаления животного.
     */
    public int showRemoveAnimalDialog() {
        String infoMessage = String.format("Введите номер животного (1 - %d)", kennelAccounting.getAnimals().size());
        System.out.println(infoMessage);
        while (true) {
            try {
                scanner = new Scanner(System.in);
                int animalNumber = scanner.nextInt();
                ParentAnimal animal = kennelAccounting.getAnimals().get(animalNumber - 1);

                return kennelAccounting.removeAnimal(animal);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Запись с таким номером отсутствует");
            }
        }
    }

    /**
     * Метод парсит введенные данные для создания нового животного.
     *
     * @param inputData Введенные данные в виде строки.
     * @return Объект AnimalData, содержащий имя, дату рождения и род животного.
     * @throws IllegalArgumentException Если введены некорректные данные.
     */
    private AnimalData parceAnimalData(String inputData) {
        String[] input = inputData.split(" ");

        if (input.length < 3) {
            throw new IllegalArgumentException("Недостаточное количество данных");
        }
        if (input.length > 3) {
            throw new IllegalArgumentException("Слишком много данных");
        }
        String animalName = input[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDay = LocalDate.parse(input[1], formatter);
        AnimalType genius = AnimalType.valueOf(input[2].toUpperCase());
        return new AnimalData(animalName, birthDay, genius);
    }

    /**
     * Очищает консоль.
     */
    private void clearConsole() {
        System.out.print("\033[H\033[J");
    }

    /**
     * Печатает строку с символом указанное количество раз.
     *
     * @param symbol   Символ для печати.
     * @param sizeLine Количество повторений символа.
     */
    private void printLineWithSymbol(String symbol, int sizeLine) {
        System.out.println(symbol.repeat(sizeLine));
    }

    /**
     * Печатает заголовок с отступами.
     *
     * @param caption Заголовок.
     * @param padSymb Символ отступа.
     */
    private void printCaption(String caption, String padSymb) {
        int spaceSize = (SIZE_LINE - caption.length()) / 2;
        String captionLine = padSymb.repeat(spaceSize) + caption + padSymb.repeat(spaceSize);
        System.out.println(captionLine);
    }

    /**
     * Печатает заголовок реестра животных.
     */
    private void printRegistryHeader() {
        String header = String.format(COLUMN_HEADER_FORMAT, "№", "Имя", "Дата рождения", "Возраст(в месяцах)",
                "Род животного");
        System.out.println(header);
    }

    /**
     * Печатает строку.
     *
     * @param row Строка для печати.
     */
    private void printLine(String row) {
        System.out.printf("%s\n", row);
    }


    /**
     * Печатает информацию о животном.
     *
     * @param animal Животное, информацию о котором нужно напечатать.
     */
    private void printAnimalInfo(ParentAnimal animal) {
        clearConsole();
        printCaption("Detail info", "~");
        System.out.printf("Род животного: %s\n", animal.getAnimalGenius().getTitle());
        System.out.printf("Имя: %s\n", animal.getName());
        System.out.printf("Дата рождения: %s\n", animal.getBurthDateAsString());
        System.out.printf("Возраст (в месяцах): %d\n", animal.getAge());
        System.out.printf("Умения: %s\n", animal.getAnimalSkills());
        printLineWithSymbol("~", SIZE_LINE);
    }
}

