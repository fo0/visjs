package org.vaadin.visjs.networkDiagram.event;

import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.Node;

/**
 * Created by roshans on 11/24/14.
 */
public class NetworkEvent {

    String node;
    String edge;
    
    
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getEdge() {
		return edge;
	}
	public void setEdge(String edge) {
		this.edge = edge;
	}
   
  
}
