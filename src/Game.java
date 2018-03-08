import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Created by John Smith on 3/4/2018.
 */
public class Game extends JPanel{


    public static void main(String [] args) throws IOException {
        JOptionPane.showMessageDialog(null,
                "Welcome to Java");

        String st;
        st = JOptionPane.showInputDialog(
        "Enter your name");

        System.out.println(st);
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Do you wanna close the window?",
                "Choose",
                JOptionPane.YES_NO_OPTION);
        System.out.println(selectedOption);
        if (selectedOption == 1) {
            System.out.println("NO");
        }
        JOptionPane.showMessageDialog(null,
                "Welcome to Java");
        System.exit(0);
    }


}

