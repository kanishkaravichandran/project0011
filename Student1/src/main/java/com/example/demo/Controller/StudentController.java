package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.StudentService;
import com.example.demo.bean.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping("/i")
	public String viewIn( Model model) {
		List<Student> studentlist = service.listAll();
		model.addAttribute("getAllStudent", studentlist);
		return "index";
	}
	
	@RequestMapping("/new_add")
	public String viewForm( Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "insert";
		
	}
	@RequestMapping(value ="/save_student",method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		service.create(student);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEdit(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("update");
		Student student =service.updateid(id);
		mav.addObject( "student" ,student);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
}
