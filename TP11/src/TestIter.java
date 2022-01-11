import java.util.Iterator;

public class TestIter<E> implements Iterator<E> {
    private final E[] tableau;
    int index = 0;

    public TestIter(E[] tab) {
        this.tableau = tab;
    }

    @Override
    public boolean hasNext() {
        while (tableau[index + 1] == null && (index + 1) != tableau.length) {
            index++;
        }
        return (index + 1) != tableau.length;
    }

    @Override
    public E next() {
        if (hasNext())
            return tableau[index];
        return null;
    }
}
