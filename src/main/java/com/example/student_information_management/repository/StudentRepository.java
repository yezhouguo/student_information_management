package com.example.student_information_management.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.student_information_management.model.Student;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface StudentRepository extends Repository<Student,Integer>
{
    /**
	 * Retrieve {@link Student}s from the data store by name, returning all students
	 * whose name <i>starts</i> with the given name.
	 * @param name Value to search for
	 * @return a Collection of matching {@link Student}s (or an empty Collection if none
	 * found)
	 */
    @Query("SELECT student FROM Student student WHERE student.name =:name")
	@Transactional(readOnly = true)
    ArrayList<Student> findByName(@Param("name") String name);
    

    /**
	 * Retrieve an {@link Owner} from the data store by id.
	 * @param id the id to search for
	 * @return the {@link Owner} if found
	 */
	@Query("SELECT student FROM Student student WHERE student.id =:id")
	@Transactional(readOnly = true)
    Student findById(@Param("id") Integer id);
    

    /**
	 * Retrieve an {@link Owner} from the data store by id.
	 * @param id the id to search for
	 * @return the {@link Owner} if found
	 */
	@Query("SELECT student FROM Student student ORDER BY student.id")
	@Transactional(readOnly = true)
    ArrayList<Student> findAll(@Param("id") Integer id);


    /**
	 * Save an {@link Owner} to the data store, either inserting or updating it.
	 * @param student the {@link Owner} to save
	 */
    void save(Student student);
    

    /**
	 * 
	 * @param id 
	 */
    @Transactional
    @Modifying
    @Query("DELETE From Student student WHERE student.id =:id")
    void delete(Integer id);
    

    /**
	 * 
	 * @param id 
	 */
    @Transactional
    @Modifying
    @Query("UPDATE Student student SET student.name=:name,student.gender=:gender,student.birthday=:birthday,student.native_place=:native_place,student.major=:major WHERE student.id =:id")
	void update(Integer id,String name,String gender,String birthday,String native_place,String major);
}