package AccesoADato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.selenium.Utiles.*;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// ** Este metodo es para invocar al archivo excel y hacer referencia a la hoja
	// donde vamos a obtener los datos **//
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			Utiles.escribir("Abrir el archivo excel");
			FileInputStream ExcelFile = new FileInputStream(Path);
			Utiles.escribir("Acceder a la hoja del excel indicada para obtener datos");
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	// ** Este Metodo lee los datos del cada celda del excel
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "No se pudo obtener dato";
		}
	}

	// **Crear un objeto con los datos enviados en el excel **//
	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow, int columnas)
			throws Exception {
		String[][] tabArray = null;
		try {
			setExcelFile(FilePath, SheetName);
			int startCol = 0, ci = 0, cj = 0, totalRows = iTestCaseRow, totalCols = columnas;
			tabArray = new String[totalRows][totalCols];
			for (int ley = 1; ley <= iTestCaseRow; ley++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(ley, j);
					System.out.println(tabArray[ci][cj]);
				}
				ci++;
			}
		} catch (FileNotFoundException e) {
			Utiles.escribir("No se puedo abrir el excel");
			System.out.println("No se pudo abrir el excel");
			e.printStackTrace();
		} catch (IOException e) {
			Utiles.escribir("No se puedo abrir el excel");
			System.out.println("No se pudo abrir el excel");
			e.printStackTrace();
		}
		return (tabArray);
	}

	// ** Metodos para determinar cuantas filas se enviaron **//
	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}

}
