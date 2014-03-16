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
 import javafx.scene.chart.AreaChart;
 import javafx.scene.chart.BarChart;  
 import javafx.scene.chart.BubbleChart;
 import javafx.scene.chart.CategoryAxis;  
 import javafx.scene.chart.LineChart;
 import javafx.scene.chart.NumberAxis;  
 import javafx.scene.chart.PieChart;  
 import javafx.scene.chart.ScatterChart;
 import javafx.scene.chart.XYChart;  
 import javafx.scene.control.Tab;  
 import javafx.scene.control.TabPane;  
 import javafx.scene.layout.BorderPane;  
 import javafx.stage.Stage;  


public class Charts extends Application 
{
      /*  
       * Main method: calls launch method to launch FX GUI*/  
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
           BorderPane borderPane = new BorderPane();  
           final TabPane tabPane = new TabPane();  
           /*To Set Preferred Dimensions*/  
           tabPane.setPrefSize(900, 400);  
           tabPane.setSide(Side.TOP);  
           tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);  
           
            
           /*  
            * Definition of New Tab : AreaTab*/  
           final Tab AreaTab = new Tab();
           setAreaTab(AreaTab);
           
           /*  
            * Definition of New Tab : BarTab*/  
           final Tab BarTab = new Tab();  
           setBarTab(BarTab);  
           
           /*  
           * Definition of New Tab : BubbleTab*/  
           final Tab BubbleTab = new Tab();
           setBubbleTab(BubbleTab);
           
           /*  
            * Definition of New Tab : LineTab*/  
           final Tab LineTab = new Tab();
           setLineTab(LineTab);  
           
           /*  
            * Definition of New Tab : PieTab*/  
           final Tab PieTab = new Tab();  
           setPieTab(PieTab); 
           
           /*  
           * Definition of New Tab : ScatterTab*/  
           final Tab ScatterTab = new Tab();
           setScatterTab(ScatterTab);  
           
           /*Addition of tabs to TabPane*/ 
           tabPane.getTabs().addAll(AreaTab,BarTab,BubbleTab,LineTab,PieTab,ScatterTab);  
           borderPane.setCenter(tabPane);  
           root.getChildren().add(borderPane);  
      }  
      
       private void setAreaTab(Tab areaTab)
      {
           areaTab.setText("Area Chart");
        
          final NumberAxis xAxis = new NumberAxis(1, 12, 1);
          xAxis.setMinorTickCount(0);    
          final NumberAxis yAxis = new NumberAxis(0, 15, 5);        
          yAxis.setMinorTickLength(yAxis.getTickLength());
          yAxis.setForceZeroInRange(false);        
        
          final AreaChart<Number,Number> ac = 
            new AreaChart<Number,Number>(xAxis,yAxis);       
          ac.setTitle("Results of Sample Analysis");
 
          XYChart.Series series1= new XYChart.Series();
          series1.setName("Batch 1");
          series1.getData().add(new XYChart.Data(2, 1));
          series1.getData().add(new XYChart.Data(3, 4));
          series1.getData().add(new XYChart.Data(4, 5));
          series1.getData().add(new XYChart.Data(6, 1));
          series1.getData().add(new XYChart.Data(7, 5));
                
          XYChart.Series series2 = new XYChart.Series();
          series2.setName("Batch 2");
          series2.getData().add(new XYChart.Data(0, 5));
          series2.getData().add(new XYChart.Data(3, 10));
          series2.getData().add(new XYChart.Data(1, 7));
          series2.getData().add(new XYChart.Data(5, 12));
          series2.getData().add(new XYChart.Data(2, 4));

          XYChart.Series series3 = new XYChart.Series();
          series3.setName("Batch 3");
          series3.getData().add(new XYChart.Data(0, 2));
          series3.getData().add(new XYChart.Data(5, 4));
          series3.getData().add(new XYChart.Data(6, 10));
          series3.getData().add(new XYChart.Data(9, 15));
          series3.getData().add(new XYChart.Data(1, 4));

          XYChart.Series series4 = new XYChart.Series();
          series4.setName("Batch 4");
          series4.getData().add(new XYChart.Data(0, 2));
          series4.getData().add(new XYChart.Data(3, 4));
          series4.getData().add(new XYChart.Data(6, 1));
          series4.getData().add(new XYChart.Data(9, 2));
          series4.getData().add(new XYChart.Data(2,10));
          ac.getData().addAll(series1,series2,series3,series4);
          areaTab.setContent(ac);        
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
      
       private void setBubbleTab(Tab bubbleTab)
      {
          bubbleTab.setText("Bubble Chart");
          final NumberAxis xAxis = new NumberAxis(1, 70, 5);
          final NumberAxis yAxis = new NumberAxis(0, 80, 10);
          final BubbleChart<Number,Number> blc = new
                BubbleChart<Number,Number>(xAxis,yAxis);
          xAxis.setLabel("Range");
          yAxis.setLabel("Capacity");
          blc.setTitle("Product Comparision Chart");

          XYChart.Series series1 = new XYChart.Series();
          series1.setName("Technology A");
          series1.getData().add(new XYChart.Data(3, 30, 5));
          series1.getData().add(new XYChart.Data(10, 50, 3));
          series1.getData().add(new XYChart.Data(5, 25, 5));
          series1.getData().add(new XYChart.Data(20, 30, 3));
          series1.getData().add(new XYChart.Data(32, 20, 1));
          series1.getData().add(new XYChart.Data(35, 7, 7));
          series1.getData().add(new XYChart.Data(4, 17, 1));
          series1.getData().add(new XYChart.Data(49, 30, 1.8));

          XYChart.Series series2 = new XYChart.Series();
          series2.setName("Technology B");
          series2.getData().add(new XYChart.Data(4, 15, 6));
          series2.getData().add(new XYChart.Data(13, 33, 4));
          series2.getData().add(new XYChart.Data(5, 45, 5));
          series2.getData().add(new XYChart.Data(24, 30, 4));
          series2.getData().add(new XYChart.Data(30, 70, 5));
          series2.getData().add(new XYChart.Data(40, 8, 5));
          series2.getData().add(new XYChart.Data(5, 17, 2));
          series2.getData().add(new XYChart.Data(47, 23, 8));            
          blc.getData().addAll(series1, series2);
          bubbleTab.setContent(blc);           
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
     
            private void setScatterTab(Tab scatterTab)
            {
            scatterTab.setText("Scatter Chart");
            final NumberAxis xAxis = new NumberAxis(0, 10, 1);
            final NumberAxis yAxis = new NumberAxis(0, 100, 10);        
            final ScatterChart<Number,Number> sc = 
                new ScatterChart<Number,Number>(xAxis,yAxis);
            xAxis.setLabel("Age (years)");                
            yAxis.setLabel("Returns to date");
            sc.setTitle("Investment Overview");

            XYChart.Series series1 = new XYChart.Series();

            series1.setName("Energy");
            series1.getData().add(new XYChart.Data(4, 99));
            series1.getData().add(new XYChart.Data(2, 36));
            series1.getData().add(new XYChart.Data(6, 28));
            series1.getData().add(new XYChart.Data(10,14));
            series1.getData().add(new XYChart.Data(2, 24));
            series1.getData().add(new XYChart.Data(4, 14));
            series1.getData().add(new XYChart.Data(8, 33));
            series1.getData().add(new XYChart.Data(6, 90));
            series1.getData().add(new XYChart.Data(9, 87));
            series1.getData().add(new XYChart.Data(0, 50));
            series1.getData().add(new XYChart.Data(2, 15));
            series1.getData().add(new XYChart.Data(8, 28));
            series1.getData().add(new XYChart.Data(3, 43));
            series1.getData().add(new XYChart.Data(1, 84));
            series1.getData().add(new XYChart.Data(3, 100));
            series1.getData().add(new XYChart.Data(7, 42));

            XYChart.Series series2 = new XYChart.Series();
            series2.setName("Materials");
            series2.getData().add(new XYChart.Data(5, 29));
            series2.getData().add(new XYChart.Data(2, 38));
            series2.getData().add(new XYChart.Data(3, 14));
            series2.getData().add(new XYChart.Data(1, 34));
            series2.getData().add(new XYChart.Data(3, 22));
            series2.getData().add(new XYChart.Data(7, 11));
            series2.getData().add(new XYChart.Data(3, 33));
            series2.getData().add(new XYChart.Data(6, 20));
            series2.getData().add(new XYChart.Data(8, 26));
            series2.getData().add(new XYChart.Data(1, 48));
            series2.getData().add(new XYChart.Data(7, 24));
            series2.getData().add(new XYChart.Data(9, 99));
            series2.getData().add(new XYChart.Data(8, 87));

            XYChart.Series series3 = new XYChart.Series();
            series3.setName("Industries");
            series3.getData().add(new XYChart.Data(6, 21));
            series3.getData().add(new XYChart.Data(8, 26));
            series3.getData().add(new XYChart.Data(1, 48));
            series3.getData().add(new XYChart.Data(7, 24));
            series3.getData().add(new XYChart.Data(6, 12));
            series3.getData().add(new XYChart.Data(2, 48));
            series3.getData().add(new XYChart.Data(7, 24));
            series3.getData().add(new XYChart.Data(6, 100));
            series3.getData().add(new XYChart.Data(1, 98));
            series3.getData().add(new XYChart.Data(9, 25));
            series3.getData().add(new XYChart.Data(3, 27));
            series3.getData().add(new XYChart.Data(1, 21));

            XYChart.Series series4 = new XYChart.Series();
            series4.setName("Utilietes");
            series4.getData().add(new XYChart.Data(2, 99));
            series4.getData().add(new XYChart.Data(4, 39));
            series4.getData().add(new XYChart.Data(1, 10));
            series4.getData().add(new XYChart.Data(7, 24));
            series4.getData().add(new XYChart.Data(9, 25));
            series4.getData().add(new XYChart.Data(4, 44.));
            series4.getData().add(new XYChart.Data(8, 34));
            series4.getData().add(new XYChart.Data(6, 99));
            series4.getData().add(new XYChart.Data(4, 84));
            series4.getData().add(new XYChart.Data(5, 24));
            series4.getData().add(new XYChart.Data(3, 37));
            series4.getData().add(new XYChart.Data(1, 20));
            sc.getData().addAll(series1, series2, series3, series4);        
            scatterTab.setContent(sc);       
          }
    }
    
