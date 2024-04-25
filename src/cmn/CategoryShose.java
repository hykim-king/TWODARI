package cmn;

import java.util.ArrayList;
import java.util.List;

public class CategoryShose<T> {
	private List<T> listShose = new ArrayList<T>();
	
	public CategoryShose() { }
	
	public CategoryShose(List<T> listShose) {
		this.listShose = listShose;
	}
	public List<T> getListShose() {
		return listShose;
	}
	public void setListShose(List<T> listShose) {
		this.listShose = listShose;
	}
	
	public void add(T item) {
		this.listShose.add(item);
	}
	
	public T get(int index) {
		return this.listShose.get(index);
	}
	@Override
	public String toString() {
		return "CategoryShose [listShose=" + listShose + "]";
	}
	
}