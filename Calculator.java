import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;

    JButton[] numberButtons = new JButton[10];
   JButton addButton, subButton, mulButton, divButton;
JButton decButton, equalButton, delButton, clrButton;

JButton sqrtButton;
JButton squareButton;
JButton powerButton;
JButton sinButton;
JButton cosButton;
JButton tanButton;
JButton logButton;
JButton lnButton;
JButton piButton;
JButton eButton;
JButton factButton;
JButton percentButton;

    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 25);

    double result = 0;
    String expression = "";

    Calculator() {

        setTitle("Modern Calculator");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        display = new JTextField();
        display.setBounds(20, 20, 350, 70);
        display.setFont(new Font("Segoe UI", Font.BOLD, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        display.setBackground(new Color(40, 40, 40));
        display.setForeground(Color.WHITE);
        display.setCaretColor(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        display.setBackground(new Color(45, 45, 45));
        display.setForeground(Color.WHITE);
        display.setCaretColor(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display);

        addButton = new RoundedButton("+",
                new Color(255, 149, 0),
                new Color(255, 170, 40));
        subButton = new RoundedButton("-",
                new Color(255, 149, 0),
                new Color(255, 170, 40));
        mulButton = new RoundedButton("*",
                new Color(255, 149, 0),
                new Color(255, 170, 40));
        divButton = new RoundedButton("/",
                new Color(255, 149, 0),
                new Color(255, 170, 40));
        decButton = new RoundedButton(".", new Color(60, 60, 60), new Color(90, 90, 90));
        equalButton = new RoundedButton("=", new Color(0, 122, 255), new Color(30, 144, 255));
        delButton = new RoundedButton("DE", new Color(220, 53, 69), new Color(255, 80, 80));
        clrButton = new RoundedButton("CE", new Color(220, 53, 69), new Color(255, 80, 80));
        sqrtButton = new RoundedButton("√", new Color(80,80,80), new Color(110,110,110));

squareButton = new RoundedButton("x²", new Color(80,80,80), new Color(110,110,110));

powerButton = new RoundedButton("xʸ", new Color(80,80,80), new Color(110,110,110));

sinButton = new RoundedButton("sin", new Color(80,80,80), new Color(110,110,110));

cosButton = new RoundedButton("cos", new Color(80,80,80), new Color(110,110,110));

tanButton = new RoundedButton("tan", new Color(80,80,80), new Color(110,110,110));

logButton = new RoundedButton("log", new Color(80,80,80), new Color(110,110,110));

lnButton = new RoundedButton("ln", new Color(80,80,80), new Color(110,110,110));

piButton = new RoundedButton("π", new Color(80,80,80), new Color(110,110,110));

eButton = new RoundedButton("e", new Color(80,80,80), new Color(110,110,110));

factButton = new RoundedButton("!", new Color(80,80,80), new Color(110,110,110));

percentButton = new RoundedButton("%", new Color(80,80,80), new Color(110,110,110));
        JButton[] functionButtons = {

addButton, subButton, mulButton, divButton,

decButton,
equalButton,
delButton,
clrButton,

sqrtButton,
squareButton,
powerButton,

sinButton,
cosButton,
tanButton,

logButton,
lnButton,

piButton,
eButton,

factButton,
percentButton

};

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new RoundedButton(
                    String.valueOf(i),
                    new Color(60, 60, 60),
                    new Color(90, 90, 90));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(30, 90, 100, 40);
        clrButton.setBounds(140, 90, 110, 40);
        divButton.setBounds(260, 90, 110, 40);

        add(delButton);
        add(clrButton);
        add(divButton);

        panel = new JPanel();
        panel.setBounds(20, 110, 350, 430);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(30, 30, 30));
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(divButton);
        panel.add(mulButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(subButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(equalButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(new JLabel());
        panel.add(new JLabel());

        add(panel);

// VERY IMPORTANT
setupKeyBindings();
KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
    new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {

            if (e.getID() == KeyEvent.KEY_PRESSED) {

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    delButton.doClick();
                    return true;
                }

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    clrButton.doClick();
                    return true;
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    equalButton.doClick();
                    return true;
                }
            }

            return false;
        }
    }
);

setVisible(true);
requestFocusInWindow();
requestFocus();
        
    }

    private void styleButton(JButton button, Color bg, Color fg) {
        button.setBackground(bg);
        button.setForeground(fg);

        Font myFont = new Font("Segoe UI", Font.BOLD, 24);

        button.setFocusPainted(false);

        button.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50)));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                expression += i;
                display.setText(expression);
            }
        }

        // Decimal
        if (e.getSource() == decButton) {
            expression += ".";
            display.setText(expression);
        }

        // Operators
        if (e.getSource() == addButton) {
            expression += "+";
            display.setText(expression);
        }

        if (e.getSource() == subButton) {
            expression += "-";
            display.setText(expression);
        }

        if (e.getSource() == mulButton) {
            expression += "*";
            display.setText(expression);
        }

        if (e.getSource() == divButton) {
            expression += "/";
            display.setText(expression);
        }

        // Clear
        if (e.getSource() == clrButton) {
            expression = "";
            display.setText("");
        }

        // Delete
        if (e.getSource() == delButton) {
            if (!expression.isEmpty()) {
                expression = expression.substring(0, expression.length() - 1);
                display.setText(expression);
            }
        }

        // Equal
        if (e.getSource() == equalButton) {
            try {
                result = evaluateExpression(expression);

                if (result == (int) result)
                    display.setText(String.valueOf((int) result));
                else
                    display.setText(String.valueOf(result));

                expression = String.valueOf(result);

            } catch (Exception ex) {
                display.setText("Error");
                expression = "";
            }
        }
    }

    private double evaluateExpression(String exp) {

        String[] tokens = exp.split("(?<=[-+*/])|(?=[-+*/])");

        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {

            String op = tokens[i];
            double num = Double.parseDouble(tokens[i + 1]);

            switch (op) {
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "/":
                    result /= num;
                    break;
            }
        }

        return result;
    }

    private void setupKeyBindings() {

        JRootPane root = getRootPane();

        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = root.getActionMap();

        // ---------- Numbers ----------
        // Number keys (top row)
for (int i = 0; i <= 9; i++) {

    final int num = i;

    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_0 + i, 0), "NUM" + i);

    am.put("NUM" + i, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberButtons[num].doClick();
        }
    });
}

