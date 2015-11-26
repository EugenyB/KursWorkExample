package gui;

import logic.Diagram;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eugeny on 26.11.2015.
 */
public class DiagramPanel extends JPanel{
    private Diagram d;
    public final static int OTSTUP = 10;
    private Color[] colors = {Color.BLUE, Color.MAGENTA, Color.YELLOW};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
//        g.drawOval(OTSTUP,OTSTUP,getWidth()-2*OTSTUP,getHeight()-2*OTSTUP);
        int[] data = d.getData();
        if (data==null) return;
        int[] angles = new int[data.length];
        int s = d.sum();
        for (int i = 0; i < angles.length; i++) {
            angles[i] = 360 * data[i] / s;
        }
        int start = 0;
        for (int i = 0; i < angles.length; i++) {
            g.setColor(colors[i]);
            g.fillArc(OTSTUP,OTSTUP,getWidth()-2*OTSTUP,getHeight()-2*OTSTUP,start, angles[i]);
            start+=angles[i];
        }
    }

    public void setDiagram(Diagram diagram) {
        this.d = diagram;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }
}
