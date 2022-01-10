import java.util.Locale;

public class Piece {
    boolean color;
    String nomP;
    public Piece(boolean color, String nomP){
        this.color=color;
        this.nomP=nomP;
    }

    @Override
    public String toString() {
        if(nomP==null)
            return null;
        if (color) {
            return nomP.substring(0,1).toLowerCase();
        }
        else
            return nomP.substring(0,1).toUpperCase();
    }


    public boolean estValide(Deplacement d,Plateau p){
        if (p.getCase(d.x1,d.y1).piece!=null) {
            return p.getCase(d.x0, d.y0).color == p.getCase(d.x1, d.y1).color;
        }
        return false;
    }
}
