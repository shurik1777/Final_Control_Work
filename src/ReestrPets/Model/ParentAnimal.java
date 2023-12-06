package ReestrPets.Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс ParentAnimal предоставляет общие свойства и методы для всех типов животных.
 * Потомки этого класса должны предоставить конкретные реализации для определения видов животных.
 */
public abstract class ParentAnimal {
    /**
     * Статический счетчик для присвоения уникальных идентификаторов животным.
     */
    private static int counter;
    /**
     * Уникальный идентификатор животного.
     */
    private final int id = ++counter;
    /**
     * Тип животного.
     */
    private AnimalType animalGenius;

    /**
     * Имя животного.
     */
    private String name;

    /**
     * Дата рождения животного.
     */
    private LocalDate birthDate;

    /**
     * Список выполняемых команд животного.
     */
    private List<Command> animalSkills;

    /**
     * Получает уникальный идентификатор животного.
     *
     * @return Уникальный идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Получает имя животного.
     *
     * @return Имя животного.
     */
    public String getName() {
        return name;
    }

    /**
     * Получает дату рождения животного.
     *
     * @return Дата рождения.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Устанавливает дату рождения животного.
     *
     * @param birthDate Дата рождения для установки.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Получает тип животного.
     *
     * @return Тип животного.
     */
    public AnimalType getAnimalGenius() {
        return animalGenius;
    }

    /**
     * Устанавливает тип животного.
     *
     * @param animalGenius Тип животного для установки.
     */
    public void setAnimalGenius(AnimalType animalGenius) {
        this.animalGenius = animalGenius;
    }

    /**
     * Получает список выполняемых команд животного.
     *
     * @return Список выполняемых команд.
     */
    public List<Command> getAnimalSkills() {
        return animalSkills;
    }

    /**
     * Конструктор класса ParentAnimal.
     *
     * @param name      Имя животного.
     * @param birthDate Дата рождения животного.
     */
    public ParentAnimal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalSkills = new ArrayList<>();
    }

    /**
     * Получает дату рождения животного в виде строки.
     *
     * @return Строка с датой рождения в формате "dd-MM-yyyy".
     */
    public String getBurthDateAsString() {
        return String.format("%02d-%02d-%4d", birthDate.getDayOfMonth(), birthDate.getMonthValue(),
                birthDate.getYear());
    }

    /**
     * Получает возраст животного в месяцах.
     *
     * @return Возраст в месяцах.
     */
    public int getAge() {
        int years = Period.between(birthDate, LocalDate.now()).getYears();
        int months = Period.between(birthDate, LocalDate.now()).getMonths();
        return years * 12 + months;
    }

    /**
     * Добавляет новую команду в список выполняемых команд животного.
     *
     * @param newSkill Новая команда.
     * @return true, если команда успешно добавлена, false - в противном случае.
     */
    public boolean learnSkill(Command newSkill) {
        if (animalSkills.contains(newSkill)) {
            return false;
        }
        animalSkills.add(newSkill);
        return true;
    }

    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     *
     * @return Строка с информацией об объекте.
     */
    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}