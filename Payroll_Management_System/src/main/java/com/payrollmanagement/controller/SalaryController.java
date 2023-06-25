package com.payrollmanagement.controller;




import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.payrollmanagement.entity.AddCandidate;
import com.payrollmanagement.entity.AddEmployee;
import com.payrollmanagement.entity.Salary;
import com.payrollmanagement.repository.AddCandidateRepo;
import com.payrollmanagement.repository.SalaryRepo;
import com.payrollmanagement.service.SalaryService;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/api")
public class SalaryController {

	@Autowired
	private SalaryService serviceInter;
	@Autowired
	private AddCandidateRepo addCandidateRepo;
	
	@Autowired
	private SalaryRepo ERepo;
	
	
		// save details for pranav EMP (salary)
	@PostMapping("/details")
	public Salary Details(@RequestBody Salary e) {

		return serviceInter.saveEmpp(e);

	}

	
	
	
	
	
	
	@PutMapping("/detailsCanUpdate/{addEmployee}")
	public Salary CandidateDetailsUpdate(@RequestBody Salary ep,@PathVariable("addEmployee") AddEmployee addEmployee) {

		List<Salary> optional = serviceInter.getEmppThroughEmpID(addEmployee);
		
		
		Salary empToUpdate = optional.get(0);
		    empToUpdate.setAddEmployee(ep.getAddEmployee());
		    empToUpdate.setMonth(ep.getMonth());
		    empToUpdate.setYear(ep.getYear());
		    empToUpdate.setLeaves(ep.getLeaves());
		    empToUpdate.setLoans(ep.getLoans());
		    empToUpdate.setProfTax(ep.getProfTax());
		    empToUpdate.setAbsent(ep.getAbsent());
		    empToUpdate.setApprPoints(ep.getApprPoints());
		    empToUpdate.setWarningPoints(ep.getWarningPoints());
		    empToUpdate.setDelayPoints(ep.getDelayPoints());
		    empToUpdate.setAllowances(ep.getAllowances());
		    empToUpdate.setBonus(ep.getBonus());
		    empToUpdate.setNetSalary(ep.getNetSalary());
		    empToUpdate.setTds(ep.getTds());
		    empToUpdate.setTransactionDate(ep.getTransactionDate());
		    empToUpdate.setSourceBank(ep.getSourceBank());
		    empToUpdate.setCreditedBy(ep.getCreditedBy());
		   
		    
		return serviceInter.saveEmpp(empToUpdate);

	}

	
	
	// Get Candidate Id through EmpId
	@GetMapping("/getCandidateThroughQuery/{addEmployee}")
	public String getCandidateIdByEmpId(AddEmployee addEmployee) {
	    return ERepo.findCandidateIdByEmpId(addEmployee);
	}
	
	
	
	
	
