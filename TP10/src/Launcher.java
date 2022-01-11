import java.awt.*;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        ImageEditModel model = new ImageEditModel("src/Image.png");
        ImageEditView edit = new ImageEditView(model);
        EventQueue.invokeLater(() -> {
            edit.pack();
            edit.setVisible(true);
        });
    }
}
