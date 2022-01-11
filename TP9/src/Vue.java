import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Vue extends JFrame {
    JComponent affichage;
    JPanel panneauColore;
    JLabel etiqCouleur;
    JPanel panneauChoix;
    JPanel down;
    JPanel up;
    JButton button = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JLabel rouge = new JLabel("Rouge");
    JLabel vert = new JLabel("Vert");
    JLabel bleu = new JLabel("Bleu");
    JSlider slider = new JSlider(0, 100, 0);
    JSlider slider2 = new JSlider(0, 100, 0);
    JSlider slider3 = new JSlider(0, 100, 0);
    Modele modele;
    Controleur control;

    public Vue(Modele modele) {
        this.setTitle("Palette");
        this.setSize(800, 600);
        this.panneauColore = new JPanel();
        this.etiqCouleur = new JLabel();
        this.panneauChoix = new JPanel();
        this.down = new JPanel();
        this.up = new JPanel();
        this.modele = modele;

        this.etiqCouleur.setText("Vert");
        panneauColore.setBackground(Color.GREEN);
        panneauColore.setLayout(new BorderLayout());
        panneauColore.add(etiqCouleur);
        this.etiqCouleur.setHorizontalAlignment(0);

        this.getContentPane().setLayout(new GridLayout());


        button.setText("Mémoriser");
        button2.setText("S'en rappeler");
        button3.setText("Complémentaire");
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.addChangeListener((event) -> control.sliderMoved());

        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setPaintTrack(true);
        slider2.setMajorTickSpacing(25);
        slider2.setMinorTickSpacing(5);
        slider2.addChangeListener((event) -> control.sliderMoved());

        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setPaintTrack(true);
        slider3.setMajorTickSpacing(25);
        slider3.setMinorTickSpacing(5);
        slider3.addChangeListener((event) -> control.sliderMoved());

        rouge.setHorizontalAlignment(SwingConstants.CENTER);
        vert.setHorizontalAlignment(SwingConstants.CENTER);
        bleu.setHorizontalAlignment(SwingConstants.CENTER);

        button.addActionListener((event) -> control.memoriser());
        button2.addActionListener((event) -> control.rappel());
        button3.addActionListener((event) -> control.complementaire());

        panneauChoix.setLayout(new BorderLayout());
        down.setLayout(new GridLayout(1, 3));
        this.panneauChoix.add(down, BorderLayout.SOUTH);
        this.down.add(button);
        this.down.add(button2);
        this.down.add(button3);

        up.setLayout(new GridLayout(8, 1));
        this.panneauChoix.add(up, BorderLayout.CENTER);
        this.up.add(rouge, BorderLayout.CENTER);
        this.up.add(slider);
        this.up.add(vert, BorderLayout.CENTER);
        this.up.add(slider2);
        this.up.add(bleu, BorderLayout.CENTER);
        this.up.add(slider3);


        this.getContentPane().add(panneauChoix);
        this.getContentPane().add(panneauColore);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JSlider getSlider() {
        return slider;
    }

    public JSlider getSlider2() {
        return slider2;
    }

    public JSlider getSlider3() {
        return slider3;
    }

    public void miseAjour() {
        Color c = new Color(modele.getRouge(), modele.getVert(), modele.getBleu());
        this.panneauColore.setBackground(c);
        etiqCouleur.setText("#" + Integer.toHexString(modele.getRouge()) + Integer.toHexString(modele.getVert()) + Integer.toHexString(modele.getBleu()));
    }

    public void setVert(JLabel vert) {
        this.vert = vert;
    }

    public void setRouge(JLabel rouge) {
        this.rouge = rouge;
    }

    public void setBleu(JLabel bleu) {
        this.bleu = bleu;
    }

    @Override
    public Container getContentPane() {
        return super.getContentPane();
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }
}
