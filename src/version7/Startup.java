package version7;

import javax.swing.*;

/**
 * This is the startup class that you should use with this version (7). It
 * starts a GUI that you can use to change fly and quack behaviors at runtime.
 */
public class Startup {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // start the GUI
            new MainGUI();
        });
    }

}
