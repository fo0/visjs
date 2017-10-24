package org.vaadin.visjs.networkDiagram.util;

/**
 * Created by roshans on 10/22/14. Added opacity property by Martin Prause 5.8.2017
 */
public class Color {

  private String hover;
  private String highlight = "#D2E5FF";
  // private String border = "#2B7CE9";
  // private String background = "#97C2FC";
  private String color = "#df6b1d";
  private int opacity = 1;

  public Color() {}

  public Color(final String color) {
    this.color = color;
  }

  public Color(final String backgroundColor, final String highlightColor) {
    // this.background = backgroundColor;
    highlight = highlightColor;
  }

  public Color(final String backgroundColor, final String hoverColor, final String highlightColor) {
    // this.background = backgroundColor;
    highlight = highlightColor;
    hover = hoverColor;
  }

  public Color(final String backgroundColor, final String hoverColor, final String highlightColor,
      final String borderColor) {
    // this.background = backgroundColor;
    hover = hoverColor;
    highlight = highlightColor;
    // this.border = borderColor;
  }



  public int getOpacity() {
    return opacity;
  }

  public void setOpacity(final int opacity) {
    this.opacity = opacity;
  }

  public String getHoverColor() {
    return hover;
  }

  public void setHoverColor(final String hover) {
    this.hover = hover;
  }

  public String getHighlight() {
    return highlight;
  }

  public void setHighlightColor(final String highlight) {
    this.highlight = highlight;
  }

  // public String getBorderColor() {
  // return border;
  // }
  //
  // public void setBorderColor(String border) {
  // this.border = border;
  // }
  //
  // public String getBackgroundColor() {
  // return background;
  // }
  //
  // public void setBackgroundColor(String background) {
  // this.background = background;
  // }

  public String getColor() {
    return color;
  }

  public void setColor(final String color) {
    this.color = color;
  }

  public String getHover() {
    return hover;
  }

  public void setHover(final String hover) {
    this.hover = hover;
  }

  // public String getBorder() {
  // return border;
  // }
  //
  // public void setBorder(String border) {
  // this.border = border;
  // }
  //
  // public String getBackground() {
  // return background;
  // }
  //
  // public void setBackground(String background) {
  // this.background = background;
  // }

  public void setHighlight(final String highlight) {
    this.highlight = highlight;
  }


}
