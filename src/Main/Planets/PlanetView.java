package Main.Planets;

import View.ViewComponent;

public class PlanetView extends ViewComponent{

	Planet planet;
	public PlanetView(Planet src){
		planet = src;
	}
	public void update() {
		planet.img.draw(planet.getX()-planet.getRadius(), planet.getY()-planet.getRadius(), planet.getRadius()*2,planet.getRadius()*2);
		
	}

}
