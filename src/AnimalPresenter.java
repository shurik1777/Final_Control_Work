import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;


public class AnimalPresenter {
    private AnimalModel model;
    private AnimalView view;

    public AnimalPresenter(AnimalModel model, AnimalView view) {
        this.model = model;
        this.view = view;
    }

    public void getAllAnimals() {
        List<Animal> animals = model.getAllAnimals();
        view.displayAnimals(animals);
    }

    // Другие методы презентера могут быть добавлены здесь
    // Метод в AnimalPresenter
    public void addNewAnimal(String name, String commands, LocalDate birthDate) {
        Animal newAnimal = new Animal(name, commands, birthDate);
        model.addAnimal(newAnimal);
    }

    // Метод в AnimalPresenter
    public void displayCommandsForAnimal(String animalName) {
        String commands = model.getCommandsForAnimal(animalName);
        System.out.println("Команды для животного " + animalName + ": " + commands);
    }

    public void teachNewCommandsToAnimal(String animalName, String newCommands) {
        model.teachAnimalNewCommands(animalName, newCommands);
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Показать всех животных");
            System.out.println("2. Завести новое животное");
            System.out.println("3. Показать команды для животного");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    getAllAnimals();
                    break;
                case 2:
                    System.out.print("Введите имя нового животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите команды для нового животного: ");
                    String commands = scanner.nextLine();
                    System.out.print("Введите дату рождения нового животного (гггг-мм-дд): ");
                    String birthDateString = scanner.nextLine();
                    LocalDate birthDate = LocalDate.parse(birthDateString);
                    addNewAnimal(name, commands, birthDate);
                    break;
                case 3:
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    displayCommandsForAnimal(animalName);
                    break;
                case 4:
                    System.out.print("Введите имя животного: ");
                    String animalNameToTeach = scanner.nextLine();
                    System.out.print("Введите новые команды для животного: ");
                    String newCommands = scanner.nextLine();
                    teachNewCommandsToAnimal(animalNameToTeach, newCommands);
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }
    }

}
