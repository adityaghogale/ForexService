package com.cg.model;

/**
 * 
 * @author Aditya Ghogale
 *
 */

//interface is used as a projection to store data from custom query to table
//I referred this link(https://www.javaer101.com/en/article/6015226.html)
public interface ReportData {
	String getReportType();
	Double getProf();
}
