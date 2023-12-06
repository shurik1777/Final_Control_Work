package ReestrPets.Storage;


import ReestrPets.Model.ParentAnimal;

import java.util.List;

/**
 * Интерфейс Create определяет контракт для работы с хранилищем животных.
 * Предоставляет базовые операции по получению, добавлению и удалению животных.
 */
public interface Create {
    /**
     * Возвращает список всех животных в хранилище.
     *
     * @return Список всех животных.
     */
    List<ParentAnimal> getAllAnimals();

    /**
     * Возвращает животное по его идентификатору.
     *
     * @param animalId Идентификатор животного.
     * @return Животное с указанным идентификатором или null, если такого животного нет.
     */
    ParentAnimal getAnimalById(int animalId);

    /**
     * Добавляет новое животное в хранилище.
     *
     * @param animal Добавляемое животное.
     * @return true, если животное успешно добавлено, false - в противном случае.
     */

    boolean addAnimal(ParentAnimal animal);

    /**
     * Удаляет животное из хранилища.
     *
     * @param animal Животное, которое нужно удалить.
     * @return Идентификатор удаленного животного, или -1, если такого животного не существует.
     */
    int removeAnimal(ParentAnimal animal);
}

