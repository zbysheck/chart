package charts;

import java.io.IOException;
import java.util.Iterator;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;

public class Chart extends Application {

	/**
	 * 
	 * @param lineTab
	 * @param type 1-line chart, 2-bar chart, 3-pie chart (to go)
	 * @throws BiffException
	 * @throws IOException
	 */
	private void setLineTab(Tab lineTab, int type) throws BiffException, IOException
	{
		//lineTab.setText("Line Chart"); 
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final LineChart<String,Number> llc = new LineChart<String,Number>(xAxis,yAxis);
		final BarChart<String,Number> lc = new BarChart<String,Number>(xAxis,yAxis);
			
		switch(type){
		case 1:
			break;
		case 2:
			break;
		default:
		}
		
		Data d=new Data("tem.xls");
		d.read(true);
		d.show();

		lc.setTitle(d.getFilename());
		//xAxis.setLabel(d.h1);
		//yAxis.setLabel(d.h2); 

		XYChart.Series[] ser = new XYChart.Series[d.getColumns()+1];
		for(int i=0;i<d.getColumns();i++){
			System.out.println(d.getColumns());
			System.out.println(i);
			ser[i] = new XYChart.Series();
		}
		
		for(int i=0;i<d.getColumns();i++){
			ser[i].setName(d.hc[i]);
			for(int j=0;j<d.getRows();j++){
				ser[i].getData().add(new XYChart.Data(d.hr[j],d.getValue(i,j)));
			}
			lc.getData().addAll(ser[i]); 
		}
        lineTab.setContent(lc); 
	}
	public static void main(String args[])
	{  
		launch(args);  
	}  
	/*  
	 * start method to show and initiate primary stage*/  
	@Override  
	public void start(Stage primaryStage) throws Exception 
	{  
		init(primaryStage);  
		primaryStage.show();  
	}  
	/*  
	 * init method to initialize the primary stage*/  
	private void init(Stage primaryStage) throws BiffException, IOException 
	{  
		/* To Set the title of the stage */  
		primaryStage.setTitle("Charts");  
		/*  
		 * Definition of new Group root to be set and displayed as scene*/  
		Group root = new Group();  
		primaryStage.setScene(new Scene(root));  
		/*  
		 * Definition of BorderPane and TabPane*/  
		BorderPane borderPane = new BorderPane();  
		final TabPane tabPane = new TabPane();  
		/*To Set Preferred Dimensions*/  
		tabPane.setPrefSize(600, 400);  
		tabPane.setSide(Side.TOP);  
		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);  

		/*  
		 * Definition of New Tab : LineTab*/  
		final Tab LineTab = new Tab();
		setLineTab(LineTab,1);  

		/*Addition of tabs to TabPane*/ 
		tabPane.getTabs().addAll(LineTab);  
		borderPane.setCenter(tabPane);  
		root.getChildren().add(borderPane);  
	}

}
