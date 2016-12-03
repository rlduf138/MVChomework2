package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Division;
import kr.ac.hansung.model.Semester;
import kr.ac.hansung.service.CourseService;

@Controller
public class ShowSemesterController {
private CourseService courseService;
	
	@Autowired
	public void setcourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping("/showsemester")
	public String showCourses(Model model){
		
//		List<Course> Courses = courseService.getCurrent();
//		
//		model.addAttribute("courses", Courses);
//		
		List<Semester> semesters = courseService.showSemester();
		model.addAttribute("semesters", semesters);
		
		
		return "showsemester";
	}
	
	@RequestMapping("/createCourse")
	public String createCourse(Model model){
		
		return "createCourse";
	}
	
	@RequestMapping("/showSemesterSelected")
	public String showSemesterSelected(Model model,@RequestParam int select){
		List<Semester> semesters = courseService.showSemester();
		int year = semesters.get(select).getYear();
		int semester = semesters.get(select).getSemester();
		
		List<Course> courses = courseService.showSemesterSelected(year, semester);
		model.addAttribute("courses",courses);
		
		return "showSemesterSelected";
	}
	
	//@RequestMapping("/showSemesterSelected1")
	
	
	@RequestMapping("/showregistercourse")
	public String showRegisterCourse(Model model){
		
		
		List<Course> courses = courseService.showRegisterCourse();
		model.addAttribute("courses",courses);
		
		return "showregistercourse";
	}
	
	@RequestMapping("/showdivision")
	public String showDivision(Model model){
		int sum=0;
		
		List<Division> divisions = courseService.showDivision();
		for(int i = 0 ;i<divisions.size();i++){
			sum+=divisions.get(i).getCredit();
		}
		
		Division newdiv = new Division("합계",sum);
		divisions.add(newdiv);
		
		model.addAttribute("divisions", divisions);
		
		return "showdivision";
	}
	
	@RequestMapping("/registercourse")
	public String Registercourse(Model model){
		
		model.addAttribute(new Course());
		
		return "registercourse";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Course course, BindingResult result){
		
		course.setYear(2017);
		course.setSemester(1);
		
		if(result.hasErrors()){
			System.out.println("Form data does not Validate");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "registercourse";
		}
		
		courseService.insert(course);
		
		return "registersuccess";
	}
}
