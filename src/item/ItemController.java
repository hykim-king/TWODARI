package item;
 

import java.util.Scanner;
 

import cmn.PLog;

public class ItemController implements PLog {

 
	private ItemDao dao;
	
	public ItemController() {
		dao = new ItemDao();
	}
	/*doSave*/
	public int doSave_top() {
	    int flag = 0;
	    ItemDTO param = new ItemDTO(); // MemberDao 파라메터
	    // 1. Scanner
	    // 2. 등록할 사용자 정보
	    // 3. dao.doSave(MemberDTO)
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("[상의] 상품을 등록하세요.>"
	            + "\n(name, price, size)");
	    String inputData = scanner.nextLine().trim();
	    LOG.debug("inputData: " + inputData);
	    String[] strMember = inputData.split(",");
	    // Convert strMember[1] to an integer
	    int price = Integer.parseInt(strMember[1].trim());
	    param.setName(strMember[0].trim());
	    param.setPrice(price); // Assign the converted integer value
	    param.setSize(strMember[2].trim());
	    // dao 호출
	    flag = dao.doSave_top(param);
	    return flag;
	}

	public int doSave_bt() {
	    int flag = 0;
	    ItemDTO param = new ItemDTO(); // MemberDao 파라메터
	    // 1. Scanner
	    // 2. 등록할 사용자 정보
	    // 3. dao.doSave(MemberDTO)
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("[하의] 상품을 등록하세요.>"
	            + "\n(name, price, size)");
	    String inputData = scanner.nextLine().trim();
	    LOG.debug("inputData: " + inputData);
	    String[] strMember = inputData.split(",");
	    // Convert strMember[1] to an integer
	    int price = Integer.parseInt(strMember[1].trim());
	    param.setName(strMember[0].trim());
	    param.setPrice(price); // Assign the converted integer value
	    param.setSize(strMember[2].trim());
	    // dao 호출
	    flag = dao.doSave_bt(param);
	    return flag;
	}

	public int doSave_out() {
	    int flag = 0;
	    ItemDTO param = new ItemDTO(); // MemberDao 파라메터
	    // 1. Scanner
	    // 2. 등록할 사용자 정보
	    // 3. dao.doSave(MemberDTO)
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("[아우터] 상품을 등록하세요.>"
	            + "\n(name, price, size)");
	    String inputData = scanner.nextLine().trim();
	    LOG.debug("inputData: " + inputData);
	    String[] strMember = inputData.split(",");
	    // Convert strMember[1] to an integer
	    int price = Integer.parseInt(strMember[1].trim());
	    param.setName(strMember[0].trim());
	    param.setPrice(price); // Assign the converted integer value
	    param.setSize(strMember[2].trim());
	    // dao 호출
	    flag = dao.doSave_out(param);
	    return flag;
	}

	public int doSave_hat() {
	    int flag = 0;
	    ItemDTO param = new ItemDTO(); // MemberDao 파라메터
	    // 1. Scanner
	    // 2. 등록할 사용자 정보
	    // 3. dao.doSave(MemberDTO)
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("[모자] 상품을 등록하세요.>"
	            + "\n(name, price, size)");
	    String inputData = scanner.nextLine().trim();
	    LOG.debug("inputData: " + inputData);
	    String[] strMember = inputData.split(",");
	    // Convert strMember[1] to an integer
	    int price = Integer.parseInt(strMember[1].trim());
	    param.setName(strMember[0].trim());
	    param.setPrice(price); // Assign the converted integer value
	    param.setSize(strMember[2].trim());
	    // dao 호출
	    flag = dao.doSave_hat(param);
	    return flag;
	}

	public int doSave_sh() {
	    int flag = 0;
	    ItemDTO param = new ItemDTO(); // MemberDao 파라메터
	    // 1. Scanner
	    // 2. 등록할 사용자 정보
	    // 3. dao.doSave(MemberDTO)
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("[신발] 상품을 등록하세요.>"
	            + "\n(name, price, size)");
	    String inputData = scanner.nextLine().trim();
	    LOG.debug("inputData: " + inputData);
	    String[] strMember = inputData.split(",");
	    // Convert strMember[1] to an integer
	    int price = Integer.parseInt(strMember[1].trim());
	    param.setName(strMember[0].trim());
	    param.setPrice(price); // Assign the converted integer value
	    param.setSize(strMember[2].trim());
	    // dao 호출
	    flag = dao.doSave_sh(param);
	    return flag;
	}


	
	/**/
	public int doUpdate_top() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		int flag =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할[상의]의 이름를 입력하세요. >");
		
