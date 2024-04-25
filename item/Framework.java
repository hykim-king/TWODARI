package item;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

import cmn.Category;
import cmn.CategoryO;
import cmn.CategoryShose;
import cmn.CategoryTop;
import cmn.Item_Hat;
import cmn.PLog;
 

public class Framework implements PLog{
    private String admin;
    private String cust;
    
    //데이터 추가
    
    ItemDTO Top01;
    ItemDTO Top02;
    ItemDTO Top03;
    ItemDTO Top04;
    ItemDTO Top05;
    
    ItemDTO bottom01;
    ItemDTO bottom02;
    ItemDTO bottom03;
    ItemDTO bottom04;
    ItemDTO bottom05;
    
    ItemDTO out01;
   	ItemDTO out02;
   	ItemDTO out03;
   	ItemDTO out04;
   	ItemDTO out05;
    
    ItemDTO hat01;
    ItemDTO hat02;
    ItemDTO hat03;
    ItemDTO hat04;
    ItemDTO hat05;
    
    ItemDTO shose01;
    ItemDTO shose02;
    ItemDTO shose03;
    ItemDTO shose04;
    ItemDTO shose05;
    
    
    CategoryTop<ItemDTO> item_top;
    Category<ItemDTO> item_bt;
    CategoryO<ItemDTO> item_out;
    Item_Hat<ItemDTO> item_hat;
    CategoryShose<ItemDTO> item_sh;
    
    
    ItemDao dao;
    
    public void Data_list() {
    	
    	
    	Top01 = new ItemDTO("반팔티",10000,"95");
    	Top02 = new ItemDTO("긴팔티",15000,"100");
    	Top03 = new ItemDTO("후드티",20000,"105");
    	Top04 = new ItemDTO("줄무늬티",13000,"100");
    	Top05 = new ItemDTO("맨투맨",24000,"95");
    	
    	bottom01 = new ItemDTO("긴바지", 10000, "90");
    	bottom02 = new ItemDTO("통바지", 20000, "100");
    	bottom03 = new ItemDTO("청바지", 30000, "110");
    	bottom04 = new ItemDTO("반바지", 40000, "120");
    	bottom05 = new ItemDTO("스커트", 50000, "130");
    	
    	out01 = new ItemDTO("가디건", 10000, "s");
		out02 = new ItemDTO("점퍼", 20000,  "s");
		out03 = new ItemDTO("자켓", 30000,  "s");
		out04 = new ItemDTO("코트", 40000,  "s");
		out05 = new ItemDTO("패딩", 50000,  "s");

    	
    	hat01 = new ItemDTO("팀뉴욕모자", 15000, "100");
    	hat02 = new ItemDTO("팀시카고모자", 15000, "110");
        hat03 = new ItemDTO("팀브루클린모자", 15000, "110");
        hat04 = new ItemDTO("팀양키즈모자", 15000, "100");
        hat05 = new ItemDTO("팀엘에이모자", 15000, "120");
        
        shose01 = new ItemDTO("슬리퍼", 10000, "235");
    	shose02 = new ItemDTO("장화", 20000, "235");
    	shose03 = new ItemDTO("런닝화", 30000, "235");
    	shose04 = new ItemDTO("운동화", 40000, "235");
    	shose05 = new ItemDTO("구두", 50000, "235");

    	
    	item_top = new CategoryTop<ItemDTO>();
    	item_top.add(Top01);
    	item_top.add(Top02);
    	item_top.add(Top03);
    	item_top.add(Top04);
    	item_top.add(Top05);
    	
    	item_bt = new Category<ItemDTO>();
    	item_bt.add(bottom01);
    	item_bt.add(bottom02);
    	item_bt.add(bottom03);
    	item_bt.add(bottom04);
    	item_bt.add(bottom05);
    	
    	item_out = new CategoryO<ItemDTO>();
    	item_out.add(out01);
    	item_out.add(out02);
    	item_out.add(out03);
    	item_out.add(out04);
    	item_out.add(out05);
    	
    	item_hat = new Item_Hat<ItemDTO>();
    	item_hat.add(hat01);
    	item_hat.add(hat02);
        item_hat.add(hat03);
        item_hat.add(hat04);
        item_hat.add(hat05);
        
        item_sh = new CategoryShose<ItemDTO>();
    	item_sh.add(shose01);
    	item_sh.add(shose02);
    	item_sh.add(shose03);
    	item_sh.add(shose04);
    	item_sh.add(shose05);
    	
    
    	dao = new ItemDao();
    	dao.setListBottom(item_bt.getListBottom());
    	dao.setListTop(item_top.getListTop());
    	dao.setListOut(item_out.getListOut());
    	dao.setListHat(item_hat.getHat());
    	dao.setListShose(item_sh.getListShose());

    	dao.doSaveFile();
    	dao.doSaveFile_bt();
    }
    
 
 


