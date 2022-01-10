import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Exercice4 {
    public static int question() {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        int compteur = 1;
        int n1 = rd.nextInt(10);
        int n2 = rd.nextInt(10);
        System.out.println("Que fait " + n1 + "*" + n2 + " ?");
        int r = sc.nextInt();
        while (r != ((n1 * n2))) {
            System.out.println("Vous avez faux ! Reéssayez :");
            r = sc.nextInt();
            compteur++;
        }
        return compteur;

    }

    public static int evaluation(int n) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        int bonne_reponse = 0;
        int note;
        for (int i = 0; i < n; i++) {
            int n1 = rd.nextInt(10);
            int n2 = rd.nextInt(10);
            System.out.println("Que fait " + n1 + "*" + n2 + " ?");
            int r = sc.nextInt();
            if (r == n1 * n2) {
                System.out.println("Bonne réponse !");
                bonne_reponse++;
            } else
                System.out.println("Mauvaise réponse !");
        }
        note = (20 * bonne_reponse) / n;
        return note;
    }

    public static void main(String[] args) {
        System.out.println("Vous avez bon ! Bravo ! Vous avez trouvé la bonne réponse en " + question() + " coup(s)");
        System.out.println("Combien de questions voulez vous ?");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int note = evaluation(r);
        System.out.println("Votre note est de " + note + "/20 !");
    }
}
