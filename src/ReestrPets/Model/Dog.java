package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Класс Dog представляет собой конкретное домашнее животное - собаку.
 * Унаследован от абстрактного класса Pet.
 */
public class Dog extends Pet {
    /**
     * Конструктор класса Dog для создания экземпляра собаки с заданным именем и датой рождения.
     *
     * @param name      Имя собаки.
     * @param birthDate Дата рождения собаки.
     */
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.DOG);
    }
}

