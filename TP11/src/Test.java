import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        Collection<Integer> ints = new ArrayList<>();
        ints.add(4);
        ints.add(5);
        Collection<Integer> ints1 = new ArrayList<>();
        ints1.add(1);
        ints1.add(6);
        Collection<Integer> ints2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ints2.add(i);
        }

        TabSet<Integer> tab = new TabSet();
        System.out.println(tab.addAll(ints));
        System.out.println(tab.addAll(ints));
        System.out.println(tab.addAll(ints1));
        System.out.println(tab.retainAll(ints));
        System.out.println(tab.containsAll(ints));
        System.out.println(tab.containsAll(ints1));
        System.out.println(tab.removeAll(ints));
        System.out.println(tab.containsAll(ints));
        System.out.println(tab.addAll(ints));
        TabSet<Integer> tab2 = new TabSet();
        System.out.println(tab2.addAll(ints2));
        for (Integer e : tab2) {
            System.out.println(e);
        }
        System.out.println(tab2.add(10));
        for (Integer e : tab2) {
            System.out.println(e);
        }
    }
}
