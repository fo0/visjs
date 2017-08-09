package org.vaadin.visjs.networkDiagram.options;

import org.vaadin.visjs.networkDiagram.options.cluster.Cluster;
import org.vaadin.visjs.networkDiagram.options.edges.Edges;
import org.vaadin.visjs.networkDiagram.options.physics.Physics;

import java.util.List;

/**
 * Created by trobar 4.8.2017
 */
public class Manipulation {

	 private boolean enabled= false;
	 //All other fields are callback functions -> refer to NetworkDiagram

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	 
	 
}
