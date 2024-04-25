package cmn;

import java.util.ArrayList;
import java.util.List;

public class CategoryTop<T> {
 
	    private List<T> listTop = new ArrayList<T>();

	    
	    public CategoryTop() { 
		}

		public List<T> getListTop() {
	        return listTop;
	    }

	    public void setListTop(List<T> listTop) {
	        this.listTop = listTop;
	    }

	    public void add(T item) {
	        this.listTop.add(item);
	    }


	    public T get(int index) {
	        return this.listTop.get(index);
	    }

	    @Override
	    public String toString() {
	        return "Category [listTop=" + listTop + "]";
	    }
	 


	}
 