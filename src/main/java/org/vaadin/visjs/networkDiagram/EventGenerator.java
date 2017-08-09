package org.vaadin.visjs.networkDiagram;

import org.vaadin.visjs.networkDiagram.event.AddEdgeEvent;
import org.vaadin.visjs.networkDiagram.event.AddNodeEvent;
import org.vaadin.visjs.networkDiagram.event.ClickEvent;
import org.vaadin.visjs.networkDiagram.event.DeleteNodesEdgesEvent;
import org.vaadin.visjs.networkDiagram.event.HoverBlurEvent;
import elemental.json.JsonArray;
import elemental.json.JsonException;

/**
 * Created by roshans on 11/30/14.
 */
public class EventGenerator {

	 public static ClickEvent getClickEvent(JsonArray properties) {
		 ClickEvent selectEvent = null;
	        try {
	            selectEvent = new ClickEvent(properties);
	        } catch (JsonException e) {
	            e.printStackTrace();
	        }
	        return selectEvent;
	    }

	
    public static HoverBlurEvent getHoverBlurEvent(JsonArray properties){
    	HoverBlurEvent hoverEvent = null;
        try {
            hoverEvent = new HoverBlurEvent(properties);
        } catch (JsonException e) {
            e.printStackTrace();
        }
        return hoverEvent;
    }
    
    public static AddNodeEvent getAddNodeEventEvent(JsonArray properties){
    	AddNodeEvent addNodeEvent = null;
        try {
        	addNodeEvent = new AddNodeEvent(properties);
        } catch (JsonException e) {
            e.printStackTrace();
        }
        return addNodeEvent;
    }
    
    public static AddEdgeEvent getAddEdgeEventEvent(JsonArray properties){
    	AddEdgeEvent addEdgeEvent = null;
        try {
        	addEdgeEvent = new AddEdgeEvent(properties);
        } catch (JsonException e) {
            e.printStackTrace();
        }
        return addEdgeEvent;
    }
    
    public static DeleteNodesEdgesEvent getDeleteNodesEdgesEvent(JsonArray properties){
    	DeleteNodesEdgesEvent deleteNodesEdges = null;
        try {
        	deleteNodesEdges = new DeleteNodesEdgesEvent(properties);
        } catch (JsonException e) {
            e.printStackTrace();
        }
        return deleteNodesEdges;
    }
   
}
