package item;
  
import java.util.ArrayList;

import java.util.Scanner;
 
import cmn.PLog;
public class MainCtrl implements PLog{
	
		ItemDTO bottom01;
		ItemDTO bottom02;
		ItemDTO bottom03;
		ItemDTO bottom04;
		ItemDTO bottom05;
		
		ArrayList<ItemDTO> bt;
		ItemDao dao;
		
		private ItemController itemController;
		
		public MainCtrl() {
			
			bottom01 = new ItemDTO("�����", 10000, "90");
	    	bottom02 = new ItemDTO("�����", 20000, "100");
	    	bottom03 = new ItemDTO("û����", 30000, "110");
	    	bottom04 = new ItemDTO("�ݹ���", 40000, "120");
	    	bottom05 = new ItemDTO("��ĿƮ", 50000, "130");
	    	
	    	bt = new ArrayList<ItemDTO>();
	    	bt.add(bottom01);
	    	bt.add(bottom02);
	    	bt.add(bottom03);
	    	bt.add(bottom04);
	    	bt.add(bottom05);
	    	
	    	
	    	dao = new ItemDao();
	    	dao.setListBottom(bt);
	    	dao.doSaveFile_bt();
	    	
	    	itemController = new ItemController();
	    	System.out.println();
	    	System.out.println(menuString());
	    	
	    	Menu();
			
		}
		
		
		private void Menu() {
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("Menu ����>");
				String menuInput = sc.nextLine().trim();
				
				switch(menuInput) {
				
				case"2":
					ItemDTO name = itemController.doSelectOne_bt();
					if(null != name) {
						System.out.println("��ȸ ����"+name);
					}else {
						System.out.println("�̻󼾼�Ȯ��.\n"+name);
						break;
					}
					
				default:
					System.out.println("�޴�Ȯ�� �̻��̻�");
					break;
				
				
				}
				}
				
			
			
		}
		
		
		public String menuString() {
			StringBuilder sb = new StringBuilder(1500);
			sb.append("ȸ�� ��� ��ȸ  \n" );
			sb.append("ȸ�� ��� ��ȸ  \n" );
			sb.append("ȸ�� �ܰ�����  \n" );
			sb.append("ȸ�� �ܰ� ����  \n" );
			sb.append("ȸ�� �ܰ� ����   \n");
			sb.append("����");
			return sb.toString();
			
			
		}
		
	public static void main(String[] args) { 
		
	
		 
		 
		MainCtrl mc=new MainCtrl();
		

	}


}
