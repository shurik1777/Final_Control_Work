package ReestrPets.Model;

import java.time.LocalDate;

/**
 * Абстрактный класс PackAnimal расширяет функциональность абстрактного класса ParentAnimal
 * и предоставляет общие свойства и методы для всех видов вьючных животных.
 */
public abstract class PackAnimal extends ParentAnimal {
    /**
     * Значение грузоподъемности по умолчанию, кг.
     */
    public static final int DEFAULT_LOAD_CAPACITY = 100;

    /**
     * Грузоподъемность вьючного животного, кг.
     */
    private int loadCapacity;

    /**
     * Конструктор класса PackAnimal.
     *
     * @param name      Имя вьючного животного.
     * @param birthDate Дата рождения вьючного животного.
     */
    public PackAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.loadCapacity = DEFAULT_LOAD_CAPACITY;
    }

    /**
     * Получает значение грузоподъемности вьючного животного.
     *
     * @return Грузоподъемность в килограммах.
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * Устанавливает значение грузоподъемности вьючного животного.
     *
     * @param loadCapacity Новое значение грузоподъемности в килограммах.
     */
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}

