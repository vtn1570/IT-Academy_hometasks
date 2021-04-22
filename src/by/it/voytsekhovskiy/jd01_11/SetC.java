package by.it.voytsekhovskiy.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[0];

    private int size;

    @Override
    public boolean add(T t) {
        boolean switcherAdd = true;

        if (elements.length == 0) {
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[size++] = t;
            return true;
        } else {
            for (T element : elements) {
                if (element == null) {
                    if (element == t) {
                        switcherAdd = false;
                        break;
                    }
                } else {
                    if (element.equals(t)) {
                        switcherAdd = false;
                        break;
                    }
                }
            }
        }
        if (switcherAdd) {
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[size++] = t;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] enteringElenemts = (T[]) c.toArray();
        boolean isAdding = false;
        for (T element : enteringElenemts) {
            if (add(element)) {
                isAdding = true;
            }
        }
        return isAdding;
    }

    @Override
    public boolean remove(Object o) {
        boolean switcherRemove = false;
        int index = 0;
        if (elements.length == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                if (o == elements[i]) {
                    switcherRemove = true;
                    index = i;
                    break;
                }
            } else {
                if (elements[i].equals(o)) {
                    switcherRemove = true;
                    index = i;
                    break;
                }
            }
        }
        if (switcherRemove) {
            System.arraycopy(elements, index + 1, elements, index, size - (index + 1));
            size--;
            return true;
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> newElements) {
        boolean isChanged = false;
        for (Object newElement : newElements) {
            if (remove(newElement)) {
                isChanged = true;
            }
        }
        return isChanged;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int current = -1;

            @Override
            public boolean hasNext() {
                return current + 1 < size;
            }

            @Override
            public T next() {
                return elements[++current];
            }

            @Override
            public void remove() {

            }
        };
    }

    @Override
    public boolean contains(Object o) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (o == null) {
                if (it.next() == o) {
                    return true;
                }
            } else {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> newElements) {
//        Object[] newElements1 = newElements.toArray(); ??????????????????????????????????
        for (Object newElement : newElements) { // ?????
            if (!contains(newElement)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner txt = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                txt.add(elements[i].toString());
            } else {
                txt.add(null);
            }
        }
        return txt.toString();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int to = size, i = 0; i < to; i++) {
            size--;
        }
    }
}