	public Framework() {
        admin = "admin"; // admin 변수 초기화
        cust = "cust"; // custmer 변수 초기화
    }
    
    boolean mein = true;
    
    public void selectStart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("─────────────────────────────────────────────");
        System.out.println("			◆WELCOME TWODARISHOP◆     ");
        System.out.println("─────────────────────────────────────────────");
        while (mein) {
            System.out.println("◆LOGIN◆");
            System.out.println("─────────────────────────────────────────────");
            System.out.print("ID:(id를 입력하세요) ");
            String login = sc.nextLine();

            if (login.equals(admin)) {
                System.out.println("관리자 모드입니다.");

                while (true) {
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println("(1)상품 등록 (2)상품 수정 (3)상품 삭제 (4)상품 검색 (5)나가기 ");
                    System.out.println("─────────────────────────────────────────────");
                    System.out.print("메뉴를 선택하세요: ");

                    int choice = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    String MenuName = "";

                    if (choice == 1) {

                    
                    
                    
                    
                    
                    } else if (choice == 2) {
                        MenuName = "상품수정";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                        
                    } else if (choice == 3) {
                        MenuName = "상품삭제";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                        
                        
                        
                        
                        
                        
                    } else if (choice == 4) {
                        MenuName = "상품검색";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                        
                    } else if (choice == 5) {
                        System.out.println("나가기를 선택하셨습니다.");
                        break; // 내부 루프를 종료하고 외부 루프로 돌아감
                        
                    } else {
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    }
                }
            } else if (login.equals(cust)) {
                System.out.println("고객 모드입니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                System.out.println("─────────────────────────────────────────────");
            }
        }
    }
    
    
    /*
     * 수정
     */
    public void doUpdate_bt() {
		LOG.debug("doUpdate_bt()");
		int flag = dao.doUpdate_bt( new ItemDTO("긴바지", 11111, "111"));
		if(2 == flag) {
			LOG.debug("─────────────────────────────");
			LOG.debug("[하의]를 수정 했습니다.");
			LOG.debug("─────────────────────────────");
		}else {
			LOG.debug("[하의]를 수정 실패 했습니다.");
		}
	}
    
