package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//API_EXcel.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 0);
		String Apidata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {

				Apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}

		}

		return Apidata;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserName() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//API_EXcel.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
  
		String Api[] = new String[rownum];
		for (int i = 1; i <= rownum; i++) {
			Api[i - 1] = xl.getCellData("Sheet1", i, 1);

		}

		return Api;

	}

}
