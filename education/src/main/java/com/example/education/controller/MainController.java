package com.example.education.controller;

import com.example.education.domain.Courses;
import com.example.education.domain.User;
import com.example.education.repos.CoursesRepo;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    
    @Autowired
    private CoursesRepo coursesRepo;
    
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
         Iterable<Courses> courses = coursesRepo.findAll();
         model.put("courses", courses);
        return "main";
    }
    
     @PostMapping("/main")
      public String add( @AuthenticationPrincipal User user,@RequestParam String title,@RequestParam String description, Map<String, Object> model) {
         Courses course = new Courses(title, description,user);
         course.setCreationDate(LocalDateTime.now());
         coursesRepo.save(course);
         Iterable<Courses> courses = coursesRepo.findAll(); 
         model.put("courses", courses);
         return "main";
      }
      @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Courses> courses;

        if (filter != null && !filter.isEmpty()) {
            courses= coursesRepo.findByDescription(filter);
        } else {
            courses = coursesRepo.findAll();
        }

        model.put("courses", courses);

        return "main";
    }
}
