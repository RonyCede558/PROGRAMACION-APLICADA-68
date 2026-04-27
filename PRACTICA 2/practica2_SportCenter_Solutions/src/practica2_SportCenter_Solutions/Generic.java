package practica2_SportCenter_Solutions;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {

    private List<T> listElements = new ArrayList<>();

    public void add(T element) {
        listElements.add(element);
    }

    public List<T> getList() {
        return listElements;
    }

    public T find(java.util.function.Predicate<T> condition) {
        for (T element : listElements) {
            if (condition.test(element)) {
                return element;
            }
        }
        return null;
    }

    public void showAll() {
        for (T element : listElements) {
            System.out.println(element);
        }
    }
}