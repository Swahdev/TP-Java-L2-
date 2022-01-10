import java.util.LinkedList;

public class Ligne extends ChaineCar {
    LinkedList<ChaineCar> ligne;

    public boolean isEmpty() {
        return ligne.size() == 0;
    }

    @Override
    public int len() {
        return ligne.size();
    }

    @Override
    public String toString() {
        String lignefinale = "";
        int i = 0;
        while (i < ligne.size()) {
            lignefinale += " " + ligne.get(i).toString();
            i++;
        }
        return lignefinale;
    }

    public LinkedList<ChaineCar> addChaine(ChaineCar mot) {
        if (isEmpty())
            ligne.add(0, mot);
        else
            ligne.add(ligne.size(), mot);
        return ligne;
    }

    public void addMot(Mot b) {
        ligne.add(b);
    }
}
