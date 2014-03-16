package charts;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import jxl.read.biff.BiffException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Data {

	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String str) {
		filename=str;
	}


	public String[] hc, hr;
	private int rows, columns;
	private Sheet s;
	private float[][] v;
	public float getValue(int x, int y) {
		return v[x][y];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	private void vInit(){
		float[][] v=new float[rows][];
		for(int i=0;i<rows;i++){
			v[i]=new float[columns];
		}
	}



	LinkedHashMap <String, Float> vv = new LinkedHashMap<String, Float>();


	public Data(String str){
		filename=str;
	}

	public void init() throws BiffException, IOException{
		//otwarcie dokumentu i wybór dokumentu
		Workbook w = Workbook.getWorkbook(new File(filename));
		s = w.getSheet(0);
	}

	public void read(boolean headers)throws IOException, BiffException {
		init();
		rows=s.getRows();
		columns=s.getColumns();
		vInit();
		hRead();



		for(int i=1;i<rows-1;i++){
			System.out.print("dupa: ");
			System.out.print(s.getRows());
			System.out.println(rows);

			//System.out.println(sheet.getRows());
			System.out.println(s.getCell(0,i).getContents());
			System.out.println(Float.parseFloat(s.getCell(1, i).getContents()));
			vv.put(s.getCell(0,i).getContents(),Float.parseFloat(s.getCell(1, i).getContents()));
			/*
			Cell c=s.getCell(1,	i);
			if(c== null){
				System.out.println("dupa");
			}else{
				System.out.println(c.getContents());
			}*/
		}
	}

	private void hRead() {
		String[] hc=new String[columns];
		String[] hr=new String[rows];
		for(int i=1;i<rows;i++){
			hr[i]=s.getCell(0,i).getContents();
		}
		for(int i=1;i<columns;i++){
			hc[i]=s.getCell(i,0).getContents();
		}

	}
	public void show(){/*
		Set set=vv.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public void showf(){
		Iterator<String> it=vv.keySet().iterator();
		System.out.println("pen");
		while(it.hasNext()){
			System.out.println(it.next());
			//System.out.println("dupa");
		}
	}


	public void gmain(String[] args) throws IOException, BiffException {
		filename="tem.xls";
		read(true);
		show();
		//otwarcie dokumentu i wybór dokumentu
		Workbook workbook = Workbook.getWorkbook(new File("temp.xls"));
		Sheet sheet = workbook.getSheet(0);

		//odczyt i wyświetlenie nagłówka
		Cell cell = sheet.getCell(1, 0);
		String head = cell.getContents();
		System.out.println(head);

		//odczyt i wyświetlenie liczb
		for(int i=1; i<=5; i++){
			cell = sheet.getCell(1, i);
			System.out.println(cell.getContents());
		}

		//zamknięcie dokumentu
		workbook.close();
		System.out.println("Odczyt zakończony sukcesem.");
	}



}
