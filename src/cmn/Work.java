package cmn;

import java.util.List;

import item.ItemDTO;

public interface Work<T> extends PLog {
	

	/** 목록 조회
	 * 
	 * @param search
	 * @return
	 */
	public List<T> doRetrieve(DTO search);
	
	/**
	 * 단건 저장
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doSave(T param);
	public int doSave_top(T param);
	public int doSave_bt(T param);
	public int doSave_out(T param);
	public int doSave_hat(T param);
	public int doSave_sh(T param);
	
	/**
	 * 단건 수정
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doUpdate(T param); 
	/**
	 * 단건 수정
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doUpdate_top(T param);
	public int doUpdate_bt(T param);
	public int doUpdate_out(T param);
	public int doUpdate_hat(T param);
	public int doUpdate_sh(T param); 
	/**
	 * 단건 삭제
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	//public int doDelete(T param);
	public int doDelete_top(T param);
	public int doDelete_bt(T param);
	public int doDelete_out(T param);
	public int doDelete_hat(T param);
	public int doDelete_sh(T param);
	
	public int doDelete(T param, List<ItemDTO> list); 
	/**
	 * 단건 조회
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	//public int doSearch(T param);
	public ItemDTO doSelectOne(ItemDTO param);
		/**
	 * 단건 조회
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public ItemDTO doSelectOne_top(ItemDTO param);
	public ItemDTO doSelectOne_bt(ItemDTO param);
	public ItemDTO doSelectOne_out(ItemDTO param);
	public ItemDTO doSelectOne_hat(ItemDTO param);
	public ItemDTO doSelectOne_sh(ItemDTO param);

	/**
	 * 객체를 파일(Json) 저장
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doSaveFile();
	public int doSaveFile_top();
	public int doSaveFile_bt();
	public int doSaveFile_out();
	public int doSaveFile_hat();
	public int doSaveFile_sh();
	
	/**
	 * 파일(json) 객체로 변환
	 * @return 저장건수
	 */
	public int doReadFile();
	public int doReadFile_top();
	public int doReadFile_bt();
	public int doReadFile_out();
	public int doReadFile_hat();
	public int doReadFile_sh();
	
 


 
 

	 
	

}
 
