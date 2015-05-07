package com.sds.icto.emaillist.dao;

import java.sql.*;
import java.util.*;

import com.sds.icto.emaillist.vo.EmailListVo;

public class EmailListDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2 디비 콘 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return conn;
	}

	public void insert(EmailListVo vo) throws ClassNotFoundException,
			SQLException {

		// connection 생성
		Connection conn = getConnection();

		// statement sql 준비
		String sql = "insert into email_list values(email_list_no_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 바인딩
		pstmt.setString(1, vo.getFirstname());
		pstmt.setString(2, vo.getLastname());
		pstmt.setString(3, vo.getEmail());

		// query 설정
		pstmt.executeUpdate();

		// 자원정리

		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	public void delete(Long id) {

	}

	public void delete() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		// statement sql 준비
		Statement stmt = conn.createStatement();
		String sql = "delete from email_list";
		stmt.executeQuery(sql);
	}


	public List<EmailListVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<EmailListVo> list = new ArrayList<EmailListVo>();

		// 1 connection 생성
		Connection conn = getConnection();

		Statement stmt = conn.createStatement();

		String sql = "select * from email_list";
		ResultSet rs = stmt.executeQuery(sql);

		// 4 결과처리
		while (rs.next()) {
			Long no = rs.getLong(1);
			String FirstName = rs.getString(2);
			String LastName = rs.getString(3);
			String email = rs.getString(4);

			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirstname(FirstName);
			vo.setLastname(LastName);
			vo.setEmail(email);
			list.add(vo);
		}
		// 5 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}

		return list;

	}

}
