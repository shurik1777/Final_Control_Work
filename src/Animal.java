import java.time.LocalDate;

public class Animal {
    private String name;
    private String commands;
    private LocalDate birthDate;

    public Animal(String name, String commands, LocalDate birthDate) {
        this.name = name;
        this.commands = commands;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", commands='" + commands + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
