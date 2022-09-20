package org.sdet40.genericUtility;

/**
 * This interface consists all the external file paths
 * @author MOHAN GOWDA
 *
 */
public interface IConstantPath {
	//variable, method name= camelcase
	//interface, class, enum, annotion = Pascel Case
	//static final member ==> CAPICAL
	String PROJECT_PATH=System.getProperty("user.dir");
	String EXCEL_PATH= PROJECT_PATH+"/src/test/resources/testData.xlsx";
	String PROPERTY_FILE_PATH=PROJECT_PATH+"/src/test/resources/commonData.properties";
	String DB_URL="jdbc:mysql://localhost:3306/tyss";
}
