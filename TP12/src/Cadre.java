import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Cadre extends JFrame implements MouseInputListener {

    private JPanel page;
    private Modele modele;
    private int nbCarre=0;
    private JLabel etiquette;
    private boolean etatfin=false;

    public Cadre() {
        this.setTitle("Fenetre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        page = new JPanel(null);
        this.setContentPane(page);
        int y = (int) (Math.random() * 10 + 1);
        modele = new Modele(y);
        for (int i = 0; i < y; i++) {
            Carre c1 = new Carre();
            modele.add(i, c1.getBackground());
            page.add(c1);
        }
        etiquette=new JLabel("Gagné ! Bravo !");
        etiquette.setVisible(false);
        etiquette.setBounds(100,100,600,600);
        etiquette.setFont(new Font("Arial",Font.BOLD,50));
        page.add(etiquette);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (etatfin)
            this.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (etatfin)
            this.dispose();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void finJeu() {
        if (modele.gagne()) {
            //this.dispose();
            etiquette.setVisible(true);
            etatfin=true;
        }
    }

    public class Carre extends JPanel implements MouseInputListener {

        private boolean isMoving = false;
        private int x, y,id;

        public Carre() {
            Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            this.setBackground(color);
            this.setBounds((int) (Math.random() * 550), (int) (Math.random() * 550), 50, 50);
            this.addMouseMotionListener(this);
            this.addMouseListener(this);
            id=nbCarre++;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("click !");
            isMoving = !isMoving;
            if (isMoving) {
                x = e.getX();
                y = e.getY();
            }
            this.setBackground(Color.green);
            modele.add(id,Color.green);
            finJeu();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            this.setBackground(Color.blue);
            modele.add(id,Color.blue);
            finJeu();
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (this.isMoving) {
                this.setLocation(e.getXOnScreen() - Cadre.this.getX() - x, e.getYOnScreen() - Cadre.this.getY() - y - Cadre.this.getInsets().top);
            }
        }
    }

}
