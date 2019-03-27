import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {
    JTextField input ;
    JTextArea calculations;
    JButton bEvaluate;
    //todo
    // JList<String> lista = new JList<String>();
    public Window() {
        setSize(800, 600);
        setTitle("Calc");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bEvaluate = new JButton("Make Math Happen!");
        bEvaluate.setBounds(550, 450, 200, 85);
        input = new JTextField();
        input.setBounds(0, 450, 550, 85);
        calculations = new JTextArea();
        calculations.setEditable(false);
        calculations.setLineWrap(true);
        calculations.setBounds(0, 0, 600, 450);
        //JScrollPane scroll = new JScrollPane (calculations);

        //adding menuBar and stuff
        addMenu();
        //add(scroll);
        //getContentPane().add(scroll);
        add(calculations);
        add(bEvaluate);
        add(input);

        input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                bEvaluate.doClick();
            }
        });
        bEvaluate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                double result = calculate(input.getText());
                calculations.append(input.getText() + "\n");
                calculations.append("\t \t" + result + "\n");
                input.setText("");
            }
        });

        setVisible(true);

    }

    public void addMenu() {
        JMenu menu = new JMenu("options");
        JMenuBar mb = new JMenuBar();
        JMenuItem i1 = new JMenuItem("reset");
        JMenuItem i2 = new JMenuItem("exit");
        menu.add(i1);
        menu.add(i2);
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText("");
                calculations.setText("");
            }
        });
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        mb.add(menu);
        this.setJMenuBar(mb);

    }

    public double calculate(String text) {
        if(!text.matches("[0-9]") || text.length() < 2){
            calculations.append("invalid input\n");
            JOptionPane.showConfirmDialog(
                    this,
                    "Invalid input, are you invalid ???",
                    "An Inane Question",
                    JOptionPane.YES_NO_OPTION);
        }
        double a = 0;
        double b = 0;
        int lenght = text.length();
        if (text.contains("*")) {
            int i = text.indexOf('*');
            a = Double.parseDouble(text.substring(0, i));
            b = Double.parseDouble(text.substring(i + 1, lenght));
            return a * b;
        } else if (text.contains("/")) {
            int i = text.indexOf('/');
            a = Double.parseDouble(text.substring(0, i));
            b = Double.parseDouble(text.substring(i + 1, lenght));
            return a / b;
        } else if (text.contains("-")) {
            int i = text.indexOf('-');
            a = Double.parseDouble(text.substring(0, i));
            b = Double.parseDouble(text.substring(i + 1, lenght));
            return a - b;
        }
        if (text.contains("+")) {
            int i = text.indexOf('+');
            a = Double.parseDouble(text.substring(0, i));
            b = Double.parseDouble(text.substring(i + 1, lenght));
            return a + b;
        } else {
            return a;
        }


    }
}