	// generate document of payslip of employee
	@GetMapping("/pdf/{addEmployee}")
	public void generatePdf(@PathVariable("addEmployee") AddEmployee addEmployee, HttpServletResponse response)
			throws IOException, DocumentException {

		List<Salary> personList = serviceInter.getEmppThroughEmpID(addEmployee);
		Salary firstPerson = personList.get(0);
		
		String firstName = firstPerson.getTransactionId();

		String lastName = firstPerson.getMonth();
		
		int age = firstPerson.getYear();
		
		 
		
		
		
		String OEmpId="";
		for (Salary person1 : personList) {


			OEmpId =person1.getAddEmployee().getEmpId();

		}
		
		String candidate_Id ="";
	for (Salary person2 : personList) {

			candidate_Id	= ERepo.findCandidateIdByEmpId(person2.getAddEmployee()); ;
		}
	System.err.print(candidate_Id);
           Optional <AddCandidate> details = addCandidateRepo.findById(candidate_Id);
           AddCandidate can = details.get();
		
        
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"person.pdf\"");

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		
		
		
		Font font = new Font(Font.FontFamily.HELVETICA, 26, Font.BOLD);
		Paragraph heading = new Paragraph("PAY SLIP", font);
		heading.setAlignment(Element.ALIGN_CENTER);
		heading.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, 40));
		heading.setSpacingAfter(30);
		document.add(heading);
		
		
		String account_HolderName="";
		String account_Number="";
		String bank_Name="";
		String ifsc_Code="";
		String pan_Card	="";
		String blood_Group="";
		String nominee="";
		String Nominee_Contact="";
		String branch="";
		String Joining_Date	="";
		for (Salary person : personList) {

		
		 account_HolderName	= String.valueOf(person.getAddEmployee().getAccountHolderName()  );
		 account_Number	= String.valueOf(person.getAddEmployee().getAccountNumber()  );
		 bank_Name	= String.valueOf(person.getAddEmployee().getBankName() );
		 ifsc_Code	= String.valueOf(person.getAddEmployee().getIfscCode()  );
		 pan_Card	= String.valueOf(person.getAddEmployee().getPanCard()  );
		 blood_Group	= String.valueOf(person.getAddEmployee().getBloodGroup()  );
		 nominee	= String.valueOf(person.getAddEmployee().getNominee()  );
		 Nominee_Contact	= String.valueOf(person.getAddEmployee().getNomineeContact() );
		 branch	= String.valueOf(person.getAddEmployee().getBranch() );
		 Joining_Date	= String.valueOf(person.getAddEmployee().getJoiningDate() );


		}
		
		
		
		//AddEmpolyee data in the form of table form database
		PdfPTable tableofAddEmployee = new PdfPTable(2); // 2 columns
		tableofAddEmployee.setWidthPercentage(105);
		tableofAddEmployee.setSpacingBefore(10f);
		tableofAddEmployee.setSpacingAfter(10f);

		// Add table headers
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("Employee Name")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase( can.getFirstName()  +"  " + can.getLastName() )));
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("account HolderName")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase(   account_HolderName )));

		tableofAddEmployee.addCell(new PdfPCell(new Phrase("account Number")));
	
		String maskedAccountNumber = "XXXXXXXXXXXX" + account_Number.substring(account_Number.length() - 4);
		tableofAddEmployee.addCell(new PdfPCell(new Phrase(  maskedAccountNumber  )));
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("bank Name")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase( bank_Name   )));

		tableofAddEmployee.addCell(new PdfPCell(new Phrase("ifsc Code")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase(   ifsc_Code )));
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("pan_Card")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase(  pan_Card  )));
			
		
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("Email")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase( can.getEmail()  )));
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("phoneNumber")));
	tableofAddEmployee.addCell(new PdfPCell(new Phrase(  can.getPhoneNumber() )) );
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("Address")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase(   can.getAddress()  )));
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("branch")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase(  branch  )));
		
		tableofAddEmployee.addCell(new PdfPCell(new Phrase("Joining Date")));
		tableofAddEmployee.addCell(new PdfPCell(new Phrase( Joining_Date   )));
		
				document.add(tableofAddEmployee);
		

		
		// Creating table to store data
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);

		PdfPTable table2 = new PdfPTable(2);
		table2.setWidthPercentage(100); 
		
		table2.setSpacingBefore(10f);
		table2.setSpacingAfter(10f);

		PdfPTable table3 = new PdfPTable(2);
		table3.setWidthPercentage(100);
		table3.setSpacingBefore(10f);
		table3.setSpacingAfter(10f);

		PdfPTable table4 = new PdfPTable(2);
		table4.setWidthPercentage(100);
		table4.setSpacingBefore(10f);
		table4.setSpacingAfter(10f);
		
		PdfPTable table5 = new PdfPTable(2);
		table5.setWidthPercentage(100);
		table5.setSpacingBefore(10f);
		table5.setSpacingAfter(10f);

		PdfPTable table6 = new PdfPTable(2);
		table6.setWidthPercentage(100);
		table6.setSpacingBefore(10f);
		table6.setSpacingAfter(10f);
		
		PdfPTable table7 = new PdfPTable(2);
		table7.setWidthPercentage(100);
		table7.setSpacingBefore(10f);
		table7.setSpacingAfter(10f);
		
		PdfPTable table8 = new PdfPTable(2);
		table8.setWidthPercentage(100);
		table8.setSpacingBefore(10f);
		table8.setSpacingAfter(10f);
		
		PdfPTable table9 = new PdfPTable(2);
		table9.setWidthPercentage(100);
		table9.setSpacingBefore(10f);
		table9.setSpacingAfter(10f);
		
		PdfPTable table10 = new PdfPTable(2);
		table10.setWidthPercentage(100);
		table10.setSpacingBefore(10f);
		table10.setSpacingAfter(10f);
		
		// Adding table headers

		PdfPCell cell1 = new PdfPCell(new Paragraph("transaction Id"));
	
		
		PdfPCell cell2 = new PdfPCell(new Paragraph("empId"));

		PdfPCell cell3 = new PdfPCell(new Paragraph("month"));

		PdfPCell cell4 = new PdfPCell(new Paragraph("year"));

		PdfPCell cell5 = new PdfPCell(new Paragraph("leaves"));

		PdfPCell cell6 = new PdfPCell(new Paragraph("loans"));

		PdfPCell cell7 = new PdfPCell(new Paragraph("prof Tax"));

		PdfPCell cell8 = new PdfPCell(new Paragraph("absent"));

		PdfPCell cell9 = new PdfPCell(new Paragraph("appr Points"));

		PdfPCell cell10 = new PdfPCell(new Paragraph("warning Points"));

		PdfPCell cell11 = new PdfPCell(new Paragraph("delay Points"));

		PdfPCell cell12 = new PdfPCell(new Paragraph("allowances"));

		
		
		PdfPCell cell13 = new PdfPCell(new Paragraph("bonus"));

		PdfPCell cell14 = new PdfPCell(new Paragraph("net Salary"));

		PdfPCell cell15 = new PdfPCell(new Paragraph("tds"));

		PdfPCell cell16 = new PdfPCell(new Paragraph("transaction Date"));

		PdfPCell cell17 = new PdfPCell(new Paragraph("source Bank"));

		PdfPCell cell18 = new PdfPCell(new Paragraph("credited By"));
		
		PdfPCell cell19 = new PdfPCell(new Paragraph("final Salary"));
		table.addCell(cell1);
		table.addCell(cell2);
		
		table2.addCell(cell11);
		table2.addCell(cell12);
		
		
		table3.addCell(cell3);
		table3.addCell(cell4);
	

		table4.addCell(cell5);
		table4.addCell(cell6);
		
		table5.addCell(cell7);
		table5.addCell(cell8);
		
		table6.addCell(cell9);		
		table6.addCell(cell10);
		
		table7.addCell(cell13);
		
		
		table8.addCell(cell15);
		table8.addCell(cell16);
		
		table9.addCell(cell17);
		table9.addCell(cell18);
		
		table10.addCell(cell14);
		table10.addCell(cell19);

		// Adding person data to table

		
			PdfPCell transaction_Id = new PdfPCell(new Paragraph(firstPerson.getTransactionId()));
			
			PdfPCell empId = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getAddEmployee().getEmpId())));
	
		table.addCell(transaction_Id);
			table.addCell(empId);



			PdfPCell delay_Points = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getDelayPoints())));

			PdfPCell allowances = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getAllowances())));
		

			table2.addCell(delay_Points);

			table2.addCell(allowances);


		PdfPCell month = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getMonth())));
			PdfPCell year = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getYear())));
			table3.addCell(month);
		table3.addCell(year);



			PdfPCell leaves = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getLeaves())));
			PdfPCell loans = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getLoans())));
			table4.addCell(leaves);
			table4.addCell(loans);


			PdfPCell prof_Tax = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getProfTax())));
			PdfPCell absent = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getAbsent())));
			table5.addCell(prof_Tax);
			table5.addCell(absent);


			PdfPCell appr_Points = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getApprPoints())));
			PdfPCell warning_Points = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getWarningPoints())));

			table6.addCell(appr_Points);
			table6.addCell(warning_Points);


		
		
	
		
			
		PdfPCell cell = new PdfPCell(new Phrase(String.valueOf( firstPerson.getBonus()   )));
		table7.addCell(cell);
	

		
		table7.addCell("YOU");
	
			
			
	
	
	

			
			PdfPCell tds = new PdfPCell(new Paragraph(String.valueOf(    firstPerson.getTds()          )));
			
			PdfPCell transaction_Date = new PdfPCell(new Paragraph(String.valueOf(   firstPerson.getTransactionDate()   )));
		
			
			table8.addCell(tds);
			
			table8.addCell(transaction_Date);
		
			
	
		
		
		
		


			PdfPCell source_Bank = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getSourceBank())));

			PdfPCell credited_By = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getCreditedBy())));
		
			
			table9.addCell(source_Bank);
			
		
		table9.addCell(credited_By);
	
		

		
			
			PdfPCell net_Salary = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getNetSalary())));
			PdfPCell final_Salary = new PdfPCell(new Paragraph(String.valueOf(firstPerson.getFinalSalary())));
			table10.addCell(net_Salary);
		table10.addCell(final_Salary);
	
		
		
		// create parent table with two columns
		PdfPTable parentTable = new PdfPTable(2);
		parentTable.setWidthPercentage(80);
		parentTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		// add left and right tables to the parent table
		PdfPCell leftCell = new PdfPCell(table);
		leftCell.setBorder(Rectangle.NO_BORDER);
		parentTable.addCell(leftCell);

		PdfPCell rightCell = new PdfPCell(table2);
		rightCell.setBorder(Rectangle.NO_BORDER);
		parentTable.addCell(rightCell);
		
		
		// add left and right tables to the parent table 2
		PdfPTable parentTable2 = new PdfPTable(2);
		parentTable2.setWidthPercentage(80);
		parentTable2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		
		
		PdfPCell leftCell2 = new PdfPCell(table3);
		leftCell2.setBorder(Rectangle.NO_BORDER);
		parentTable2.addCell(leftCell2);
		
		PdfPCell rightCell2 = new PdfPCell(table4);
		rightCell2.setBorder(Rectangle.NO_BORDER);
		parentTable2.addCell(rightCell2);
		
		// add left and right tables to the parent table 3
		PdfPTable parentTable3 = new PdfPTable(2);
		parentTable2.setWidthPercentage(80);
		parentTable2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		
		
		PdfPCell leftCell3 = new PdfPCell(table5);
		leftCell3.setBorder(Rectangle.NO_BORDER);
		parentTable3.addCell(leftCell3);
		
		PdfPCell rightCell3 = new PdfPCell(table6);
		rightCell3.setBorder(Rectangle.NO_BORDER);
		parentTable3.addCell(rightCell3);
