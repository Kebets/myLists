/**
 * Реализация связанного списка.
 *
 * @param <T> Тип элементов в списке
 */
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> prev; // Добавляем ссылку на предыдущий узел
    private int size;

    /**
     * Внутренний класс, представляющий узел списка.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Создает новый экземпляр MyLinkedList.
     */
    public MyLinkedList() {
        head = null;
        prev = null;
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент для добавления
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current; // Обновляем ссылку на предыдущий узел
        }
        size++;
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
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
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
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
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
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Очищает список (делает его пустым).
     */
    public void clear() {
        head = null;
        prev = null;
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
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
