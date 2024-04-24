package item;

import java.util.ArrayList;
import java.util.List;


import cmn.DTO;
import cmn.Work;
import item.ItemDTO;
import cmn.Category;

public class ItemDao implements Work<ItemDTO> {
	
	
	private final String fileName = "item_bt.json";
	private List<ItemDTO> listBottom = null;
	
	

	public ItemDao() { 
		
		listBottom = new ArrayList<ItemDTO>();
		int count  = doReadFile();
		LOG.debug("data count : "+count);
	}
	
	
	
	public List<ItemDTO> getListBottom() {
		return listBottom;
	}


	public void setListBottom(List<ItemDTO> listBottom) {
		this.listBottom = listBottom;
	}


	public String getFileName() {
		return fileName;
	}


	//자동완성
	@Override
	public List<ItemDTO> doRetrieve(DTO search) { 
		return null;
	}

	@Override
	public int doSave(ItemDTO param) {  
		return 0;
	}

	@Override
	public int doUpdate(ItemDTO param) { 
		return 0;
	}

	@Override
	public int doDelete(ItemDTO param) { 
		return 0;
	}

	@Override
	public ItemDTO doSelectOne(ItemDTO param) { 
		return null;
	}

	@Override
	public int doSaveFile() { 
		return 0;
	}

	@Override
	public int doReadFile() { 
		return 0;
	}

	public static void main(String[] args) { 

	}

}
