import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalModel {
    private Connection connection;

    public AnimalModel(String jdbcUrl, String username, String password) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM friend_man");
            while (resultSet.next()) {
                Animal animal = new Animal(
                        resultSet.getString("name"),
                        resultSet.getString("commands"),
                        resultSet.getDate("birthdate").toLocalDate()
                );
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    // Другие методы для работы с базой данных могут быть добавлены здесь
    // Завести новое животное
    public void addAnimal(Animal animal) {
        try {
            String query = "INSERT INTO friend_man (name, commands, birthdate) VALUES (VARCHAR(255) NOT NULL, VARCHAR(255), DATE)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, animal.getName());
                preparedStatement.setString(2, animal.getCommands());
                preparedStatement.setDate(3, Date.valueOf(animal.getBirthDate()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод в AnimalModel
    public String getCommandsForAnimal(String animalName) {
        try {
            String query = "SELECT commands FROM horse_and_donkeys WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, animalName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getString("commands");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Животное не найдено";
    }

    public void teachAnimalNewCommands(String animalName, String newCommands) {
        try {
            String query = "UPDATE horse_and_donkeys SET commands = ? WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newCommands);
                preparedStatement.setString(2, animalName);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}