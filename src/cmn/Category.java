package cmn;

import java.util.ArrayList;
import java.util.List;

public class Category<T> {
	private List<T> listBottom = new ArrayList<T>();

	public Category() { 
	}

	public List<T> getListBottom() {
		return listBottom;
	}

	public void setListBottom(List<T> listBottom) {
		this.listBottom = listBottom;
	}
	
	public void add(T item) {
		this.listBottom.add(item);
	}
	
	
	public T get(int index) {
		return this.listBottom.get(index);
	}

	@Override
	public String toString() {
		return "Category [listBottom=" + listBottom + "]";
	}
 
	

}
