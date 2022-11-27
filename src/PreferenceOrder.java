import java.util.*;

public class PreferenceOrder {
    private ArrayList<Station> order;

    public PreferenceOrder() {
        this.order = new ArrayList<Station>();
    }

    public PreferenceOrder(ArrayList<Station> order) {
        this.order = order;
    }

    public void clearOrder() {
        this.order = new ArrayList<Station>();
    }

    public void sendToTop(Station station) {
        this.order.remove(station);
        this.order.add(0, station);
    }

    public void sendToBottom(Station station) {
        this.order.remove(station);
        this.order.add(station);
    }

    public void sendToN(Station station, int n) {
        this.order.remove(station);
        this.order.add(n, station);
    }
}
