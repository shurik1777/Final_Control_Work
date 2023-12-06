package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Класс Camel представляет собой верблюда как вьючное животное.
 * Унаследован от абстрактного класса PackAnimal.
 */
public class Camel extends PackAnimal {
    /**
     * Конструктор класса Camel для создания экземпляра верблюда с заданным именем и датой рождения.
     *
     * @param name      Имя верблюда.
     * @param birthDate Дата рождения верблюда.
     */
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.CAMEL);
    }
}

