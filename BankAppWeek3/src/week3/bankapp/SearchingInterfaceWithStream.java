package week3.bankapp;

import java.util.List;

public interface SearchingInterfaceWithStream {
	boolean search(List<Join> list, String id, String pw ,boolean cheak);
	
	Join returnJoin(List<Join> list, String id, String pw, Join join1); 

}
