package org.vaadin.visjs.networkDiagram.options;

/**
 * Created by Martin Prause 4.8.2017
 */
public class Configure {

	 private boolean enabled= false;
	 private boolean showButton= false;
	 //TODO
	 //filter: 'nodes,edges',
	 //container: undefined,
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isShowButton() {
		return showButton;
	}
	public void setShowButton(boolean showButton) {
		this.showButton = showButton;
	}
	 
}
