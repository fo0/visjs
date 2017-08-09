package org.vaadin.visjs.networkDiagram.listener;

import org.vaadin.visjs.networkDiagram.event.AddEdgeEvent;
import org.vaadin.visjs.networkDiagram.event.AddNodeEvent;
import org.vaadin.visjs.networkDiagram.event.DeleteNodesEdgesEvent;

/**
 * Created by Martin Prause 9.8.2017
 */
public interface  ManipulationListener {

    public  void onFiredNodeAdded(AddNodeEvent event);
    public  void onFiredEdgeAdded(AddEdgeEvent event);
    public  void onFiredEdgeEdited(AddEdgeEvent event);
    public  void onFiredDelete(DeleteNodesEdgesEvent event);
}
