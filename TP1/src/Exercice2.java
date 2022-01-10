public class Exercice2 {
    public static void affiche(int t[]) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(" " + t[i]);

        }
    }

    public static int[] multiplication(int t1[], int t2[]) {
        //le boolean sert a savoir lequel est le plus petit
        boolean tabap;
        int taille;
        int x = t1.length;
        int y = t2.length;
        //nous cherchons quel tableau est le plus grand et lequel est le plus petit
        if (x >= y) {
            taille = x;
            tabap = false;
        } else {
            taille = y;
            tabap = true;
        }
        int[] tab = new int[taille];
        if (tabap) {
            for (int j = 0; j < taille; j++) {
                if (j > x - 1) {
                    tab[j] = t2[j];
                } else
                    tab[j] = t1[j] * t2[j];
            }
        } else {
            for (int h = 0; h < taille; h++) {
                if (h > y - 1)
                    tab[h] = t1[h];
                else
                    tab[h] = t1[h] * t2[h];
            }
        }
        return tab;
    }
    //3)Returns the string representation of the boolean argument.
    //
    //Parameters:
    //b - a boolean.
    //Returns:
    //if the argument is true, a string equal to "true" is returned; otherwise, a string equal to "false" is returned.
    //Returns the int value that the specified Unicode character represents. For example, the character '\u216C' (the roman numeral fifty) will return an int with a value of 50.
    //
    //The letters A-Z in their uppercase ('\u0041' through '\u005A'), lowercase ('\u0061' through '\u007A'), and full width variant ('\uFF21' through '\uFF3A' and '\uFF41' through '\uFF5A') forms have numeric values from 10 through 35. This is independent of the Unicode specification, which does not assign numeric values to these char values.
    //
    //If the character does not have a numeric value, then -1 is returned. If the character has a numeric value that cannot be represented as a nonnegative integer (for example, a fractional value), then -2 is returned.
    //
    //Note: This method cannot handle supplementary characters. To support all Unicode characters, including supplementary characters, use the getNumericValue(int) method.

    public static int[] split(int t[]) {
        String mot = "";
        for (int i : t) {
            mot = mot + String.valueOf(i);
        }
        int[] tab = new int[mot.length()];
        for (int j = 0; j < mot.length(); j++) {
            tab[j] = Character.getNumericValue(mot.charAt(j));
        }
        return tab;

    }

    public static void main(String[] args) {

        int[] t = {1, 2, 3, 4};
        int[] t2 = {2, 4, 5, 8};
        int[] tab = multiplication(t, t2);
        affiche(tab);
        System.out.println();
        int[] test = {2, 12, 36, 7};
        affiche(split(test));
    }
}

