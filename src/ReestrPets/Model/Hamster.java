package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Класс Hamster представляет собой конкретное домашнее животное - хомяка.
 * Унаследован от абстрактного класса Pet.
 */
public class Hamster extends Pet {
    /**
     * Конструктор класса Hamster для создания экземпляра хомяка с заданным именем и датой рождения.
     *
     * @param name      Имя хомяка.
     * @param birthDate Дата рождения хомяка.
     */
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.HAMSTER);
    }
}

