package store.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import store.model.vo.Store;

public class StoreDao {

	public ArrayList<Store> selectStoreList(Connection conn, int storeCateId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Store> list = new ArrayList<Store>();
		
		String query = "select * from store_db where store_cate_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeCateId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Store s = new Store();
				s.setStoreNo(rset.getInt("store_no"));
				s.setStoreCeo(rset.getString("store_ceo"));
				s.setStoreAddr(rset.getString("store_addr"));
				s.setStoreTel(rset.getString("store_tel"));
				s.setStoreDet(rset.getString("store_det"));
				s.setStoreName(rset.getString("store_name"));
				s.setStoreCateId(rset.getInt("store_cate_id"));
				s.setStoreStartT(rset.getString("store_start_t"));
				s.setStoreEndT(rset.getString("store_end_t"));
				s.setStoreFilepath(rset.getString("store_filepath"));
				s.setStoreFilename(rset.getString("store_filename"));
				s.setStoreRest(rset.getString("store_rest"));
				
				list.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	

}
