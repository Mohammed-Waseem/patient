package DataPhiLabs.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataPhiLabs.utility.DBUtil;

import DataPhiLabs.constants.DBConstant;
import DataPhiLabs.utility.DML;

public class PatientBean 
{
private int id;
private String firstName,lastName,bady,age,gender,phone,textArea;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getBady() {
	return bady;
}
public void setBady(String bady) {
	this.bady = bady;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getTextArea() {
	return textArea;
}
public void setTextArea(String textArea) {
	this.textArea = textArea;
}

public boolean insert()
{
	id = DML.generateID(DBConstant.TABLE_PATIENT, DBConstant.COL_ID);
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String sql = "insert into " + DBConstant.TABLE_PATIENT + " values(?, ?, ?, ?, ?, ?, ?, ?)";
	
	try
	{
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		pstmt.setString(2,firstName);
		pstmt.setString(3,lastName);
		pstmt.setString(4,bady);
		pstmt.setString(5,age);
		pstmt.setString(6,gender);
		pstmt.setString(7,phone);
		pstmt.setString(8,textArea);
		
		pstmt.executeUpdate();
		
		return true;
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		DBUtil.closeConnections(null, pstmt, con);
	}
	
	return false;
}

public static List<PatientBean> getPatient()
{
	ArrayList<PatientBean> list = new ArrayList<>();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select * from " + DBConstant.TABLE_PATIENT;
	
	try
	{
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			PatientBean bean = new PatientBean();
			bean.setId(rs.getInt(DBConstant.COL_ID));
			bean.setFirstName(rs.getString(DBConstant.COL_FIRST_NAME));
			bean.setLastName(rs.getString(DBConstant.COL_LAST_NAME));
			bean.setBady(rs.getString(DBConstant.COL_BDAY));
			bean.setAge(rs.getString(DBConstant.COL_AGE));
			bean.setGender(rs.getString(DBConstant.COL_GENDER));
			bean.setPhone(rs.getString(DBConstant.COL_PHONE));
			bean.setTextArea(rs.getString(DBConstant.COL_TEXT_AREA));
			list.add(bean);
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		DBUtil.closeConnections(rs, pstmt, con);
	}
	
	return list;
}


}
