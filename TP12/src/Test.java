import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        Cadre c1 = new Cadre();
                        c1.setVisible(true);
                    }
                }
        );
    }
}
