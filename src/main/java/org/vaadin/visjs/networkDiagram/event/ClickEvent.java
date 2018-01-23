package org.vaadin.visjs.networkDiagram.event;

import org.vaadin.visjs.networkDiagram.api.Event;

import elemental.json.JsonArray;
import elemental.json.JsonException;
import elemental.json.JsonObject;

/**
 * Created by roshans on 11/30/14. Added previousSelection and pointer by Martin Prause 9.8.2017
 */
public class ClickEvent extends Event {
  public ClickEvent(final JsonArray properties) throws JsonException {
    super();
    final JsonArray edges = properties.getObject(0).getArray("edges");
    final JsonArray nodes = properties.getObject(0).getArray("nodes");
    for (int i = 0; i < nodes.length(); i++) {
      getNodeIds().add(nodes.getString(i));
    }

    for (int i = 0; i < edges.length(); i++) {
      getEdgeIds().add(edges.getString(i));
    }

    final JsonObject pointer = properties.getObject(0).getObject("pointer");
    if (pointer != null) {
      final JsonObject dom = pointer.getObject("DOM");
      if (dom != null) {
        this.getPointer().getDOM().setX((int) dom.getNumber("x"));
        this.getPointer().getDOM().setY((int) dom.getNumber("y"));
      }
      final JsonObject canvas = pointer.getObject("canvas");
      if (canvas != null) {
        this.getPointer().getCanvas().setX((int) canvas.getNumber("x"));
        this.getPointer().getCanvas().setY((int) canvas.getNumber("y"));
      }
    }

    final JsonObject previousSelection = properties.getObject(0).getObject("previousSelection");
    if (previousSelection != null) {
      final JsonArray previousEdges = previousSelection.getArray("edges");
      for (int i = 0; i < previousEdges.length(); i++) {
        this.getPreviousSelection().getEdgeIds().add(previousEdges.getString(i));
      }
      final JsonArray previousNodes = previousSelection.getArray("nodes");
      for (int i = 0; i < previousNodes.length(); i++) {
        this.getPreviousSelection().getNodeIds().add(previousNodes.getString(i));
      }
    }
  }
}