//		
		
		
		// add left and right tables to the parent table 4
		PdfPTable parentTable4 = new PdfPTable(2);
		parentTable4.setWidthPercentage(80);
		parentTable4.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		
		
		PdfPCell leftCell4 = new PdfPCell(table7);
		leftCell4.setBorder(Rectangle.NO_BORDER);
		parentTable4.addCell(leftCell4);
		
		PdfPCell rightCell4 = new PdfPCell(table8);
		rightCell4.setBorder(Rectangle.NO_BORDER);
		parentTable4.addCell(rightCell4);
		
		// add left and right tables to the parent table 5
				PdfPTable parentTable5 = new PdfPTable(2);
				parentTable5.setWidthPercentage(80);
				parentTable5.getDefaultCell().setBorder(Rectangle.NO_BORDER);
				
				
				
				
				
				// add left and right tables to the parent table 6
				PdfPTable parentTable6 = new PdfPTable(1);
				parentTable6.setWidthPercentage(80);
				parentTable6.getDefaultCell().setBorder(Rectangle.NO_BORDER);
				
				PdfPCell LeftCell6 = new PdfPCell(table9);
				// LeftCell6.setBorder(Rectangle.NO_BORDER);
				parentTable6.addCell(LeftCell6);
				
				PdfPCell rightCell6 = new PdfPCell(table10);
				rightCell6.setBorder(Rectangle.NO_BORDER);
				parentTable6.addCell(rightCell6);
				
			
	
				
