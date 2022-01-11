public class Modele {
    private int rouge;
    private int vert;
    private int bleu;
    private int rouge1;
    private int vert1;
    private int bleu1;

    public Modele(int rouge, int vert, int bleu) {
        this.rouge = rouge;
        this.vert = vert;
        this.bleu = bleu;
    }


    public int getBleu() {
        return bleu;
    }

    public int getRouge() {
        return rouge;
    }

    public int getVert() {
        return vert;
    }

    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    public void setBleu(int bleu) {
        this.bleu = bleu;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }

    public void memorisercolor(int r, int v, int b) {
        this.bleu1=b;
        this.rouge1=r;
        this.vert1=v;
    }

    public int getBleu1() {
        return bleu1;
    }

    public int getRouge1() {
        return rouge1;
    }

    public int getVert1() {
        return vert1;
    }
}
