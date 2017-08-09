package org.vaadin.visjs.networkDiagram;

import org.vaadin.visjs.networkDiagram.event.AddEdgeEvent;
import org.vaadin.visjs.networkDiagram.event.AddNodeEvent;
import org.vaadin.visjs.networkDiagram.event.ClickEvent;
import org.vaadin.visjs.networkDiagram.event.DeleteNodesEdgesEvent;
import org.vaadin.visjs.networkDiagram.event.HoverBlurEvent;
import org.vaadin.visjs.networkDiagram.event.NetworkEvent;
import org.vaadin.visjs.networkDiagram.listener.GraphDrawingListener;
import org.vaadin.visjs.networkDiagram.listener.GraphListener;
import org.vaadin.visjs.networkDiagram.listener.GraphSelectListener;
import org.vaadin.visjs.networkDiagram.listener.ManipulationListener;

import org.vaadin.visjs.networkDiagram.options.Options;
import org.vaadin.visjs.networkDiagram.util.Constants;
import com.google.gson.Gson;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import elemental.json.JsonArray;
import elemental.json.JsonException;
import elemental.json.JsonObject;
import elemental.json.JsonType;


import java.util.List;


/**
 * Created by roshans on 10/10/14.
 * Added callback function, events and graph methods by Martin Prause 9.8.2017
 */

@JavaScript({"vis.min.js", "networkDiagram-connector.js"})
@StyleSheet({"vis.min.css", "networkDiagram.css"})
public class NetworkDiagram extends AbstractJavaScriptComponent {
	
	
    
	private GraphSelectListener nodeSelectListeners;
	private GraphSelectListener edgeSelectListeners;
	private GraphSelectListener selectListener;
	private GraphSelectListener clickListener;
	private GraphSelectListener doubleClickListener;
	private GraphSelectListener onContextListener;
	private GraphSelectListener holdListener;
	private GraphSelectListener releaseListener;
	private GraphSelectListener deselectNodeListener;
	private GraphSelectListener deselectEdgeListener;
	private GraphListener hoverNodeListener;
	private GraphListener blurNodeListener;
	private GraphListener hoverEdgeListener;
	private GraphListener blurEdgeListener;
	private GraphSelectListener dragStartListener;
	private GraphSelectListener dragEndListener;
	private GraphSelectListener draggingListener;
    private GraphListener resizeListener;
    private GraphListener stabilizationStartListener;
    private GraphListener stabilizedListener;
    private GraphListener zoomListener;
    private ManipulationListener manipulationListener;
    private GraphDrawingListener showPopupListener;
    private GraphDrawingListener hidePopupListener;
    private GraphDrawingListener initRedrawListener;
    private GraphDrawingListener beforeDrawingListener;
    private GraphDrawingListener afterDrawingListener;
    