		 String name = sc.nextLine().trim();
		    LOG.debug("[상의]이름: " + name);
		    param.setName(name);

		    // Retrieve member information from the database
		    outVO = dao.doSelectOne_top(param);
		    if (outVO != null) {
		        System.out.println("현재 [상의] 정보: " + outVO);

		        // Prompt user to update member information
		        System.out.println("수정할 [상의]의 가격을 입력하세요.");
		        System.out.println("가격:");
		        String input = sc.nextLine().trim();
		        int price = Integer.parseInt(input);
		        outVO.setPrice(price);
 
		        System.out.println("수정할 [상의]의 사이즈을 입력하세요.");
		        System.out.println("사이즈:");
		        String size = sc.nextLine();
		        outVO.setSize(size);
 
		        flag = dao.doUpdate_top(outVO);
		        if (flag > 0) {
		            LOG.debug("[상의]성공적으로 업데이트되었습니다.");
		            LOG.debug("[상의]성공적으로 업데이트되었습니다."+outVO);
		        } else {
		            LOG.debug("[상의]업데이트에 실패했습니다.");
		        }
		    } else {
		        LOG.debug("해당[상의]이/가 존재하지 않습니다.");
		    }
		    return flag;
		}
	
	public int doUpdate_bt() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		int flag =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할[하의]의 이름를 입력하세요. >");
		
		 String name = sc.nextLine().trim();
		    LOG.debug("[하의]이름: " + name);
		    param.setName(name);

		    // Retrieve member information from the database
		    outVO = dao.doSelectOne_bt(param);
		    if (outVO != null) {
		        System.out.println("현재 [하의] 정보: " + outVO);

		        // Prompt user to update member information
		        System.out.println("수정할 [하의]의 가격을 입력하세요.");
		        System.out.println("가격:");
		        String input = sc.nextLine().trim();
		        int price = Integer.parseInt(input);
		        outVO.setPrice(price);
 
		        System.out.println("수정할 [하의]의 사이즈을 입력하세요.");
		        System.out.println("사이즈:");
		        String size = sc.nextLine();
		        outVO.setSize(size);
 
		        flag = dao.doUpdate_bt(outVO);
		        if (flag > 0) {
		            LOG.debug("[하의]성공적으로 업데이트되었습니다.");
		        } else {
		            LOG.debug("[하의]업데이트에 실패했습니다.");
		        }
		    } else {
		        LOG.debug("해당[하의]이/가 존재하지 않습니다.");
		    }
		    return flag;
		}
	public int doUpdate_out() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		int flag =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할[아우터]의 이름를 입력하세요. >");
		
		 String name = sc.nextLine().trim();
		    LOG.debug("[아우터]이름: " + name);
		    param.setName(name);

		    // Retrieve member information from the database
		    outVO = dao.doSelectOne_out(param);
		    if (outVO != null) {
		        System.out.println("현재 [아우터] 정보: " + outVO);

		        // Prompt user to update member information
		        System.out.println("수정할 [아우터]의 가격을 입력하세요."); 
		        System.out.println("가격:");
		        String input = sc.nextLine().trim();
		        int price = Integer.parseInt(input);
		        outVO.setPrice(price);
 
		        System.out.println("수정할 [아우터]의 사이즈을 입력하세요.");
		        System.out.println("사이즈:");
		        String size = sc.nextLine().trim();
		        outVO.setSize(size);
 
		        flag = dao.doUpdate_out(outVO);
		        if (flag > 0) {
		            LOG.debug("[아우터]성공적으로 업데이트되었습니다.");
		        } else {
		            LOG.debug("[아우터]업데이트에 실패했습니다.");
		        }
		    } else {
		        LOG.debug("해당[아우터]이/가 존재하지 않습니다.");
		    }
		    return flag;
		}
	public int doUpdate_hat() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		int flag =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할[모자]의 이름를 입력하세요. >");
		
		 String name = sc.nextLine().trim();
		    LOG.debug("[모자]이름: " + name);
		    param.setName(name);

		    // Retrieve member information from the database
		    outVO = dao.doSelectOne_hat(param);
		    if (outVO != null) {
		        System.out.println("현재 [모자] 정보: " + outVO);

		        // Prompt user to update member information
		        System.out.println("수정할 [모자]의 가격을 입력하세요.");
		        System.out.println("가격:");
		        String input = sc.nextLine().trim();
		        int price = Integer.parseInt(input);
		        outVO.setPrice(price);
 
		        System.out.println("수정할 [모자]의 사이즈을 입력하세요.");
		        String size = sc.nextLine().trim();
		        System.out.println("사이즈:");
		        outVO.setSize(size);
 
		        flag = dao.doUpdate_hat(outVO);
		        if (flag > 0) {
		            LOG.debug("[모자]성공적으로 업데이트되었습니다.");
		        } else {
		            LOG.debug("[모자]업데이트에 실패했습니다.");
		        }
		    } else {
		        LOG.debug("해당[모자]이/가 존재하지 않습니다.");
		    }
		    return flag;
		}
	public int doUpdate_sh() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		int flag =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할[신발]의 이름를 입력하세요. >");
		
		 String name = sc.nextLine().trim();
		    LOG.debug("[신발]이름: " + name);
		    param.setName(name);

		    // Retrieve member information from the database
		    outVO = dao.doSelectOne_sh(param);
		    if (outVO != null) {
		        System.out.println("현재 [신발] 정보: " + outVO);

		        // Prompt user to update member information
		        System.out.println("수정할 [신발]의 가격을 입력하세요.");
		        System.out.println("가격:");
		        String input = sc.nextLine().trim();
		        int price = Integer.parseInt(input);
		        outVO.setPrice(price);
 
		        System.out.println("수정할 [신발]의 사이즈을 입력하세요.");
		        System.out.println("사이즈:");
		        String size = sc.nextLine().trim();
		        outVO.setSize(size);
 
		        flag = dao.doUpdate_sh(outVO);
		        if (flag > 0) {
		            LOG.debug("[신발]성공적으로 업데이트되었습니다.");
		        } else {
		            LOG.debug("[신발]업데이트에 실패했습니다.");
		        }
		    } else {
		        LOG.debug("해당[신발]이/가 존재하지 않습니다.");
		    }
		    return flag;
		}
	/*dodelete*/
		public int doDelete_top() {
		
		
		int flag = 0;  //return
		ItemDTO param = new ItemDTO(); //MemberDao 파라매터
		
		//1. scanner
		//2. 조회할 사용자 memberId
		//3. dao.doSelectOne(MemberDTO)
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 [상의]의 상품명을 입력 하세요. >");
		
		String removedata = sc.nextLine().trim();
		LOG.debug("remove"+removedata);
		param.setName(removedata);
		LOG.debug("param"+param);
		
		//dao호출
		flag = dao.doDelete_top(param);
		LOG.debug("flag:"+flag);

		
		return flag;
		
	}
		public int doDelete_bt() {
			
			
			int flag = 0;  //return
			ItemDTO param = new ItemDTO(); //MemberDao 파라매터
			
			//1. scanner
			//2. 조회할 사용자 memberId
			//3. dao.doSelectOne(MemberDTO)
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 [하의]의 상품명을 입력 하세요. >");
			
			String removedata = sc.nextLine().trim();
			LOG.debug("remove"+removedata);
			param.setName(removedata);
			LOG.debug("param"+param);
			
			//dao호출
			flag = dao.doDelete_bt(param);
			LOG.debug("flag:"+flag);

			
			return flag;
			
		}
		public int doDelete_out() {
			
			
			int flag = 0;  //return
			ItemDTO param = new ItemDTO(); //MemberDao 파라매터
			
			//1. scanner
			//2. 조회할 사용자 memberId
			//3. dao.doSelectOne(MemberDTO)
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 [아우터]의 상품명을 입력 하세요. >");
			
			String removedata = sc.nextLine().trim();
			LOG.debug("remove"+removedata);
			param.setName(removedata);
			LOG.debug("param"+param);
			
			//dao호출
			flag = dao.doDelete_out(param);
			LOG.debug("flag:"+flag);

			
			return flag;
			
		}
		public int doDelete_hat() {
			
			
			int flag = 0;  //return
			ItemDTO param = new ItemDTO(); //MemberDao 파라매터
			
			//1. scanner
			//2. 조회할 사용자 memberId
			//3. dao.doSelectOne(MemberDTO)
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 [모자]의 상품명을 입력 하세요. >");
			
			String removedata = sc.nextLine().trim();
			LOG.debug("remove"+removedata);
			param.setName(removedata);
			LOG.debug("param"+param);
			
			//dao호출
			flag = dao.doDelete_hat(param);
			LOG.debug("flag:"+flag);

			
			return flag;
			
		}
		public int doDelete_sh() {
			
			
			int flag = 0;  //return
			ItemDTO param = new ItemDTO(); //MemberDao 파라매터
			
			//1. scanner
			//2. 조회할 사용자 memberId
			//3. dao.doSelectOne(MemberDTO)
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 [신발]의 상품명을 입력 하세요. >");
			
			String removedata = sc.nextLine().trim();
			LOG.debug("remove"+removedata);
			param.setName(removedata);
			LOG.debug("param"+param);
			
			//dao호출
			flag = dao.doDelete_sh(param);
			LOG.debug("flag:"+flag);

			
			return flag;
			
		}
	
	/**/
	public ItemDTO doSelectOne_top() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 [상의]의 상품명을 입력하세요.");
		
		String inputdata = sc.nextLine().trim();
		LOG.debug("intput: "+inputdata);
		param.setName(inputdata);
		LOG.debug("param: "+param);
		
		outVO = dao.doSelectOne_top(param);
		LOG.debug("outVO: "+outVO); 
		return outVO; 
	}
	public ItemDTO doSelectOne_bt() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 [하의]의 상품명을 입력하세요.");
		
		String inputdata = sc.nextLine().trim();
		LOG.debug("intput: "+inputdata);
		param.setName(inputdata);
		LOG.debug("param: "+param);
		
		outVO = dao.doSelectOne_bt(param);
		LOG.debug("outVO: "+outVO); 
		return outVO; 
	}
	public ItemDTO doSelectOne_out() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 [아우터]의 상품명을 입력하세요.");
		
		String inputdata = sc.nextLine().trim();
		LOG.debug("intput: "+inputdata);
		param.setName(inputdata);
		LOG.debug("param: "+param);
		
		outVO = dao.doSelectOne_out(param);
		LOG.debug("outVO: "+outVO);  
		return outVO; 
	}
	public ItemDTO doSelectOne_hat() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 [모자]의 상품명을 입력하세요.");
		
		String inputdata = sc.nextLine().trim();
		LOG.debug("intput: "+inputdata);
		param.setName(inputdata);
		LOG.debug("param: "+param);
		
		outVO = dao.doSelectOne_hat(param);
		LOG.debug("outVO: "+outVO); 
		return outVO; 
	}
	public ItemDTO doSelectOne_sh() {
		ItemDTO outVO = null;
		ItemDTO param = new ItemDTO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 [신발]의 상품명을 입력하세요.");
		
		String inputdata = sc.nextLine().trim();
		LOG.debug("intput: "+inputdata);
		param.setName(inputdata);
		LOG.debug("param: "+param);
		
		outVO = dao.doSelectOne_sh(param);
		LOG.debug("outVO: "+outVO); 
		return outVO; 
	}
	
	public ItemDTO doSelectOne() {
		ItemDTO outVO = null;  //return
		ItemDTO param = new ItemDTO(); //MemberDao 파라매터
		
		//1. scanner
		//2. 조회할 사용자 memberId
		//3. dao.doSelectOne(MemberDTO)
		Scanner sc = new Scanner(System.in);
		System.out.println("단건 조회할 Size 를 입력 하세요. >");
		
		String inputdata = sc.nextLine().trim();
		LOG.debug("input: "+inputdata);
		param.setSize(inputdata); 
		LOG.debug("param: "+param);
		
		//dao호출
		outVO = dao.doSelectOne(param);
		LOG.debug("outVO: "+outVO);

		
		return outVO;
		
	}

	public int doSaveFile_top() {
		return dao.doSaveFile_top();
	}
	
	public int doSaveFile_bt() {
		return dao.doSaveFile_bt();
	}
	public int doSaveFile_out() {
		return dao.doSaveFile_out();
	}
	public int doSaveFile_hat() {
		return dao.doSaveFile_hat();
	}
	public int doSaveFile_sh() {
		return dao.doSaveFile_sh();
	}
	
	
	
}