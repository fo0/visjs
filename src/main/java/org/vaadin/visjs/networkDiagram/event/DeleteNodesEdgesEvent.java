package org.vaadin.visjs.networkDiagram.event;


import java.util.ArrayList;
import java.util.List;

import elemental.json.JsonArray;
import elemental.json.JsonException;

/**
 * Created by Martin Prause 9.8.2017
 */
public class DeleteNodesEdgesEvent {
	
	private ArrayList<String> nodes=new ArrayList<String>();
	private ArrayList<String> edges=new ArrayList<String>();

    public DeleteNodesEdgesEvent(JsonArray properties) throws JsonException {

    	if (properties.getObject(0).hasKey("nodes")){
    	     JsonArray nodeIDs = properties.getObject(0).getArray("nodes");
    	     for(int i = 0 ; i<nodeIDs.length() ; i++ ){
    	    	 nodes.add(nodeIDs.getString(i));
    	     }
    	}
    	
    	if (properties.getObject(0).hasKey("edges")){
   	     JsonArray edgeIDs = properties.getObject(0).getArray("edges");
   	     for(int i = 0 ; i<edgeIDs.length() ; i++ ){
   	    	 edges.add(edgeIDs.getString(i));
   	     }
   	}
     
    }

	public ArrayList<String> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<String> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<String> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<String> edges) {
		this.edges = edges;
	}


    
    

}
