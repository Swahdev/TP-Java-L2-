public class Exercice3 {
    public static String Shift(String[] t) {
        String mot = "";
        char[] voyelles = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (int i = 0; i < t.length; i++) {
            mot += ' ';
            for (int j = 0; j < t[i].length(); j++) {
                if (t[i].charAt(j) == 'y')
                    mot += 'a';
                else if (t[i].charAt(j) == 'a')
                    mot += 'e';
                else if (t[i].charAt(j) == 'e')
                    mot += 'i';
                else if (t[i].charAt(j) == 'i')
                    mot += 'o';
                else if (t[i].charAt(j) == 'o')
                    mot += 'u';
                else if (t[i].charAt(j) == 'u')
                    mot += 'y';
                else
                    mot += t[i].charAt(j);

            }
        }
        return mot;
    }

    public static void main(String[] args) {
        System.out.println(Shift(args));
    }

}
