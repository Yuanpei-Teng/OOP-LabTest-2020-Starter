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
	}
}
