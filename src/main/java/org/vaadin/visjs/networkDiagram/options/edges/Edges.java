package org.vaadin.visjs.networkDiagram.options.edges;

import org.vaadin.visjs.networkDiagram.util.Color;
import org.vaadin.visjs.networkDiagram.util.Font;
import org.vaadin.visjs.networkDiagram.util.Scaling;
import org.vaadin.visjs.networkDiagram.util.Shadow;
import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.options.nodes.WidthConstraint;

/**
 * Created by roshans on 10/29/14.
 * Updated to news options by Martin Prause 5.8.2017
 */
public class Edges {
	
	private Arrows arrows;
    boolean arrowStrikethrough=true;
    boolean chosen=true;
   
    private Color color = new Color("#848484","#848484");

    private int dashes[];
    private Font font;
    
   
    private boolean hidden=false;
    private double hoverWidth=1.5;
    private String label;
    private boolean labelHighlightBold=true;
    private Integer length;
    private boolean physics=true;

    private Scaling scaling=null;
    private int selectionWidth=1;
    private int selfReferenceSize=20;
    private Shadow shadow=null;

    private Smooth smooth;;
    private String title;
    private Integer value;
    private int width=1;
    private WidthConstraint widthConstraint;
       
    
    
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public boolean isArrowStrikethrough() {
		return arrowStrikethrough;
	}
	public void setArrowStrikethrough(boolean arrowStrikethrough) {
		this.arrowStrikethrough = arrowStrikethrough;
	}
	public boolean isChosen() {
		return chosen;
	}
	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int[] getDashes() {
		return dashes;
	}
	public void setDashes(int[] dashes) {
		this.dashes = dashes;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Arrows getArrows() {
		return arrows;
	}
	public void setArrows(Arrows arrows) {
		this.arrows = arrows;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public double getHoverWidth() {
		return hoverWidth;
	}
	public void setHoverWidth(double hoverWidth) {
		this.hoverWidth = hoverWidth;
	}
	public boolean isLabelHighlightBold() {
		return labelHighlightBold;
	}
	public void setLabelHighlightBold(boolean labelHighlightBold) {
		this.labelHighlightBold = labelHighlightBold;
	}
	public boolean isPhysics() {
		return physics;
	}
	public void setPhysics(boolean physics) {
		this.physics = physics;
	}
	public Scaling getScaling() {
		return scaling;
	}
	public void setScaling(Scaling scaling) {
		this.scaling = scaling;
	}
	public int getSelectionWidth() {
		return selectionWidth;
	}
	public void setSelectionWidth(int selectionWidth) {
		this.selectionWidth = selectionWidth;
	}
	public int getSelfReferenceSize() {
		return selfReferenceSize;
	}
	public void setSelfReferenceSize(int selfReferenceSize) {
		this.selfReferenceSize = selfReferenceSize;
	}
	public Shadow getShadow() {
		return shadow;
	}
	public void setShadow(Shadow shadow) {
		this.shadow = shadow;
	}
	public Smooth getSmooth() {
		return smooth;
	}
	public void setSmooth(Smooth smooth) {
		this.smooth = smooth;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public WidthConstraint isWidthConstraint() {
		return widthConstraint;
	}
	public void setWidthConstraint(WidthConstraint widthConstraint) {
		this.widthConstraint = widthConstraint;
	}
     
 
  
}
