/**
 * Author
 * Emre Yasar 20210808602
 */


public interface Observer {
     void update(Observable o);
     void update(Observable o, double price, double OldPrice);
}
