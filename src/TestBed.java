import JavaGame.Game;


public class TestBed extends Game{

	public TestBed(int width, int height) {
		super(width, height);
	}

	protected void init() {
		super.MAX_FPS = 5;		
	}

	@Override
	protected void update() {

		
	}

	@Override
	protected void render() {
		
		
	}
	
	public static void main(String[] args){
		Game game = new TestBed(640,640);
	}

}
