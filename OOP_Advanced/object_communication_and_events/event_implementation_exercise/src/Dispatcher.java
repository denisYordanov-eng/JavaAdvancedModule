import java.util.ArrayList;
import java.util.List;


public class Dispatcher implements Observable {
    private String name;
    private List<NameChangeListener> listeners;

    public Dispatcher() {
        this.listeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addNameChangeListener(NameChangeListener listener) {
        if(this.listeners != null){
            this.listeners.add(listener);
        }
    }

    @Override
    public void removeNameChangeListener(NameChangeListener listener) {
        if(this.listeners != null && !this.listeners.contains(listener)){
            this.listeners.remove(listener);
        }
    }

    @Override
    public void fireNameChangeEvent() {
        NameChange event = new NameChange(this, this.name);
        for(NameChangeListener listener : this.listeners){
            listener.handleChangedName(event);
        }
    }
}
