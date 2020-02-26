package bankapplication;

import java.io.IOException;

import java.util.Scanner;
import java.util.Scanner;
public class RunClass {
	private static String admin = "admin";				//admin ����
	static Scanner s = new Scanner(System.in);			//Scanner Ŭ����
	private static Join joinArray[] = new Join [100];	//join Ŭ����
	public static void main(String args[]) throws IOException {
		
		boolean bankapplication = true;
		int i = 0;
		
		while(bankapplication) {

			System.out.println("---------------------");
			System.out.println("1.���� | 2.��ȸ | 3.�Ա� | 4.��� | 5.Ż�� | 6.����");
			
			int keyCode = s.nextInt();
			s.nextLine();
			
			if (keyCode == 1) {				//1.����
				 i = createAccount(i);
				 
			}else if(keyCode == 2) {		//2.��ȸ
				retrieve(i);
				
			}else if(keyCode == 3) {		//3.�Ա�
				deposit(i);
				
			}else if(keyCode == 4) {		//4.���
				withdraw(i);
				
			}else if(keyCode == 5) {		//5.Ż��
				boolean confirm = false;
				confirm = delete(i,confirm);
			    if(confirm){
			    	i--;
			    }
			}else if(keyCode == 6) {		//6.����
				System.out.println("����");
				bankapplication = false;
				break;

			}else {System.out.println("�ٽ� �Է����ּ���");

			}
		}
	}
/*--------------------------------------------------------------------*/
	//�����޼ҵ�
	private static int createAccount (int i){		//1.����
	   int k =0;
	   boolean idcheak=true;
	   System.out.println("ȸ�������� �մϴ�");
	   System.out.println("���̵� �Է��ϼ���");
	   String id1 = s.nextLine();
	   for(k=0; k<i; k++){
	     if(id1.equals(joinArray[k].getId())){
	       System.out.println("�̹� �����ϴ� ���̵� �Դϴ�");
	       idcheak = false;
	       break;
	     }
	   }
	   while (idcheak){
	     System.out.println("��й�ȣ�� �Է��ϼ���");
	     String pw1 = s.nextLine();
	     System.out.println("�ݾ��� �Է��ϼ���");
	     int val1 = s.nextInt();
	     System.out.println("���̵�:" + id1);
	     System.out.println("��й�ȣ:" + pw1);
	     System.out.println("�ܾ�:" + val1);
	     joinArray[i]= new Join(id1,pw1,val1);
	     i++;
	     idcheak= false;
	   }
	   return i;
	  
	}
	private static void retrieve(int i){		//2.��ȸ
		System.out.println("������ ��ȸ�մϴ�.");
		System.out.println("���̵� �Է��ϼ���");
		String id1 = s.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw1 = s.nextLine();
		if (id1.equals(admin)&&pw1.equals(admin)){
			for(int k=0; k<i; k++){
				System.out.println ("-----------");
				System.out.println ("���̵�:" +joinArray[k].getId());
				System.out.println ("��й�ȣ:" + joinArray[k].getPassword());
				System.out.println ("�ܾ�:" + joinArray[k].getVal());
			}
	   }else{
	     boolean search = true;
	     int k =0;
	     while(search){
	       String ids = joinArray[k].getId();
	       String pws = joinArray[k].getPassword();
	       if(id1.equals(ids)&&pw1.equals(pws)){
	         search = false;
	         System.out.println("���̵�:"+joinArray[k].getId());
	         System.out.println("�ܾ�:" + joinArray[k].getVal());
	         
	       }else{
	         k++;
	         if(k==i){
	           System.out.println("������ ��ġ���� �ʽ��ϴ�");
	           search = false;
	         }
	       }
	     }  
	   }
	}
	private static void deposit (int i){		//3.�Ա�
	   System.out.println("�Ա��մϴ�");
	   System.out.println("���̵� �Է����ּ���");
	   String id1 = s.nextLine();
	   Join join = searchAccount(id1,i);
	   if (join !=null){
	     System.out.println("�ݾ��� �Է����ּ���");
	     int val1 = s.nextInt();
	     join.setVal(join.getVal()+val1);
	     System.out.println("�ܾ�:"+join.getVal());
	   }else{
	     System.out.println("������ ��ġ���� �ʽ��ϴ�");
	   }
	}

	private static void withdraw(int i){		//4.���
	   System.out.println("����մϴ�");
	   System.out.println("���̵� �Է����ּ���");
	   String id1 = s.nextLine();
	   Join join = searchAccount(id1,i);
	   if (join!= null){
	     System.out.println("��й�ȣ�� �Է����ּ���");
	     String pw1 = s.nextLine();
	     if (pw1.equals(join.getPassword())){
	       System.out.println("�ݾ��� �Է����ּ���");
	       int bal = s.nextInt();
	       if (join.getVal()<bal){
	         System.out.println("�ܾ��� �����մϴ�.");
	       }else{
	         join.setVal(join.getVal()-bal);
	         System.out.println("�ܾ�:"+join.getVal());
	       }
	     }else{
	    	 System.out.println("������ ��ġ���� �ʽ��ϴ�");
	     }
	   }else{
		   System.out.println("������ ��ġ���� �ʽ��ϴ�");
	   }
	}



	private static boolean delete(int i, boolean confirm){		//5.Ż��
		System.out.println("���̵� �Է����ּ���");
	   String id1 = s.nextLine();
	   Join join = searchAccount (id1,i);
	   if (join != null){
		   System.out.println("��й�ȣ�� �Է����ּ���");
		    String pw1 = s.nextLine();
	     if (pw1.equals(join.getPassword())){
	       deleteAccount(id1,i);
	       confirm = true;
	     }else{
	    	 System.out.println("������ ��ġ���� �ʽ��ϴ�");
	     }
	   }else {
		   System.out.println("������ ��ġ���� �ʽ��ϴ�");
	   }
	   return confirm;
	}

	private static Join searchAccount(String id1, int i){		//���̵� ã�� �޼ҵ�
	   Join join = null;
	   for (int k= 0; k<i; k++){
	     if(id1.equals(joinArray[k].getId())){
	       join = joinArray[k];
	     }
	   }
	   return join;
	  
	}

	private static void deleteAccount (String id1,int i){		//���̵� �����ϴ� �޼ҵ�
	   for(int k=0; k<i; k++){
	     if(id1.equals(joinArray[k].getId())){
	       for(int l=0; l+k<i; k++)
	       joinArray[k] = joinArray[k+1];
	     }
	   }
	}
}
