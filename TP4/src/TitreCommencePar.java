public class TitreCommencePar extends Predicat{
    char lettre;
    public TitreCommencePar(char lettre){
        this.lettre=lettre;
    }
    @Override
    boolean estVrai(Media m) {
        return m.getTitre().charAt(0) == Character.toLowerCase(lettre) || m.getTitre().charAt(0) == Character.toUpperCase(lettre);
    }
}
