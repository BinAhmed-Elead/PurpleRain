import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    final int WIDTH = 800;
    final int HEIGHT = 600;

    public Window(){
        this.setSize(WIDTH,HEIGHT);
        Dimension screenSize = getToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setLocation(screenWidth/2 - WIDTH/2,screenHeight/2 - HEIGHT/2);
        this.add(new DrawingPanel(this));
    }
}
