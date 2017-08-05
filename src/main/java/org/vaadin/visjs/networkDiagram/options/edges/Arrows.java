package org.vaadin.visjs.networkDiagram.options.edges;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin Prause 5.8.2017
 */

public class Arrows {
	
	ArrowHead to;
	ArrowHead middle;
	ArrowHead from;

	
	public ArrowHead getTo() {
		return to;
	}


	public void setTo(ArrowHead to) {
		this.to = to;
	}


	public ArrowHead getMiddle() {
		return middle;
	}


	public void setMiddle(ArrowHead middle) {
		this.middle = middle;
	}


	public ArrowHead getFrom() {
		return from;
	}


	public void setFrom(ArrowHead from) {
		this.from = from;
	}


	public static enum Style {
        @SerializedName("arrow")
        arrow,
        @SerializedName("circle")
        circle;
	}

}
