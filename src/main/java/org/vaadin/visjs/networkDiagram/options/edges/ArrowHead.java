package org.vaadin.visjs.networkDiagram.options.edges;

/**
 * Created by Martin Prause 5.8.2017
 */

public class ArrowHead {
	private boolean enabled=false;
	private int scaleFactor=1; 
	private Arrows.Style style=Arrows.Style.arrow;
	
	public ArrowHead(){
		enabled=true;
	}
	
	public ArrowHead(int scaleFactor,Arrows.Style style){
		enabled=true;
		this.scaleFactor=scaleFactor;
		this.style=style;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getScaleFactor() {
		return scaleFactor;
	}
	public void setScaleFactor(int scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	public Arrows.Style getStyle() {
		return style;
	}

	public void setStyle(Arrows.Style style) {
		this.style = style;
	}

	
	
}
