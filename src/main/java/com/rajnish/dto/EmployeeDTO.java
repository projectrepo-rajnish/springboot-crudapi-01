package com.rajnish.dto;

public class EmployeeDTO {
	 
		private int id;
		private String firstName;
		private String lastName;
		private String emailid;
		private int salary;
		private String city;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public EmployeeDTO(int id, String firstName, String lastName, String emailid, int salary, String city) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailid = emailid;
			this.salary = salary;
			this.city = city;
		}
		public EmployeeDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((emailid == null) ? 0 : emailid.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + id;
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + salary;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EmployeeDTO other = (EmployeeDTO) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (emailid == null) {
				if (other.emailid != null)
					return false;
			} else if (!emailid.equals(other.emailid))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (salary != other.salary)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailid="
					+ emailid + ", salary=" + salary + ", city=" + city + "]";
		}
		
		
}
