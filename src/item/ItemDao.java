package item;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cmn.DTO;
import cmn.Work;
import item.ItemDTO;
import cmn.Category;
import cmn.CategoryTop;
import cmn.CategoryShose;
public class ItemDao implements Work<ItemDTO> {
	
	
	private final String fileName = "item_bt.json";
	private final String fileName3 = "item_out.json";
	private final String fileName4 = "item_hat.json";
	private final String fileName5 = "item_sh.json";
	
	
	private List<ItemDTO> listTop = null;
	private List<ItemDTO> listBottom = null;
	private List<ItemDTO> listOut = null;
	
	private List<ItemDTO> listHat = null;
	private List<ItemDTO> listShose = null;
	
	public ItemDao() { 
		
		
		listTop = new ArrayList<ItemDTO>();
		listBottom = new ArrayList<ItemDTO>();
		listOut = new ArrayList<ItemDTO>();
		listHat = new ArrayList<ItemDTO>();
		listShose = new ArrayList<ItemDTO>();
		
		int count  = doReadFile();
		LOG.debug("data count : "+count);
	}
	
	/*
	 * 상의
	 */
	public List<ItemDTO> getListTop() {
		return listTop;
	}
 
	public void setListTop(List<ItemDTO> listTop) {
		this.listTop = listTop;
	}
 
	
	/*
	 * 하의
	 */

	public List<ItemDTO> getListBottom() {
		return listBottom;
	}
	
	public void setListBottom(List<ItemDTO> listBottom) {
		this.listBottom = listBottom;
	}
 
	public String getFileName() {
		return fileName;
	}
	
	/*
	 * 아우터
	 */
	public List<ItemDTO> getListOut() {
		return listOut;
	}

	public void setListOut(List<ItemDTO> listOut) {
		this.listOut = listOut;
	}


	public String getFileName3() {
		return fileName3;
	}
	
	
	
	/*
	 * 모자
	 */
	
	public List<ItemDTO> getListHat() {
		return listHat;
	}
	public void setListHat(List<ItemDTO> listHat) {
		this.listHat = listHat;
	}

	public String getFileName4() {
		return fileName4;
	}
	/*
	 * 신발
	 */
	public List<ItemDTO> getListShose() {
		return listShose;
	}
	public void setListShose(List<ItemDTO> listShose) {
		this.listShose = listShose;
	}
	public String getFileName5() {
		return fileName5;
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
	//
	@Override
	public int doSave_bt(ItemDTO param) {  
	
		int flag = 0;
	
		if(isNameExists(param) == 1) {
			flag = 2;
			return flag;
		}
	
		flag = this.listBottom.add(param)==true?1:0;
	
		LOG.debug("flag: " +flag);
		return flag
		;
	}

	private int isNameExists(ItemDTO param) {
		int flag = 0;
		
		for(ItemDTO member:this.listBottom) {
			if(member.getName().equals(param.getName())) {
				flag =1;
				break;
			}
		}
		return flag;
	}
	@Override
	public int doUpdate(ItemDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	//--
	@Override
	public int doUpdate_bt(ItemDTO param) { 
		int flag = doDelete_bt(param);
		if(1==flag) {
			flag +=doSave_bt(param);
			
		}
		return flag;
	}
	
    /*
	@Override
	public int doDelete(ItemDTO param) { 
		return 0;
	}
	*/
	//--
	@Override
	public int doDelete_bt(ItemDTO param) { 
		int flag = 0;
		for(ItemDTO item : listBottom) {
			if(item.getName().equals(param.getName())) {
				
				flag =listBottom.remove(item) == true?1:0; 
				break;
			}
		}
		LOG.debug("flag: " +flag);
		return flag;
	}
	   @Override
	    public int doDelete(ItemDTO param, List<ItemDTO> list) {
	        // ex) ItemDTO param       : ItemDTO hat01
	        // ex) List<ItemDTO> list : List<ItemDTO> listBottom 
	        int flag = 0;
	            for (ItemDTO item : list) {
	                if (item.getName().equals(param.getName())) {
	                    flag = list.remove(param) == true ? 1 : 0;
	                    break;
	                }
	            }
	        LOG.debug("flag : " + flag);
	        return flag;

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
	public int doSaveFile_bt() { 
		int count = 0;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(fileName)){
			gson.toJson(listBottom	, writer);
			count = listBottom.size();
			
		} catch (IOException e) {
			
			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}

	

	@Override
	public int doReadFile() { 
		return 0;
	}

	public static void main(String[] args) { 

	}



}
