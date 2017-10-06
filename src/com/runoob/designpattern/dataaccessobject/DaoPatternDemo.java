package com.runoob.designpattern.dataaccessobject;

public class DaoPatternDemo {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();
		for (Student student : studentDao.getAllStudents()) {
			System.out.println("Student: [RollNo: " +
					student.getRollNo() + ", name: " + student.getName() + "]");
		}
		Student student = studentDao.getAllStudents().get(0);
		student.setName("Michael");
		studentDao.updateStudent(student);
		
		studentDao.getStudent(0);
		System.out.println("Student: [RollNo : "
		         +student.getRollNo()+", Name : "+student.getName()+" ]");
	}
}
