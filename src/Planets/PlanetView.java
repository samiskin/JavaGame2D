package Planets;


import JavaGame.ViewComponent;

public class PlanetView extends ViewComponent{

	Planet planet;
	public PlanetView(Planet src){
		planet = src;
	}
	public void render() {
		planet.img.render(planet.getX()-planet.getRadius(), planet.getY()-planet.getRadius(), planet.getRadius()*2,planet.getRadius()*2);
		
	}
}
