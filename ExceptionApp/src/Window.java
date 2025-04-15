import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Walidacja Hasła");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel("Wprowadź hasło:");
        JPasswordField passwordField = new JPasswordField();
        JButton validateButton = new JButton("Sprawdź");

        panel.add(label);
        panel.add(passwordField);
        panel.add(validateButton);
        frame.add(panel, BorderLayout.CENTER);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                try {
                    PasswordCheck.validatePassword(password);
                    JOptionPane.showMessageDialog(frame, "Hasło jest poprawne.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                } catch (MissBigLetter ex) {
                    JOptionPane.showMessageDialog(frame, "Błąd: " + ex.getMessage(), "Brak dużej litery", JOptionPane.ERROR_MESSAGE);
                } catch (MissSmallLetter ex) {
                    JOptionPane.showMessageDialog(frame, "Błąd: " + ex.getMessage(), "Brak małej litery", JOptionPane.ERROR_MESSAGE);
                } catch (MissNum ex) {
                    JOptionPane.showMessageDialog(frame, "Błąd: " + ex.getMessage(), "Brak cyfry", JOptionPane.ERROR_MESSAGE);
                } catch (PasswordException ex) {
                    JOptionPane.showMessageDialog(frame, "Nieoczekiwany błąd: " + ex.getMessage(), "Nieznany błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
