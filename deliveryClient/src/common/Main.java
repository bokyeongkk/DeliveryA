package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		String cliId = "";
		String cliPw = "";
		String cliName = "";
		String cliNickName = "";
		String cliTel = "";
		String cliEmail = "";
		String cliAddr = "";
		String cliGender = "";
		String cliBirth = "";
		String cliEnrollDate = "";
		String cliAddrDet = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from client_db";

		try {
			conn = JDBCTemplate.getConnection();
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				cliId = rset.getString(1);
				cliPw = rset.getString(2);
				cliName = rset.getString(3);
				cliNickName = rset.getString(4);
				cliTel = rset.getString(5);
				cliEmail = rset.getString(6);
				cliAddr = rset.getString(7);
				cliGender = rset.getString(8);
				cliBirth = rset.getString(9);
				cliEnrollDate = rset.getString(10);
				cliAddrDet = rset.getString(11);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}

		System.out.println(cliId);
		System.out.println(cliPw);
		System.out.println(cliName);
		System.out.println(cliNickName);
		System.out.println(cliTel);
		System.out.println(cliEmail);
		System.out.println(cliAddr);
		System.out.println(cliGender);
		System.out.println(cliBirth);
		System.out.println(cliEnrollDate);
		System.out.println(cliAddrDet);
	}
}