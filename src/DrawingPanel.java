import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPanel extends JPanel implements ActionListener {

    private final ArrayList<RainDroplet> rainDroplets;
    private final JSlider direction;
    public DrawingPanel(Window master){
        this.setSize(master.getSize());
        this.rainDroplets = new ArrayList<>();
        Timer timer = new Timer(0, this);
        timer.start();
        this.direction = new JSlider();
        this.direction.setMaximum(180);
        this.direction.setMinimum(-180);
        this.direction.setValue(0);
        this.direction.addChangeListener((e)->{
            RainDroplet.setDirection(direction.getValue());
            repaint();
        });
        RainDroplet.setDirection(direction.getValue());
        this.add(direction);
    }

    private void createDroplets() {
        RainDroplet.setDirection(90);
        int numberOfDroplets = 100;
        Color purple = new Color(106, 0, 106);
        Random rand = new Random();
        for(int i = rainDroplets.size() ; i < numberOfDroplets ; i++){
            Dimension dropletSize = new Dimension(6,rand.nextInt(40,80));
            rainDroplets.add(
                    new RainDroplet(purple,dropletSize,new Point(rand.nextInt(0,
                            this.getWidth()-dropletSize.width),rand.nextInt(-dropletSize.height*10,-dropletSize.height)))
            );
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(Math.toRadians(direction.getValue()),getWidth()/2.,getHeight()/2.);
        createDroplets();
        for( RainDroplet droplet : rainDroplets){
            Dimension dropletSize = droplet.getSize();
            Point dropletPos = droplet.getPosition();
            g2.setColor(droplet.getColor());
            g2.fillRect(dropletPos.x,dropletPos.y,dropletSize.width,dropletSize.height);
        }
        killIfOutOfWindow();
//        System.out.println("nOfRainDroplets: "+rainDroplets.size());
    }
    void step(){
        for( RainDroplet droplet : rainDroplets){
            Point pos = droplet.getPosition();
            droplet.setPosition(pos.x,pos.y+droplet.getSpeed());
        }
    }

    void killIfOutOfWindow(){
        ArrayList<RainDroplet> dropletsOutOfView = new ArrayList<>();
        for( RainDroplet droplet : rainDroplets){
            Point pos = droplet.getPosition();
            if(pos.x > getWidth() || pos.y > getHeight())
                    dropletsOutOfView.add(droplet);
        }
        for(RainDroplet droplet : dropletsOutOfView)
            rainDroplets.remove(droplet);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        repaint();
    }
}
