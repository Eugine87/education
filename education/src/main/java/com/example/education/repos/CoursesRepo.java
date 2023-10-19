/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.education.repos;

import com.example.education.domain.Courses;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Star
 */
public interface CoursesRepo extends CrudRepository<Courses,Long>{
    
     List<Courses> findByDescription(String description);
}
