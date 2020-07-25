package alex.calculator.Buttons;

import alex.calculator.App;
import alex.calculator.Buttons.BaseButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputButton extends BaseButton {
    public InputButton(App app, int x, int y, String caption) {
        super(app, x, y, caption);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getApp().getController().onInput(getText(e));
            }
        });
    }
}
