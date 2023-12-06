package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Класс Donkey представляет собой конкретное вьючное животное - ослика.
 * Унаследован от абстрактного класса PackAnimal.
 */
public class Donkey extends PackAnimal {
    /**
     * Конструктор класса Donkey для создания экземпляра ослика с заданным именем и датой рождения.
     *
     * @param name      Имя ослика.
     * @param birthDate Дата рождения ослика.
     */
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.DONKEY);
    }
}

