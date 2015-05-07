package com.sds.icto.emaillist.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;

public class testemaillistDao {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		
	
		try{
			//0. 딜리트 테스트
			//testDelete();
			//1. 인서트 테스트
		testInsert();
		//2. fetchList 테스트
		testFetchList();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void testFetchList() throws Exception{
		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchList();
		for (EmailListVo vo : list) {
			System.out.print(vo.getNo() + " : ");
			System.out.print(vo.getFirstname() + " : ");
			System.out.print(vo.getLastname() + " : ");
			System.out.print(vo.getEmail() + " : ");
			System.out.println("");
		}
		
	}
	
	public static void testInsert() throws Exception{
		
		EmailListVo vo = new EmailListVo();
		vo.setFirstname("Ahn");
		vo.setLastname("D.Hyuck");
		vo.setEmail("kickscar@sunnyvale.co.kr");
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		
		vo = new EmailListVo();
		vo.setFirstname("sshn");
		vo.setLastname("dfwerk");
		vo.setEmail("werwerwerr@sunnyvale.co.kr");
		
		dao = new EmailListDao();
		dao.insert(vo);
	}
	
	public static void testDelete() throws Exception {

		EmailListDao dao = new EmailListDao();
		dao.delete();
	}


}
