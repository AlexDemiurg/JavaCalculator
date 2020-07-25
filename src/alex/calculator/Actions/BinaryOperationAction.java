package alex.calculator.Actions;

import alex.calculator.App;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BinaryOperationAction extends OperationAction {
/*    public BinaryOperationAction(String text) {
        super(text);
    }*/
    public BinaryOperationAction(App app, String text) {
        super(app, text);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String) this.getValue(Action.NAME);
        //JOptionPane.showMessageDialog(null, "Message text: " + name);
        getApp().getController().onBinaryOperation(name);
    }
}
