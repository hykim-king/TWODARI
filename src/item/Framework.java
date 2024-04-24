package item;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

import cmn.Category;
import cmn.PLog;
 

public class Framework implements PLog{
    private String admin;
    private String cust;
    
    //데이터 추가
    ItemDTO bottom01;
    ItemDTO bottom02;
    ItemDTO bottom03;
    ItemDTO bottom04;
    ItemDTO bottom05;
    
    Category<ItemDTO> item_bt;
    ItemDao dao;
    
    public void Data_list() {
    	bottom01 = new ItemDTO("긴바지", 10000, "90");
    	bottom02 = new ItemDTO("통바지", 20000, "100");
    	bottom03 = new ItemDTO("청바지", 30000, "110");
    	bottom04 = new ItemDTO("반바지", 40000, "120");
    	bottom05 = new ItemDTO("스커트", 50000, "130");
    	 
    	item_bt = new Category<ItemDTO>();
    	item_bt.add(bottom01);
    	item_bt.add(bottom02);
    	item_bt.add(bottom03);
    	item_bt.add(bottom04);
    	item_bt.add(bottom05);
    	
    	dao = new ItemDao();
    	dao.setListBottom(item_bt.getListBottom());
    	dao.doSaveFile();
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
                        MenuName = "상품등록";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                   
                        
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
    public static void main(String[] args) { 
        
    	 
    	
    	
    	Framework framework = new Framework();
    	framework.Data_list();
    	int count = framework.saveToJson("item_bt.json");
    	LOG.debug("저장건수: "+count);
    	
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
	
	
	//객체 to json
}

 

