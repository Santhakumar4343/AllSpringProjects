package com.payrollmanagement.serviceImpl;



import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.entity.Salary;
import com.payrollmanagement.repository.SalaryRepo;
import com.payrollmanagement.service.SalaryService;

@Service
public class Salaryserviceimpl implements SalaryService {

	@Autowired
	private SalaryRepo Erepo;

	String ss;

	String lastValueCheck() {
	

		String currentValuee = Erepo.lastValueCheck();
		return ss = currentValuee;
	}

	@Override
	public Salary saveEmpp(Salary e) {

		// Tax Calculation
		double Prof_tax = e.getProfTax() / 100 * e.getNetSalary();
		double Tds = e.getAbsent() / 100 * e.getNetSalary();
		double Taxs = Prof_tax + Tds;
		double after_Tax = e.getNetSalary() - Taxs;

		// Deduction of Absents Amounts
		int absents = e.getAbsent();
		double absentsAmountPerDay = e.getNetSalary() / 30;
		double totalAbsentsAmountPerCount = 0;
		for (int i = 1; i <= absents; i++) {
			totalAbsentsAmountPerCount = totalAbsentsAmountPerCount + absentsAmountPerDay;
		}
		double after_Absents = after_Tax - totalAbsentsAmountPerCount;

		// Deduction of Leaves Amounts
		int leaves = e.getLeaves();
		double LeavesAmountPerDay = 0.0;
		double perDay = e.getNetSalary() / 30;

		if (leaves > 1) {
			for (int i = 1; i <= (leaves - 1); i++) {
				LeavesAmountPerDay = (double) LeavesAmountPerDay + perDay;
			}
		}
		double after_leaves = after_Absents - LeavesAmountPerDay;

		// Bonus Addition
		double bonus = e.getBonus();
		double after_bouns = after_leaves + ((bonus / 100) * (after_leaves));

		// after_loans Deduction
		double after_loans = after_bouns - e.getLeaves();

		// after_appp_amont Addition
		double after_appp_amont = after_loans + e.getApprPoints();

		// after_Waring_amont Addition
		double after_Waring_amont = after_appp_amont - e.getWarningPoints();

		// After All Transactions Over all salary is settled
		e.setFinalSalary(after_Waring_amont);

//		String jdbcUrl = "jdbc:mysql://localhost:3306/pranav"; // Replace with your database URL
//		String username = "root"; // Replace with your database username
//		String password = "1234"; // Replace with your database password

		if (lastValueCheck() != null) {

			System.out.println("IF part..");
			int jj = Integer.parseInt(ss) + 1;

			final DecimalFormat decimalFormattt = new DecimalFormat("000");
			String ee = decimalFormattt.format(jj);

			String s = "SAL";

			DateFormat df = new SimpleDateFormat("YY"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime());

			DateFormat dff = new SimpleDateFormat("MM"); // Just the year, with 2 digits
			String formattedDatee = dff.format(Calendar.getInstance().getTime());

			String Concatenated = s + formattedDate + formattedDatee + ee;

			e.setTransactionId(Concatenated);

		} else {

			System.out.println("ELSE part..");

			String s = "SAL";

			DateFormat df = new SimpleDateFormat("YY"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime());

			DateFormat dff = new SimpleDateFormat("MM"); // Just the year, with 2 digits
			String formattedDatee = dff.format(Calendar.getInstance().getTime());

			final DecimalFormat decimalFormat = new DecimalFormat("000");

			int u = 0;

			int o = ++u;

			String j = decimalFormat.format(o);

			String Concatenated = s + formattedDate + formattedDatee + j;

			e.setTransactionId(Concatenated);

		}

	e.setAddEmployee(e.getAddEmployee()  );
		
		
		return Erepo.save(e);

	}


	@Override
	public Salary getEmppThroughTransID(String transaction_Id) {
		
		return	Erepo.findById(transaction_Id).get();
		 
	}


	@Override
	public List<Salary> getEmppThroughEmpID(AddEmployee addEmployee) {
		
		
		
		return Erepo.findByAddEmployee(addEmployee);
	}


	
	
	// to write the final salary in the words 
	@Override
	  public  String convertToIndianCurrency(double finalSalary) {
	        BigDecimal bd = new BigDecimal(finalSalary);
	        long number = bd.longValue();
	        long no = bd.longValue();
	        int decimal = (int) (bd.remainder(BigDecimal.ONE).doubleValue() * 100);
	        int digits_length = String.valueOf(no).length();
	        int i = 0;
	        ArrayList<String> str = new ArrayList<>();
	        HashMap<Integer, String> words = new HashMap<>();
	        words.put(0, "");
	        words.put(1, "One");
	        words.put(2, "Two");
	        words.put(3, "Three");
	        words.put(4, "Four");
	        words.put(5, "Five");
	        words.put(6, "Six");
	        words.put(7, "Seven");
	        words.put(8, "Eight");
	        words.put(9, "Nine");
	        words.put(10, "Ten");
	        words.put(11, "Eleven");
	        words.put(12, "Twelve");
	        words.put(13, "Thirteen");
	        words.put(14, "Fourteen");
	        words.put(15, "Fifteen");
	        words.put(16, "Sixteen");
	        words.put(17, "Seventeen");
	        words.put(18, "Eighteen");
	        words.put(19, "Nineteen");
	        words.put(20, "Twenty");
	        words.put(30, "Thirty");
	        words.put(40, "Forty");
	        words.put(50, "Fifty");
	        words.put(60, "Sixty");
	        words.put(70, "Seventy");
	        words.put(80, "Eighty");
	        words.put(90, "Ninety");
	        String digits[] = {"", "Hundred", "Thousand", "Lakh", "Crore"};
	        while (i < digits_length) {
	            int divider = (i == 2) ? 10 : 100;
	            number = no % divider;
	            no = no / divider;
	            i += divider == 10 ? 1 : 2;
	            if (number > 0) {
	                int counter = str.size();
	                String plural = (counter > 0 && number > 9) ? "s" : "";
	                String tmp = (number < 21) ? words.get(Integer.valueOf((int) number)) + " " + digits[counter] + plural : words.get(Integer.valueOf((int) Math.floor(number / 10) * 10)) + " " + words.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] + plural;                
	                str.add(tmp);
	            } else {
	                str.add("");
	            }
	        }
	 
	        Collections.reverse(str);
	        String Rupees = String.join(" ", str).trim();
	 
	      
	        return   Rupees + " Rupees " ;
	    }

	
	
	




}