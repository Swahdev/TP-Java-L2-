public class Informations {
    int v;
    int f;
    int a;
    Informations inf;

    public Informations(int v, int f, int a) {
        this.v = v;
        this.f = f;
        this.a = a;
    }

    public Informations(Informations inf) {
        this.inf = inf;
    }

    public int getVitalite() {
        return v;
    }

    public int getForce() {
        return f;
    }

    public int getAgilite() {
        return a;
    }

    public int setVitalite(int newVitalite) {
        return this.v = newVitalite;
    }

    public int setForce(int newForce) {
        return this.f = newForce;
    }

    public int setAgilite(int newAgilite) {
        return this.a = newAgilite;
    }


    public String toString() {
        return "Le personnage a une vitalite de " + this.getVitalite() + " une force de " + this.getForce() + " et une agilité de " + getAgilite();
    }

}
