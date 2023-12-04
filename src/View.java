import java.util.List;

public class AnimalView {
    public void displayAnimals(List<Animal> animals) {
        System.out.println("Список животных:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    // Другие методы для отображения информации могут быть добавлены здесь
}
