package week3.bankapp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForCreate implements SearchingInterfaceWithStream {//&& for delete
	//실체 메소드
	public boolean search(List<Join> list, String id, String pw, boolean cheak) {
		
		List<Join> list1 = list.stream()
				.filter( m->m.getId().equals(id))
				.collect(Collectors.toList());
		
		if (list1.isEmpty()) {
			
		}else{
			cheak = false;
		}
		return cheak;
	}
	
	public Join returnJoin(List<Join> list,String id,String pw, Join join1) {
		return join1;
	}
}
