package cmn;

import java.util.ArrayList;
import java.util.List;

public class Item_Hat<T> {
    
    private List<T> Hat= new ArrayList<T>();

    public Item_Hat() {
        
    }

    public Item_Hat(List<T> hat) {
        this.Hat = hat;
    }

    public List<T> getHat() {
        return Hat;
    }

    public void setHat(List<T> hat) {
        this.Hat = hat;
    }
    
    public void add(T item) {
        this.Hat.add(item);
    }
    
    public T get(int index) {
        return this.Hat.get(index);
    }

    @Override
    public String toString() {
        return "Item_Hat [Hat=" + Hat + "]";
    }
    
}