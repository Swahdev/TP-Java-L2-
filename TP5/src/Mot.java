public class Mot extends ChaineCar {
    String mot;

    public Mot(String mot) {
        this.mot = mot;
    }

    @Override
    public int len() {
        return mot.length();
    }

    @Override
    public String toString() {
        return "Mot{" +
                "mot='" + mot + '\'' +
                '}';
    }

}
