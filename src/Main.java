/**
 * Entry point of the application.
 * Launches the GUI using Swing's event dispatch thread.
 */
import ui.MainFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
// updated by 20114