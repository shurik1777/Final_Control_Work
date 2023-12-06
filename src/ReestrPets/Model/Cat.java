package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Класс Cat представляет собой конкретное домашнее животное - кота.
 * Унаследован от абстрактного класса Pet.
 */

public class Cat extends Pet {
    /**
     * Конструктор класса Cat для создания экземпляра кота с заданным именем и датой рождения.
     *
     * @param name      Имя кота.
     * @param birthDate Дата рождения кота.
     */
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.CAT);
    }
}

