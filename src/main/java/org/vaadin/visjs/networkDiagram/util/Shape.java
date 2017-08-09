package org.vaadin.visjs.networkDiagram.util;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin Prause 9.8.2017
 */


public enum Shape {
	   @SerializedName("ellipse")
       ellipse,
       @SerializedName("circle")
       circle,
       @SerializedName("box")
       box,
       @SerializedName("database")
       database,
       @SerializedName("image")
       image,
       @SerializedName("circularImage")
       circularImage,
       @SerializedName("diamond")
       diamond,
       @SerializedName("dot")
       dot,
       @SerializedName("star")
       star,
       @SerializedName("triangleDown")
       triangleDown,
       @SerializedName("triangle")
       triangle,
       @SerializedName("square")
       square,
       @SerializedName("icon")
       icon;
}
