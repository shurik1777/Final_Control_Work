package ReestrPets;

/**
 * Класс Counter предоставляет простой счетчик, который может использоваться в блоке try-with-resources.
 */
public class Counter implements AutoCloseable {
    private int counter;
    private boolean closed;

    /**
     * Конструктор класса Counter.
     * Инициализирует счетчик и устанавливает флаг "закрыто" в false.
     */
    public Counter() {
        counter = 0;
        closed = false;
    }

    /**
     * Получает текущее значение счетчика.
     *
     * @return Текущее значение счетчика.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Закрывает счетчик, сбрасывает его значение и устанавливает флаг "закрыто" в true.
     */
    @Override
    public void close() {
        closed = true;
        counter = 0;
    }

    /**
     * Увеличивает значение счетчика на 1.
     *
     * @throws RuntimeException Если счетчик закрыт, выбрасывается исключение.
     */
    public void add() {
        if (closed) {
            throw new RuntimeException("Counter is out of try_with_resources block");
        }
        counter++;
    }
}

