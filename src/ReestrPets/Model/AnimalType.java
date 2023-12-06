package ReestrPets.Model;

/**
 * Перечисление AnimalType представляет собой различные типы животных.
 * Каждый тип имеет свое уникальное название.
 */
public enum AnimalType {
    DOG("Собака"),
    CAT("Кошка"),
    HAMSTER("Хомяк"),
    HORSE("Лошадь"),
    CAMEL("Верблюд"),
    DONKEY("Осёл");

    private String title;

    /**
     * Конструктор для создания типа животного с указанным названием.
     *
     * @param title Название типа животного.
     */
    AnimalType(String title) {
        this.title = title;
    }

    /**
     * Получение названия типа животного.
     *
     * @return Название типа животного.
     */
    public String getTitle() {
        return title;
    }
}

