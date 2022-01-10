import java.util.LinkedList;

public class ParagrapheJoli {
    private int max;
    LinkedList<Ligne> paragraphe;

    public ParagrapheJoli() {
        this.paragraphe = new LinkedList<>();
        this.max = 0;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isEmpty() {
        return paragraphe.size() == 0;
    }

    /*
    public LinkedList<Ligne> addString(Ligne mot) {
        if (isEmpty())
            paragraphe.addFirst(mot);
        if (paragraphe.size()+mot.len()>max){
            paragraphe.add();
        }else
            paragraphe.add(paragraphe.size(), ligne);
         return paragraphe;
    }

     */
}
