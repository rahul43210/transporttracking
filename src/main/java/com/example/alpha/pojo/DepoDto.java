package com.example.alpha.pojo;

import java.util.List;

import com.example.alpha.model.Depo;
import com.example.alpha.model.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class DepoDto {

	private Integer id;

	private String depoName;

	private String depoStationCode;

	private String city;

	private String state;

	private String pincode;

	private Integer route;

	private Integer totalEmployees;

	private Integer totalWorker;

	private List<EmployeeDto> employee;

	private String licenseNumber;

	private Integer revenu;
	
	private String uniqueId;

	public DepoDto() {
		super();
	}

	public DepoDto(final Depo depo) {
		super();
		this.id = depo.getId();
		this.depoName = depo.getDepoName();
		this.depoStationCode = depo.getDepoStationCode();
		this.city = depo.getCity();
		this.state = depo.getState();
		this.pincode = depo.getPincode();
		this.route = depo.getRoute();
		this.totalEmployees = depo.getTotalEmployees();
		this.totalWorker = depo.getTotalWorker();
		this.licenseNumber = depo.getLicenseNumber();
		this.revenu = depo.getRevenu();
		if (depo.getEmployee() != null) {
			this.employee = depo.getEmployee().stream().map(EmployeeDto::new).toList();
		}
		this.uniqueId = depo.getUniqueId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepoName() {
		return depoName;
	}

	public void setDepoName(String depoName) {
		this.depoName = depoName;
	}

	public String getDepoStationCode() {
		return depoStationCode;
	}

	public void setDepoStationCode(String depoStationCode) {
		this.depoStationCode = depoStationCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Integer getRoute() {
		return route;
	}

	public void setRoute(Integer route) {
		this.route = route;
	}

	public Integer getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(Integer totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public Integer getTotalWorker() {
		return totalWorker;
	}

	public void setTotalWorker(Integer totalWorker) {
		this.totalWorker = totalWorker;
	}

	public List<EmployeeDto> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeDto> employee) {
		this.employee = employee;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Integer getRevenu() {
		return revenu;
	}

	public void setRevenu(Integer revenu) {
		this.revenu = revenu;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	
}
