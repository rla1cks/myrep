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
			System.out.println("1.���� | 2.��ȸ | 3.�Ա� | 4.��� | 5.Ż�� | 6.����");
			
			int keyCode = 0;
			
			try {
				keyCode = s.nextInt();
				s.nextLine();
			}catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("��ȣ�� �Է����ּ���");
				throw e;
				
							}
			
			if (keyCode == 1) {				//1.����
				createAccount();
				 
			}else if(keyCode == 2) {		//2.��ȸ
				retrieve();
				
			}else if(keyCode == 3) {		//3.�Ա�
				deposit();
				
			}else if(keyCode == 4) {		//4.���
				withdraw();
				
			}else if(keyCode == 5) {		//5.Ż��
				delete();
			   
			}else if(keyCode == 6) {		//6.����
				System.out.println("����");
				bankapplication = false;
				break;

			}else {System.out.println("�ٽ� �Է����ּ���");

			}
		}
	}
/*--------------------------------------------------------------------*/
	private static void createAccount() {
		boolean cheak = true;
		System.out.println("ȸ�������� �մϴ�");
		System.out.println("���̵� �Է��ϼ���");
		String id1 = s.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw1 = s.nextLine();
		
		cheak = fc.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("�ݾ��� �Է��ϼ���");
			int val1 = s.nextInt();
			Join join = new Join(id1,pw1,val1);
			list.add(join);
		}else {
			System.out.println(id1+"�� ������� ���̵� �Դϴ�");
		}
	}
	private static void retrieve() {
		boolean cheak = true;
		System.out.println("ȸ�������� �մϴ�");
		System.out.println("���̵� �Է��ϼ���");
		String id1 = s.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw1 = s.nextLine();
		
		if(id1.equals("admin")&&pw1.equals("admin")) {
			list.forEach(m->System.out.println("----------------------"+"\r���̵�:"+m.getId()+" "+"��й�ȣ:"+m.getPassword()+" "+"�ݾ�:"+m.getVal()));
			return;
		}
		
		cheak = fr.search(list, id1, pw1, cheak);
		if (cheak) {
			
		}
		
	}
	private static void deposit() {
		boolean cheak = true;
		System.out.println("�Ա��մϴ�");
		System.out.println("���̵� �Է��ϼ���");
		String id1 = s.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw1 = s.nextLine();
		cheak = fr.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("�ݾ��� �Է��ϼ���");
			int val1 = s.nextInt();
			for (Join element:list) {		//stream ���� �ϴ¹�?
				if(element.getId().contentEquals(id1)) {
					element.setVal(element.getVal()+val1);
					System.out.println("�ܾ�:"+element.getVal());
				}
			}
		}
	}
	private static void withdraw() {
		boolean cheak = true;
		System.out.println("����մϴ�");
		System.out.println("���̵� �Է��ϼ���");
		String id1 = s.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw1 = s.nextLine();
		cheak = fr.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("�ݾ��� �Է��ϼ���");
			int val1 = s.nextInt();
			for (Join element:list) {		//stream ���� �ϴ¹�?
				if(element.getId().contentEquals(id1)) {
					if(element.getVal()<val1) {
						System.out.println("�ܾ��� �����մϴ�");
						return;
					}
					element.setVal(element.getVal()-val1);
					System.out.println("�ܾ�:"+element.getVal());
				}
			}
		}
	}
	private static void delete() {
		boolean cheak = true;
		System.out.println("Ż���մϴ�");
		System.out.println("���̵� �Է��ϼ���");
		String id1 = s.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw1 = s.nextLine();
		if (id1.equals("admin")&&pw1.equals("admin")) {
			System.out.println("admin�� ������ �� �����ϴ�");
			return;
		}
		cheak = fc.search(list, id1, pw1, cheak);
		if (cheak) {
			System.out.println("���� ���̵� �Դϴ�");
		}else {
			System.out.println(id1+"�� �����մϴ�");
			for (Join element:list) {
				if(element.getId().equals(id1)&&element.getPassword().equals(pw1)) {
					list.remove(element);
					break;
				}
			}
			
		}
		
	}

}
