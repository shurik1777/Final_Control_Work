package ReestrPets.Model;

import java.time.LocalDate;


/**
 * Описывает абстрактное домашнее животное
 */
public abstract class Pet extends ParentAnimal {
    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

