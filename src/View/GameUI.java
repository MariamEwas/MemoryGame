package View;



import java.util.HashMap;







import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import GameImplementaion.GameClass;
public class GameUI extends Application{

	static Scene currentscene,scene1;
	public static Stage primaryStage;
	public static int row=5,col=6;
	static int count;
	public static boolean[][] taken;
	public static Button[][] cards;
	public static Label timerlabel;
	public static Label Moves;
    public static int NumberofMoves;
	public static Timeline timeline;
	public static int seconds;
	public static typegame type=typegame.SOLO;
	public static Label warning;
	public static VBox RightSection;
	public static HashMap<String, Image> images= new HashMap<>(); 
	public static Button hints;
	public static Label counthints;

	
	public static boolean taketurns;
	public static Label whoseturn;
    public static int[] points; 
    public static Label[] players;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		   Label b1= new Label("Do you want to Try an INTERESTING GAME ?");
		   Label b2=new Label(" Size of the Board ");
		   //b1.setStyle("-fx-font-size: 26px;  -fx-text-fill: black;");
		   Button1 b56=new Button1("5 X 6");
		   Button1 b78=new Button1("7 X 8");
		   Button1 b1112=new Button1("11 X 12");
		   //b2 .setStyle("-fx-font-size: 26px;  -fx-text-fill: black;");
          
		   Label ask=new Label("How do you want to play ?");
		 //  ask.setStyle("-fx-font-size: 26px;-fx-text-fill: black;");		   
		   Button1 solo=new Button1("SOLO");
		   Button1 withafriend=new Button1 ("With A friend");
		   Button1 letsgo=new Button1("Start The Game");   
		   letsgo.setAlignment(Pos.CENTER);		   
           
		   ask.setFont(Font.font("Broadway",FontWeight.NORMAL,26));
		   ask.setStyle("-fx-text-fill: GREEN;");		  
		   b1.setFont(Font.font("Broadway",FontWeight.BOLD,50));
		   b1.setStyle("-fx-text-fill: GREEN; -fx-underline: true; -fx-underline-color: BLACK; -fx-underline-width: 2px;");
		   b2.setFont(Font.font("Broadway",FontWeight.NORMAL,26));
		   b2.setStyle("-fx-text-fill: GREEN;");
		   letsgo.setFont(Font.font("Broadway",FontWeight.BOLD,26));
	       
	       HBox root2=new HBox(10);
		   root2.getChildren().addAll(solo,withafriend);
		   root2.setAlignment(Pos.CENTER);
		   HBox root=new HBox(10);
		   root.setAlignment(Pos.CENTER);
		   root.getChildren().addAll(b1,b56,b78,b1112);
		   VBox mainroot=new VBox(30);	   
		   mainroot.getChildren().addAll(b1,b2,root,ask,root2,letsgo);
		   BorderPane startpage=new BorderPane(); 
		   
		   
		  // startpage.setRight(b1);
		   startpage.setCenter(mainroot);
		  
		   
		   mainroot.setAlignment(Pos.CENTER);
			 b56.setPrefSize(110,50);
			 b78.setPrefSize(110,50);
			 b1112.setPrefSize(110,50);
			 letsgo.setPrefSize(260,80);
			 solo.setPrefSize(130,50);
			 withafriend.setPrefSize(190,50);

			 BorderStroke borderStroke = new BorderStroke(
		                Color.BROWN, BorderStrokeStyle.SOLID, null, new BorderWidths(3));
		        Border border = new Border(borderStroke);
				   solo.setBorder(border);
				   b56.setBorder(border);
		        solo.setOnAction(e->{type=typegame.SOLO;
		   solo.setBorder(border);
		   withafriend.setBorder(null);
		   });
		   withafriend.setOnAction(e->{type=typegame.WithaFriend;
		   withafriend.setBorder(border);
		   solo.setBorder(null);
		   });
		   b56.setOnAction(e->{row=5;col=6;
		   b56.setBorder(border);
		   b78.setBorder(null);
		   b1112.setBorder(null);
		   });
		   b78.setOnAction(e->{row=7;col=8;
		   b78.setBorder(border);
		   b56.setBorder(null);
		   b1112.setBorder(null);

		   });
		   b1112.setOnAction(e->{row=11;col=12;
		   b1112.setBorder(border);
		   b78.setBorder(null);
		   b56.setBorder(null);
          });
		   
