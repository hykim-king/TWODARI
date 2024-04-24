package com.pcwk.ehr.member;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pcwk.ehr.cmn.Box;
import com.pcwk.ehr.cmn.DTO;

import com.pcwk.ehr.member.ItemDTO;
import com.pcwk.ehr.cmn.WorkDlv;

public class itemDAO implements WorkDlv<ItemDTO> {
	private final String fileName = "item.json";
	private List<ItemDTO> listBox = null;

	public itemDAO() {
		// 초기화
		listBox = new ArrayList<ItemDTO>();
		int count = doReadFile();
		LOG.debug("member count : " + count);
	} // MemberDao

	public List<ItemDTO> getListBox() {
		return listBox;
	}

	public void setListBox(List<ItemDTO> listBox) {
		this.listBox = listBox;
	}

	public String getFileName() {
		return fileName;
	}

	@Override
	public List<ItemDTO> doRetrieve(DTO search) {
		//검색조건
		//" ":전체
		//10:상품명
		//20:상품가격
		//30:상품사이즈
		SearchDTO searchVO = (SearchDTO) search; 
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		//전체 조회
		if(searchVO == null || searchVO.getSearchWord().equals("")) {
			list = this.listBox;
			return list;
		
		}
		//이름으로 조회 : 김
		if(searchVO.getSearchWord().equals("10")) {
			
			for(ItemDTO member : this.listBox) {	
				String name = member.getName();
				if(name.startsWith(searchVO.getSearchWord())) {
					list.add(member);
				}
			}
		//사이즈로 조회 
		}else if(searchVO.getSearchSize(i)) {
			
			for(ItemDTO member : this.listBox) {
				String email = member.getEmail();
				if(email.startsWith(searchVO.getSearchWord())) {
					list.add(member);
				}
			}
		}
	  	
		return list;
	}

	// memberId 존재 여부
	// 존재(1)/없으면(0)

	public int isMemberIdExists(ItemDTO param) {
		int flag = 0;

		for (ItemDTO member : this.listBox) {
			if (member.getMemberId().equals(param.getMemberId())) {
				flag = 1;
				break;
			}
		}

		return flag;
	}

	/**
	 * flag : 성공(1)/실패(0)/실패(2)
	 */
	@Override
	public int doSave(ItemDTO param) {
		int flag = 0;

		if (isMemberIdExists(param) == 1) {
			flag = 2;
			return flag;
		}

		flag = this.listBox.add(param) == true ? 1 : 0;

		LOG.debug("flag: " + flag);
		return flag;
	}

	/**
	 * delete/insert : 2가 들어오면 수정 성공/ 그외는 실패
	 */
	@Override
	public int doUpdate(ItemDTO param) {
		int flag = doDelete(param);
		if (1 == flag) {
			flag += doSave(param);
		}

		return flag;
	}

	@Override
	public int doDelete(ItemDTO param) {
		int flag = 0;
		for (ItemDTO member : listBox) {
			if (member.getMemberId().equals(param.getMemberId())) {

				flag = listBox.remove(member) == true ? 1 : 0;
				break;
			}
		}
		LOG.debug("flag: " + flag);
		return flag;
	}

	@Override
	public ItemDTO doSelectOne(ItemDTO param) {
		ItemDTO memberDTO = null;
		for (ItemDTO member : listBox) {
			if (member.getMemberId().equals(param.getMemberId())) {
				memberDTO = member;
				break;
			}
		}

		LOG.debug("memberDTO: " + memberDTO);
		return memberDTO;
	}

	@Override
	public int doSaveFile() {
		int count = 0;

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (FileWriter writer = new FileWriter(fileName)) {
			gson.toJson(listBox, writer);
			count = listBox.size();

		} catch (IOException e) {

			LOG.debug(e.getMessage());
			count = 0;
		}
		return count;
	}

	@Override
	public int doReadFile() {
		LOG.debug("doReadFile()");

		try (FileReader fr = new FileReader(fileName)) {
			Gson gson = new Gson();

			Type type = new TypeToken<List<ItemDTO>>() {
			}.getType();

			List<ItemDTO> tmpBox = gson.fromJson(fr, type);
			if (null != tmpBox) {
				listBox = tmpBox;
			}
		} catch (IOException e) {
			LOG.debug(e.getMessage());
		}
		return 0;
	}
}