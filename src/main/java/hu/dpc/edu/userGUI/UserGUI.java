package hu.dpc.edu.userGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by vrg on 11/10/16.
 */
public class UserGUI {

    private JFrame frame;
    private JTable users;
    private JScrollPane scrollPane;

    public UserGUI() {
    }

    protected void buildGUI() {
        frame = new JFrame("Users");
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        users = new JTable(new DefaultTableModel(new Vector(Arrays.asList("Username","First name", "Last name")), 3));
        scrollPane.setViewportView(users);
    }

    public void show() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (frame == null) {
                    buildGUI();
                }
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new UserGUI().show();
    }

}
