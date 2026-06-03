public interface Observable {
    void addNameChangeListener(NameChangeListener listener);

    void removeNameChangeListener(NameChangeListener listener);

    void fireNameChangeEvent();
}
