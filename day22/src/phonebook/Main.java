package phonebook;

import java.util.List;
import java.util.Scanner;

public class Main { ///  사용자와 DAO와 상용작용
	public static void main(String[] args) {

		DAO dao = new DAO(); // handler
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		String name, pnum;
		int age,row=0;
		List<DTO> list = null;
		DTO tmp = null;

		while (menu != 0) {
			System.out.println("1. 전체 목록");
			System.out.println("2. 추가");
			System.out.println("3. 검색");
			System.out.println("4. 단일 검색");
			System.out.println("5. 삭제");
			System.out.println("6. 수정");
			System.out.println("0. 종료");
			System.out.print("선택 >>>");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				list = dao.selectAll();
				for (DTO dto : list) {
					System.out.print(dto.getIdx() + "\t");
					System.out.print(dto.getName() + "\t");
					System.out.print(dto.getAge() + "\t");
					System.out.print(dto.getPnum() + "\n");
				}
				break;
			
			case 2: 
				System.out.print("이름 입력 : ");
				name = sc.nextLine();
				System.out.print("나이 입력 : ");
				age = Integer.parseInt(sc.nextLine());
				System.out.print("전화번호 입력 : ");
				pnum = sc.nextLine();
				
				tmp = new DTO();
				tmp.setName(name);
				tmp.setAge(age);
				tmp.setPnum(pnum);
				
				row = dao.insert(tmp);
				System.out.printf("%s 행이 추가되었습니다.\n",row);
				break;
				
			 case 3:
				 System.out.print("검색어 입력 : ");
				 name = sc.nextLine();
				 /// 여러결과를 한번에
				 
				 list = dao.search(name);
				 list.forEach(dto -> System.out.println(dto));
				 break;
				
			 case 4: // 단일 검색
//				 DTO dto =new DTO(); /// tmp를 만들어놔서 그걸 사용
				 System.out.print("이름 입력 : ");
				 name = sc.nextLine();
				 tmp = dao.seleteOne(name);
//				 dto = dao.seleteOne(name);
//				 System.out.println(dto);
				 System.out.println(tmp);
				 break;
				 
			 case 5: // 삭제
				 System.out.print("삭제할 이름 입력 : ");
				 name = sc.nextLine();
				 row = dao.delete(name);
				 System.out.println(row + "개 행이 삭제되었습니다.");
				 break;
				 
			 case 6: // 수정
				 System.out.print("수정할 데이터 이름 입력 : ");
				 name = sc.nextLine();
				 tmp = dao.seleteOne(name);
				 System.out.println(tmp);
				 System.out.println("수정할 데이터가 맞습니까? (y/n) : ");
				 if(sc.nextLine().equalsIgnoreCase("y")) {
					 tmp = new DTO();
					 System.out.print("변경할 이름 : ");
					 tmp.setName(sc.nextLine());

					 System.out.print("변경할 나이 : ");
					 tmp.setAge(Integer.parseInt(sc.nextLine()));

					 System.out.print("변경할 폰번호 : ");
					 tmp.setPnum(sc.nextLine());
					 row = dao.update(tmp, name);
				 }
				 
				 System.out.println(row + "개 행이 수정되었습니다.");
				 break;
				 
				
			case 0:
				sc.close();
			}/// end of switch
			System.out.println();
		} /// end of while
		System.out.println("프로그램 종료");

	}

}
