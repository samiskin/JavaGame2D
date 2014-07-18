package JavaGame;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileWriter {

	private Writer out;
	private String src;
	
	public FileWriter(String src){
		out = null;
		this.src = src;
		open();
	}
	
	public void write(String str){
		try {
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeLine(String str){
		try {
			out.write(str+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FileReader getReader(){
		return new FileReader(src);
	}
	
	
	public void close(){
		try {out.close();} catch (Exception ex) {}
	}
	
	public void open(){
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src), "utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
