/**
 * Реализация динамического массива.
 *
 * @param <T> Тип элементов в массиве
 */
public class MyArrayList<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Создает новый экземпляр MyArrayList с начальным размером по умолчанию.
     */
    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент для добавления
     */
    public void add(T element) {
        if (size == array.length) {
            // Увеличиваем размер массива при необходимости
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size++] = element;
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   Индекс, куда добавить элемент
     * @param element Элемент для добавления
     * @throws IndexOutOfBoundsException Если индекс недопустим
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        if (size == array.length) {
            // Увеличиваем размер массива при необходимости
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента
     * @return Элемент по индексу
     * @throws IndexOutOfBoundsException Если индекс недопустим
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        return (T) array[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента для удаления
     * @throws IndexOutOfBoundsException Если индекс недопустим
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    /**
     * Очищает список (делает его пустым).
     */
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;

    }

    /**
     * Возвращает строковое представление списка.
     *
     * @return Строковое представление списка
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T current = (T) array[j];
                T next = (T) array[j + 1];
                if (compare(current, next) > 0) {
                    // Обмен элементов, если текущий больше следующего
                    array[j] = next;
                    array[j + 1] = current;
                }
            }
        }
    }

    /**
     * Сравнивает два элемента для определения порядка сортировки.
     * Возвращает отрицательное число, если a < b, положительное число, если a > b,
     * и 0, если a равно b.
     *
     * @param a Первый элемент
     * @param b Второй элемент
     * @return Результат сравнения
     */
    private int compare(T a, T b) {
        return (a.hashCode() - b.hashCode());
    }

    /**
     * Возвращает текущий размер (количество элементов) списка.
     *
     * @return Размер списка
     */
    public int size() {
        return size;
    }
}
