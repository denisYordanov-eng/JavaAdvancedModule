package contracts;

public interface Kingable extends Observer,Attackable {
    void notifyObservers();

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);
}
