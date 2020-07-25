package alex.calculator.Actions;

import alex.calculator.App;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.awt.event.ActionEvent;

public class PlusOperationAction extends BinaryOperationAction {
    public PlusOperationAction(App app) {
        super(app, "+");
        /* putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);*/
    }
}
