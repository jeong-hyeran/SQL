package jdbc;

public class Ex04 {
	public static void main(String[] args) throws Exception {
		System.out.println("\n\t전체 목록\n\n");
		Ex01.main(null);
		
		System.out.println("\n\t1행 추가\n\n");
		Ex02_Insert.main(null);
		
//		System.out.println("\n\t전체 목록\n\n");
//		Ex01.main(null);
		
		System.out.println("\n\t6번 상품 삭제\n\n");
		Ex03_Delete.main(null);
		
		System.out.println("\n\t전체 목록\n\n");
		Ex01.main(null);
		
	}

}
