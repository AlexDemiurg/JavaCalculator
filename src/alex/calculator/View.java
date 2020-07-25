package alex.calculator;

import alex.calculator.Actions.*;
import alex.calculator.Buttons.InputButton;
import alex.calculator.Buttons.OperationButton;

import javax.swing.*;
import java.awt.*;

public class View {
    private App app;
    private JTextField field;
  /*  public static String[] operations = {
            "C", "M", "R",
            "+", "-", "*",
            "/", "/x", "%",
            "v", "xy", "="
    };*/
    public enum OperationType {
        VOID_OPERATION,
        UNARY_OPERATION,
        BINARY_OPERATION,
        EQUAL_OPERATION
    }
    public enum Operations {
        Clear(OperationType.VOID_OPERATION, "C"),
        Memory(OperationType.VOID_OPERATION,"M"),
        Remember(OperationType.VOID_OPERATION, "R"),
        Add(OperationType.BINARY_OPERATION, "+"),
        Subtract(OperationType.BINARY_OPERATION,"-"),
        Multiply(OperationType.BINARY_OPERATION,"*"),
        Divide(OperationType.BINARY_OPERATION, "/"),
        Reciprocal(OperationType.UNARY_OPERATION, "/x"),
        Percent(OperationType.BINARY_OPERATION, "%"),
        SquareRoot(OperationType.UNARY_OPERATION, "v"),
        Power(OperationType.BINARY_OPERATION, "xy"),
        Equal(OperationType.EQUAL_OPERATION, "=");

        private String caption;
        private OperationType operationType;

/*        public String getCaption() {
            return caption;
        }
        public int getAction() {
            return action;
        }*/

        Operations(OperationType operationType, String caption) {
            // Assign to instance variables here
            this.operationType = operationType;
            this.caption = caption;
        }

        // Provide getter methods here.
    }
    public static String[] inputs = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "0", ".", "+/-"
    };
    // TODO correct this method
    public String format(float value) {
        if (value - Math.floor(value) == 0) {
            return String.valueOf(Math.round(value));
        } else {
            return String.valueOf(value);
        }
    };
    public String getText() {
        return field.getText();
    }
    public void setText(String text) {
        field.setText(text);
    }
    public float getFloat() {
        return Float.valueOf(getText());
    }
    public void setFloat(float value) {
        setText(format(value));
    }
    public View(App app) {
        this.app = app;
        init();
    }
    private void init() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(385, 240);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Container container = frame.getContentPane();

        field = new JTextField();
        field.setText("0");
        field.setBounds(5, 5, 365, 30);
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setFont(new Font("Arial", Font.BOLD, 16));
        field.setForeground(new Color(0,0,255));
        container.add(field);
        for ( int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                String caption = inputs[i + j * 3];
                int x = 5 + i * 60;
                int y = 45 + j * 40;
                InputButton button = new InputButton(app, x, y, caption);
                container.add(button);
            }
        }
        /*
        for ( int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                String caption = operations[i + j * 3];
                int x = 200 + i * 60;
                int y = 45 + j * 40;
                OperationButton button = new OperationButton(
                    app,
                    x, y,
                    new BinaryOperationAction(app, caption)
                );
                //button.setAction(new PlusOperationAction(app));
                container.add(button);
            }
        }*/
        int z = 0;
        for (Operations operation : Operations.values()) {
            int i = z%3;
            int j = z/3;
            z++;
            //String caption = operations[i + j * 3];
            int x = 200 + i * 60;
            int y = 45 + j * 40;
            OperationType operationType = operation.operationType;
            String caption = operation.caption;
            OperationButton button = null;
            if (operationType == OperationType.VOID_OPERATION) {
                button = new OperationButton(
                        app,
                        x, y,
                        new VoidOperationAction(app, caption)
                );
            }
            if (operationType == OperationType.UNARY_OPERATION) {
                button = new OperationButton(
                        app,
                        x, y,
                        new UnaryOperationAction(app, caption)
                );
            }
            if (operationType == OperationType.BINARY_OPERATION) {
                button = new OperationButton(
                        app,
                        x, y,
                        new BinaryOperationAction(app, caption)
                );
            }
            if (operationType == OperationType.EQUAL_OPERATION) {
                button = new OperationButton(
                        app,
                        x, y,
                        new EqualOperationAction(app, caption)
                );
            }
            container.add(button);
        }
        frame.setVisible(true);
    }
}

