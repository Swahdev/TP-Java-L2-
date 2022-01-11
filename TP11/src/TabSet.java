import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TabSet<E> implements Iterable<E>, Set<E> {

    private E[] table;
    private int content = 0;

    @SuppressWarnings("unchecked")
    public TabSet() {
        this.table = (E[]) new Object[10];
    }

    public E[] getTable() {
        return table;
    }

    class TabIter implements Iterator<E> {

        private int curr = 0;

        @Override
        public boolean hasNext() {
            return curr < table.length;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E ans = table[curr];
                curr++;
                return ans;
            }
            return null;
        }

        public void add(E e) {
            for (int i = curr; i < table.length; i++) {
                if (table[i] == null) {
                    table[i] = e;
                    content++;
                    return;
                }
            }
            E[] tab = toArray(table);
            tab[table.length] = e;
            content++;
            table = tab;
        }

        @Override
        public void remove() {
            if (curr == 0) {
                throw new IllegalStateException("Can't remove before using next");
            }
            table[curr - 1] = null;
        }
    }

    @Override
    public TabIter iterator() {
        return (new TabIter());
    }

    @Override
    public boolean contains(Object o) {
        for (E e : table) {
            if (e != null && e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return content;
    }

    @Override
    public boolean isEmpty() {
        return content == 0;
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        }
        if (e == null) {
            throw new NullPointerException("Can't add null");
        }
        TabIter iter = iterator();
        iter.add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Can't delete null");
        }
        for (TabIter iter = iterator(); iter.hasNext(); ) {
            E et = iter.next();
            if (et != null && et.equals(o)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (TabIter iter = iterator(); iter.hasNext(); ) {
            E et = iter.next();
            iter.remove();
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int ind = 0;
        for (E e : table) {
            if (e != null) {
                array[ind++] = e;
            }
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length > size()) {
            int ind = 0;
            for (E e : table) {
                a[ind++] = (T) e;
            }
            return a;
        }
        Class c = a.getClass().getComponentType();
        T[] tab = (T[]) Array.newInstance(c, 2 * table.length);
        int ind = 0;
        for (E e : table) {
            tab[ind++] = (T) e;
        }
        return tab;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E comp : c) {
            if (!add(comp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (E et : this) {
            if (et != null && !c.contains(et) && !remove(et)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object obj : c) {
            if (!remove(obj)) {
                return false;
            }
        }
        return true;
    }

}