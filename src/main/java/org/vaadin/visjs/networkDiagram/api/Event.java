package org.vaadin.visjs.networkDiagram.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roshans on 11/30/14.
 */
public abstract class Event {
	
	
    private List<String> nodeIds;
    private List<String> edgeIds;
    private Pointer pointer;
    private PreviousSelection previousSelection;
    
    public Event(){
        nodeIds = new ArrayList<>();
        edgeIds = new ArrayList<>();
        pointer=new Pointer();
        previousSelection= new PreviousSelection();
    }

    public List<String> getNodeIds() {
        return nodeIds;
    }

    public void setNodeIds(List<String> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public List<String> getEdgeIds() {
        return edgeIds;
    }

    public void setEdgeIds(List<String> edgeIds) {
        this.edgeIds = edgeIds;
    }

	public Pointer getPointer() {
		return pointer;
	}

	public void setPointer(Pointer pointer) {
		this.pointer = pointer;
	}

	public PreviousSelection getPreviousSelection() {
		return previousSelection;
	}

	public void setPreviousSelection(PreviousSelection previousSelection) {
		this.previousSelection = previousSelection;
	}
    
    
}

