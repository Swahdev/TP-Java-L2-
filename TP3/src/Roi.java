public class Roi extends Piece{
    public Roi(boolean color) {
        super(color, "Roi");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        if(d.typeDeplacement()=='x'||d.typeDeplacement()=='c'||d.dist()!=1)
            return false;
        return super.estValide(d, p);
    }
}
