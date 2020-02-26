package bankapplication;

import java.io.IOException;

import java.util.Scanner;
import java.util.Scanner;
public class RunClass {
	private static String admin = "admin";				//admin 권한
	static Scanner s = new Scanner(System.in);			//Scanner 클래스
	private static Join joinArray[] = new Join [100];	//join 클래스
	public static void main(String args[]) throws IOException {
		
		boolean bankapplication = true;
		int i = 0;
		
		while(bankapplication) {

			System.out.println("---------------------");
			System.out.println("1.가입 | 2.조회 | 3.입금 | 4.출금 | 5.탈퇴 | 6.종료");
			
			int keyCode = s.nextInt();
			s.nextLine();
			
			if (keyCode == 1) {				//1.가입
				 i = createAccount(i);
				 
			}else if(keyCode == 2) {		//2.조회
				retrieve(i);
				
			}else if(keyCode == 3) {		//3.입금
				deposit(i);
				
			}else if(keyCode == 4) {		//4.출금
				withdraw(i);
				
			}else if(keyCode == 5) {		//5.탈퇴
				boolean confirm = false;
				confirm = delete(i,confirm);
			    if(confirm){
			    	i--;
			    }
			}else if(keyCode == 6) {		//6.종료
				System.out.println("종료");
				bankapplication = false;
				break;

			}else {System.out.println("다시 입력해주세요");

			}
		}
	}
/*--------------------------------------------------------------------*/
	//정적메소드
	private static int createAccount (int i){		//1.가입
	   int k =0;
	   boolean idcheak=true;
	   System.out.println("회원가입을 합니다");
	   System.out.println("아이디를 입력하세요");
	   String id1 = s.nextLine();
	   for(k=0; k<i; k++){
	     if(id1.equals(joinArray[k].getId())){
	       System.out.println("이미 존재하는 아이디 입니다");
	       idcheak = false;
	       break;
	     }
	   }
	   while (idcheak){
	     System.out.println("비밀번호를 입력하세요");
	     String pw1 = s.nextLine();
	     System.out.println("금액을 입력하세요");
	     int val1 = s.nextInt();
	     System.out.println("아이디:" + id1);
	     System.out.println("비밀번호:" + pw1);
	     System.out.println("잔액:" + val1);
	     joinArray[i]= new Join(id1,pw1,val1);
	     i++;
	     idcheak= false;
	   }
	   return i;
	  
	}
	private static void retrieve(int i){		//2.조회
		System.out.println("정보를 조회합니다.");
		System.out.println("아이디를 입력하세요");
		String id1 = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw1 = s.nextLine();
		if (id1.equals(admin)&&pw1.equals(admin)){
			for(int k=0; k<i; k++){
				System.out.println ("-----------");
				System.out.println ("아이디:" +joinArray[k].getId());
				System.out.println ("비밀번호:" + joinArray[k].getPassword());
				System.out.println ("잔액:" + joinArray[k].getVal());
			}
	   }else{
	     boolean search = true;
	     int k =0;
	     while(search){
	       String ids = joinArray[k].getId();
	       String pws = joinArray[k].getPassword();
	       if(id1.equals(ids)&&pw1.equals(pws)){
	         search = false;
	         System.out.println("아이디:"+joinArray[k].getId());
	         System.out.println("잔액:" + joinArray[k].getVal());
	         
	       }else{
	         k++;
	         if(k==i){
	           System.out.println("정보가 일치하지 않습니다");
	           search = false;
	         }
	       }
	     }  
	   }
	}
	private static void deposit (int i){		//3.입금
	   System.out.println("입금합니다");
	   System.out.println("아이디를 입력해주세요");
	   String id1 = s.nextLine();
	   Join join = searchAccount(id1,i);
	   if (join !=null){
	     System.out.println("금액을 입력해주세요");
	     int val1 = s.nextInt();
	     join.setVal(join.getVal()+val1);
	     System.out.println("잔액:"+join.getVal());
	   }else{
	     System.out.println("정보가 일치하지 않습니다");
	   }
	}

	private static void withdraw(int i){		//4.출금
	   System.out.println("출금합니다");
	   System.out.println("아이디를 입력해주세요");
	   String id1 = s.nextLine();
	   Join join = searchAccount(id1,i);
	   if (join!= null){
	     System.out.println("비밀번호를 입력해주세요");
	     String pw1 = s.nextLine();
	     if (pw1.equals(join.getPassword())){
	       System.out.println("금액을 입력해주세요");
	       int bal = s.nextInt();
	       if (join.getVal()<bal){
	         System.out.println("잔액이 부족합니다.");
	       }else{
	         join.setVal(join.getVal()-bal);
	         System.out.println("잔액:"+join.getVal());
	       }
	     }else{
	    	 System.out.println("정보가 일치하지 않습니다");
	     }
	   }else{
		   System.out.println("정보가 일치하지 않습니다");
	   }
	}



	private static boolean delete(int i, boolean confirm){		//5.탈퇴
		System.out.println("아이디를 입력해주세요");
	   String id1 = s.nextLine();
	   Join join = searchAccount (id1,i);
	   if (join != null){
		   System.out.println("비밀번호를 입력해주세요");
		    String pw1 = s.nextLine();
	     if (pw1.equals(join.getPassword())){
	       deleteAccount(id1,i);
	       confirm = true;
	     }else{
	    	 System.out.println("정보가 일치하지 않습니다");
	     }
	   }else {
		   System.out.println("정보가 일치하지 않습니다");
	   }
	   return confirm;
	}

	private static Join searchAccount(String id1, int i){		//아이디를 찾는 메소드
	   Join join = null;
	   for (int k= 0; k<i; k++){
	     if(id1.equals(joinArray[k].getId())){
	       join = joinArray[k];
	     }
	   }
	   return join;
	  
	}

	private static void deleteAccount (String id1,int i){		//아이디를 삭제하는 메소드
	   for(int k=0; k<i; k++){
	     if(id1.equals(joinArray[k].getId())){
	       for(int l=0; l+k<i; k++)
	       joinArray[k] = joinArray[k+1];
	     }
	   }
	}
}
