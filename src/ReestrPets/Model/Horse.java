package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Класс Horse представляет собой конкретное вьючное животное - лошадь.
 * Унаследован от абстрактного класса PackAnimal.
 */
public class Horse extends PackAnimal {
    /**
     * Конструктор класса Horse для создания экземпляра лошади с заданным именем и датой рождения.
     *
     * @param name      Имя лошади.
     * @param birthDate Дата рождения лошади.
     */
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.HORSE);
    }
}

