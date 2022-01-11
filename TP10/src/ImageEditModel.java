import javax.imageio.ImageIO;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageEditModel {
    private final BufferedImage image;
    private final UndoManager undoManager = new UndoManager();

    public ImageEditModel(String chemin) throws IOException {
        this.image = ImageIO.read(new File(chemin));
    }

    public BufferedImage getImage() {
        return image;
    }

    public UndoManager getUndoManager() {
        return undoManager;
    }

    public void fillzone(Rectangle z, int[][] pixels) {

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                image.setRGB(z.x + j, z.y + i, pixels[i][j]);
            }
        }


    }

    public void clearzone(Rectangle z) {

        Color color = Color.white;
        int srgb = color.getRGB();
        int[][] pixels = new int[z.height][z.width];
        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++)
                pixels[i][j] = srgb;
        fillzone(z, pixels);

    }

    public void saveCut(Rectangle z) {
        int x = z.x;
        int y = z.y;
        int w = z.width;
        int h = z.height;
        BufferedImage buff = image.getSubimage(x, y, w, h);
        Coupe c = new Coupe(x, y, w, h, buff);
        c.doit();
        CutEdit cutEdit = new CutEdit(c);
        undoManager.addEdit(cutEdit);
    }

    public class Coupe {
        private Rectangle z;
        int[][] pixels;

        public Coupe(int x, int y, int largeur, int hauteur, BufferedImage buff) {

            z = new Rectangle(x, y, largeur, hauteur);
            pixels = new int[hauteur][largeur];
            for (int i = 0; i < hauteur; i++) {
                for (int j = 0; j < largeur; j++) {
                    pixels[i][j] = buff.getRGB(j, i);
                }
            }
        }

        public void doit() {
            clearzone(z);
        }

        public void undo() {
            fillzone(z, pixels);
        }

    }

    public class CutEdit extends AbstractUndoableEdit {
        private Coupe c;

        public CutEdit(Coupe c) {
            this.c = c;
        }

        public void undo() {
            this.c.undo();
        }

        public void redo() {
            this.c.doit();
        }

    }


}
