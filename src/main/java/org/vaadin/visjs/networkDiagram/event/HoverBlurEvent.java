package org.vaadin.visjs.networkDiagram.event;

import org.vaadin.visjs.networkDiagram.api.Event;
import elemental.json.JsonArray;
import elemental.json.JsonException;
import elemental.json.JsonObject;

/**
 * Created by roshans on 11/30/14.
 */
public class HoverBlurEvent extends NetworkEvent {
    public HoverBlurEvent(JsonArray properties) throws JsonException {
        super();
        if (properties.getObject(0).hasKey("node")){
	        String nodeID = properties.getObject(0).getString("node");
	        this.setNode(nodeID);
        }
        if (properties.getObject(0).hasKey("edge")){
	        String edgeID = properties.getObject(0).getString("edge");
	        this.setEdge(edgeID);
        }
    }
}
