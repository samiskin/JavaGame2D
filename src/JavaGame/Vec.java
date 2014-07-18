package JavaGame;

import org.jbox2d.common.Vec2;

public class Vec extends Vec2{

	private static final long serialVersionUID = 1L;
	
	public Vec(double x, double y){
		super((float)x,(float)y);
		
	}
	
	public Vec(Vec2 v) {
		super(v);
	}

	public void set (double x, double y){
		super.set((float)x,(float)y);
	}
	
	
	public Vec sub(Vec v){
		return new Vec(super.sub(v)); 
	}
	
	public Vec add(Vec v){
		return new Vec(super.add(v));
	}

}
