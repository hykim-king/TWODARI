package cmn;

import java.util.ArrayList;
import java.util.List;

public class CategoryO<T> {
	private List<T> listOut = new ArrayList<T>();

	public CategoryO() { 
	}

	public List<T> getListOut() {
		return listOut;
	}


	public void setListOut(List<T> listOut) {
		this.listOut = listOut;
	}


	public void add(T item) {
		this.listOut.add(item);
	}
	
	
	public T get(int index) {
		return this.listOut.get(index);
	}

	@Override
	public String toString() {
		return "CategoryO [listOut=" + listOut + "]";
	}
 
	

}
