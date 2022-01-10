public class Et extends Predicat{
    private final Predicat p1,p2;
    public Et(Predicat c1, Predicat c2){
        p1=c1;
        p2=c2;
    }
    boolean estVrai(Media m){
        return p1.estVrai(m) && p2.estVrai(m);
    }

}
