package week3.bankapp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForRetrieve implements SearchingInterfaceWithStream {
	
	public boolean search(List<Join> list, String id, String pw, boolean cheak) {
		
		List<Join> list2 = list.stream()
				.filter( m->m.getId().equals(id))
				.collect(Collectors.toList());
	
		if (list2.isEmpty()) {
			System.out.println("다시 입력해주세요");
			cheak = false;
		}else {
			list2.forEach(m->System.out.println("아이디:"+m.getId()+"\r금액"+m.getVal()));
			
		}
		return cheak;
	}
	public Join returnJoin(List<Join> list,String id, String pw, Join join1) {
		return join1;
	}

}