		   letsgo.setOnAction(e-> Game());
		   BackgroundImage backgroundImage = new BackgroundImage(new Image("b3.png"),BackgroundRepeat.ROUND, BackgroundRepeat.ROUND,
	                BackgroundPosition.CENTER,
	                new BackgroundSize(1350, 800, false, false, true, false)
	        );
		   startpage.setBackground(new Background(backgroundImage)); 
//		   Image backgroundImage = new Image("b2.jpeg");
//
//	        ImageView backgroundImageView = new ImageView(backgroundImage);
//	        BoxBlur blurEffect = new BoxBlur(10, 10, 3);
//	        backgroundImageView.setEffect(blurEffect);
//	       
//	        backgroundImageView.setScaleX(0.8);
//	        backgroundImageView.setScaleY(0.8);
//		   double wid=scene1.getWidth(),len=scene1.getHeight();
//		   backgroundImageView.setFitWidth(wid);
//	        backgroundImageView.setFitHeight(len);
		   StackPane order = new StackPane(startpage);
		   scene1=new Scene(order,1350,650);
		   primaryStage=stage;
		   currentscene=scene1;
		   primaryStage.setScene(currentscene);
           primaryStage.setFullScreen(true);
		   primaryStage.setTitle("Luna");
		   primaryStage.setResizable(true);
		   primaryStage.show();	  	
		  
	        
	}
    void Game()
    {
    	taken=new boolean[row][col];
    	hints=new Button("Use Hint !");
    	counthints=new Label("3");
    	count=3;
    	warning=new Label();
        loadimages();

    	warning.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #00CED1;");
    	counthints.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #00CED1;");
    	hints.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #00CED1;");
		//hints.setBackground(new Background(new BackgroundFill(Color.color(1.00,0.97,0.80), CornerRadii.EMPTY, null)));
    	GridPane game=new GridPane(); 
    	cards=new Button[row][col];
    	 BorderStroke borderStroke = new BorderStroke(
	                Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1));
	        Border border = new Border(borderStroke);
	        
	        BackgroundImage background = new BackgroundImage(images.get("!"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.CENTER,
	                new BackgroundSize((int)(1000/col), (int)(800/row), false, false, true, false)
	        );    
    	for (int i=0;i<row;i++)
    	{
    		for (int j=0;j<col;j++)
    		{
    			cards[i][j]=new Button();
    			cards[i][j].setPrefSize((int)(1000/col), (int)(800/row));
    	     	cards[i][j].setBorder(border);
    			cards[i][j].setBackground(new Background(background));
    			int temi=i,temj=j;
    			cards[i][j].setOnAction(e->{if (GameClass.ok)GameClass.clicked(temi,temj);
    			if (checkwin())
    	    	{
    				String message;
    				if (type==typegame.SOLO)message="Congratulations ! You win the Game";
    				else
    				{
    					if (points[0]>points[1])message="Player 1 won the Game !\n Congratulations !";
    					else if (points[0]<points[1])message="Player 2 won the Game!\n Congratulations";
    					else message="It is a tie ! Congratulations to both of You!";
    				}
    				
    				GameWinWindow.display("Win",message);
    	    		if (GameWinWindow.answer)primaryStage.setScene(scene1);
    	    		else primaryStage.close();
    	    	}
    			});
    			
    			game.add(cards[i][j], i, j);	
    		}
    	}
    	   	
    	GameClass.startgame();
    	
    		hints.setOnAction(e->{
    		if (count>0)
    		usehints();   		
    		});
    	
    	HBox all =new HBox();
    	HBox hintbox=new HBox(15);
    	hintbox.getChildren().addAll(hints,counthints);
    	timerlabel=new Label("00:00:00");
    	timerlabel.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #00CED1;");
    	Moves=new Label("Number Of Moves : " + NumberofMoves);
    	Moves.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #00CED1;");

    	KeyFrame kf=new KeyFrame(Duration.seconds(1),e->{
        	seconds++;
        	updateTimerLabel();});
    	timeline = new Timeline (kf); 
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	 
       	 RightSection=new VBox(35);
       	RightSection.setPadding(new Insets(40));
       	RightSection.getChildren().addAll(timerlabel,Moves);
   	    //RightSection.setAlignment(Pos.TOP); 
        RightSection.setTranslateX(0);  
       	if (type==typegame.WithaFriend)
        {
       		players =new Label[2];
       		points=new int[2];
       		points[0]=0;points[1]=0; 
       		whoseturn=new Label();
        	players[0]=new Label();players[1]=new Label();
        	players[0].setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: blue;");
        	players[1].setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: red;");
        	whoseturn.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: blue;");
        	withafriend();
        	HBox pl=new HBox(40);
        	pl.getChildren().addAll(players[0],players[1]);
        	RightSection.getChildren().addAll(whoseturn,pl);
        }
       	BackgroundImage backgroundImage = new BackgroundImage(new Image("b4.jpeg"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
       	
	   // RightSection.setBackground(new Background(backgroundImage));    	
       	RightSection.getChildren().addAll(hintbox,warning);
		game.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
    	all.getChildren().addAll(game,RightSection);
    	Scene scene2=new Scene(all,1350,800);
    	primaryStage.setFullScreen(true);
    	currentscene=scene2;
    	primaryStage.setScene(currentscene);
        timeline.play();	
    }
   
    public static void updateTimerLabel()
    {
    	int hours=seconds/3600;
    	int minutes=(seconds%3600)/60;
    	int remaining=seconds%60;
    	String timeText=String.format("%02d:%02d:%02d",hours,minutes,remaining);
    	timerlabel.setText(timeText);
    	
    }
    public static void withafriend()
    {
    	players[0].setText("Player 1\n      "+points[0]);
    	players[1].setText("Player 2\n      "+points[1]);
    	if (taketurns) 
    	{
    		whoseturn.setText("Player 1 Turn");  
        	whoseturn.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: blue;");

    	}
    	else
    	{
    		whoseturn.setText("Player 2 Turn");
        	whoseturn.setStyle("-fx-font-family: 'Broadway'; -fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: red;");
    	}	
    } 
    static boolean checkwin()
    {
    	boolean f=true;
    	for (int i=0;i<row;i++)
    	{
    		for (int j=0;j<col;j++)
    		{
    			if (!GameClass.Cells[i][j].equals("Done"))
    				return false;
    		}
    	}
    	return true;
    }
    public static void setbackground(String s,int x,int y)
    {
    	if (s.equals("Done")) return;
    	 BorderStroke borderStroke = new BorderStroke(
	                Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(3));
	        Border border = new Border(borderStroke);
	        BorderStroke borderStroke2 = new BorderStroke(
	                Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1));
	        Border border2 = new Border(borderStroke2);
	        BorderStroke borderStroke3 = new BorderStroke(
	                Color.BLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(3));
	        Border border3 = new Border(borderStroke3);
    	BackgroundImage backgroundImage = new BackgroundImage(images.get(s),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.CENTER,
	                new BackgroundSize((int)(1000/col), (int)(800/row), false, false, true, false)
	        );
		   cards[x][y].setBackground(new Background(backgroundImage)); 	
		   
		   if (s.equals("!"))
			   cards[x][y].setBorder(border2);
		   else {
		       if (type==typegame.WithaFriend && taketurns)
		       {
		    	   cards[x][y].setBorder(border3);
		       }
		       else 
			     cards[x][y].setBorder(border);	   
		   }
		   
    }
    public static void usehints()
    {
    	for (int i=0;i<row;i++)
    	{
    		for (int j=0;j<col;j++)
    		{
    			setbackground(GameClass.Cells[i][j],i,j);
    			//cards[i][j].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    		}
    	}
    	GameClass.ok=false;
    	PauseTransition pause = new PauseTransition(Duration.seconds(5)); // Wait for 2 seconds
        pause.setOnFinished(e -> {
        	for (int i=0;i<row;i++){
        		for (int j=0;j<col;j++){
			       if (GameClass.Cells[i][j].equals("Done")) continue;
        			GameUI.setbackground("!", i, j);
        		}
        		}
        	GameClass.ok=true;
        });
        count-=1;
        counthints.setText((""+count));
        pause.play();
        
    }
    
    static void loadimages()
    {
    	images.put("!",new Image("bubbles.jpg"));
    	images.put("A", new Image("fish1m.jpg"));
    	images.put("B", new Image("fish2m.jpg"));
    	images.put("C", new Image("fish31.png"));
    	images.put("D", new Image("turtlem.jpg"));
    	images.put("E", new Image("Dolphin.png"));
    	images.put("F", new Image("Biser.jpg"));
    	images.put("G", new Image("slippers.jpg"));
    	images.put("H", new Image("oct.jpg"));
    	images.put("I", new Image("sand.jpeg"));
    	images.put("J", new Image("ball.jpg"));
    	images.put("K", new Image("crap.jpg"));
    	images.put("L", new Image("fish4.jpg"));
    	images.put("M", new Image("fish5.jpg"));
    	images.put("N", new Image("floating.jpg"));
    	images.put("O", new Image("umbrella1.png"));
    	images.put("P", new Image("candy.jpg"));
    	images.put("Q", new Image("sun.jpg"));
    	images.put("R", new Image("bt.jpg"));
    	images.put("S", new Image("chair1.png"));
    	images.put("T", new Image("cural.png"));
    	images.put("U", new Image("glasses.jpg"));
    	images.put("V", new Image("submarine.png"));
    	images.put("W", new Image("fish6.png"));
    	images.put("X", new Image("fish7.png"));
    	images.put("Y", new Image("boat.png"));
    	images.put("Z", new Image("bag.png"));
    	images.put("a", new Image("starfish.png"));
    	images.put("b", new Image("fish8.png"));
    	images.put("c", new Image("fish9.png"));
    	images.put("d", new Image("hatt.png"));
    	images.put("e", new Image("duck2.jpg"));
    	images.put("f", new Image("fish10.png"));
    	images.put("g", new Image("fish11.png"));    	
    }
    //الحمد لله
	
	public static void main(String [] args)
	{
 		launch(args);
	}

}
