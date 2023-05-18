package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dao.MenuDao;
import test.dto.MenuDto;
import test.util.DBConnect;

public class MenuDao {
	//메뉴 추가
	public boolean insert(MenuDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int rowCount = 0; //수행후 변화된 row의 갯수
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "INSERT INTO cafemenu"
					+ " (name, ice, price)" 
					+ " VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getIce());
			pstmt.setInt(3, dto.getPrice());
		
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			} //finally-try
		}
		
		//rowCount가 0이라면 F 아니라면 T
		return rowCount == 0 ? false : true;
	} //insert
	
	//가격 수정
	public boolean update(MenuDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int rowCount = 0; //수행후 변화된 row의 갯수
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "UPDATE cafemenu"
					+ " SET price=?" 
					+ " WHERE name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getIce());
			pstmt.setInt(3, dto.getPrice());
		
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			} //finally-try
		}
		
		//rowCount가 0이라면 F 아니라면 T
		return rowCount == 0 ? false : true;
	} //update
	
	//메뉴 삭제
	public boolean delete(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int rowCount = 0; //수행후 변화된 row의 갯수
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "DELETE FROM cafemenu"
					+ " WHERE name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
		
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			} //finally-try
		}
		
		//rowCount가 0이라면 F 아니라면 T
		return rowCount == 0 ? false : true;
	} //delete
	
	//메뉴 검색
	public MenuDto getData(String where) {
		MenuDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT name, ice"
		               + " FROM cafemenu"
		               + " WHERE "+where;
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				String name = rs.getString("name");
				String ice = rs.getString("ice");
				int price = rs.getInt("price");
				
				dto = new MenuDto();
				dto.setName(name);
				dto.setIce(ice);
				dto.setPrice(price);
				
				return dto;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} //try
		
		return null;
	} //getData
	
	//메뉴 불러오기
	public List<MenuDto> getList() {
		List<MenuDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT name, ice, price"
					+ " FROM cafemenu"
					+ " ORDER BY name DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				MenuDto dto = new MenuDto();
				dto.setName(rs.getString("name"));
				dto.setIce(rs.getString("ice"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} //try
		
		return list;
	} //getList
	
	
}
