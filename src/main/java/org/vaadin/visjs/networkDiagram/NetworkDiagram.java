package org.vaadin.visjs.networkDiagram;

import java.util.List;

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


/**
 * Created by roshans on 10/10/14. Added callback function, events and graph methods by Martin
 * Prause 9.8.2017
 */

@JavaScript({"vis.js", "networkDiagram-connector.js"})
@StyleSheet({"vis-network.min.css", "networkDiagram.css"})
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

  private final Gson gson = new Gson();


  public NetworkDiagram(final Options options) {
    super();


    addFunction(Constants.ON_SELECT, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireSelectEvent(event);
      }
    });
    addFunction(Constants.ON_SELECT_NODE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireNodeSelectEvent(event);
      }
    });

    addFunction(Constants.ON_SELECT_EDGE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireEdgeSelectEvent(event);
      }
    });

    addFunction(Constants.ON_CLICK, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireClickEvent(event);
      }
    });
    addFunction(Constants.ON_DOUBLE_CLICK, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireDoubleClickEvent(event);
      }
    });
    addFunction(Constants.ON_HOVER_NODE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
        fireHoverNodeEvent(event);
      }
    });
    addFunction(Constants.ON_BLUR_NODE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
        fireBlurNodeEvent(event);
      }
    });
    addFunction(Constants.ON_HOVER_EDGE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
        fireHoverEdgeEvent(event);
      }
    });
    addFunction(Constants.ON_BLUR_EDGE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final HoverBlurEvent event = EventGenerator.getHoverBlurEvent(properties);
        fireBlurEdgeEvent(event);
      }
    });

    addFunction(Constants.ON_CONTEXT, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireOnContextEvent(event);
      }
    });

    addFunction(Constants.ON_HOLD, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireHoldEvent(event);
      }
    });

    addFunction(Constants.ON_RELEASE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireReleaseEvent(event);
      }
    });

    addFunction(Constants.ON_DESELECT_NODE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireDeselectNodeEvent(event);
      }
    });

    addFunction(Constants.ON_DESELECT_EDGE, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireDeselectEdgeEvent(event);
      }
    });

    addFunction(Constants.ON_DRAG_START, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireDragStartEvent(event);
      }
    });
    addFunction(Constants.ON_DRAG_END, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireDragEndEvent(event);
      }
    });

    addFunction(Constants.ON_DRAGGING, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        final ClickEvent event = EventGenerator.getClickEvent(properties);
        fireDraggingEvent(event);
      }
    });

    addFunction(Constants.ON_START_STABILIZATION, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        // System.out.println("onStartStabilization" + properties);
        fireGraphStabilizationStartEvent(new NetworkEvent());
      }
    });
    addFunction(Constants.ON_STABILIZED, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        // System.out.println("onStabilized" + properties);
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
        if (properties.length() > 0) {
          final AddNodeEvent event = EventGenerator.getAddNodeEventEvent(properties);
          fireAddNodeEvent(event);
          // debugPrintJsonProperties(Constants.ON_MANIPULATION_NODEADDED,properties.getObject(0));
        }
      }
    });
    addFunction(Constants.ON_MANIPULATION_EDGEADDED, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        if (properties.length() > 0) {
          final AddEdgeEvent event = EventGenerator.getAddEdgeEventEvent(properties);
          fireAddEdgeEvent(event);

          // debugPrintJsonProperties(Constants.ON_MANIPULATION_EDGEADDED,properties.getObject(0));
        }
      }
    });
    addFunction(Constants.ON_MANIPULATION_NODEDELETED, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        if (properties.length() > 0) {
          final DeleteNodesEdgesEvent event = EventGenerator.getDeleteNodesEdgesEvent(properties);
          fireDeleteEvent(event);
          // debugPrintJsonProperties(Constants.ON_MANIPULATION_NODEDELETED,properties.getObject(0));
        }
      }
    });
    addFunction(Constants.ON_MANIPULATION_EDGEDELETED, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        if (properties.length() > 0) {
          final DeleteNodesEdgesEvent event = EventGenerator.getDeleteNodesEdgesEvent(properties);
          fireDeleteEvent(event);
          // debugPrintJsonProperties(Constants.ON_MANIPULATION_EDGEDELETED,properties.getObject(0));
        }
      }
    });

    addFunction(Constants.ON_MANIPULATION_EDGEEDITED, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        if (properties.length() > 0) {
          final AddEdgeEvent event = EventGenerator.getAddEdgeEventEvent(properties);
          fireEditEdgeEvent(event);
          debugPrintJsonProperties(Constants.ON_MANIPULATION_EDGEEDITED, properties.getObject(0));
        }
      }
    });


    addFunction(Constants.ON_GETSELECTION, new JavaScriptFunction() {
      @Override
      public void call(final JsonArray properties) throws JsonException {
        if (properties.length() > 0) {
          // AddEdgeEvent event = EventGenerator.getAddEdgeEventEvent(properties);
          // fireEditEdgeEvent(event);
          // debugPrintJsonProperties(Constants.ON_GETSELECTION,properties.getObject(0));
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


    // System.out.println(gson.toJson(options));

    callFunction("init", gson.toJson(options));



  }

  private void debugPrintJsonProperties(final String header, final JsonObject properties) {

    for (final String key : properties.keys()) {
      final JsonType type = properties.get(key).getType();
      String value = "";
      if (type == JsonType.STRING) {
        value = properties.getString(key);
      } else if (type == JsonType.NUMBER) {
        value = String.valueOf(properties.getNumber(key));
      } else if (type == JsonType.BOOLEAN) {
        value = String.valueOf(properties.getBoolean(key));
      } else if (type == JsonType.ARRAY) {
        final JsonArray ar = properties.get(key);
        for (int i = 0; i < ar.length(); i++) {
          if (ar.get(i).getType() == JsonType.STRING) {
            value += " " + ar.getString(i);
          }
        }
      }
      System.out.println(header + ": " + key + ":" + value);
    }

  }



  public void setCustomNodeIfAdded(final boolean activate, final String id, final String label) {
    callFunction("setCustomNodeIfAdded", activate, id, label);
  }

  public void setCustomEdgeIfAdded(final boolean activate, final String id, final String label) {
    callFunction("setCustomEdgeIfAdded", activate, id, label);
  }

  @Override
  public NetworkDiagramState getState() {
    return (NetworkDiagramState) super.getState();
  }


  public void updateOptions(final Options options) {
    getState().updates++;
    callFunction("updateOptions", gson.toJson(options));
  }

  public void addNode(final Node... node) {
    getState().updates++;
    // System.out.println(gson.toJson(node));
    callFunction("addNodes", gson.toJson(node));
  }

  public void addNodes(final List<Node> nodes) {
    getState().updates++;
    callFunction("addNodes", gson.toJson(nodes));
  }

  public void addEdges(final List<Edge> edges) {
    getState().updates++;

    callFunction("addEdges", gson.toJson(edges));
  }

  public void addEdge(final Edge... edges) {
    getState().updates++;
    // System.out.println(gson.toJson(edges));
    callFunction("addEdges", gson.toJson(edges));
  }

  public void removeNode(final Node... node) {
    getState().updates++;
    callFunction("removeNode", gson.toJson(node));
  }

  public void removeEdge(final Edge... edges) {
    getState().updates++;
    callFunction("removeEdge", gson.toJson(edges));
  }

  public void updateNode(final Node... node) {
    getState().updates++;
    callFunction("updateNode", gson.toJson(node));
  }

  public void updateEdge(final Edge... edges) {
    getState().updates++;
    callFunction("updateEdge", gson.toJson(edges));
  }

  public void updateEdges(final List<Edge> edges) {
    callFunction("updateEdge", gson.toJson(edges));
  }

  public void updateNodes(final List<Node> nodes) {
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

  public void focusNode(final String id) {
    callFunction("focusNode", id);
  }

  public void addNodeMode() {
    callFunction("addNodeMode");
  }

  public void addEdgeMode() {
    callFunction("addEdgeMode");
  }

  public void enableEditMode() {
    callFunction("enableEditMode");
  }

  public void disableEditMode() {
    callFunction("disableEditMode");
  }

  public void editEdgeMode() {
    callFunction("editEdgeMode");
  }

  public void deleteSelected() {
    callFunction("deleteSelected");
  }

  public void fit() {
    callFunction("fit");
  }

  public void getSelection() {
    callFunction("getSelection");
  }

  public void storePositions() {
    callFunction("storePositions");
  }

  public void moveNode(final String nodeId, final int x, final int y) {
    callFunction("moveNode", nodeId, x, y);
  }

  public void setSize(final String x, final String y) {
    callFunction("setSize", x, y);
  }

  public void stabalize(final int iterations) {
    callFunction("stabalize", iterations);
  }

  public void releaseNode() {
    callFunction("releaseNode");
  }

  public void unselectAll() {
    callFunction("unselectAll");
  }


  public void clear() {
    clearEdges();
    clearNodes();
  }

  public void drawConnections() {
    callFunction("drawConnections");
  }

  // adding and removing graph listeners


  public void addSelectListener(final GraphSelectListener listener) {
    selectListener = listener;
  }

  public void removeSelectListener() {
    selectListener = null;
  }

  public void addNodeSelectListener(final GraphSelectListener listener) {
    nodeSelectListeners = listener;
  }

  public void removeNodeSelectListener() {
    nodeSelectListeners = null;
  }

  public void addEdgeSelectListener(final GraphSelectListener listener) {
    edgeSelectListeners = listener;
  }

  public void removeEdgeSelectListener() {
    edgeSelectListeners = null;
  }

  public void addClickListener(final GraphSelectListener listener) {
    clickListener = listener;
  }

  public void removeClickListener() {
    clickListener = null;
  }

  public void addDoubleClickListener(final GraphSelectListener listener) {
    doubleClickListener = listener;
  }

  public void removeDoubleClickListener() {
    doubleClickListener = null;
  }

  public void addOnContextListener(final GraphSelectListener listener) {
    onContextListener = listener;
  }

  public void removeOnContextListener() {
    onContextListener = null;
  }

  public void addHoldListener(final GraphSelectListener listener) {
    holdListener = listener;
  }

  public void removeHoldListener() {
    holdListener = null;
  }

  public void addReleaseListener(final GraphSelectListener listener) {
    releaseListener = listener;
  }

  public void removeReleaseListener() {
    releaseListener = null;
  }

  public void addDeselectNodeListener(final GraphSelectListener listener) {
    deselectNodeListener = listener;
  }

  public void removeDeselectNodeListener() {
    deselectNodeListener = null;
  }

  public void addDeselectEdgeListener(final GraphSelectListener listener) {
    deselectEdgeListener = listener;
  }

  public void removeDeselectEdgeListener() {
    deselectEdgeListener = null;
  }

  public void addHoverNodeListener(final GraphListener listener) {
    hoverNodeListener = listener;
  }

  public void removeHoverNodeListener() {
    hoverNodeListener = null;
  }

  public void addBlurNodeListener(final GraphListener listener) {
    blurNodeListener = listener;
  }

  public void removeBlurNodeListener() {
    blurNodeListener = null;
  }

  public void addHoverEdgeListener(final GraphListener listener) {
    hoverEdgeListener = listener;
  }

  public void removeHoverEdgeListener() {
    hoverEdgeListener = null;
  }

  public void addBlurEdgeListener(final GraphListener listener) {
    blurEdgeListener = listener;
  }

  public void removeBlurEdgeListener() {
    blurEdgeListener = null;
  }

  public void addDragStartListener(final GraphSelectListener listener) {
    dragStartListener = listener;
  }

  public void removeDragStartListener() {
    dragStartListener = null;
  }

  public void addDragEndListener(final GraphSelectListener listener) {
    dragEndListener = listener;
  }

  public void removeDragEndListener() {
    dragEndListener = null;
  }

  public void addDraggingListener(final GraphSelectListener listener) {
    draggingListener = listener;
  }

  public void removeDraggingEndListener() {
    draggingListener = null;
  }

  public void addManipulationListenerListener(final ManipulationListener listener) {
    manipulationListener = listener;
  }

  public void removeManipulationListener() {
    manipulationListener = null;
  }

  public void addResizeListener(final GraphListener resizeListener) {
    this.resizeListener = resizeListener;
  }

  public void addStabilizationStartListener(final GraphListener stabilizationStartListener) {
    this.stabilizationStartListener = stabilizationStartListener;
  }

  public void addStabilizedListener(final GraphListener stabilizedListener) {
    this.stabilizedListener = stabilizedListener;
  }


  public void addZoomListener(final GraphListener zoomListener) {
    this.zoomListener = zoomListener;
  }

  public void removeResizeListener() {
    resizeListener = null;
  }

  public void removeStabilizationStartListener() {
    stabilizationStartListener = null;
  }

  public void removeStabilizedListener() {
    stabilizedListener = null;
  }

  public void removeZoomListener() {
    zoomListener = null;
  }

  public void addShowPopupListener(final GraphDrawingListener listener) {
    showPopupListener = listener;
  }

  public void removeShowPopupListener() {
    showPopupListener = null;
  }

  public void addHidePopupListener(final GraphDrawingListener listener) {
    hidePopupListener = listener;
  }

  public void removeHidePopupListener() {
    hidePopupListener = null;
  }


  public void addInitRedrawListener(final GraphDrawingListener listener) {
    initRedrawListener = listener;
  }

  public void removeInitRedrawListener() {
    initRedrawListener = null;
  }

  public void addBeforeDrawingListener(final GraphDrawingListener listener) {
    beforeDrawingListener = listener;
  }

  public void removeBeforeDrawingListener() {
    beforeDrawingListener = null;
  }

  public void addAfterDrawingListener(final GraphDrawingListener listener) {
    afterDrawingListener = listener;
  }

  public void removeAfterDrawingListener() {
    afterDrawingListener = null;
  }


  // listeners for entire graph

  public void fireSelectEvent(final ClickEvent event) {
    if (selectListener != null) {
      selectListener.onFired(event);
    }
  }

  public void fireGraphResizeEvent(final NetworkEvent event) {
    if (resizeListener != null) {
      resizeListener.onFired(event);
    }
  }

  public void fireGraphStabilizationStartEvent(final NetworkEvent event) {
    if (stabilizationStartListener != null) {
      stabilizationStartListener.onFired(event);
    }
  }

  public void fireGraphStabilizedEvent(final NetworkEvent event) {
    if (stabilizedListener != null) {
      stabilizedListener.onFired(event);
    }
  }

  public void fireGraphZoomEvent(final NetworkEvent event) {
    if (zoomListener != null) {
      zoomListener.onFired(event);
    }
  }


  public void fireEdgeSelectEvent(final ClickEvent event) {
    if (edgeSelectListeners != null) {
      edgeSelectListeners.onFired(event);
    }
  }

  public void fireNodeSelectEvent(final ClickEvent event) {
    if (nodeSelectListeners != null) {
      nodeSelectListeners.onFired(event);
    }
  }

  public void fireClickEvent(final ClickEvent event) {
    if (clickListener != null) {
      clickListener.onFired(event);
    }
  }

  public void fireDoubleClickEvent(final ClickEvent event) {
    if (doubleClickListener != null) {
      doubleClickListener.onFired(event);
    }
  }

  public void fireOnContextEvent(final ClickEvent event) {
    if (onContextListener != null) {
      onContextListener.onFired(event);
    }
  }

  public void fireHoldEvent(final ClickEvent event) {
    if (holdListener != null) {
      holdListener.onFired(event);
    }
  }

  public void fireReleaseEvent(final ClickEvent event) {
    if (releaseListener != null) {
      releaseListener.onFired(event);
    }
  }

  public void fireDeselectNodeEvent(final ClickEvent event) {
    if (deselectNodeListener != null) {
      deselectNodeListener.onFired(event);
    }
  }

  public void fireDeselectEdgeEvent(final ClickEvent event) {
    if (deselectEdgeListener != null) {
      deselectEdgeListener.onFired(event);
    }
  }

  public void fireHoverNodeEvent(final HoverBlurEvent event) {
    if (hoverNodeListener != null) {
      hoverNodeListener.onFired(event);
    }
  }

  public void fireBlurNodeEvent(final HoverBlurEvent event) {
    if (blurNodeListener != null) {
      blurNodeListener.onFired(event);
    }
  }

  public void fireHoverEdgeEvent(final HoverBlurEvent event) {
    if (hoverEdgeListener != null) {
      hoverEdgeListener.onFired(event);
    }
  }

  public void fireBlurEdgeEvent(final HoverBlurEvent event) {
    if (blurEdgeListener != null) {
      blurEdgeListener.onFired(event);
    }
  }

  public void fireDragStartEvent(final ClickEvent event) {
    if (dragStartListener != null) {
      dragStartListener.onFired(event);
    }
  }

  public void fireDragEndEvent(final ClickEvent event) {
    if (dragEndListener != null) {
      dragEndListener.onFired(event);
    }
  }

  public void fireDraggingEvent(final ClickEvent event) {
    if (draggingListener != null) {
      draggingListener.onFired(event);
    }
  }

  public void fireAddNodeEvent(final AddNodeEvent event) {
    if (manipulationListener != null) {
      manipulationListener.onFiredNodeAdded(event);
    }
  }

  public void fireAddEdgeEvent(final AddEdgeEvent event) {
    if (manipulationListener != null) {
      manipulationListener.onFiredEdgeAdded(event);
    }
  }

  public void fireEditEdgeEvent(final AddEdgeEvent event) {
    if (manipulationListener != null) {
      manipulationListener.onFiredEdgeEdited(event);
    }
  }

  public void fireDeleteEvent(final DeleteNodesEdgesEvent event) {
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
