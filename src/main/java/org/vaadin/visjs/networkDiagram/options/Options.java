package org.vaadin.visjs.networkDiagram.options;

import java.util.HashMap;

import org.vaadin.visjs.networkDiagram.options.edges.ArrowHead;
import org.vaadin.visjs.networkDiagram.options.edges.Arrows;
import org.vaadin.visjs.networkDiagram.options.edges.Edges;
import org.vaadin.visjs.networkDiagram.options.edges.Layout;
import org.vaadin.visjs.networkDiagram.options.nodes.Nodes;
import org.vaadin.visjs.networkDiagram.options.physics.Physics;

/**
 * Created by roshans on 10/10/14. Updated with new modules by Martin Prause 9.8.2017
 */
public class Options {

  private boolean clickToUse = true;
  private boolean autoResize = true;
  private String locale = "en";
  private String height = "300px";
  private String width = "300px";
  private HashMap<String, Locale> locales;
  private Configure configure;
  private Manipulation manipulation;
  private Interaction interaction;
  private HashMap<String, Group> groups;


  private Physics physics;
  private Edges edges;
  private Nodes nodes;
  // private Cluster clustering;
  private Layout layout;


  public Options() {
    configure = new Configure();
    manipulation = new Manipulation();
    interaction = new Interaction();
    locales = new HashMap<>();
    locales.put("en", new Locale());
    final Arrows ar = new Arrows(new ArrowHead());
    edges = new Edges();
    edges.setArrows(ar);
    nodes = new Nodes();
    groups = new HashMap<>();
    physics = new Physics();
    layout = new Layout();
  }

  public HashMap<String, Group> getGroups() {
    return groups;
  }

  public void setGroups(final HashMap<String, Group> groups) {
    this.groups = groups;
  }

  public void addGroup(final String name, final Group group) {
    groups.put(name, group);
  }

  public void removeGroup(final String name) {
    groups.remove(name);
  }

  public void clearGroups() {
    groups.clear();
  }

  public Interaction getInteraction() {
    return interaction;
  }

  public void setInteraction(final Interaction interaction) {
    this.interaction = interaction;
  }

  public boolean isAutoResize() {
    return autoResize;
  }

  public void setAutoResize(final boolean autoResize) {
    this.autoResize = autoResize;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(final String locale) {
    this.locale = locale;
  }

  public Configure getConfigure() {
    return configure;
  }

  public void setConfigure(final Configure configure) {
    this.configure = configure;
  }

  public Manipulation getManipulation() {
    return manipulation;
  }

  public void setManipulation(final Manipulation manipulation) {
    this.manipulation = manipulation;
  }

  public boolean isClickToUse() {
    return clickToUse;
  }

  public void setClickToUse(final boolean clickToUse) {
    this.clickToUse = clickToUse;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(final String height) {
    this.height = height;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(final String width) {
    this.width = width;
  }

  public HashMap<String, Locale> getLocales() {
    return locales;
  }

  public void setLocales(final HashMap<String, Locale> locales) {
    this.locales = locales;
  }

  public Physics getPhysics() {
    return physics;
  }

  public void setPhysics(final Physics physics) {
    this.physics = physics;
  }

  public Edges getEdges() {
    return edges;
  }

  public void setEdges(final Edges edges) {
    this.edges = edges;
  }

  public Nodes getNodes() {
    return nodes;
  }

  public void setNodes(final Nodes nodes) {
    this.nodes = nodes;
  }

  public Layout getLayout() {
    return layout;
  }

  public void setLayout(final Layout layout) {
    this.layout = layout;
  }

}
