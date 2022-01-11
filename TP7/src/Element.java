public abstract class Element {
    public abstract String getType();

    @Override
    public String toString() {
        return "Fichier de type " + getType();
    }
}
