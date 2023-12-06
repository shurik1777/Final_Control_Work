package ReestrPets.Model;

import java.util.Objects;

/**
 * Запись Command представляет собой команду, которую животное может выучить.
 * Команда содержит имя и при наличии описание.
 */
public record Command(String name, String description) {
    /**
     * Конструктор для создания команды с указанным именем и описанием.
     *
     * @param name Имя команды.
     */
    public Command(String name) {
        this(name, null);
    }

    /**
     * Переопределение метода equals для сравнения команд по имени.
     *
     * @param o Объект для сравнения.
     * @return true, если имена команд совпадают, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command skill = (Command) o;
        return name.equals(skill.name);
    }

    /**
     * Переопределение метода hashCode для генерации хэш-кода на основе имени команды.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Переопределение метода toString для представления команды в виде строки по ее имени.
     *
     * @return Строковое представление команды.
     */
    @Override
    public String toString() {
        return name;
    }
}