//		document.add(table);
//		document.add(table2);
		
//		document.add(parentTable);
//		document.add(parentTable2);
//		
		
		PdfPTable combinedTable = new PdfPTable(1);
		combinedTable.setWidthPercentage(105);
		PdfPCell parentTableobj = new PdfPCell(parentTable);
		parentTableobj.setBorder(Rectangle.NO_BORDER);
		combinedTable.addCell(parentTableobj);
		
		PdfPCell parentTable2obj = new PdfPCell(parentTable2);
		parentTable2obj.setBorder(Rectangle.NO_BORDER);
		combinedTable.addCell(parentTable2obj);

		PdfPCell parentTable3obj = new PdfPCell(parentTable3);
		parentTable3obj.setBorder(Rectangle.NO_BORDER);
		combinedTable.addCell(parentTable3obj);
		
		PdfPCell parentTable4obj = new PdfPCell(parentTable4);
		parentTable4obj.setBorder(Rectangle.NO_BORDER);
		combinedTable.addCell(parentTable4obj);
		
		PdfPCell parentTable5obj = new PdfPCell(parentTable5);
		parentTable5obj.setBorder(Rectangle.NO_BORDER);
		combinedTable.addCell(parentTable5obj);
		
		PdfPCell parentTable6obj = new PdfPCell(parentTable6);
		parentTable6obj.setBorder(Rectangle.NO_BORDER);
		combinedTable.addCell(parentTable6obj);
		
		
		
		document.add(combinedTable);
		
		double final_Salaryy=0.0;
		
		//Final salary in words 
		for (Salary person : personList) {
			
			
			 final_Salaryy = person.getFinalSalary();
		
		
		}
		
		
		
		System.err.println( final_Salary );
	String inWords = serviceInter.convertToIndianCurrency( final_Salaryy  );
		
	     
        Paragraph paragraph = new Paragraph("Final Salary In Words : " + inWords);
        document.add(paragraph);


		try {
		// Load the image from file
		Image img = Image.getInstance("src\\main\\resources\\Images\\APT IT LOGO.png");

		// Set the position and dimensions of the image
		img.setAbsolutePosition(20, 20); // x, y are the coordinates of the lower-left corner of the image
		img.scaleAbsolute(80, 80 );

		// Add the image to the document
		document.add(img);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		document.close();

	}

	
	
	
	
	
	
	
	
	
	
	
}
