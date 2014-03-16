/*
 * A00177362
 */

package charts;

 import javafx.application.Application;  
 import javafx.collections.FXCollections;  
 import javafx.collections.ObservableList;  
 import javafx.geometry.Side;  
 import javafx.scene.Group;  
 import javafx.scene.Scene;  
 import javafx.scene.chart.BarChart;  
 import javafx.scene.chart.CategoryAxis;  
 import javafx.scene.chart.LineChart;
 import javafx.scene.chart.NumberAxis;  
 import javafx.scene.chart.PieChart;  
 import javafx.scene.chart.XYChart;  
 import javafx.scene.control.Tab;  
 import javafx.scene.control.TabPane;  
 //import javafx.scene.layout.BorderPane;  
 import javafx.stage.Stage;  


public class Charts extends Application 
{
      /*  
       * Main method: calls launch method to launch FX GUI*/  
      public static void smain(String args[])
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
      private void init(Stage primaryStage) 
      {  
           /* To Set the title of the stage */  
           primaryStage.setTitle("Charts");  
           /*  
            * Definition of new Group root to be set and displayed as scene*/  
           Group root = new Group();  
           primaryStage.setScene(new Scene(root));  
           /*  
            * Definition of BorderPane and TabPane*/  
           //BorderPane borderPane = new BorderPane();  
           final TabPane tabPane = new TabPane();  
           /*To Set Preferred Dimensions*/  
           tabPane.setPrefSize(900, 400);  
           tabPane.setSide(Side.TOP);  
           tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);  
           
            
           
           /*  
            * Definition of New Tab : BarTab*/  
           final Tab BarTab = new Tab();  
           setBarTab(BarTab);  
                      
           /*  
            * Definition of New Tab : LineTab*/  
           final Tab LineTab = new Tab();
           setLineTab(LineTab);  
           
           /*  
            * Definition of New Tab : PieTab*/  
           final Tab PieTab = new Tab();  
           setPieTab(PieTab); 
           
      }  
      
       /*  
       * Method BarTab*/  
      private void setBarTab(Tab barTab) 
      {
           barTab.setText("Bar Chart");  
           String Orange = "Orange";  
           String Apple = "Apple";  
           String Banana = "Banana";  
           String Lemon = "Lemon";  
           String Blueberry = "Blueberry";  
           final CategoryAxis xAxis = new CategoryAxis();  
           final NumberAxis yAxis = new NumberAxis();  
           
           final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);  
           
           bc.setTitle("Amount of Fruits Consumed in Years 2011-2013");  
           xAxis.setLabel("Fruits");      
           yAxis.setLabel("Amount");  
           XYChart.Series series1 = new XYChart.Series();  
           series1.setName("Year 2011");      
           series1.getData().add(new XYChart.Data(Orange, 2500));  
           series1.getData().add(new XYChart.Data(Apple, 3200));  
           series1.getData().add(new XYChart.Data(Banana, 10000));  
           series1.getData().add(new XYChart.Data(Lemon, 1200));  
           series1.getData().add(new XYChart.Data(Blueberry, 12000));     
           XYChart.Series series2 = new XYChart.Series();  
           
           series2.setName("Year 2012");  
           series2.getData().add(new XYChart.Data(Orange, 2750));  
           series2.getData().add(new XYChart.Data(Apple, 3255));  
           series2.getData().add(new XYChart.Data(Banana, 4500));  
           series2.getData().add(new XYChart.Data(Lemon, 1500));  
           series2.getData().add(new XYChart.Data(Blueberry, 18000));   
           XYChart.Series series3 = new XYChart.Series();  
           
           series3.setName("Year 2013");  
           series3.getData().add(new XYChart.Data(Orange, 4500));  
           series3.getData().add(new XYChart.Data(Apple, 10000));  
           series3.getData().add(new XYChart.Data(Banana, 18000));  
           series3.getData().add(new XYChart.Data(Lemon, 17100));  
           series3.getData().add(new XYChart.Data(Blueberry, 25221));  
           
           bc.getData().addAll(series1,series2,series3);  
           barTab.setContent(bc);  
      }  
      
       /*  
       * Method PieTab*/  
      private void setPieTab(Tab pieTab) 
      {  
           pieTab.setText("Pie Chart");  
           ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(  
           new PieChart.Data("Poland", 38000000),
           new PieChart.Data("Germany", 80000000),
           new PieChart.Data("France", 62000000),
           new PieChart.Data("Belgium", 5000000),
           new PieChart.Data("UK", 60000000),
           new PieChart.Data("Rep of Ireland", 3800000)); 
           final PieChart chart = new PieChart(pieChartData);  
           
           chart.setTitle("European Countries by Population");
           chart.setLabelLineLength(10);
           chart.setLegendSide(Side.RIGHT);
           chart.setClockwise(true);
           chart.setStartAngle(0);
           pieTab.setContent(chart);
      }  
      private void setLineTab(Tab lineTab)
      {
           lineTab.setText("Line Chart"); 
           final CategoryAxis xAxis = new CategoryAxis();
           final NumberAxis yAxis = new NumberAxis();          
           final LineChart<String,Number> lc = new LineChart<String,Number>(xAxis,yAxis); 
       
           lc.setTitle("Number of Teens With Cell Phones in Athlone");
           xAxis.setLabel("Age in Years");
           yAxis.setLabel("Number in Teens"); 
         
           XYChart.Series series1 = new XYChart.Series();
           XYChart.Series series2 = new XYChart.Series();
           
           series1.setName("Athlone");
        
           series1.getData().add(new XYChart.Data("Jan", 2300));
           series1.getData().add(new XYChart.Data("Feb", 2420));
           series1.getData().add(new XYChart.Data("Mar", 2500));
           series1.getData().add(new XYChart.Data("Apr", 2550));
           series1.getData().add(new XYChart.Data("May", 2600));
           series1.getData().add(new XYChart.Data("Jun", 1500));
           series1.getData().add(new XYChart.Data("Jul", 1650));
           series1.getData().add(new XYChart.Data("Aug", 1200));
           series1.getData().add(new XYChart.Data("Sep", 2700));
           series1.getData().add(new XYChart.Data("Oct", 2550));
           series1.getData().add(new XYChart.Data("Nov", 3000));
           series1.getData().add(new XYChart.Data("Dec", 3150)); 
           series2.setName("Athlone");
        
           series2.getData().add(new XYChart.Data("Jan", 300));
           series2.getData().add(new XYChart.Data("Feb", 420));
           series2.getData().add(new XYChart.Data("Mar", 500));
           series2.getData().add(new XYChart.Data("Apr", 550));
           series2.getData().add(new XYChart.Data("May", 600));
           series2.getData().add(new XYChart.Data("Jun", 500));
           series2.getData().add(new XYChart.Data("Jul", 650));
           series2.getData().add(new XYChart.Data("Aug", 200));
           series2.getData().add(new XYChart.Data("Sep", 700));
           series2.getData().add(new XYChart.Data("Oct", 550));
           series2.getData().add(new XYChart.Data("Nov", 000));
           series2.getData().add(new XYChart.Data("Dec", 150));     
           lc.getData().addAll(series1);  
           lc.getData().addAll(series2);  
           lineTab.setContent(lc); 
      }
    }
    
