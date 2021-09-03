package com.admin.bean;

public class Hotel {
	
		int no,number;
		String name, designation;
         
		public Hotel()
		{
			no=0;
			
		}
		

		public Hotel(String name, int number, String designation, int no) {
			super();
			this.no = no;
			this.name = name;
			this.number = number;
			this.designation = designation;
		}


		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

	}



