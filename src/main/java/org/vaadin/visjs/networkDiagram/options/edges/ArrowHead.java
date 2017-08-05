package org.vaadin.visjs.networkDiagram.options.edges;

/**
 * Created by Martin Prause 5.8.2017
 */

public class ArrowHead {
	private boolean enabled=false;
	private int scaleFactor=1; 
	private Arrows.Style type=Arrows.Style.arrow;
	
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
	public Arrows.Style getType() {
		return type;
	}
	public void setType(Arrows.Style type) {
		this.type = type;
	}
	
	
}
