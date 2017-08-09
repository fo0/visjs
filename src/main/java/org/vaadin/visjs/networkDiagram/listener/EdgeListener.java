package org.vaadin.visjs.networkDiagram.listener;

import org.vaadin.visjs.networkDiagram.Edge;
import org.vaadin.visjs.networkDiagram.Node;
import org.vaadin.visjs.networkDiagram.api.Event;
import org.vaadin.visjs.networkDiagram.event.NetworkEvent;

/**
 * Created by Martin Prause 9.8.2017
 */
public abstract class EdgeListener {
    Edge edge;

    public EdgeListener(Edge edge){
        this.edge = edge;
    }

    public Edge getEdge(){
        return edge;
    }
}
