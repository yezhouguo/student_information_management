package com.example.student_information_management.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.example.student_information_management.model.Student;
import com.example.student_information_management.repository.StudentRepository;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
class StudentController
{
    private final StudentRepository students;

    public StudentController(StudentRepository StudentService) {
		this.students= StudentService;
    }
    
    

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/student")
    public String CreateStudent(Model model)
    {
        //Student student = new Student();
        return "/student/search";
    }

    
    @GetMapping("/student/search")
    public String Search(Student student,String name, BindingResult result, Model model,HttpServletRequest request) {
        
        ArrayList<Student> results = new ArrayList<>();
        //String temp=new String();
        //System.out.println(name);
        if(name==null)
            results = this.students.findByName(" ");
        else
            results = this.students.findByName(name);
        
        //System.out.println("名字查询的返回值："+temp);
        //results.add(new Student());
        /*Student s = new Student();
        s.setName("yzg");
        s.setGender("男");
        s.setBirthday("1997676");
        s.setNative_place("brasil");
        s.setMajor("计算机");
        this.students.save(s);*/
        
        //ArrayList byID = this.students.findById(10);
        //System.out.println("这是FindById的返回值："+byID);
        //results.add(s);

		if (results.isEmpty()) {
            // no owners found
            //System.out.println("没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有");
			result.rejectValue("name", "notFound", "not found");
			return "student/search";
		}
        else
        {
            //System.out.println("有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了");
            model.addAttribute("results", results);
            return "/student/search";
        }
    }

    @GetMapping(value="/student/add")
    public String Add(String name,String gender,String birthday,String native_place,String major) {
        int id=9999;
        if(name!=null)
        {
            Student s = new Student(id,name,gender,birthday,native_place,major);
            this.students.save(s);
            return "/student/addsuccess";
        }
        return "/student/add";
    }

    @GetMapping(value="/student/delete")
    public String Delete(Integer id,Model model) {

            ArrayList<Student> results = this.students.findAll(id);
            if (results.isEmpty()) {
                // no owners found
                //System.out.println("没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有");
                ;
            }
            else
            {
                //System.out.println("有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了有了");
                model.addAttribute("results", results);
            }
            if(id!=null)
            {
                this.students.delete(id);
                return "/student/deletesuccess";
            }
            
            return "/student/delete";
    }
    

    @GetMapping(value="/student/update")
    public String Update(Integer id ,String name,String gender,String birthday,String native_place,String major,Model model) {
        ArrayList<Student> results = this.students.findAll(id);
        model.addAttribute("results", results);
        if(id!=null)
        {
            Student s = this.students.findById(id);
            s.setName(name);
            s.setGender(gender);
            s.setBirthday(birthday);
            s.setNative_place(native_place);
            s.setMajor(major);
            this.students.update(id,name,gender,birthday,native_place,major);
            return "/student/updatesuccess";
        }

        return "/student/update";
    }

}