// Number pad keys
for (int i = 0; i <= 9; i++) {

    final int num = i;

    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_0 + i, 0), "NUM" + i);
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0 + i, 0), "NUMPAD" + i);

    AbstractAction action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberButtons[num].doClick();
        }
    };

    am.put("NUM" + i, action);
    am.put("NUMPAD" + i, action);
}
/// PLUS
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "PLUS_NUMPAD");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.SHIFT_DOWN_MASK), "PLUS");

AbstractAction plusAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        addButton.doClick();
    }
};

am.put("PLUS", plusAction);
am.put("PLUS_NUMPAD", plusAction);

// MINUS
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "MINUS");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "MINUS_NUMPAD");

AbstractAction minusAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        subButton.doClick();
    }
};

am.put("MINUS", minusAction);
am.put("MINUS_NUMPAD", minusAction);

// MULTIPLY
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "MUL_NUMPAD");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.SHIFT_DOWN_MASK), "MUL");

AbstractAction mulAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        mulButton.doClick();
    }
};

am.put("MUL", mulAction);
am.put("MUL_NUMPAD", mulAction);

// DIVIDE
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "DIV_NUMPAD");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "DIV");

AbstractAction divAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        divButton.doClick();
    }
};
am.put("DIV", divAction);
am.put("DIV_NUMPAD", divAction);

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), "DOT");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), "DOT2");

AbstractAction dotAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        decButton.doClick();
    }
};

am.put("DOT", dotAction);
am.put("DOT2", dotAction);


// -------------------- ENTER --------------------
im.put(
    KeyStroke.getKeyStroke(
        KeyEvent.VK_ENTER,
        0
    ),
    "ENTER"
);

am.put("ENTER", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        equalButton.doClick();
    }
});
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "BACKSPACE");

am.put("BACKSPACE", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (!expression.isEmpty()) {
            expression = expression.substring(0, expression.length() - 1);
            display.setText(expression);
        }

    }
});

        // ---------- ESC ----------
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC");

        am.put("ESC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                expression = "";
                display.setText("");

            }
        });

    }

    public static void main(String[] args) {
        new Calculator();
    }
}