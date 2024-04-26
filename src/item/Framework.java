package item;

import java.io.FileReader;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

import item.ItemController; 
import cmn.PLog;
 

public class Framework implements PLog{
	private String admin;
    private String cust;
    private String exit;

    private List<ItemDTO>  item_top = new ArrayList<>();
    private List<ItemDTO>  item_bt = new ArrayList<>();
    private List<ItemDTO>  item_out = new ArrayList<>();
    private List<ItemDTO>  item_hat = new ArrayList<>();
    private List<ItemDTO>  item_sh = new ArrayList<>();

    private ItemDao dao;
    private ItemController itemController;

    public Framework() {
        admin = "admin"; // Initialize admin variable
        cust = "cust"; // Initialize customer variable
        exit = "exit";

        // Adding top items
        item_top.add(new ItemDTO("반팔티", 10000, "95"));
        item_top.add(new ItemDTO("긴팔티", 15000, "100"));
        item_top.add(new ItemDTO("후드티", 20000, "105"));
        item_top.add(new ItemDTO("줄무늬티", 13000, "100"));
        item_top.add(new ItemDTO("맨투맨", 24000, "95"));

        // Adding bottom items
        item_bt.add(new ItemDTO("긴바지", 10000, "90"));
        item_bt.add(new ItemDTO("통바지", 20000, "100"));
        item_bt.add(new ItemDTO("청바지", 30000, "110"));
        item_bt.add(new ItemDTO("반바지", 40000, "120"));
        item_bt.add(new ItemDTO("스커트", 50000, "130"));

        // Adding outerwear items
        item_out.add(new ItemDTO("가디건", 10000, "s"));
        item_out.add(new ItemDTO("점퍼", 20000, "s"));
        item_out.add(new ItemDTO("자켓", 30000, "s"));
        item_out.add(new ItemDTO("코트", 40000, "s"));
        item_out.add(new ItemDTO("패딩", 50000, "s"));

        // Adding hat items
        item_hat.add(new ItemDTO("팀뉴욕모자", 15000, "100"));
        item_hat.add(new ItemDTO("팀시카고모자", 15000, "110"));
        item_hat.add(new ItemDTO("팀브루클린모자", 15000, "110"));
        item_hat.add(new ItemDTO("팀양키즈모자", 15000, "100"));
        item_hat.add(new ItemDTO("팀엘에이모자", 15000, "120"));

        // Adding shoe items
        item_sh.add(new ItemDTO("슬리퍼", 10000, "235"));
        item_sh.add(new ItemDTO("장화", 20000, "235"));
        item_sh.add(new ItemDTO("런닝화", 30000, "235"));
        item_sh.add(new ItemDTO("운동화", 40000, "235"));
        item_sh.add(new ItemDTO("구두", 50000, "235"));

        // Initialize DAO and set item lists
        dao = new ItemDao();
        dao.setListTop(item_top);
        dao.setListBottom(item_bt);
        dao.setListOut(item_out);
        dao.setListHat(item_hat);
        dao.setListShose(item_sh);

        // Save data to files
        dao.doSaveFile();
        dao.doSaveFile_top();
        dao.doSaveFile_bt();
        dao.doSaveFile_out();
        dao.doSaveFile_hat();
        dao.doSaveFile_sh();

        // Initialize item controller
        itemController = new ItemController();
        selectStart();
         
    }
    
    boolean mein = true;
    
