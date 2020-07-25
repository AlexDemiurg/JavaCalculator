package alex.calculator;

public class App {
    private Model model;
    private View view;
    private Controller controller;

    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public View getView() {
        return view;
    }
    public void setView(View view) {
        this.view = view;
    }
    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public App() {
        model = new Model(this);
        view = new View(this);
        controller = new Controller(this);
    }
}