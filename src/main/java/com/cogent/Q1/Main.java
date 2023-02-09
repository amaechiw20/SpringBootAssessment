package com.cogent.Q1;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 9, 2023
 */

public class Main {
	public static void main(String [] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml")) {
			Employee employee = (Employee) ctx.getBean("employee");
			System.out.println("----------------------------------------");
			System.out.println("Employe ID: " + employee.getEmpId());
			System.out.println("Employe Name: " + employee.getEmpName());
			System.out.println("Employe Salary: " + employee.getEmpSal());
			System.out.println("----------------------------------------");
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}
}