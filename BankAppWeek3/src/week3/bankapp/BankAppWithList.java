package week3.bankapp;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class BankAppWithList {
	static Scanner s = new Scanner(System.in);
	static List<Join> list = new ArrayList<Join>();
	static SearchingInterfaceWithStream fc = new ForCreate();
	static SearchingInterfaceWithStream fr = new ForRetrieve();
	
	public static void main(String[] args) throws IOException {
		
		Join admin = new Join("admin","admin",0);
		list.add(admin);
		boolean bankapplication = true;
		
		while (bankapplication) {
			System.out.println("---------------------");
			System.out.println("1.가입 | 2.조회 | 3.입금 | 4.출금 | 5.탈퇴 | 6.종료");
			
			int keyCode = 0;
			
			try {
				keyCode = s.nextInt();
				s.nextLine();
			}catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("번호를 입력해주세요");
				throw e;
				
							}
			
			if (keyCode == 1) {				//1.가입
				createAccount();
				 
			}else if(keyCode == 2) {		//2.조회
				retrieve();
				
			}else if(keyCode == 3) {		//3.입금
				deposit();
				
			}else if(keyCode == 4) {		//4.출금
				withdraw();
				
			}else if(keyCode == 5) {		//5.탈퇴
				delete();
			   
			}else if(keyCode == 6) {		//6.종료
				System.out.println("종료");
				bankapplication = false;
				break;

			}else {System.out.println("다시 입력해주세요");

			}
		}
	}
/*--------------------------------------------------------------------*/
	private static void createAccount() {
		boolean cheak = true;
		System.out.println("회원가입을 합니다");
		System.out.println("아이디를 입력하세요");
		String id1 = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw1 = s.nextLine();
		
		cheak = fc.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("금액을 입력하세요");
			int val1 = s.nextInt();
			Join join = new Join(id1,pw1,val1);
			list.add(join);
		}else {
			System.out.println(id1+"은 사용중인 아이디 입니다");
		}
	}
	private static void retrieve() {
		boolean cheak = true;
		System.out.println("회원가입을 합니다");
		System.out.println("아이디를 입력하세요");
		String id1 = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw1 = s.nextLine();
		
		if(id1.equals("admin")&&pw1.equals("admin")) {
			list.forEach(m->System.out.println("----------------------"+"\r아이디:"+m.getId()+" "+"비밀번호:"+m.getPassword()+" "+"금액:"+m.getVal()));
			return;
		}
		
		cheak = fr.search(list, id1, pw1, cheak);
		if (cheak) {
			
		}
		
	}
	private static void deposit() {
		boolean cheak = true;
		System.out.println("입금합니다");
		System.out.println("아이디를 입력하세요");
		String id1 = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw1 = s.nextLine();
		cheak = fr.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("금액을 입력하세요");
			int val1 = s.nextInt();
			for (Join element:list) {		//stream 으로 하는법?
				if(element.getId().contentEquals(id1)) {
					element.setVal(element.getVal()+val1);
					System.out.println("잔액:"+element.getVal());
				}
			}
		}
	}
	private static void withdraw() {
		boolean cheak = true;
		System.out.println("출금합니다");
		System.out.println("아이디를 입력하세요");
		String id1 = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw1 = s.nextLine();
		cheak = fr.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("금액을 입력하세요");
			int val1 = s.nextInt();
			for (Join element:list) {		//stream 으로 하는법?
				if(element.getId().contentEquals(id1)) {
					if(element.getVal()<val1) {
						System.out.println("잔액이 부족합니다");
						return;
					}
					element.setVal(element.getVal()-val1);
					System.out.println("잔액:"+element.getVal());
				}
			}
		}
	}
	private static void delete() {
		boolean cheak = true;
		System.out.println("탈퇴합니다");
		System.out.println("아이디를 입력하세요");
		String id1 = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw1 = s.nextLine();
		if (id1.equals("admin")&&pw1.equals("admin")) {
			System.out.println("admin은 삭제할 수 없습니다");
			return;
		}
		cheak = fc.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("없는 아이디 입니다");
		}else {
			System.out.println(id1+"을 삭제합니다");
			for (Join element:list) {
				if(element.getId().equals(id1)&&element.getPassword().equals(pw1)) {
					list.remove(element);
					break;
				}
			}
			
		}
		
	}

}
