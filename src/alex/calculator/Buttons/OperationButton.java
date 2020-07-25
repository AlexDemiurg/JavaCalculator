package alex.calculator.Buttons;

import alex.calculator.Actions.OperationAction;
import alex.calculator.App;
import alex.calculator.Buttons.BaseButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationButton extends BaseButton {
    public OperationButton (App app, int x, int y, String caption) {
        super(app, x, y, caption);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getApp().getController().onOperation(getText(e));
            }
        });
    }
    public OperationButton (App app, int x, int y, OperationAction action) {
        super(app, x, y, action);
        /*addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getApp().getController().onOperation(getText(e));
            }
        });*/
    }
}