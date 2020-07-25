package alex.calculator.Actions;

import alex.calculator.App;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BaseAction extends AbstractAction {
    private App app;
    public App getApp() {
        return app;
    }
    public BaseAction(String text) {
        super(text);
    }
    public BaseAction(App app, String text) {
        super(text);
        this.app = app;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
