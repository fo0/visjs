package org.vaadin.visjs.networkDiagram.options.nodes;

import org.vaadin.visjs.networkDiagram.util.Color;
import org.vaadin.visjs.networkDiagram.util.Font;
import org.vaadin.visjs.networkDiagram.util.Scaling;
import org.vaadin.visjs.networkDiagram.util.Shadow;
import org.vaadin.visjs.networkDiagram.util.Shape;
import org.vaadin.visjs.networkDiagram.util.ShapeProperties;
import org.vaadin.visjs.networkDiagram.options.nodes.Icon;

/**
 * Created by roshans on 10/29/14.
 * Updated to latest elements by Martin Prause 4.8.2017
 */
public class Nodes {

	private int borderWidth = 1;
    private int borderWidthSelected;
    private boolean chosen=true;
    private Color color;
    //fixed
    private Font font;
    //group
    private boolean heightConstraint=false;
    private boolean hidden=false;
    private Icon icon;
    private String image;
    private String brokenImage;
    
    private boolean labelHighlightBold= true;
    private Integer level;
    private int mass=1;
    private boolean physics=true;
    private Scaling scaling;
    private Shadow shadow;
    private Shape shape = Shape.ellipse;
    private ShapeProperties shapeProperties;
    
    private int size=25;
    private String title=null;
    private String value=null;
    private WidthConstraint widthConstraint;
    private Integer x=null;
    private Integer y=null;
    
    
    
    
	public boolean isChosen() {
		return chosen;
	}
	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
	public WidthConstraint getWidthConstraint() {
		return widthConstraint;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public int getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}
	public int getBorderWidthSelected() {
		return borderWidthSelected;
	}
	public void setBorderWidthSelected(int borderWidthSelected) {
		this.borderWidthSelected = borderWidthSelected;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public boolean isHeightConstraint() {
		return heightConstraint;
	}
	public void setHeightConstraint(boolean heightConstraint) {
		this.heightConstraint = heightConstraint;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBrokenImage() {
		return brokenImage;
	}
	public void setBrokenImage(String brokenImage) {
		this.brokenImage = brokenImage;
	}
	public boolean isLabelHighlightBold() {
		return labelHighlightBold;
	}
	public void setLabelHighlightBold(boolean labelHighlightBold) {
		this.labelHighlightBold = labelHighlightBold;
	}
	public int getMass() {
		return mass;
	}
	public void setMass(int mass) {
		this.mass = mass;
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
	public Shadow getShadow() {
		return shadow;
	}
	public void setShadow(Shadow shadow) {
		this.shadow = shadow;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public ShapeProperties getShapeProperties() {
		return shapeProperties;
	}
	public void setShapeProperties(ShapeProperties shapeProperties) {
		this.shapeProperties = shapeProperties;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public WidthConstraint isWidthConstraint() {
		return widthConstraint;
	}
	public void setWidthConstraint(WidthConstraint widthConstraint) {
		this.widthConstraint = widthConstraint;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
  
   
    
}
