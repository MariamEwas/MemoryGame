package GameImplementaion;

import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import View.GameUI;
import View.typegame;

public class GameClass {
	public static String[][] Cells;
	public static int Row;
	public static int Col;
	public static int numclicked=0;
    public static int[] posclicked;
    public static boolean ok=true;
	
	
	public static void startgame()
	{
		GameUI.seconds=0; 
		GameUI.NumberofMoves=0;
		Row=GameUI.row;
		Col=GameUI.col;
		Cells=new String[Row][Col];
		//images=new char[Row*Col/2];
	    
        if (Row==5)
        {
        	for (int i=0;i<15;i++)
        	{
        		char c=(char)(i+'A');
        		//images[i]=(char)(i+'A');
        		int temi=(int)(Math.random()*Row);
        		int temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        		temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        		}    	
        }
        else if (Row==7)
        {
        	for (int i=0;i<26;i++)
        	{
        		char c=(char)(i+'A');
        		//images[i]=(char)(i+'A');
        		int temi=(int)(Math.random()*Row);
        		int temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        		temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        	}
        	char c='a';
        	//images[26]=(char)('a');
        	int temi=(int)(Math.random()*Row);
    	    int temj=(int)(Math.random()*Col);
    		while(GameUI.taken[temi][temj])
    		{
    			temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
    		}
    		Cells[temi][temj]=""+c; GameUI.taken[temi][temj]=true;
    		temi=(int)(Math.random()*Row);
    	    temj=(int)(Math.random()*Col);
    		while(GameUI.taken[temi][temj])
    		{
    			temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
    		}
    		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        	
        	
        	
        	c='b';
        	//images[27]=(char)('b'); 
        	temi=(int)(Math.random()*Row);
    	    temj=(int)(Math.random()*Col);
    		while(GameUI.taken[temi][temj])
    		{
    			temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
    		}
    		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
    		
    		temi=(int)(Math.random()*Row);
    	    temj=(int)(Math.random()*Col);
    		while(GameUI.taken[temi][temj])
    		{
    			temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
    		}
    		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        }
        else if (Row==11)
        {
        	//images=new char[33];
        	for (int i=0;i<33;i++)
        	{
        		char c;
        		if (i<26)
        			c=(char)(i+'A');
        		else 
        			c=(char)((i-26)+'a');
        		
        		//images[i]=(char)(i+'A');
        		int temi=(int)(Math.random()*Row);
        	    int temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        		temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        		temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
        		temi=(int)(Math.random()*Row);
        	    temj=(int)(Math.random()*Col);
        		while(GameUI.taken[temi][temj])
        		{
        			temi=(int)(Math.random()*Row);
            	    temj=(int)(Math.random()*Col);
        		}
        		Cells[temi][temj]=""+c;GameUI.taken[temi][temj]=true;
       	
        	}
        }
       
       
	}
	public static void clicked(int temi,int temj)
	{
		if (Cells[temi][temj].equals("Done"))
		{
			GameUI.warning.setText("\"This Card is Actually Done\"");
		   return;	
		}
		numclicked++;
		if (numclicked==1)
		{
			posclicked=new int[2];
			posclicked[0]=temi;
			posclicked[1]=temj;
			GameUI.setbackground(Cells[temi][temj], temi, temj);
		}
		else 
		{
			if (temi==posclicked[0] && temj==posclicked[1])
			{
				//Something like a warning in the right section !
				GameUI.warning.setText("\"Choose Another Card !\"");
				numclicked=1;
				return ;
			}
			else if (Cells[temi][temj].equals(Cells[posclicked[0]][posclicked[1]])) 
			{
				GameUI.setbackground(Cells[temi][temj], temi, temj);
				Cells[temi][temj]="Done";
				Cells[posclicked[0]][posclicked[1]]="Done";
				GameUI.warning.setText("");				
				if (GameUI.type==typegame.WithaFriend){
				if (GameUI.taketurns)
				GameUI.points[0]++;
				else 
				GameUI.points[1]++;
				}
				
			}
			else 
			{
				ok=false;
				GameUI.warning.setText("\"YOUR Choice is Wrong :(\"");
				GameUI.setbackground(Cells[temi][temj], temi, temj);
				PauseTransition pause = new PauseTransition(Duration.seconds(1)); // Wait for 2 seconds
	            pause.setOnFinished(e -> {
					GameUI.warning.setText("");
					GameUI.setbackground("!", temi, temj);
					GameUI.setbackground("!", posclicked[0], posclicked[1]);
                   ok=true;
	            });
				GameUI.taketurns=!GameUI.taketurns;
	            pause.play();      
			}
			GameUI.NumberofMoves++;
	    	GameUI.Moves.setText("Number Of Moves : " + GameUI.NumberofMoves);
	    	if (GameUI.type==typegame.WithaFriend)
	    	GameUI.withafriend();
			numclicked=0;
		}
			
	}
	
	
	
	

}
