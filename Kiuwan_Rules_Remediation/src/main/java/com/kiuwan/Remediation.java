package com.kiuwan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.violatedrule.ViolatedRuleBean;

public class Remediation {

	public static void main(String[] args) {

		if(args.length != 4) {
			System.out.println("You need to pass 4 parameters: username password applicationName xlsxFilePath");
			return;
		}

		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String filePath = args[3];
		
		File file = new File(filePath);   //creating a new file instance  
		FileInputStream fis;
		XSSFWorkbook wb = null;
		try {
			fis = new FileInputStream(file); 
			wb = new XSSFWorkbook(fis); //creating Workbook instance that refers to .xlsx file  
		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<ViolatedRuleBean> violatedRules = client.getViolatedRulesForApplication(applicationName);
			for (ViolatedRuleBean violatedRuleBean : violatedRules) {
				String ruleCode = violatedRuleBean.getRuleCode();
				System.out.println(ruleCode + " -> " +getRemediation(ruleCode, wb));
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
	}

	public static String getRemediation(String ruleC, XSSFWorkbook wb) {

		try {    
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file over each row 
			while (itr.hasNext()) {  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
				while (cellIterator.hasNext())  {  
					Cell cell = cellIterator.next(); 
					switch (cell.getColumnIndex()) {  
					case 0: //Excel Column 0 = RuleCode name
						String rulecode = cell.getStringCellValue();
						if (rulecode.equals(ruleC)) {
							while(cell.getColumnIndex() != 12) { //Get Excel column 12 = Remediation field
								cell = cellIterator.next(); 
							}
							return cell.getStringCellValue(); //Return Remediation
						}

					default:  
					}  
				}  
			}  
		}  
		catch(Exception e) {  
			return null;
		}
		return null;  
	}
}
