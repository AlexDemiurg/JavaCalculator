package alex.calculator.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;

import alex.calculator.Actions.BaseAction;
import alex.calculator.App;

public class BaseButton extends JButton {
    private App app;
    public App getApp() {
        return app;
    }
    public BaseButton(App app, int x, int y, String caption) {
        super(caption);
        this.app = app;
        this.setBounds(x, y, 50, 30);
        this.addActionListener(null);
    }
    public BaseButton(App app, int x, int y, BaseAction action) {
        super(action);
        this.app = app;
        this.setBounds(x, y, 50, 30);
        //this.addActionListener(null);
    }
    protected String getText(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        return button.getText();
    }
}
