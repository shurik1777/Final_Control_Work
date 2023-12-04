public class MainApplication {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
        // Подключение к базе данных (замените параметры подключения своими)
        String jdbcUrl = "jdbc:mysql://localhost:3306/friend_man";
        String username = "user";
        String password = "123";

        // Создание объектов Model, View и Presenter
        AnimalModel model = new AnimalModel(jdbcUrl, username, password);
        AnimalView view = new AnimalView();
        AnimalPresenter presenter = new AnimalPresenter(model, view);

        // Выполнение запроса и отображение результата
        presenter.getAllAnimals();
        } catch (Exception e) {
            // Ловим исключения, если что-то пошло не так
            e.printStackTrace();
        }
    }
}
