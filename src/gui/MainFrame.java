package gui;

import logic.Diagram;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eugeny on 26.11.2015.
 */
public class MainFrame extends JFrame {
    private Diagram d;
    private DiagramPanel dp;
    private EditPanel[] panels = new EditPanel[3];
    private String[] txt = {"a","b","c"};

    public MainFrame() throws HeadlessException {
        setTitle("Курсовая");
        dp = new DiagramPanel();
        d = new Diagram();
        dp.setDiagram(d);
        getContentPane().add(dp);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,1,10,10));
        for (int i=0; i<panels.length; i++) {
            panels[i] = new EditPanel(txt[i]);
            panel1.add(panels[i]);
        }
        JButton btn = new JButton("Draw");
        panel1.add(btn);
        btn.addActionListener(e->{
            int[] arr = new int[panels.length];
            for(int i=0; i<arr.length; i++) {
                arr[i] = panels[i].getValue();
                d.setData(arr);
            }
            repaint();
        });

        getContentPane().add(panel1,BorderLayout.EAST);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
