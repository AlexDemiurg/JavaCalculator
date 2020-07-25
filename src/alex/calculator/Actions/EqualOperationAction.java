package alex.calculator.Actions;

import alex.calculator.App;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EqualOperationAction extends OperationAction {
    public EqualOperationAction(App app, String text) {
        super(app, text);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String) this.getValue(Action.NAME);
        //JOptionPane.showMessageDialog(null, "Message text: " + name);
        getApp().getController().onEqual(name);
    }
}
