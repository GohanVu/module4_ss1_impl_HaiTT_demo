package com.example.impl_haitt_demo_ss1.controllers;

import com.example.impl_haitt_demo_ss1.models.Student;
import com.example.impl_haitt_demo_ss1.services.IStudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//Danh dau day la 1 controller (1 bean)
// Annotation la cai cu phap: @
@Controller
@RequestMapping ("student")
public class StudentController {
    //co che DI (Dependence Injection) : Tiem phu thuoc de giam su phu thuoc
    //DI : Field
    //DI: Getter
    //DI : Constructor

    @Autowired
    IStudentService studentService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("")
    public String displayAllStudent(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";

    }
    @GetMapping("/create")
    public String viewCreate(){
        return "student/create";
    }

    @PostMapping("/create")
    public String newStudent(@RequestParam("name")String name,
                             @RequestParam("address")String address,
                             @RequestParam("score")Float score,
                             Model model, RedirectAttributes redirectAttributes){
        Student student = new Student(name,address,score);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message","them moi thanh cong");
        return "redirect:/student";
    }
    @GetMapping ("/update/{id}")
    public String viewUpdate(@PathVariable("id")Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/edit";
    }

    @PostMapping("/update/{id}")
    public String updateStudent (@RequestParam("name")String name,
                                 @RequestParam("address")String address,
                                 @RequestParam("score")Float score,
                                 RedirectAttributes redirectAttributes,
                                 @PathVariable("id") long id){
        Student student = studentService.findById(id);
        Student student1 = new Student(id,name,address,score);
        if (student == null){
            redirectAttributes.addFlashAttribute("message", "Chinh sua that bai");
        } else {
            studentService.updateStudent (student1,id);
            redirectAttributes.addFlashAttribute("message","Chinh sua thanh cong");
        }
        return "redirect:/student";
    }
}
