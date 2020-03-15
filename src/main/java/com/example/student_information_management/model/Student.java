package com.example.student_information_management.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.core.style.ToStringCreator;


@Entity
@Table(name = "students")
public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Student()
    {
      this.id=0;
      this.name="";
      this.gender="";
      this.birthday="";
      this.native_place="";
      this.major="";
    }

    public Student(int id, String name,String gender,String birthday,String native_place,String major)
    {
      this.id=id;
      this.name=name;
      this.gender=gender;
      this.birthday=birthday;
      this.native_place=native_place;
      this.major=major;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
	@NotEmpty(message ="姓名不能为空")
    private String name;

    @Column(name = "gender")
	@NotEmpty(message ="性别不能为空")
    private String gender;

    @Column(name = "birthday")
	@NotEmpty(message ="生日不能为空")
    private String birthday;

    @Column(name = "native_place")
	@NotEmpty(message ="籍贯不能为空")
    private String native_place;

    @Column(name = "major")
	@NotEmpty(message ="院系不能为空")
    private String major;

    public int getId() {
		return this.id;
    }
    
    public String getName() {
		return this.name;
    }

    public String getGender() {
		return this.gender;
    }

    public String getBirthday() {
		return this.birthday;
    }

    public String getNative_place() {
		return this.native_place;
    }

    public String getMajor() {
		return this.major;
    }

    public void setId(int id) {
      this.id=id;
    }

    public void setName(String name) {
      this.name=name;
    }

    public void setGender(String gender) {
      this.gender=gender;
    }

    public void setBirthday(String birthday) {
      this.birthday=birthday;
    }

    public void setNative_place(String native_place) {
      this.native_place=native_place;
    }

    public void setMajor(String major) {
      this.major=major;
    }

  @Override
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("name", this.getName()).append("gender", this.getGender())
				.append("birthday", this.getBirthday()).append("native_place", this.getNative_place()).append("major", this.getMajor())
				.toString();
	}
  


}