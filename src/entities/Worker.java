package entities;

import java.util.ArrayList;
import java.util.List;

import entities_enum.WorkLevel;

public class Worker {
	
	private String name;
	private WorkLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}
		
	public Worker(String name, WorkLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
		
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
		
	}
	
	public Double income(Integer year, Integer month) {
		//atribui o Salario Base na variavel sum
		Double sum = baseSalary;
		
		//percorrer a lista em busca do contrato que contenha o ano e mes informado
		for(HourContract c: contracts) {
			if(c.getDate().getMonthValue()==month && c.getDate().getYear()==year) {
				sum += c.totalValue();
			}
			
		}
		return sum; 
	}

}
