package org.vaadin.visjs.networkDiagram.api;

public class Pointer {

	Coordinates DOM;
	Coordinates canvas;
	
	public Pointer(){
		DOM=new Coordinates();
		canvas=new Coordinates();
	}
	
	public Coordinates getDOM() {
		return DOM;
	}
	public void setDOM(Coordinates dOM) {
		DOM = dOM;
	}
	public Coordinates getCanvas() {
		return canvas;
	}
	public void setCanvas(Coordinates canvas) {
		this.canvas = canvas;
	}


}
