import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;

public class Window extends JFrame {
    private int counter = 0;
    private int diamonds = 0;
    private boolean gameOver = false; // Flaga dla końca gry
    private Random random = new Random();
    private JLabel label;
    private JTextField textField;

    Window() {
        setLayout(new GridLayout(2, 2, 10, 10));

        //elementy interfejsu
        JButton btn1 = new JButton("Przycisk1");
        JButton btn2 = new JButton("Przycisk2");
        label = new JLabel("Witaj! Jeśli chcesz zagrać, naciśnij dowolny przycisk.");
        textField = new JTextField("Zaczynamy!");

        //dodanie elementow
        add(btn1);
        add(btn2);
        add(label);
        add(textField);

        //jeden wspólny ActionListener
        ActionListener buttonListener = e -> handleButtonClick(e.getSource() == btn1);

        //dodajemy ActionListener 
        btn1.addActionListener(buttonListener);
        btn2.addActionListener(buttonListener);

        //ustawinie rozmiaru okna
        setTitle("GameBombaDiament");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //metoda do obsługi kliknięć przycisków
    private void handleButtonClick(boolean isButton1) { 
        if (gameOver) {
            counter = 0;
            diamonds = 0;
            gameOver = false;
            label.setText("Diamenty: " + diamonds + " | Próby: " + counter);
            textField.setText("Zaczynamy od nowa! Naciśnij przycisk.");
            return;
        }

        //sprawdzamy, czy osiągnięto 20 prób
        if (counter == 20) {
            textField.setText("Zakończyłeś 20 prób! Aby zacząć od nowa, naciśnij przycisk.");
            gameOver = true; // Ustawiamy flagę końca gry
            return;
        }

        int number = random.nextInt(2);

        //sprawdzamy, który przycisk został naciśnięty i aktualizujemy pola tekstowe
        if (isButton1) {
            if (number == 0) {
                textField.setText("Bomba! Uważaj!");
                counter++;
            } else {
                textField.setText("Znaleziono diament!");
                diamonds++;
                counter++;
            }
        } else {
            if (number == 0) {
                textField.setText("Znaleziono diament!");
                diamonds++;
                counter++;
            } else {
                textField.setText("Bomba! Uważaj!");
                counter++;
            }
        }

        label.setText("Diamenty: " + diamonds + " | Próby: " + counter);
    }
}  
