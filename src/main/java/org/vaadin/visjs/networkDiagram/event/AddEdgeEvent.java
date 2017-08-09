package org.vaadin.visjs.networkDiagram.event;


import elemental.json.JsonArray;
import elemental.json.JsonException;

/**
 * Created by Martin Prause 9.8.2017
 */
public class AddEdgeEvent {
	
	private String to;
	private String from;
	private String label;
	private String id;
	
    public AddEdgeEvent(JsonArray properties) throws JsonException {

    	if (properties.getObject(0).hasKey("from")){
    		from=properties.getObject(0).getString("from");
    	}
    	if (properties.getObject(0).hasKey("to")){
    		to=properties.getObject(0).getString("to");
    	}
    	if (properties.getObject(0).hasKey("label")){
    		label=properties.getObject(0).getString("label");
    	}
    	if (properties.getObject(0).hasKey("id")){
    		id=properties.getObject(0).getString("id");
    	}
     
    }

	

	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
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
