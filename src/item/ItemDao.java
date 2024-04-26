package item;

import java.io.FileReader;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken; 

import cmn.DTO;
import cmn.Work;
import item.ItemDTO; 
public class ItemDao implements Work<ItemDTO> {
	 
	private final String fileName1 = "item_top.json";
	private final String fileName2 = "item_bt.json";
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
		
		//int count = doReadFile();  
		
		int countTop = doReadFile_top();
		LOG.debug("data countTop : "+countTop);
		
		int countBt = doReadFile_bt();
	    LOG.debug("data countBt  : " + countBt);
	    
	    
	    int countOut = doReadFile_out();
	    LOG.debug("data countOut  : " + countOut);
	    
	    int countHat = doReadFile_hat();
	    LOG.debug("data countHat  : " + countHat);
	    
	    int countSh = doReadFile_sh();
	    LOG.debug("data countSh  : " + countSh);
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

	public String getFileName1() {
		return fileName1;
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
 
	public String getFileName2() {
		return fileName2;
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
	private int isNameExists1(ItemDTO param) {
		int flag = 0;
		
		for(ItemDTO item :this.listTop) {
			if(item.getName().equals(param.getName())) {
				flag =1;
				break;
			}
		}
		return flag;
	}
	
	private int isNameExists2(ItemDTO param) {
		int flag = 0;
		
		for(ItemDTO item:this.listBottom) {
			if(item.getName().equals(param.getName())) {
				flag =1;
				break;
			}
		}
		return flag;
	}
	private int isNameExists3(ItemDTO param) {
		int flag = 0;
		
		for(ItemDTO item:this.listOut) {
			if(item.getName().equals(param.getName())) {
				flag =1;
				break;
			}
		}
		return flag;
	}
	private int isNameExists4(ItemDTO param) {
		int flag = 0;
		
		for(ItemDTO item:this.listHat) {
			if(item.getName().equals(param.getName())) {
				flag =1;
				break;
			}
		}
		return flag;
	}
	private int isNameExists5(ItemDTO param) {
		int flag = 0;
		
		for(ItemDTO item:this.listShose) {
			if(item.getName().equals(param.getName())) {
				flag =1;
				break;
			}
		}
		return flag;
	}
	
	/*doSave*/
	@Override
	public int doSave(ItemDTO param) {  
		return 0;
	}
	@Override
	public int doSave_top(ItemDTO param) {  
	
		int flag = 0;
	
		if(isNameExists1(param) == 1) {
			flag = 2;
			return flag;
		}
	
		flag = this.listTop.add(param)==true?1:0;
	
	//	LOG.debug("flag: " +flag);
		return flag
		;
	}
	@Override
	public int doSave_bt(ItemDTO param) {  
	
		int flag = 0;
	
		if(isNameExists2(param) == 1) {
			flag = 2;
			return flag;
		}
	
		flag = this.listBottom.add(param)==true?1:0;
	
	//	LOG.debug("flag: " +flag);
		return flag
		;
	}
	@Override
	public int doSave_out(ItemDTO param) {  
	
		int flag = 0;
	
		if(isNameExists3(param) == 1) {
			flag = 2;
			return flag;
		}
	
		flag = this.listOut.add(param)==true?1:0;
	
	//	LOG.debug("flag: " +flag);
		return flag
		;
	}
	@Override
	public int doSave_hat(ItemDTO param) {  
	
		int flag = 0;
	
		if(isNameExists4(param) == 1) {
			flag = 2;
			return flag;
		}
	
		flag = this.listHat.add(param)==true?1:0;
	
	//	LOG.debug("flag: " +flag);
		return flag
		;
	}
	@Override
	public int doSave_sh(ItemDTO param) {  
	
		int flag = 0;
	
		if(isNameExists5(param) == 1) {
			flag = 2;
			return flag;
		}
	
		flag = this.listShose.add(param)==true?1:0;
	
	//	LOG.debug("flag: " +flag);
		return flag
		;
	}
	
	/*doUpdate*/
	@Override
	public int doUpdate_top(ItemDTO param) {
		int flag = doDelete_top(param);
		if(1==flag) {
			flag +=doSave_top(param);
			
		}
		return flag;
	}
	 
	@Override
	public int doUpdate_bt(ItemDTO param) { 
		int flag = doDelete_bt(param);
		if(1==flag) {
			flag +=doSave_bt(param);
			
		}
		return flag;
	}
	@Override
	public int doUpdate_out(ItemDTO param) { 
		int flag = doDelete_out(param);
		if(1==flag) {
			flag +=doSave_out(param);
			
		}
		return flag;
	}
	@Override
	public int doUpdate_hat(ItemDTO param) { 
		int flag = doDelete_hat(param);
		if(1==flag) {
			flag +=doSave_hat(param);
			
		}
		return flag;
	}
	@Override
	public int doUpdate_sh(ItemDTO param) { 
		int flag = doDelete_sh(param);
		if(1==flag) {
			flag +=doSave_sh(param);
			
		}
		return flag;
	}
	 
    /*
	@Override
	public int doDelete(ItemDTO param) { 
		return 0;
	}
	*/
	
	/*doDelete*/
	@Override
	public int doDelete_top(ItemDTO param) { 
		int flag = 0;
		for(ItemDTO item : listTop) {
			if(item.getName().equals(param.getName())) {
				
				flag =listTop.remove(item) == true?1:0; 
				break;
			}
		}
		//LOG.debug("flag: " +flag);
		return flag;
	}
	@Override
	public int doDelete_bt(ItemDTO param) { 
		int flag = 0;
		for(ItemDTO item : listBottom) {
			if(item.getName().equals(param.getName())) {
				
				flag =listBottom.remove(item) == true?1:0; 
				break;
			}
		}
		//LOG.debug("flag: " +flag);
		return flag;
	}
	@Override
	public int doDelete_out(ItemDTO param) { 
		int flag = 0;
		for(ItemDTO item : listOut) {
			if(item.getName().equals(param.getName())) {
				
				flag =listOut.remove(item) == true?1:0; 
				break;
			}
		}
		//LOG.debug("flag: " +flag);
		return flag;
	}
	@Override
	public int doDelete_hat(ItemDTO param) { 
		int flag = 0;
		for(ItemDTO item : listHat) {
			if(item.getName().equals(param.getName())) {
				
				flag =listHat.remove(item) == true?1:0; 
				break;
			}
		}
		//LOG.debug("flag: " +flag);
		return flag;
	}
	@Override
	public int doDelete_sh(ItemDTO param) { 
		int flag = 0;
		for(ItemDTO item : listShose) {
			if(item.getName().equals(param.getName())) {
				
				flag =listShose.remove(item) == true?1:0; 
				break;
			}
		}
		//LOG.debug("flag: " +flag);
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
	public int doSaveFile() { 
		return 0;
	}
	
	/*doSaveFile*/
	@Override
	public int doSaveFile_top() { 
		
		int count = 0;
		LOG.debug("data count : "+count);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(fileName1)){
			gson.toJson(listTop	, writer);
			count = listTop.size();
			
		} catch (IOException e) {
			
			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}
	
	@Override
	public int doSaveFile_bt() { 
		
		int count = 0;
		LOG.debug("data count : "+count);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(fileName2)){
			gson.toJson(listBottom	, writer);
			count = listBottom.size();
			
		} catch (IOException e) {
			
			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}
	
	@Override
	public int doSaveFile_out() { 
		int count = 0;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(fileName3)){
			gson.toJson(listOut	, writer);
			count = listOut.size();
			
		} catch (IOException e) {
			
			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}
	@Override
	public int doSaveFile_hat() { 
		int count = 0;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(fileName4)){
			gson.toJson(listHat	, writer);
			count = listHat.size();
			
		} catch (IOException e) {
			
			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}
	@Override
	public int doSaveFile_sh() { 
		int count = 0;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(fileName5)){
			gson.toJson(listShose	, writer);
			count = listShose.size();
			
		} catch (IOException e) {
			
			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}

	
	/*doReadFile*/
	@Override
	public int doReadFile() { 
			LOG.debug("doReadFile()");
		
			try(FileReader fr = new FileReader(fileName1)){
			Gson gson = new Gson();
			
			Type type = new TypeToken<List<ItemDTO>>() {}.getType();
			
			List<ItemDTO> tmpBt = gson.fromJson(fr, type);
			if(null!=tmpBt) {
				listTop = tmpBt;
				listBottom = tmpBt;
			}
		}catch(IOException e) {
			LOG.debug(e.getMessage());
		}
		return 0;
	}
	@Override
	public int doReadFile_top() {
		try(FileReader fr = new FileReader(fileName1)){
			Gson gson = new Gson();
			
			Type type = new TypeToken<List<ItemDTO>>() {}.getType();
			
			List<ItemDTO> tmpTop = gson.fromJson(fr, type);
			if(null!=tmpTop) {
				listTop = tmpTop;
			}
		}catch(IOException e) {
			LOG.debug(e.getMessage());
		}
		return 0;
	    }

	@Override
	public int doReadFile_bt() {
		//LOG.debug("doReadFile()");
		
		try(FileReader fr = new FileReader(fileName2)){
		Gson gson = new Gson();
		
		Type type = new TypeToken<List<ItemDTO>>() {}.getType();
		
		List<ItemDTO> tmpBt = gson.fromJson(fr, type);
		if(null!=tmpBt) {
			listBottom = tmpBt;
		 
		}
	}catch(IOException e) {
		LOG.debug(e.getMessage());
	}
	return 0;
    }

	@Override
	public int doReadFile_out() {
		try(FileReader fr = new FileReader(fileName3)){
			Gson gson = new Gson();
			
			Type type = new TypeToken<List<ItemDTO>>() {}.getType();
			
			List<ItemDTO> tmpBt = gson.fromJson(fr, type);
			if(null!=tmpBt) {
				listOut = tmpBt;
			}
		}catch(IOException e) {
			LOG.debug(e.getMessage());
		}
		return 0;
	    }

	@Override
	public int doReadFile_hat() {
		try(FileReader fr = new FileReader(fileName4)){
			Gson gson = new Gson();
			
			Type type = new TypeToken<List<ItemDTO>>() {}.getType();
			
			List<ItemDTO> tmpBt = gson.fromJson(fr, type);
			if(null!=tmpBt) {
				listHat = tmpBt;
			}
		}catch(IOException e) {
			LOG.debug(e.getMessage());
		}
		return 0;
	    }

	@Override
	public int doReadFile_sh() {
		try(FileReader fr = new FileReader(fileName5)){
			Gson gson = new Gson();
			
			Type type = new TypeToken<List<ItemDTO>>() {}.getType();
			
			List<ItemDTO> tmpBt = gson.fromJson(fr, type);
			if(null!=tmpBt) {
				listShose = tmpBt;
			}
		}catch(IOException e) {
			LOG.debug(e.getMessage());
		}
		return 0;
	    }
	public static void main(String[] args) { 

	}
	
	
	/*doSelectOne*/
	@Override
	public ItemDTO doSelectOne(ItemDTO param) { 
		return null;
	}
	
	@Override
	public ItemDTO doSelectOne_top(ItemDTO param) { 
		
		ItemDTO itemDTO = null;
		for(ItemDTO item : listTop) {
			//OG.debug("doSelectOne_top: "+item);
			//LOG.debug("item: "+item);
			if(item.getName().equals(param.getName())) {
				itemDTO = item;
				break;
			}
		}
		//LOG.debug("itemDTO: "+itemDTO);
		return itemDTO;
	}

	@Override
	public ItemDTO doSelectOne_bt(ItemDTO param) { 

		ItemDTO itemDTO = null;
		//LOG.debug("listBottom: "+listBottom);
		for(ItemDTO item : listBottom) {
			//LOG.debug("item: "+item);
			if(item.getName().equals(param.getName())) {
				itemDTO = item;
				break;
			}
		}
		//LOG.debug("itemDTO: "+itemDTO);
		return itemDTO;
	}
	@Override
	public ItemDTO doSelectOne_out(ItemDTO param) { 
		
		ItemDTO itemDTO = null;
		//LOG.debug("listBottom: "+listOut);
		for(ItemDTO item : listOut) {
		//LOG.debug("item: "+item);
			if(item.getName().equals(param.getName())) {
				itemDTO = item;
				break;
			}
		}
		LOG.debug("itemDTO: "+itemDTO);
		return itemDTO;
	}
	@Override
	public ItemDTO doSelectOne_hat(ItemDTO param) { 
		
		ItemDTO itemDTO = null;
		//LOG.debug("listBottom: "+listBottom);
		for(ItemDTO item : listHat) {
			//LOG.debug("item: "+item);
			if(item.getName().equals(param.getName())) {
				itemDTO = item;
				break;
			}
		}
		//LOG.debug("itemDTO: "+itemDTO);
		return itemDTO;
	}
	@Override
	public ItemDTO doSelectOne_sh(ItemDTO param) { 
		
		ItemDTO itemDTO = null;
		//LOG.debug("listBottom: "+listBottom);
		for(ItemDTO item : listShose) {
			//LOG.debug("item: "+item);
			if(item.getName().equals(param.getName())) {
				itemDTO = item;
				break;
			}
		}
		//LOG.debug("itemDTO: "+itemDTO);
		return itemDTO;
	}

	@Override
	public int doUpdate(ItemDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}


 



}
