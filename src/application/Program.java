package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkLevel;

public class Program {

	public static void main(String[] args){

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmtLocalDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.next();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.next();
		System.out.print("Level: ");
		String workerLevel = sc.next();
		System.out.print("Base Salary: ");
		Double workerBaseSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker? ");
		Integer numContracts = sc.nextInt();
		
		Worker worker = new Worker(workerName,WorkLevel.valueOf(workerLevel),workerBaseSalary,new Department(departmentName));
		
		for (int i = 1; i <= numContracts; i++) {
			System.out.println("Enter contract #"+i+" data: ");
			System.out.print("Date (DD/MM/YYYY): ");
						
			LocalDate date = LocalDate.parse(sc.next(), fmtLocalDateTime);
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
				
			worker.addContract(new HourContract(date,valuePerHour,hours));
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
