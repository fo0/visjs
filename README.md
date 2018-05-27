# Visjs (4.x) Network implementation for Vaadin (8.x) - Addon

## Introduction
[Vis.js](http://visjs.org) is a dynamic, browser based visualization library. The library uses JSON for configuration and communication. 

## About this fork
 - Forked from [watho](https://github.com/watho/visjs). Based on [sameeraroshan](https://github.com/sameeraroshan/visjs)
 - Adding to the Vaadin Directory to add the missing maven integration
 - Let's see what more :-)

## About the addon
 - It only implements the network module, because all other charts provided by vis.js are already captured by Vaadin Charts.
 - The vis.js library is developed by Almende B.V, as part of CHAP. Vis.js runs fine on Chrome, Firefox, Opera, Safari, IE9+, and most mobile browsers (with full touch support).
 - Visit [http://visjs.org/docs/network/index.html](http://visjs.org/docs/network/index.html) for the documentation on visjs.
 - Visit http://visjs.org/network_examples.html for network examples in JS. Not everything is possible with this addon.


## What is implemented?
Everything in here [vis.js network](http://visjs.org/docs/network/), except

* Clustering
* Graph methods that return objects (tricky in Vaadin)
* Loading data from DOT or Gephi

## Maven dependencies

```java
<dependency>
	<groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.2.4</version>
</dependency>
```
