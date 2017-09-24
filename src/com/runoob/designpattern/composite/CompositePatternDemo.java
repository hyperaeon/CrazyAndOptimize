package com.runoob.designpattern.composite;

public class CompositePatternDemo {

	public static void main(String[] args) {
		Employee ceo = new Employee("John", "CEO", 30000);
		Employee headSales = new Employee("Robert", "Head sales", 20000);
		Employee headMarketing = new Employee("Mechaels", "Head Marketing", 20000);
		Employee clerk1 = new Employee("Laular", "Marketing", 10000);
		Employee clerk2 = new Employee("Swoesl", "Marketing", 10000);
		
		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "MaSalesrketing", 10000);
		
		ceo.add(headSales);
		ceo.add(headMarketing);
		
		headSales.add(clerk1);
		headSales.add(clerk2);
		
		headMarketing.add(salesExecutive1);
		headMarketing.add(salesExecutive2);
		
		System.out.println(ceo);
		for (Employee headEmployee : ceo.getSubordinates()) {
			System.out.println(headEmployee);
			for (Employee clerkEmployee : headEmployee.getSubordinates()) {
				System.out.println(clerkEmployee);
			}
		}
	}
}
