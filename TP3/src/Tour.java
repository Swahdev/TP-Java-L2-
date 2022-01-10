public class Tour extends Piece{

    public Tour(boolean color) {
        super(color, "Tour");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        if(d.typeDeplacement() !='v' || d.typeDeplacement() != 'h'){
            return false;
        }
        return super.estValide(d, p);
    }
}
