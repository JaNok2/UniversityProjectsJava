import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class App extends JFrame {

    private static final String FILE_NAME = "moj_plik.txt";
    private final JTextArea textArea;

    public App() {
        super("Zapis/odczyt pliku");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton btnZapis = new JButton("Zapis do pliku");
        btnZapis.addActionListener(this::zapisDoPliku);

        JButton btnOdczyt = new JButton("Odczyt z pliku");
        btnOdczyt.addActionListener(this::odczytZPliku);

        JPanel panelButtons = new JPanel();
        panelButtons.add(btnZapis); 
        panelButtons.add(btnOdczyt);

        add(scrollPane, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        System.out.println("Plik znajduje się pod ścieżką: " + new File(FILE_NAME).getAbsolutePath());
    }

    private void zapisDoPliku(ActionEvent e) {
        String text = textArea.getText();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bufferedWriter.write(text);
            System.out.println("Zapisano dane do pliku: " + FILE_NAME);
            textArea.setText("Zapisano dane do pliku.");
            
        } catch (IOException ex) {
            ex.printStackTrace();
            textArea.setText("Wystąpił błąd podczas zapisu pliku: " + ex.getMessage());
        }
    }

    private void odczytZPliku(ActionEvent e) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            textArea.setText(content.toString());
            System.out.println("Odczytano dane z pliku: " + FILE_NAME);
            
        } catch (IOException ex) {
            ex.printStackTrace();
            textArea.setText("Wystąpił błąd podczas odczytu pliku: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App frame = new App();
            frame.setVisible(true);
        });
    }
}