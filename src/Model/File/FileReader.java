package Model.File;

import java.io.BufferedReader;
import java.util.ArrayList;

public class FileReader {
	
	private ArrayList<String> lines;
	private int pointer;
	private BufferedReader in;
	
	public FileReader(String src){
		
		lines = new ArrayList<String>();
		pointer = 0;

		String line;
		in = null;
		
		try {
			
			in = new BufferedReader(new java.io.FileReader(src));
			while ((line = in.readLine()) != null){
				lines.add(line);
			}
			in.close();
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String readLine(){
		return lines.get(pointer++);
	}
	
	public String readLine(int line){
		return lines.get(line);
	}
	
	public void resetPointer(){
		pointer = 0;
	}
	
	public ArrayList<String> getLines(){
		return lines;
	}
	
	public String getFullText(){
		String fullText = "";
		for (String line : lines){
			fullText += line + "\n";
		}
		return fullText;
	}
	
	

}
