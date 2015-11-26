package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eugeny on 26.11.2015.
 */
public class EditPanel extends JPanel{
    private JTextField field;

    public EditPanel(String text) {
        field = new JTextField(8);
        add(new JLabel(text));
        add(field);
    }

    public int getValue() {
        int value = 0;
        try {
            value = Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            value = 0;
        } finally {
            return value;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100,50);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(150,50);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(75,50);
    }
}
