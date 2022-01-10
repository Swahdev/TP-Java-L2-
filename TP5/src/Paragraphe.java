import java.util.LinkedList;

public class Paragraphe extends ChaineCar {
    LinkedList<Ligne> paragraphe;
    public Paragraphe(){
        this.paragraphe=new LinkedList<>();
    }


    @Override
    public int len() {
        return paragraphe.size();
    }

    public boolean isEmpty() {
        return paragraphe.size() == 0;
    }

    public LinkedList<Ligne> addChaine(Ligne ligne) {
        if (isEmpty())
            paragraphe.add(0, ligne);
        else
            paragraphe.add(paragraphe.size(), ligne);
        return paragraphe;
    }
    public void remove(){
        paragraphe.remove(paragraphe.size()-1);
    }

}
