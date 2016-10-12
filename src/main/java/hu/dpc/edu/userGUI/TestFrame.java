package hu.dpc.edu.userGUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

/**
 * Created by vrg on 12/10/16.
 */
public class TestFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame("Hello");
        JButton b1 = new JButton("B1");
        JButton b2 = new JButton("B2");
        JButton b3 = new JButton("B3");
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(b3);
        f.setLayout(new GridLayout(2,2));
        f.pack();
        f.setVisible(true);
    }
}
