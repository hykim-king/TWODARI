package com.pcwk.ehr.member;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.message.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pcwk.ehr.cmn.Box;
import com.pcwk.ehr.cmn.PLog;
public class Main implements PLog{
	ItemDTO member01;
	ItemDTO member02;
	ItemDTO member03;
	
	Box<ItemDTO> box;
	
	itemDAO dao;
	
	public Main() {
		member01 = new ItemDTO("AAA01", "김", "a1234", "AAA01@gmail.com", "010-1111-1111", "2024-04-19", "admin");
		member02 = new ItemDTO("BBB02", "이", "b1234", "BBB02@gmail.com", "010-2222-2222", "2024-04-19", "admin");
		member03 = new ItemDTO("CCC03", "박", "c1234", "CCC03@gmail.com", "010-3333-3333", "2024-04-19", "admin");
		
		box = new Box<ItemDTO>();
		box.add(member01);
		box.add(member02);
		box.add(member03);
		dao = new itemDAO();
		dao.setListBox(box.getListBox());
		dao.doSaveFile();
	
	}
	public void doSave() {
		LOG.debug("doSave()");
		int flag = dao.doSave(new ItemDTO("james01", "최", "d1234", "ddd04@gmail.com", "010-4444-4444", "2024-04-19", "admin"));
		
		if(flag==1) {
			LOG.debug("-----------");
			LOG.debug("단건 등록 성공!");
			LOG.debug("-----------");
		}else {
			LOG.debug("단건 등록 실패! flag:"+flag);
		}
	}
	
	public void doDelete() {
		LOG.debug("doDelete()");
		int flag = dao.doDelete(member03);
		
		if(flag==1) {
			LOG.debug("-----------");
			LOG.debug("단건 삭제 성공!");
			LOG.debug("-----------");
		}else {
			LOG.debug("단건 삭제 실패!");
		}
		
		
		
	}
	
	public void doSelectOne() {
		//LOG.debug("doSelectOne()");
		ItemDTO dto = dao.doSelectOne(member01);
		
		if(null != dto) {
			LOG.debug("-----------");
			LOG.debug("단건 조회 성공!");
			LOG.debug(dto);
			LOG.debug("-----------");
		}else {
			LOG.debug("단건 조회 실패!");
		}
		
	 
		 
	}
	
	public void doUpdate() {
		LOG.debug("doUpdate()");
		
		int flag = dao.doUpdate(new ItemDTO("BBB02", "박", "c1234", "CCC03@gmail.com", "010-3333-3333", "2024-04-19", "admin"));
		if(flag==2) {
			LOG.debug("-----------");
			LOG.debug("단건 수정 성공!");
			LOG.debug("-----------");
		}else {
			LOG.debug("단건 수정 실패! flag:"+flag);
		}
		
	}
	
	public void doRetrieve() {
		LOG.debug("doRetrieve()");
		List<ItemDTO> list = dao.doRetrieve(null);
		
		if(list.size()==3){
			LOG.debug("-----------");
			LOG.debug("목록 조회 성공!");
			LOG.debug("-----------");
		}else {
			LOG.debug("-----------");
			LOG.debug("목록 조회 실패!");
			LOG.debug("-----------");
		}
		
		for(ItemDTO dto : list) {
			LOG.debug(dto);
		}
	
	}
	//출력함수
	public void dispList(List<ItemDTO> list) {
		for(ItemDTO dto : list) {
			LOG.debug(dto);
		}
	}
	
	
	public void doRetrieveName() {
		LOG.debug("doRetrieveName()");
		
		SearchDTO search = new SearchDTO("10", "김");
		List<ItemDTO> list = dao.doRetrieve(search);
		dispList(list);
		
	}
	
	public void doRetrieveEmail() {
		LOG.debug("doRetrieveEmail()");
		
		SearchDTO search = new SearchDTO("20", "BBB02@");
		List<ItemDTO>list = dao.doRetrieve(search);
		dispList(list);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		//m.doSave();
		
		//m.doDelete();
		//m.doSelectOne();
		//객체 to json file로 기록
		
		//목록조회
		//m.doRetrieve();
		//이름으로 조회
		//m.doRetrieveName();
		//이메일로 조회
		m.doRetrieveEmail();
		
		
		//m.doUpdate();
		
		
		m.dao.doSaveFile();
	}
	/**
	 * 객체  to json
	 * @param fileName
	 * @return
	 */
	public int saveToJson(String fileName) {
		int count = 0;
		
		//PrerrtPrintng Json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		try(FileWriter writer = new FileWriter(fileName)){
			
			gson.toJson(box, writer);
			count = box.getListBox().size();
			
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
			count = 0;
			
		}
		
		
		LOG.debug(fileName+"파일생성완료");
		return count;
		
	}
	
	public Box<ItemDTO> jsonToObject(String fileName){
		Box<ItemDTO> list = null;
		
		
		try(FileReader fr=new FileReader(fileName)){
			Gson gson = new Gson();
			
			list = gson.fromJson(fr, Box.class);
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
		}
		
		
		
		return list;
	}
	
	
	//객체 to json
}






 



