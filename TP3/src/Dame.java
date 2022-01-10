public class Dame extends Piece{
    public Dame(boolean color) {
        super(color, "Dame");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        if(d.typeDeplacement()=='x'|| d.typeDeplacement()=='c')
            return false;
        return super.estValide(d, p);
    }
}
