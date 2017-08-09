package org.vaadin.visjs.networkDiagram.event;


import elemental.json.JsonArray;
import elemental.json.JsonException;

/**
 * Created by Martin Prause 9.8.2017
 */
public class AddNodeEvent {
	
	private int x;
	private int y;
	private String label;
	private String id;
	
    public AddNodeEvent(JsonArray properties) throws JsonException {

    	if (properties.getObject(0).hasKey("x")){
    		x=(int)properties.getObject(0).getNumber("x");
    	}
    	if (properties.getObject(0).hasKey("y")){
    		y=(int)properties.getObject(0).getNumber("y");
    	}
    	if (properties.getObject(0).hasKey("label")){
    		label=properties.getObject(0).getString("label");
    	}
    	if (properties.getObject(0).hasKey("id")){
    		id=properties.getObject(0).getString("id");
    	}
     
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    

}
