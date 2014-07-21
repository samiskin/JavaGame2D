import JavaGame.Game;


public class TestBed extends Game{

	public TestBed() {
		super(640, 640);
	}

	protected void init() {
		super.setFPS(60);		
	}

	
	protected void update() {
		
		
	}

	
	protected void render() {
		
		
	}
	
	public static void main(String[] args){
		Game game = new TestBed();
	}

}
