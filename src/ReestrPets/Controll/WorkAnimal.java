package ReestrPets.Controll;

import ReestrPets.Model.*;
import ReestrPets.Storage.Create;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс WorkAnimal предоставляет функциональность для управления животными в приюте.
 */
public class WorkAnimal {

    /**
     * Конструктор класса WorkAnimal.
     *
     * @param dbKennel База данных для хранения животных.
     */
    private Create dbKennel;

    public WorkAnimal(Create dbKennel) {
        this.dbKennel = dbKennel;
    }

    /**
     * Получает список всех животных в приюте.
     *
     * @return Список животных.
     */
    public List<ParentAnimal> getAnimals() {
        return dbKennel.getAllAnimals();
    }

    /**
     * Создает новое животное и добавляет его в приют.
     *
     * @param name         Имя животного.
     * @param birthDay     Дата рождения животного.
     * @param animalGenius Тип животного.
     * @return true, если животное успешно добавлено, false в противном случае.
     */
    public boolean createAnimal(String name, LocalDate birthDay, AnimalType animalGenius) {
        ParentAnimal animal = switch (animalGenius) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };

        return dbKennel.addAnimal(animal);
    }

    /**
     * Удаляет животное из приюта.
     *
     * @param animal Животное для удаления.
     * @return Идентификатор удаленного животного или -1, если животное не найдено.
     */
    public int removeAnimal(ParentAnimal animal) {
        if (animal == null) return -1;
        return dbKennel.removeAnimal(animal);
    }
}

