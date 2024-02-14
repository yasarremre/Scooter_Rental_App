/**
 * Author
 * Emre Yasar 20210808602
 */

import java.util.ArrayList;

public abstract class Observable {
    private final ArrayList<Observer> observerList;

    public Observable() {
        observerList = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public void notifyObservers(boolean available) {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }

    public void notifyObservers(double price, double oldPrice) {
        for (Observer observer : observerList) {
            observer.update(this, price, oldPrice);
        }
    }

}
