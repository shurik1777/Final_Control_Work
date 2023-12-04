public class Counter implements AutoCloseable {
    private int count;

    // Метод, увеличивающий значение счетчика
    public void add() {
        count++;
    }

    // Метод, возвращающий текущее значение счетчика
    public int getCount() {
        return count;
    }

    // Реализация метода close интерфейса AutoCloseable
    @Override
    public void close() throws Exception {
        // Проверка, был ли объект использован в блоке try-with-resources
        if (count == 0) {
            // Если счетчик не был увеличен (ресурс остался неиспользованным), бросаем исключение
            throw new IllegalStateException("Ресурс счетчика не был использован в блоке try-with-resources");
        }
        // В противном случае ничего не делаем, так как счетчик успешно использован и закрыт
    }
}
