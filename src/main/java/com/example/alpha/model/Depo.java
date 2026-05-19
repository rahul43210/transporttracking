package com.example.alpha.model;

import java.util.List;

import com.example.alpha.pojo.DepoDto;
import com.example.alpha.utility.AppUtility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPO")
public class Depo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "DEPO_NAME")
    private String depoName;

    @Column(name = "DEPO_STATION_NAME")
    private String depoStationCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "ROUTE")
    private Integer route;

    @Column(name = "TOTAL_EMPLOYEES")
    private Integer totalEmployees;

    @Column(name = "TOTAL_WORKER")
    private Integer totalWorker;

    @OneToMany(mappedBy = "depo")
    private List<Employee> employee;

    @Column(name = "LICENSE_NUMBER")
    private String licenseNumber;

    @Column(name = "REVENU")
    private Integer revenu;
    
    @Column(name = "UNIQUE_ID", nullable = false, unique = true)
    private String uniqueId;

	public Integer getId() {
		return id;
	}

	public Depo() {
		super();
	}
	
	public Depo(DepoDto depoDto) {
		super();
		 this.depoName = depoDto.getDepoName();
		 this.depoStationCode = depoDto.getDepoStationCode();
		 this.city = depoDto.getCity();
		 this.state = depoDto.getState();
		 this.pincode = depoDto.getPincode();
		 this.route = depoDto.getRoute();
		 this.totalEmployees = depoDto.getTotalEmployees();
		 this.totalWorker = depoDto.getTotalWorker();
		 this.licenseNumber = depoDto.getLicenseNumber();
		 this.revenu = depoDto.getRevenu();
		 this.employee = depoDto.getEmployee().stream().map(Employee::new).toList();
		 if(depoDto.getUniqueId() != null) {
			 this.uniqueId = depoDto.getUniqueId();
		 } else {
			 this.uniqueId = AppUtility.generateUniqueId().toString();
		 }
		 
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
	 

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
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