    /*
     * 삭제
     */
    public void doDelete() {
        LOG.debug("doDelete()");
        dao = new ItemDao();
        //int flag = itemDao.doDelete(bottom01, item_bt.getItem_Bottom());
        int flag = dao.doDelete(bottom01, item_bt.getListBottom());
        if(flag==1) {
        	LOG.debug("─────────────────────────────");
            LOG.debug("[]를 삭제 했습니다.");
    		LOG.debug("─────────────────────────────");
        }else {
            LOG.debug("[]를 삭제 실패 했습니다.");
            LOG.debug("flag : " + flag);
        }
                
    }

    
    public static void main(String[] args) { 
        
    	 
    	
    	
    	Framework framework = new Framework();
    	framework.Data_list();
    	int count = framework.saveToJson("item_bt.json");
    	count += framework.saveToJson_Top("item_top.json");
    	count += framework.saveToJson_Out("item_out.json");
    	count += framework.saveToJson_Hat("item_hat.json");
    	count += framework.saveToJson_Shose("item_sh.json");
    	
    	LOG.debug("저장건수: "+count);
    	
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println(); 
    	//framework.doUpdate_bt();
    	//framework.dao.doSaveFile_bt();
    	//framework.doDelete();
    	//framework.dao.doSaveFile_bt();
    	//framework.dao.doSaveFile();
    	//framework.selectStart();   
        
        
        
        
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
			
			gson.toJson(item_bt, writer);
			count = item_bt.getListBottom().size();
			
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
			count = 0;
			
		}
		
		
		LOG.debug(fileName+"파일생성완료");
		return count;
		
	}
	
	public Category<ItemDTO> jsonToObject(String fileName){
		Category<ItemDTO> list = null;
		
		
		try(FileReader fr=new FileReader(fileName)){
			Gson gson = new Gson();
			
			list = gson.fromJson(fr, Category.class);
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
		}
		
		
		
		return list;
	}
	
	/*
	 * item_top Json
	 */
	public int saveToJson_Top(String fileName3) {
		int count = 0;
		
		//PrerrtPrintng Json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		try(FileWriter writer = new FileWriter(fileName3)){
			
			gson.toJson(item_top, writer);
			count = item_top.getListTop().size();
			
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
			count = 0;
			
		}
		
		
		LOG.debug(fileName3+"파일생성완료");
		return count;
		
	}
	/*
	 * 
	 */
	public int saveToJson_Out(String fileName1) {
		int count = 0;
		
		//PrerrtPrintng Json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		try(FileWriter writer = new FileWriter(fileName1)){
			
			gson.toJson(item_out, writer);
			count = item_out.getListOut().size();
			
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
			count = 0;
			
		}
		
		
		LOG.debug(fileName1+"아우터 파일생성완료");
		return count;
		
	}

	
	/*
	 * Item_Hat json
	 */
	public int saveToJson_Hat(String fileName) {
        //product : Item_Bottom<ItemDTO> item_bt;
        //            Item_Hat<ItemDTO> item_hat;
        int count = 0;
        
        //PrerrtPrintng Json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        
        try(FileWriter writer = new FileWriter(fileName)){
            
            gson.toJson(item_hat, writer);
            count = item_hat.getHat().size();
            
            
        }catch(IOException e) {
            LOG.debug("IOException :"+e.getMessage());
            count = 0;
            
        }
        
        LOG.debug(fileName+"파일생성완료");
        return count;
        
    }
	/*
	 * item_sh json
	 */
	public int saveToJson_Shose(String fileName) {
		int count = 0;
		
		//PrerrtPrintng Json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		try(FileWriter writer = new FileWriter(fileName)){
			
			gson.toJson(item_sh, writer);
			count = item_sh.getListShose().size();
			
			
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
			count = 0;
			
		}
		
		
		LOG.debug(fileName+"파일생성완료");
		return count;
		
	}
	
	/*
	 * CategoryTop<ItemDTO>
	 */
	
	public CategoryTop<ItemDTO> jsonToObject3(String fileName3){
		CategoryTop<ItemDTO> listTop = null;
		
		
		try(FileReader fr=new FileReader(fileName3)){
			Gson gson = new Gson();
			
			listTop = gson.fromJson(fr, CategoryTop.class);
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
		}
		
		
		
		return listTop;
	}
	
	/*
	 * CategoryO<ItemDTO>
	 */

	public CategoryO<ItemDTO> jsonToObject2(String fileName1){
		CategoryO<ItemDTO> listO = null;
		
		
		try(FileReader fr=new FileReader(fileName1)){
			Gson gson = new Gson();
			
			listO = gson.fromJson(fr, CategoryO.class);
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
		}
		
		
		
		return listO;
	}
	

	

	
	
	/*
	 * Item_Hat<ItemDTO>
	 */
	public  Item_Hat<ItemDTO> jsonToObject4(String fileName4){
		Item_Hat<ItemDTO> list = null;
		
		
		try(FileReader fr=new FileReader(fileName4)){
			Gson gson = new Gson();
			
			list = gson.fromJson(fr, Item_Hat.class);
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
		}
		
		
		
		return list;
	}
	
	/*
	 * CategoryShose<ItemDTO>
	 */
	public CategoryShose<ItemDTO> jsonToObject5(String fileName){
		CategoryShose<ItemDTO> list = null;
		
		
		try(FileReader fr=new FileReader(fileName)){
			Gson gson = new Gson();
			
			list = gson.fromJson(fr, CategoryShose.class);
			
		}catch(IOException e) {
			LOG.debug("IOException :"+e.getMessage());
		}
		
		
		
		return list;
	}

	
	
	//객체 to json
}

 

