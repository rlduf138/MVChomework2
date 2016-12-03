package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Division;
import kr.ac.hansung.model.Semester;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;
	
	//Dependency Injection
	//@AutoWired
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount(){
		String sqlStatement = "select count(*) from course";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public List<Semester> showSemester(){
		
		String sqlStatement = "select year, semester, sum(credit) as creditSum from course group by year, semester";
		
		
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Semester>(){

			@Override
			public Semester mapRow(ResultSet rs, int rowNum) throws SQLException {
				Semester semester = new Semester();
				
				semester.setYear(rs.getInt("year"));
				semester.setSemester(rs.getInt("semester"));
				semester.setCredit(rs.getInt("creditSum"));
				
				System.out.println(semester);
				return semester;
			}
		});
	}
	
	
	// querying and returning a single object
	public Course getCourse(String name){
		// ? = place holder
		String sqlStatement = "select * from course where name = ?";
		
		
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{name}, 
				new RowMapper<Course>(){

					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						
						course.setYear(rs.getInt("year"));
						course.setSemester(rs.getInt("semester"));
						course.setCode(rs.getString("code"));
						course.setName(rs.getString("name"));
						course.setDivision(rs.getString("division"));
						course.setCredit(rs.getInt("credit"));
						
						return course;
					}
		});
	}
	
	// 학기별 수강정보
	public List<Course> getSemesterCourses(int year, int semester) {
		// ? = place holder
		String sqlStatement = "select * from course where year= ? and semester= ?";

		return jdbcTemplateObject.query(sqlStatement,new Object[]{year,semester}, new RowMapper<Course>() {
													//new OfferMapper<Offer>()
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}
	
	public List<Division> getDivisionCourse(){
		
		String sqlStatement="select division, sum(credit) as sumCredit from course group by division";
		
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Division>(){

			@Override
			public Division mapRow(ResultSet rs, int rowNum) throws SQLException {
				Division division = new Division();

				division.setDivision(rs.getString("division"));
				division.setCredit(rs.getInt("sumCredit"));
				
				
				return division;
			}
			
		});
	}
	
	
	// querying and returning a multiple object
	// ��� ������ ������
	public List<Course> getCourses() {
		// ? = place holder
		String sqlStatement = "select * from course";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>() {
													//new OfferMapper<Offer>()
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}
	public List<Course> getRegisterCourse() {
		String sqlStatement = "select * from course where year = '2017' and semester = '1'";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>() {
													//new OfferMapper<Offer>()
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}
	
	public boolean insert(Course course){
		
		int year = course.getYear();
		int semester = course.getSemester();
		String code  = course.getCode();
		String name = course.getName();
		String division = course.getDivision();
		int credit = course.getCredit();
		
		String sqlStatement = "insert into course (year, semester, code, name, division, credit) values (?,?,?,?,?,?)";
		
		return (jdbcTemplateObject.update(sqlStatement,new Object[]{year, semester, code, name, division, credit})==1);
		//1�̸� true
	}
//	public boolean update(Course course){
//		
//		int year = course.getYear();
//		int semester = course.getSemester();
//		String code  = course.getCode();
//		String name = course.getName();
//		String division = course.getDivision();
//		int credit = course.getCredit();
//		
//		String sqlStatement = "update offers set name = ?, email = ?, text = ? where id = ?";
//		
//		return (jdbcTemplateObject.update(sqlStatement,new Object[]{name, email, text, id})==1);
//	}
//	public boolean delete(int id){
//		String sqlStatement = "delete from course where id = ?";
//		
//		return (jdbcTemplateObject.update(sqlStatement,new Object[]{id})==1);
//	}

	
}
