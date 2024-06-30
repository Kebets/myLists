/**
 * Класс Main содержит метод main, который демонстрирует использование
 * двух пользовательских коллекций: MyArrayList и MyLinkedList.
 */
public class Main {
    public static void main(String[] args) {
        // Пример использования MyArrayList
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(10);
        myArrayList.add(20);
        System.out.println(myArrayList.get(1)); // Выведет 20
        myArrayList.remove(0); // Удалим первый элемент
        System.out.println(myArrayList.get(0)); // Выведет 20

        // Пример использования MyLinkedList
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hello");
        myLinkedList.add("World");
        System.out.println(myLinkedList.get(0)); // Выведет "Hello"
        myLinkedList.remove(1); // Удалим второй элемент
        System.out.println(myLinkedList.get(0)); // Выведет "Hello"
    }
}