package alex.calculator;

public class Controller {
    private App app;
    private Model model;
    private View view;
    private float accumulator = 0;
    private String lastOpertation = "";
    private boolean clearInput = false;
    public static String[] binaryOperations = {
            "+", "-", "*",
            "/", "%", "xy"
    };
    public static String[] unaryOperations = {
            "v", "/x"
    };

    public Controller(App app) {
        this.app = app;
        this.model = app.getModel();
        this.view = app.getView();
    }

    public static boolean isUnaryOperation(String operation) {
        for (int i = 0; i < unaryOperations.length; i++) {
            if (operation.equals(unaryOperations[i]))
                return true;
        }
        return false;
    };

    public static boolean isBinaryOperation(String operation) {
        for (int i = 0; i < binaryOperations.length; i++) {
            if (operation.equals(binaryOperations[i]))
                return true;
        }
        return false;
    };

    public float binaryOperation(float operand1, float operand2, String operation) {
        float result = 0;

        if (operation.equals("+")) {
            result = operand1 + operand2;
        }
        if (operation.equals("-")) {
            result = operand1 - operand2;
        }
        if (operation.equals("*")) {
            result = operand1 * operand2;
        }
        if (operation.equals("/")) {
            result = operand1 / operand2;
        }
        if (operation.equals("%")) {
            result = (operand1 / operand2)* 100;
        }
        if (operation.equals("xy")) {
            // TODO: Possible conversation error !
            result = (float)Math.pow(operand1, operand2);
        }
        return result;
    };
    public void onVoidOperation(String operation) {
        if (operation.equals("C")) {
            view.setText("0");
            lastOpertation = "";
            accumulator = 0;
            clearInput = true;
        }
    }
    public void onBinaryOperation(String operation) {
        accumulator = view.getFloat();
        lastOpertation = operation;
        clearInput = true;
    }
    public void onUnaryOperation(String operation) {
        float operand = view.getFloat();
        if (operation.equals("/x")) {
            operand = 1 / operand;
        }
        if (operation.equals("v")) {
            operand = (float)Math.sqrt(operand);
        }
        view.setFloat(operand);
        lastOpertation = operation;
        clearInput = true;
    }
    public void onEqual(String operation) {
        if (isBinaryOperation(lastOpertation)) {
            accumulator = binaryOperation(accumulator, view.getFloat(), lastOpertation);
            view.setFloat(accumulator);
        }
        lastOpertation = operation;
        clearInput = true;
    }
    public void onOperation(String operation) {
        if (isUnaryOperation(operation)) {
            float operand = view.getFloat();
            if (operation.equals("/x")) {
                operand = 1 / operand;
            }
            if (operation.equals("v")) {
                operand = (float)Math.sqrt(operand);
            }
            view.setFloat(operand);
            lastOpertation = operation;
            clearInput = true;
            return;
        }
        if (isBinaryOperation(operation)) {
            accumulator = view.getFloat();
            lastOpertation = operation;
            clearInput = true;
            return;
        }
        if (operation.equals("=")) {
            if (isBinaryOperation(lastOpertation)) {
                accumulator = binaryOperation(accumulator, view.getFloat(), lastOpertation);
                view.setFloat(accumulator);
            }
            lastOpertation = operation;
            clearInput = true;
        }
        if (operation.equals("C")) {
            view.setText("0");
            lastOpertation = "";
            accumulator = 0;
            clearInput = true;
        }
    }
    public void onInput(String value) {
        String text = view.getText();
        if (clearInput == true) {
            view.setText(value);
            clearInput = false;
            return;
        }
        if (value.equals(".") && text.contains(".")) {
            return;
        }
        if (value.equals("+/-")) {
            return;
        }
        if (text.equals("0")) {
            text = value;
        } else {
            text = text + value;
        }
        view.setText(text);
    }
}

