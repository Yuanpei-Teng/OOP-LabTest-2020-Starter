package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{
	public ArrayList<Task> tasks = new ArrayList<Task>();

	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv","header");
		for(TableRow row:t.rows())
		{
			Task i = new Task(row);
			tasks.add(i);
		}
	}

	public void printTasks()
	{
		for(Task i:tasks)
		{
			println(i);
		}

	}

	public void displayTasks()
	{
		float border = width * 0.08f;
		float border_height = height * 0.1f;
		float left_side = width*0.05f;
		float single_area = (width-border-border-70)/29;
		float c = 0 ;
		colorMode(HSB);
		//float alt = (float)72/10;

		//draw the line and the number of the Days
		stroke(255);
		textAlign(CENTER,CENTER);
		for(int j = 1; j<=30; j++)
		{
			float x = map(j,1,30,border + 70, width - border);
			fill(255);
			line(x,border,x,height-border);
			text((int)j, x, 30);
		}
		
		
		//draw the name of the Tasks and the rectangle
		for(int z = 0; z<tasks.size(); z++)
		{
			
			float y = map(z,0,tasks.size(),border_height,height-200);
			fill(c,255,255);
			rect(border+70+(tasks.get(z).getStart()-1)*single_area , y+15 , (tasks.get(z).getEnd()-tasks.get(z).getStart())*single_area ,30,5);
			
			fill(255);
			text(tasks.get(z).getTask(), left_side ,y+(border_height/2));
			c = c + 27;
			
			
		}


	}

	
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	

	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