    private Gson gson = new Gson();

    
    public NetworkDiagram(Options options) {
        super();
        addFunction(Constants.ON_SELECT, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
               ClickEvent event = EventGenerator.getClickEvent(properties);
               fireSelectEvent(event);
            }
        });
        addFunction(Constants.ON_SELECT_NODE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
                fireNodeSelectEvent(event);
            }
        });
        
        addFunction(Constants.ON_SELECT_EDGE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
                fireEdgeSelectEvent(event);
            }
        });
        
        addFunction(Constants.ON_CLICK, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
                ClickEvent event = EventGenerator.getClickEvent(properties);
                fireClickEvent(event);
            }
        });
        addFunction(Constants.ON_DOUBLE_CLICK, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
                fireDoubleClickEvent(event);
            }
        });
        addFunction(Constants.ON_HOVER_NODE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
                HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
                fireHoverNodeEvent(event);
            }
        });
        addFunction(Constants.ON_BLUR_NODE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
            	fireBlurNodeEvent(event);
            }
        });
        addFunction(Constants.ON_HOVER_EDGE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
                HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
                fireHoverEdgeEvent(event);
            }
        });
        addFunction(Constants.ON_BLUR_EDGE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
            	fireBlurEdgeEvent(event);
            }
        });
        
        addFunction(Constants.ON_CONTEXT, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireOnContextEvent(event);
            }
        });
        
        addFunction(Constants.ON_HOLD, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireHoldEvent(event);
            }
        });
        
        addFunction(Constants.ON_RELEASE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireReleaseEvent(event);
            }
        });
        
        addFunction(Constants.ON_DESELECT_NODE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireDeselectNodeEvent(event);
            }
        });
        
        addFunction(Constants.ON_DESELECT_EDGE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireDeselectEdgeEvent(event);
            }
        });
        
        addFunction(Constants.ON_DRAG_START, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
                ClickEvent event = EventGenerator.getClickEvent(properties);
                fireDragStartEvent(event);
            }
        });
        addFunction(Constants.ON_DRAG_END, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireDragEndEvent(event);
            }
        });
        
        addFunction(Constants.ON_DRAGGING, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	ClickEvent event = EventGenerator.getClickEvent(properties);
            	fireDraggingEvent(event);
            }
        });
        
        addFunction(Constants.ON_START_STABILIZATION, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
                //System.out.println("onStartStabilization" + properties);
                fireGraphStabilizationStartEvent(new NetworkEvent());
            }
        });
        addFunction(Constants.ON_STABILIZED, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
                //System.out.println("onStabilized" + properties);
                fireGraphStabilizedEvent(new NetworkEvent());
            }
        });
      
        addFunction(Constants.ON_ZOOM, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
               fireGraphZoomEvent(new NetworkEvent());
            }
        });
        addFunction(Constants.ON_RESIZE, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
               fireGraphResizeEvent(new NetworkEvent());
            }
        });
        addFunction(Constants.ON_MANIPULATION_NODEADDED, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	if (properties.length()>0) {
            		AddNodeEvent event = EventGenerator.getAddNodeEventEvent(properties);
            		fireAddNodeEvent(event);
            		//debugPrintJsonProperties(Constants.ON_MANIPULATION_NODEADDED,properties.getObject(0));
            	}
            }
        });
        addFunction(Constants.ON_MANIPULATION_EDGEADDED, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	if (properties.length()>0) {
            		AddEdgeEvent event = EventGenerator.getAddEdgeEventEvent(properties);
            		fireAddEdgeEvent(event);
                	
            		//debugPrintJsonProperties(Constants.ON_MANIPULATION_EDGEADDED,properties.getObject(0));
            	}
            }
        });
        addFunction(Constants.ON_MANIPULATION_NODEDELETED, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	if (properties.length()>0) {
            		DeleteNodesEdgesEvent event = EventGenerator.getDeleteNodesEdgesEvent(properties);
            		fireDeleteEvent(event);
            		//debugPrintJsonProperties(Constants.ON_MANIPULATION_NODEDELETED,properties.getObject(0));
            	}
            }
        });
        addFunction(Constants.ON_MANIPULATION_EDGEDELETED, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	if (properties.length()>0) {
            		DeleteNodesEdgesEvent event = EventGenerator.getDeleteNodesEdgesEvent(properties);
            		fireDeleteEvent(event);
            		//debugPrintJsonProperties(Constants.ON_MANIPULATION_EDGEDELETED,properties.getObject(0));
            	}
            }
        });
        
        addFunction(Constants.ON_MANIPULATION_EDGEEDITED, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	if (properties.length()>0) {
            		AddEdgeEvent event = EventGenerator.getAddEdgeEventEvent(properties);
            		fireEditEdgeEvent(event);
            		debugPrintJsonProperties(Constants.ON_MANIPULATION_EDGEEDITED,properties.getObject(0));
            	}
            }
        });
        
        
        addFunction(Constants.ON_GETSELECTION, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	if (properties.length()>0) {
            		//AddEdgeEvent event = EventGenerator.getAddEdgeEventEvent(properties);
            		//fireEditEdgeEvent(event);
            		//debugPrintJsonProperties(Constants.ON_GETSELECTION,properties.getObject(0));
            	}
            }
        });
        
        
        addFunction(Constants.ON_SHOWPOPUP, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	fireShowPopupEvent();
            }
        });
        
        addFunction(Constants.ON_HIDEPOPUP, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	fireHidePopupEvent();
            }
        });
        
        addFunction(Constants.ON_INITREDRAW, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	fireInitRedrawListener();
            }
        });
        
        addFunction(Constants.ON_BEFOREDRAWING, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	fireBeforeDrawingListener();
            }
        });
        
        addFunction(Constants.ON_AFTERDRAWING, new JavaScriptFunction() {
            @Override
            public void call(final JsonArray properties) throws JsonException {
            	fireAfterDrawingListener();
            }
        });
        
         
        //System.out.println(gson.toJson(options));
        
        callFunction("init", gson.toJson(options));
        
        
        
    }
    
    private void debugPrintJsonProperties(String header,JsonObject properties){
    	
    		for (String key:properties.keys()) {
    			JsonType type=properties.get(key).getType();
    			String value="";
    			if (type==JsonType.STRING) {
    				value=properties.getString(key);
    			} else if (type==JsonType.NUMBER) {
    				value=String.valueOf(properties.getNumber(key));
    			} else if (type==JsonType.BOOLEAN) {
    				value=String.valueOf(properties.getBoolean(key));
    			} else if (type==JsonType.ARRAY) {
    				JsonArray ar=properties.get(key);
    				for (int i=0;i<ar.length();i++) {
    					if (ar.get(i).getType()==JsonType.STRING) {
    						value+=" "+ar.getString(i);
    					}
    				}
    			}
    			System.out.println(header+": "+key+":"+value);
    		}

    }
    
      

    public void setCustomNodeIfAdded(boolean activate,String id,String label) {
    	callFunction("setCustomNodeIfAdded", activate,id,label);
    }
    public void setCustomEdgeIfAdded(boolean activate,String id,String label) {
    	callFunction("setCustomEdgeIfAdded", activate,id,label);
    }

    public NetworkDiagramState getState() {
        return (NetworkDiagramState) super.getState();
    }


    public void updateOptions(Options options) {
        getState().updates++;
        callFunction("updateOptions", gson.toJson(options));
    }

    public void addNode(Node... node) {
        getState().updates++;
        //System.out.println(gson.toJson(node));
        callFunction("addNodes", gson.toJson(node));
    }

    public void addNodes(List<Node> nodes) {
        getState().updates++;
        callFunction("addNodes", gson.toJson(nodes));
    }

    public void addEdges(List<Edge> edges) {
        getState().updates++;
        
        callFunction("addEdges", gson.toJson(edges));
    }

    public void addEdge(Edge... edges) {
        getState().updates++;
        //System.out.println(gson.toJson(edges));
        callFunction("addEdges", gson.toJson(edges));
    }

    public void removeNode(Node... node) {
        getState().updates++;
        callFunction("removeNode", gson.toJson(node));
    }

    public void removeEdge(Edge... edges) {
        getState().updates++;
        callFunction("removeEdge", gson.toJson(edges));
    }

    public void updateNode(Node... node) {
        getState().updates++;
        callFunction("updateNode", gson.toJson(node));
    }

    public void updateEdge(Edge... edges) {
        getState().updates++;
        callFunction("updateEdge", gson.toJson(edges));
    }

    public void updateEdges(List<Edge> edges) {
        callFunction("updateEdge", gson.toJson(edges));
    }

    public void updateNodes(List<Node> nodes) {
        callFunction("updateNode", gson.toJson(nodes));
    }

    public void clearNodes() {
        callFunction("clearNodes");
    }

    public void clearEdges() {
        callFunction("clearEdges");
    }

    public void destroyNetwork() {
        callFunction("destroyNetwork");
    }
    
    public void focusNode(String id){
    	callFunction("focusNode",id);
    }
    
    public void addNodeMode(){
    	callFunction("addNodeMode");
    }
    public void addEdgeMode(){
    	callFunction("addEdgeMode");
    }
    public void enableEditMode(){
    	callFunction("enableEditMode");
    }
    public void disableEditMode(){
    	callFunction("disableEditMode");
    }
    public void editEdgeMode(){
    	callFunction("editEdgeMode");
    }
    public void deleteSelected(){
    	callFunction("deleteSelected");
    }
    public void fit(){
    	callFunction("fit");
    }
    public void getSelection(){
    	callFunction("getSelection");
    }
    
    public void storePositions(){
    	callFunction("storePositions");
    }
    
    public void moveNode(String nodeId,int x,int y){
    	callFunction("moveNode",nodeId,x,y);
    }
    
    public void stabalize(int iterations){
    	callFunction("stabalize",iterations);
    }
    
    public void releaseNode(){
    	callFunction("releaseNode");
    }
    
    public void unselectAll(){
    	callFunction("unselectAll");
    }
   
   
    public void clear() {
        clearEdges();
        clearNodes();
    }

    public void drawConnections() {
        callFunction("drawConnections");
    }
    
    //adding and removing graph listeners
   
    
    public void addSelectListener(GraphSelectListener listener) {
        this.selectListener = listener;
    }
    
    public void removeSelectListener() {
        this.selectListener = null;
    }
    
    public void addNodeSelectListener(GraphSelectListener listener) {
        this.nodeSelectListeners = listener;
    }
    
    public void removeNodeSelectListener() {
        this.nodeSelectListeners = null;
    }
    
    public void addEdgeSelectListener(GraphSelectListener listener) {
        this.edgeSelectListeners = listener;
    }
    
    public void removeEdgeSelectListener() {
        this.edgeSelectListeners = null;
    }
     
    public void addClickListener(GraphSelectListener listener) {
        this.clickListener = listener;
    }
    
    public void removeClickListener() {
        this.clickListener = null;
    }
    
    public void addDoubleClickListener(GraphSelectListener listener) {
        this.doubleClickListener = listener;
    }
    
    public void removeDoubleClickListener() {
        this.doubleClickListener = null;
    }
    
    public void addOnContextListener(GraphSelectListener listener) {
        this.onContextListener = listener;
    }
    
    public void removeOnContextListener() {
        this.onContextListener = null;
    }
    
    public void addHoldListener(GraphSelectListener listener) {
        this.holdListener = listener;
    }
    
    public void removeHoldListener() {
        this.holdListener = null;
    }
    
    public void addReleaseListener(GraphSelectListener listener) {
        this.releaseListener = listener;
    }
    
    public void removeReleaseListener() {
        this.releaseListener = null;
    }
    
    public void addDeselectNodeListener(GraphSelectListener listener) {
        this.deselectNodeListener = listener;
    }
    
    public void removeDeselectNodeListener() {
        this.deselectNodeListener = null;
    }
    
    public void addDeselectEdgeListener(GraphSelectListener listener) {
        this.deselectEdgeListener = listener;
    }
    
    public void removeDeselectEdgeListener() {
        this.deselectEdgeListener = null;
    }
    public void addHoverNodeListener(GraphListener listener) {
        this.hoverNodeListener = listener;
    }
    
    public void removeHoverNodeListener() {
        this.hoverNodeListener = null;
    }
    
    public void addBlurNodeListener(GraphListener listener) {
        this.blurNodeListener = listener;
    }
    
    public void removeBlurNodeListener() {
        this.blurNodeListener = null;
    }
    
    public void addHoverEdgeListener(GraphListener listener) {
        this.hoverEdgeListener = listener;
    }
    
    public void removeHoverEdgeListener() {
        this.hoverEdgeListener = null;
    }
    
    public void addBlurEdgeListener(GraphListener listener) {
        this.blurEdgeListener = listener;
    }
    
    public void removeBlurEdgeListener() {
        this.blurEdgeListener = null;
    }
    
    public void addDragStartListener(GraphSelectListener listener) {
        this.dragStartListener = listener;
    }
    
    public void removeDragStartListener() {
        this.dragStartListener = null;
    }
    
    public void addDragEndListener(GraphSelectListener listener) {
        this.dragEndListener = listener;
    }
    
    public void removeDragEndListener() {
        this.dragEndListener = null;
    }
    
    public void addDraggingListener(GraphSelectListener listener) {
        this.draggingListener = listener;
    }
    
    public void removeDraggingEndListener() {
        this.draggingListener = null;
    }
    
    public void addManipulationListenerListener(ManipulationListener listener) {
        this.manipulationListener = listener;
    }
    
    public void removeManipulationListener() {
        this.manipulationListener = null;
    }
    
    public void addResizeListener(GraphListener resizeListener) {
        this.resizeListener = resizeListener;
    }

    public void addStabilizationStartListener(GraphListener stabilizationStartListener) {
        this.stabilizationStartListener = stabilizationStartListener;
    }

    public void addStabilizedListener(GraphListener stabilizedListener) {
        this.stabilizedListener = stabilizedListener;
    }

  
    public void addZoomListener(GraphListener zoomListener) {
        this.zoomListener = zoomListener;
    }

    public void removeResizeListener() {
        this.resizeListener = null;
    }

    public void removeStabilizationStartListener() {
        this.stabilizationStartListener = null;
    }

    public void removeStabilizedListener() {
        this.stabilizedListener = null;
    }

    public void removeZoomListener() {
        this.zoomListener = null;
    }
    public void addShowPopupListener(GraphDrawingListener listener) {
        this.showPopupListener = listener;
    }
    
    public void removeShowPopupListener() {
        this.showPopupListener = null;
    }
    
    public void addHidePopupListener(GraphDrawingListener listener) {
        this.hidePopupListener = listener;
    }
    
    public void removeHidePopupListener() {
        this.hidePopupListener = null;
    }
    
    
    public void addInitRedrawListener(GraphDrawingListener listener) {
        this.initRedrawListener = listener;
    }
    
    public void removeInitRedrawListener() {
        this.initRedrawListener = null;
    }
    
    public void addBeforeDrawingListener(GraphDrawingListener listener) {
        this.beforeDrawingListener = listener;
    }
    
    public void removeBeforeDrawingListener() {
        this.beforeDrawingListener = null;
    }
    
    public void addAfterDrawingListener(GraphDrawingListener listener) {
        this.afterDrawingListener = listener;
    }
    
    public void removeAfterDrawingListener() {
        this.afterDrawingListener = null;
    }
  

    //listeners for entire graph

    public void fireSelectEvent(ClickEvent event) {
        if (selectListener != null) {
        	selectListener.onFired(event);
        }
    }

    public void fireGraphResizeEvent(NetworkEvent event) {
        if (resizeListener != null) {
            resizeListener.onFired(event);
        }
    }

    public void fireGraphStabilizationStartEvent(NetworkEvent event) {
        if (stabilizationStartListener != null) {
            stabilizationStartListener.onFired(event);
        }
    }

    public void fireGraphStabilizedEvent(NetworkEvent event) {
        if (stabilizedListener != null) {
            stabilizedListener.onFired(event);
        }
    }

    public void fireGraphZoomEvent(NetworkEvent event) {
        if (zoomListener != null) {
            zoomListener.onFired(event);
        }
    }
    
    
    public void fireEdgeSelectEvent(ClickEvent event) {
        if (edgeSelectListeners != null) {
        	edgeSelectListeners.onFired(event);
        }
    }
    
    public void fireNodeSelectEvent(ClickEvent event) {
        if (nodeSelectListeners != null) {
        	nodeSelectListeners.onFired(event);
        }
    }
    
    public void fireClickEvent(ClickEvent event) {
        if (clickListener != null) {
        	clickListener.onFired(event);
        }
    }
   
    public void fireDoubleClickEvent(ClickEvent event) {
    	  if (doubleClickListener != null) {
    		  doubleClickListener.onFired(event);
          }
    }
    
    public void fireOnContextEvent(ClickEvent event) {
  	  if (onContextListener != null) {
  		onContextListener.onFired(event);
        }
  }
    
    public void fireHoldEvent(ClickEvent event) {
    	  if (holdListener != null) {
    		holdListener.onFired(event);
          }
    }

    public void fireReleaseEvent(ClickEvent event) {
  	  if (releaseListener != null) {
  		releaseListener.onFired(event);
        }
    }
    
    public void fireDeselectNodeEvent(ClickEvent event) {
    	  if (deselectNodeListener != null) {
    		  deselectNodeListener.onFired(event);
          }
      }
    
    public void fireDeselectEdgeEvent(ClickEvent event) {
  	  if (deselectEdgeListener != null) {
  		deselectEdgeListener.onFired(event);
        }
    }
    
    public void fireHoverNodeEvent(HoverBlurEvent event) {
    	  if (hoverNodeListener != null) {
    		  hoverNodeListener.onFired(event);
          }
      }
    
    public void fireBlurNodeEvent(HoverBlurEvent event) {
  	  if (blurNodeListener != null) {
  		  blurNodeListener.onFired(event);
        }
    }
    
    public void fireHoverEdgeEvent(HoverBlurEvent event) {
  	  if (hoverEdgeListener != null) {
  		  hoverEdgeListener.onFired(event);
        }
    }
  
  public void fireBlurEdgeEvent(HoverBlurEvent event) {
	  if (blurEdgeListener != null) {
		  blurEdgeListener.onFired(event);
      }
  }
  
  public void fireDragStartEvent(ClickEvent event) {
	  if (dragStartListener != null) {
		  dragStartListener.onFired(event);
      }
  }
  
  public void fireDragEndEvent(ClickEvent event) {
	  if (dragEndListener != null) {
		  dragEndListener.onFired(event);
      }
  }
  
  public void fireDraggingEvent(ClickEvent event) {
	  if (draggingListener != null) {
		  draggingListener.onFired(event);
      }
  }
  
  public void fireAddNodeEvent(AddNodeEvent event) {
	  if (manipulationListener != null) {
		  manipulationListener.onFiredNodeAdded(event);
      }
  }
  
  public void fireAddEdgeEvent(AddEdgeEvent event) {
	  if (manipulationListener != null) {
		  manipulationListener.onFiredEdgeAdded(event);
      }
  }
  
  public void fireEditEdgeEvent(AddEdgeEvent event) {
	  if (manipulationListener != null) {
		  manipulationListener.onFiredEdgeEdited(event);
      }
  }
  
  public void fireDeleteEvent(DeleteNodesEdgesEvent event) {
	  if (manipulationListener != null) {
		  manipulationListener.onFiredDelete(event);
      }
  }
   
  public void fireShowPopupEvent() {
  	  if (showPopupListener != null) {
  		showPopupListener.onFired();
        }
    }
  public void fireHidePopupEvent() {
  	  if (hidePopupListener != null) {
  		hidePopupListener.onFired();
        }
    }
  
  public void fireInitRedrawListener() {
  	  if (initRedrawListener != null) {
  		initRedrawListener.onFired();
        }
    }
  
  public void fireBeforeDrawingListener() {
  	  if (beforeDrawingListener != null) {
  		beforeDrawingListener.onFired();
        }
    }
  
  public void fireAfterDrawingListener() {
  	  if (afterDrawingListener != null) {
  		afterDrawingListener.onFired();
        }
    }
        
}
