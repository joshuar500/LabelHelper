package console;

import java.util.ArrayList;

public class StoreLabel {
    private String store;
    private ArrayList<String> fans;
    private ArrayList<String> quantity;
    private ArrayList<String> po;

    public StoreLabel(String s, ArrayList<String> f, ArrayList<String> q, ArrayList<String> p) {
        super();
        this.store = s;
        this.fans = f;
        this.quantity = q;
        this.po = p;
    }

    public String getStore() {
        return store;
    }

    public ArrayList<String> getFans() {
        return fans;
    }

    public ArrayList<String> getQuantity() {
        return quantity;
    }

    public ArrayList<String> getPO() {
        return po;
    }
}