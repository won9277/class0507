package guestbooktest;

import java.util.List;

import com.sds.icto.guestbook.dao.guestbookdao;
import com.sds.icto.guestbook.vo.guestbookvo;

public class guestbooktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
		testDelete();		
		
		/*testInsert();
		testFetchList();*/
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void testFetchList() throws Exception{
		guestbookdao dao = new guestbookdao();
		List<guestbookvo> list = dao.fetchList();
		for (guestbookvo vo : list) {
			System.out.print(vo.getNo() + " : ");
			System.out.print(vo.getName() + " : ");
			System.out.print(vo.getPassword() + " : ");
			System.out.print(vo.getMessage() + " : ");
			System.out.println(vo.getDate() + " : ");
			System.out.println("");
		}
		
	}
	
	public static void testInsert() throws Exception{
		
		guestbookvo vo = new guestbookvo();
		vo.setName("Ahn");
		vo.setPassword("D.Hyuck");
		vo.setMessage("kickscar@sunnyvale.co.kr");
		vo.setDate("2015-01-01");
		
		guestbookdao dao = new guestbookdao();
		dao.insert(vo);
		
		vo = new guestbookvo();
		vo.setName("sshn");
		vo.setPassword("dfwerk");
		vo.setMessage("werwerwerr@sunnyvale.co.kr");
		vo.setDate("2015-02-02");
		
		dao = new guestbookdao();
		dao.insert(vo);
	}
	
	
public static void testDelete() throws Exception{
		
		guestbookvo vo = new guestbookvo();
		vo.setNo(10);
		vo.setPassword("123123");
		
		guestbookdao dao = new guestbookdao();
		dao.delete(vo);
		
	}
}


