package org.vaadin.visjs.networkDiagram.event.node;

import org.vaadin.visjs.networkDiagram.api.Event;
import elemental.json.JsonArray;
import elemental.json.JsonException;
import elemental.json.JsonObject;

/**
 * Created by roshans on 11/30/14.
 * Added null pointer safety condition 08/04/2017
 */
public class DragStartEvent extends Event {
    public DragStartEvent(JsonArray properties) throws JsonException {
        super();
        if (properties.length()>0) {
	        JsonArray nodes = properties.getObject(0).getArray("nodeIds");
	        if (nodes!=null){
		        for (int i = 0; i < nodes.length(); i++) {
		            getNodeIds().add(nodes.getString(i));
		        }
	        }
        }
    }
}
