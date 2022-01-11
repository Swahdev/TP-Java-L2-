import java.io.InputStream;
import java.util.Scanner;

public class Shell {
    Dossier racine;
    Dossier courant;

    public Shell(Dossier dossier) {
        this.racine = dossier;
        this.courant = dossier;
    }

    public void interagir(InputStream in) {
        Scanner sc = new Scanner(in);
        sc.useDelimiter("\n");
        String[] liste = new String[1000];
        int i = 0;
        while (sc.hasNext()) {
            liste[i] = sc.next();
            i++;
        }
        switch (liste[0]) {
            case "ed" -> {
                Ed commandeEd = new Ed(racine, courant, liste, sc, (in != System.in));
                commandeEd.executer();
            }
            case "cd" -> {
                Cd commandeCd = new Cd(racine, courant, liste);
                commandeCd.executer();
            }
            case "rm" -> {
                Rm commandeRm = new Rm(racine, courant, liste);
                commandeRm.executer();
            }
            case "mv" -> {
                Mv commandeMv = new Mv(racine, courant, liste);
                commandeMv.executer();
            }
            case "mkdir" -> {
                Mkdir commandeMkdir = new Mkdir(racine, courant, liste);
                commandeMkdir.executer();
            }
            case "ls" -> {
                Ls commandeLs = new Ls(racine, courant, liste);
                commandeLs.executer();
            }
            case "cat" -> {
                Cat commandeCat = new Cat(racine, courant, liste);
                commandeCat.executer();
            }
            case "help" -> {
                System.out.println("cat <name>");
                System.out.println("ed <filename>");
                System.out.println("cd [<foldername>]");
                System.out.println("ls [<name>]");
                System.out.println("mv <src> <dst>");
                System.out.println("rm <name>");
                System.out.println("mkdir <foldername>");
            }
            case "quit" -> {
                System.exit(0);
            }
        }
    }
}
