public class Deplacement {
    int x0;
    int y0;
    int x1;
    int y1;

    public Deplacement(int x0,int y0,int x1,int y1){
        this.x0=x0;
        this.y0=y0;
        this.y1=y1;
        this.x1=x1;
    }
    public char typeDeplacement() {
        if (x1 - x0 == 0 && y1 - y0 != 0)
            return 'v';
        else if (x1 - x0 != 0 && y1 - y0 == 0)
            return 'h';
        else if (Math.abs(x1 - x0) == Math.abs(y1 - y0))
            return 'd';
        else if (Math.abs(x1 - x0) == 1 && Math.abs(y1 - y0) == 2 || Math.abs(x1 - x0) == 2 && Math.abs(y1 - y0) == 1)
            return 'c';
        else
            return 'x';
    }

    public int dist(){
        if(typeDeplacement()=='x')
            return -1;
        if(typeDeplacement()=='v')
            return (Math.abs(y1-y0));
        else if(typeDeplacement()=='h')
            return Math.abs(x1-x0);
        else if(typeDeplacement()=='d')
            return 2*Math.abs(x1-x0);
        else
            return 3;
    }

}
