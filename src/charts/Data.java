package charts;

import java.io.File;
import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Data {

	private String filename;
	public String[] hc, hr;
	private int rows, columns;
	private Sheet s;
	private float[][] v;
	
	/**
	 * Initialize memory for 2D array with data
	 */
	private void vInit(){
		v=new float[columns][rows];
	}
	
	/**
	 * initializing spreadsheet from *.xls file
	 * @throws BiffException
	 * @throws IOException
	 */
	public void init() throws BiffException, IOException{
		Workbook w = Workbook.getWorkbook(new File(filename));
		s = w.getSheet(0);
	}

	/**
	 * constructor
	 * @param str name of the loaded file
	 */
	public Data(String str){
		filename=str;
	}

	public void read(boolean headers)throws IOException, BiffException {
		init();
		//decrementing rows and columns size (firts row and columns are reserved for labels etc.)
		rows=s.getRows()-1-1;//one for testing
		columns=s.getColumns()-1;
		vInit();
		hRead();

		for(int i=0;i<columns;i++){
			for(int j=0;j<rows;j++){
				v[i][j]=Float.parseFloat(s.getCell(i+1, j+1).getContents());
			}
		}
	}
	/**
	 * Reading headers for labeling purposes
	 */
	private void hRead() {
		hc=new String[columns];
		hr=new String[rows];
		for(int i=0;i<rows;i++){
			hr[i]=s.getCell(0,i+1).getContents();
			System.out.println("hr: "+hr[i]);
		}
		for(int i=0;i<columns;i++){
			hc[i]=s.getCell(i+1,0).getContents();
			System.out.println("hc: "+hc[i]);
		}

	}
	public void show(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				System.out.print(v[j][i]+" ");
			}
			System.out.println();
		}
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String str) {
		filename=str;
	}
	public float getValue(int x, int y) {
		return v[x][y];
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}



}
