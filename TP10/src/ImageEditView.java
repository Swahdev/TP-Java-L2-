import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ImageEditView extends JFrame {
    private JButton cutButton, undoButton, redoButton;
    private ImagePane imagePane;
    private ImageEditModel model;

    public ImageEditView(ImageEditModel mod) {
        model = mod;
        this.setTitle("Mon éditeur");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        cutButton = new JButton("Cut");
        undoButton = new JButton("Undo");
        redoButton = new JButton("RedoButton");

        cutButton.setEnabled(false);
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);

        cutButton.addActionListener((event) -> {
            model.saveCut(imagePane.selection.getRectangle());
            imagePane.repaint();
            cutButton.setEnabled(false);
            undoButton.setEnabled(true);
            redoButton.setEnabled(true);
        });

        undoButton.addActionListener((event) -> {
            if (model.getUndoManager().canUndo()) {
                model.getUndoManager().undo();
                imagePane.repaint();
                redoButton.setEnabled(true);
            }

        });

        redoButton.addActionListener((event) -> {

            model.getUndoManager().redo();
            imagePane.repaint();
            undoButton.setEnabled(true);

        });

        menuBar.add(cutButton);
        menuBar.add(undoButton);
        menuBar.add(redoButton);


        imagePane = new ImagePane();
        this.setContentPane(imagePane);


    }

    public class ImagePane extends JPanel {
        public class Selection extends MouseAdapter implements MouseMotionListener {
            int x1, x2, y1, y2;

            public Rectangle getRectangle() {
                return new Rectangle(x1, y1, this.x2 - this.x1, this.y2 - this.y1);
            }

            public void mousePressed(MouseEvent event) {
                this.x1 = event.getX();
                this.y1 = event.getY();
                cutButton.setEnabled(false);
                imagePane.repaint();
            }

            public void mouseDragged(MouseEvent event) {
                this.x2 = event.getX();
                this.y2 = event.getY();
                cutButton.setEnabled(true);
                imagePane.repaint();
            }

            public void mouseMoved(MouseEvent event) {
                return;
            }
        }

        Selection selection = new Selection();

        public ImagePane() {
            this.setPreferredSize(new Dimension(model.getImage().getWidth(), model.getImage().getHeight()));
            this.addMouseListener(this.selection);
            addMouseMotionListener(this.selection);

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(model.getImage(), 0, 0, this);
            ((Graphics2D) g).draw(selection.getRectangle());
        }
    }
}
