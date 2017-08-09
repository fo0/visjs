package org.vaadin.visjs.networkDiagram.event;

import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.api.Event;

import com.vaadin.event.MouseEvents.DoubleClickListener;

import elemental.json.JsonArray;
import elemental.json.JsonException;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roshans on 11/30/14.
 * Added previousSelection and pointer by Martin Prause 9.8.2017
 */
public class ClickEvent extends Event {
    public ClickEvent(JsonArray properties) throws JsonException {
        super();
        JsonArray edges = properties.getObject(0).getArray("edges");
        JsonArray nodes = properties.getObject(0).getArray("nodes");
        for(int i = 0 ; i<nodes.length() ; i++ ){
            getNodeIds().add(nodes.getString(i));
        }

        for(int i=0;i<edges.length();i++){
            getEdgeIds().add(edges.getString(i));
        }
        
        JsonObject pointer = properties.getObject(0).getObject("pointer");
        if (pointer!=null) {
	        JsonObject dom = pointer.getObject("DOM");
	        if (dom!=null){
	        	this.getPointer().getDOM().setX((int)dom.getNumber("x"));
	        	this.getPointer().getDOM().setY((int)dom.getNumber("y"));
	        }
	        JsonObject canvas = pointer.getObject("canvas");
	        if (canvas!=null){
	        	this.getPointer().getCanvas().setX((int)canvas.getNumber("x"));
	        	this.getPointer().getCanvas().setY((int)canvas.getNumber("y"));
	        }
        }
        
        JsonObject previousSelection = properties.getObject(0).getObject("previousSelection");
        if (previousSelection!=null) {
        	JsonArray previousEdges = previousSelection.getArray("edges");
        	 for(int i = 0 ; i<previousEdges.length() ; i++ ){
                 this.getPreviousSelection().getEdgeIds().add(previousEdges.getString(i));
             }
        	 JsonArray previousNodes = previousSelection.getArray("nodes");
        	 for(int i = 0 ; i<previousNodes.length() ; i++ ){
                 this.getPreviousSelection().getNodeIds().add(previousNodes.getString(i));
             }
        }
        
    }

}
