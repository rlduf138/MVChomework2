package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Division;
import kr.ac.hansung.model.Semester;

@Service
public class CourseService {
	private CourseDAO courseDAO;

	@Autowired
	public void setCourseDao(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	public List<Course> getCurrent() {
		return courseDAO.getCourses();
	}
	
	public void insert(Course course){
		courseDAO.insert(course);
	}
	
	public List<Course> showSemesterSelected(int year, int semester){
		
		return courseDAO.getSemesterCourses(year, semester);
	}
	
	public List<Semester> showSemester(){
		return courseDAO.showSemester();
	}
	
	public List<Division> showDivision(){
		return courseDAO.getDivisionCourse();
	}

	public List<Course> showRegisterCourse() {
		
		return courseDAO.getRegisterCourse();
	}
	
}