    public void selectStart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("			◆WELCOME TWODARISHOP◆     ");
        System.out.println("────────────────────────────────────────────────────────");
        while (mein) {
            System.out.println("◆LOGIN◆");
            System.out.println("─────────────────────────────────────────────");
            System.out.print("ID:(id를 입력하세요) ");
            String login = sc.nextLine();

            if (login.equals(admin)) {
                System.out.println("관리자 모드입니다.");

                while (true) {
                    System.out.println("──────────────────────────────────────────────────────────");
                    System.out.println("(1)상품 등록 (2)상품 수정 (3)상품 삭제 (4)상품 검색 (5)나가기 ");
                    System.out.println("──────────────────────────────────────────────────────────");
                    System.out.print("메뉴를 선택하세요: ");

                    int choice = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    String MenuName = "";

                    if (choice == 1) {
                        MenuName = "상품등록";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                        System.out.println("카테고리를 선택해주세요.");
                        System.out.println("─────────────────────────────────────────────");
                        System.out.println("(1)상의 (2)하의 (3)아우터 (4)모자 (5)신발 ");
                        System.out.println("─────────────────────────────────────────────");
                        String ctInput = sc.nextLine().trim();
                        switch(ctInput) {
                       
                        case"1":
                        	int flagSave1 = itemController.doSave_top();
            				if(1== flagSave1) {
            					System.out.println("[상의] 상품이 등록 되었습니다." +flagSave1);
            					itemController.doSaveFile_top(); //상의
            				}else {
            					System.out.println("[상의] 상품이 등록되지 않았습니다." +flagSave1);
            				System.exit(0);
            				}
            				
            				break;
            				
                        case"2":
                        	int flagSave2 = itemController.doSave_bt();
            				if(1== flagSave2) {
            					System.out.println("[하의] 상품이 등록 되었습니다." +flagSave2);
            					itemController.doSaveFile_bt();
            				}else {
            					System.out.println("[하의] 상품이 등록되지 않았습니다." +flagSave2);
            				System.exit(0);
            				}
            				
            				break;	
            			
            				
                        case"3":
                        	int flagSave3 = itemController.doSave_out();
            				if(1== flagSave3) {
            					System.out.println("[아우터] 상품이 등록 되었습니다." +flagSave3);
            					itemController.doSaveFile_out(); //아우터
            				}else {
            					System.out.println("[아우터] 상품이 등록되지 않았습니다." +flagSave3);
            				System.exit(0);
            				}
            				
            				break;
            				
            				
            				
                        case"4":
                        	int flagSave4 = itemController.doSave_hat();
            				if(1== flagSave4) {
            					System.out.println("[모자] 상품이 등록 되었습니다." +flagSave4);
            					itemController.doSaveFile_hat();//모자
            				}else {
            					System.out.println("[모자] 상품이 등록되지 않았습니다." +flagSave4);
            				System.exit(0);
            				}
            				
            				break;
            				
            				
            				
            				
                        case"5":
                        	int flagSave5 = itemController.doSave_sh();
            				if(1== flagSave5) {
            					System.out.println("[신발] 상품이 등록 되었습니다." +flagSave5);
            					itemController.doSaveFile_sh();//신발
            				}else {
            					System.out.println("[신발] 상품이 등록되지 않았습니다." +flagSave5);
            				System.exit(0);
            				}
            				
            				break;
                        	
                        }
                        

                    
                    } else if (choice == 2) {
                        MenuName = "상품수정";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                        System.out.println("카테고리를 선택해주세요.");
                        System.out.println("────────────────────────────────────────────────────────");
                        System.out.println("(1)상의 (2)하의 (3)아우터 (4)모자 (5)신발 ");
                        System.out.println("────────────────────────────────────────────────────────");
                        String ctInput = sc.nextLine().trim();
                        switch(ctInput) {
                        
                        case"1":
                        	int flagUp = itemController.doUpdate_top();
            				if(0 != flagUp) {
            					System.out.println("[상의]성공적으로 업데이트되었습니다." +flagUp);
            					itemController.doSaveFile_top();
            				}else {
            					System.out.println("해당[상의]이/가 존재하지 않습니다." +flagUp);
            				System.exit(0);
            				}
            				
            				break;
                        	
            
                        case"2":
                        	int flagUp1 = itemController.doUpdate_bt();
            				if(0 != flagUp1) {
            					System.out.println("[하의]성공적으로 업데이트되었습니다." +flagUp1);
            					itemController.doSaveFile_bt();
            				}else {
            					System.out.println("해당[하의]이/가 존재하지 않습니다." +flagUp1);
            				System.exit(0);
            				}
            				
            				break;
            				
                        case"3":
                        	int flagUp2 = itemController.doUpdate_out();
            				if(0 != flagUp2) {
            					System.out.println("[아우터]성공적으로 업데이트되었습니다." +flagUp2);
            					itemController.doSaveFile_out();
            				}else {
            					System.out.println("해당[아우터]이/가 존재하지 않습니다." +flagUp2);
            				System.exit(0);
            				}
            				
            				break;	
            				
                        case"4":
                        	int flagUp3 = itemController.doUpdate_hat();
            				if(0 != flagUp3) {
            					System.out.println("[모자]성공적으로 업데이트되었습니다." +flagUp3);
            					itemController.doSaveFile_hat();
            				}else {
            					System.out.println("해당[모자]이/가 존재하지 않습니다." +flagUp3);
            				System.exit(0);
            				}
            				
            				break;	
            				
                        case"5":
                        	int flagUp4 = itemController.doUpdate_sh();
            				if(0 != flagUp4) {
            					System.out.println("[신발]성공적으로 업데이트되었습니다." +flagUp4);
            					itemController.doSaveFile_sh();
            				}else {
            					System.out.println("해당[신발]이/가 존재하지 않습니다." +flagUp4);
            				System.exit(0);
            				}
            				
            				break;	
            				 
                        	
                        }
                        
                        
                    } else if (choice == 3) {
                    	   MenuName = "상품삭제";
                           System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                           System.out.println("카테고리를 선택해주세요.");
                           System.out.println("────────────────────────────────────────────────────────");
                           System.out.println("(1)상의 (2)하의 (3)아우터 (4)모자 (5)신발 ");
                           System.out.println("────────────────────────────────────────────────────────");
                           String ctInput = sc.nextLine().trim();
                           switch(ctInput) {
                        
                        case"1":
                        	int flagUp = itemController.doDelete_top();
            				if(0 != flagUp) {
            					System.out.println("[상의]성공적으로 삭제 되었습니다." +flagUp);
            					itemController.doSaveFile_top();
            				}else {
            					System.out.println("해당[상의]이/가 존재하지 않습니다." +flagUp);
            				System.exit(0);
            				}
            				
            				break;
                        	
            
                        case"2":
                        	int flagUp1 = itemController.doDelete_bt();
            				if(0 != flagUp1) {
            					System.out.println("[하의]성공적으로 삭제 되었습니다." +flagUp1);
            					itemController.doSaveFile_bt();
            				}else {
            					System.out.println("해당[하의]이/가 존재하지 않습니다." +flagUp1);
            				System.exit(0);
            				}
            				
            				break;
            				
                        case"3":
                        	int flagUp2 = itemController.doDelete_out();
            				if(0 != flagUp2) {
            					System.out.println("[아우터]성공적으로 삭제 되었습니다." +flagUp2);
            					itemController.doSaveFile_out();
            				}else {
            					System.out.println("해당[아우터]이/가 존재하지 않습니다." +flagUp2);
            				System.exit(0);
            				}
            				
            				break;	
            				
                        case"4":
                        	int flagUp3 = itemController.doDelete_hat();
            				if(0 != flagUp3) {
            					System.out.println("[모자]성공적으로 삭제 되었습니다." +flagUp3);
            					itemController.doSaveFile_hat();
            				}else {
            					System.out.println("해당[모자]이/가 존재하지 않습니다." +flagUp3);
            				System.exit(0);
            				}
            				
            				break;	
            				
                        case"5":
                        	int flagUp4 = itemController.doDelete_sh();
            				if(0 != flagUp4) {
            					System.out.println("[신발]성공적으로 삭제 되었습니다." +flagUp4);
            					itemController.doSaveFile_sh();
            				}else {
            					System.out.println("해당[신발]이/가 존재하지 않습니다." +flagUp4);
            				System.exit(0);
            				}
            				
            				break;	
            				 
                        	
                        }
                        
                        
                        
                        
                        
                        
                    } else if (choice == 4) {
                        MenuName = "상품검색";
                        System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
                        System.out.println("카테고리를 선택해주세요.");
                        System.out.println("────────────────────────────────────────────────────────");
                        System.out.println("(1)상의 (2)하의 (3)아우터 (4)모자 (5)신발 ");
                        System.out.println("────────────────────────────────────────────────────────");
                        String ctInput = sc.nextLine().trim();
                        switch(ctInput) {
                        
                        case"1":
            				ItemDTO item = itemController.doSelectOne_top();
            				if(null != item) {
            					System.out.println("[상의]성공적으로 검색 되었습니다."  +item);
            				}else {
            					System.out.println("해당[상의]이/가 존재하지 않습니다." +item);
            				} 
            				break;
            				
                        case"2":
            				ItemDTO item2 = itemController.doSelectOne_bt();
            				if(null != item2) {
            					System.out.println("[하의]성공적으로 검색 되었습니다."  +item2);
            				}else {
            					System.out.println("해당[하의]이/가 존재하지 않습니다." +item2);
            				} 
            				break;
            				
                        case"3":
            				ItemDTO item3 = itemController.doSelectOne_out();
            				if(null != item3) {
            					System.out.println("[아우터]성공적으로 검색 되었습니다."  +item3);
            				}else {
            					System.out.println("해당[아우터]이/가 존재하지 않습니다." +item3);
            				} 
            				break;
            				
                        case"4":
            				ItemDTO item4 = itemController.doSelectOne_hat();
            				if(null != item4) {
            					System.out.println("[모자]성공적으로 검색 되었습니다." +item4);
            				}else {
            					System.out.println("해당[모자]이/가 존재하지 않습니다." +item4);
            				} 
            				break;
            				
                        case"5":
            				ItemDTO item5 = itemController.doSelectOne_sh();
            				if(null != item5) {
            					System.out.println("[신발]성공적으로 검색 되었습니다." +item5);
            				}else {
            					System.out.println("해당[신발]이/가 존재하지 않습니다." +item5);
            				} 
            				break;
                        	
                        }
                        
                        
                    } else if (choice == 5) {
                        System.out.println("나가기를 선택하셨습니다.");
                        break; // 내부 루프를 종료하고 외부 루프로 돌아감
                        
                    } else {
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    }
                }
            } else if (login.equals(cust)) {
            	System.out.println("고객 모드입니다.");
                Scanner scanner=new Scanner(System.in);
                while (true) {
                    System.out.println("─────────────────────────────────────────────");
                    System.out.println("               (1)상품 검색 (2)나가기            ");
                    System.out.println("─────────────────────────────────────────────");
                    System.out.print("메뉴를 선택하세요> ");
                    
                    int choice = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    String MenuName = "";
                    
	                if (choice == 1) {
	                	MenuName = "상품검색";
	                    System.out.println("[" + MenuName + "]" + choice + "번 선택하셨습니다.");
	                    System.out.println("카테고리를 선택해주세요.");
	                    System.out.println("─────────────────────────────────────────────");
	                    System.out.println("(1)상의 (2)하의 (3)아우터 (4)모자 (5)신발 ");
	                    System.out.println("─────────────────────────────────────────────");
	                    System.out.print("카테고리를 선택해 주세요.> ");
                        String ctInput = sc.nextLine().trim();
                        
                        switch(ctInput) {
                        
                        case"1":
            				ItemDTO item = itemController.doSelectOne_top();
            				if(null != item) {
            					System.out.println("[상의]성공적으로 검색 되었습니다."  +item);
            				}else {
            					System.out.println("해당[상의]이/가 존재하지 않습니다." +item);
            				} 
            				break;
            				
                        case"2":
            				ItemDTO item2 = itemController.doSelectOne_bt();
            				if(null != item2) {
            					System.out.println("[하의]성공적으로 검색 되었습니다."  +item2);
            				}else {
            					System.out.println("해당[하의]이/가 존재하지 않습니다." +item2);
            				} 
            				break;
            				
                        case"3":
            				ItemDTO item3 = itemController.doSelectOne_out();
            				if(null != item3) {
            					System.out.println("[아우터]성공적으로 검색 되었습니다."  +item3);
            				}else {
            					System.out.println("해당[아우터]이/가 존재하지 않습니다." +item3);
            				} 
            				break;
            				
                        case"4":
            				ItemDTO item4 = itemController.doSelectOne_hat();
            				if(null != item4) {
            					System.out.println("[모자]성공적으로 검색 되었습니다." +item4);
            				}else {
            					System.out.println("해당[모자]이/가 존재하지 않습니다." +item4);
            				} 
            				break;
            				
                        case"5":
            				ItemDTO item5 = itemController.doSelectOne_sh();
            				if(null != item5) {
            					System.out.println("[신발]성공적으로 검색 되었습니다." +item5);
            				}else {
            					System.out.println("해당[신발]이/가 존재하지 않습니다." +item5);
            				} 
            				break;
                        }
	                } else if (choice == 2) {
                    	System.out.println("종료를 선택하셨습니다.");
                    	System.out.println("┌──────────────────────────────────────────┐");
                    	System.out.println("│                Thank you                 │");
                        System.out.println("└──────────────────────────────────────────┘");

                    	System.exit(0);
       
                    }
                }

            } else if (login.equals(exit)) {
            	System.out.println("종료를 선택하셨습니다.");
            	System.out.println("┌──────────────────────────────────────────┐");
            	System.out.println("│                Thank you                 │");
                System.out.println("└──────────────────────────────────────────┘");

            	System.exit(0);
            	
            } else {
                System.out.println("잘못된 아이디거나 없는 아이디입니다. 다시 입력해주세요.");
                System.out.println("exit를 누르면 종료됩니다.");
                System.out.println("────────────────────────────────────────────────────────");
            }
        }
    }
    
     
    
    public static void main(String[] args) { 
        
    	 
    	 
    	Framework framework = new Framework();
    	framework.selectStart();   
    	//framework.Data_list();
    	
//    	int count = framework.saveToJson("item_bt.json");
//    	count += framework.saveToJson_Top("item_top.json");
//    	count += framework.saveToJson_Out("item_out.json");
//    	count += framework.saveToJson_Hat("item_hat.json");
//    	count += framework.saveToJson_Shose("item_sh.json");
//    	
//    	LOG.debug("저장건수: "+count);
    	
    	 
    	System.out.println();
    	System.out.println(); 
    	//framework.doUpdate_bt();
    	//framework.dao.doSaveFile_bt();
    	//framework.doDelete();
    	//framework.dao.doSaveFile_bt();
    	//framework.dao.doSaveFile();
    	
        
        
        
        
    } 
}
 

