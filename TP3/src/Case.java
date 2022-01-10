public class Case {
    boolean color;
    Piece piece;
    public Case(boolean color){
        this.color=color;
        this.piece=null;
    }

    public Piece getPiece() {
        return piece;
    }
    public boolean estVide(){
        return (piece==null);
    }
    public void remplirPiece(Piece p){
        this.piece=p;
    }
    public void enleverPiece(){
        this.piece=null;
    }

    @Override
    public String toString() {
        if (piece != null) {
            return piece.toString();
        } else if (color)
            return ("-");
        else
            return ("*");
    }
}
