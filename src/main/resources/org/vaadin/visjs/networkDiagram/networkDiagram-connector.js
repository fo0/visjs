/**
 * Created by roshans on 10/10/14.
 */

window.org_vaadin_visjs_networkDiagram_NetworkDiagram = function () {

    var nodes;
    var edges;
    var graph;
    var options = {"clickToUse" :"false"};
    var container;
    var self = this;
    var customNodeifAdded =false;
    var customNodeID;
    var customNodeLabel;    
    var customEdgeifAdded =false;
    var customEdgeID;  
    var customEdgeLabel;    
    

    this.onStateChange = function(){
        graph.redraw();
    }

    this.init = function(o){
        options = JSON.parse(o);
        options.manipulation.addNode=function(nodeData,callback) { if (customNodeifAdded==true) {nodeData.label=customNodeLabel;nodeData.id=customNodeID;} self.onManipulationNodeAdded(nodeData);callback(nodeData); };
        options.manipulation.addEdge=function(edgeData,callback) { if (customEdgeifAdded==true) {edgeData.label=customEdgeLabel;edgeData.id=customEdgeID;} self.onManipulationEdgeAdded(edgeData);callback(edgeData); };
        options.manipulation.deleteNode=function(nodeData,callback) { self.onManipulationNodeDeleted(nodeData);callback(nodeData); };
        options.manipulation.deleteEdge=function(edgeData,callback) { self.onManipulationEdgeDeleted(edgeData);callback(edgeData); };

        nodes = new vis.DataSet();
        edges = new vis.DataSet();
        container = this.getElement();
        graph = new vis.Network(container,{ nodes: nodes, edges: edges } , options);

            graph.on('select',function(properties){
                self.onSelect(properties);
                });
            graph.on('click',function(properties){
                self.onClick(properties);
                 });
             graph.on('doubleClick',function(properties){
                     self.onDoubleClick(properties);
                });
             graph.on('hoverNode',function(properties){
                      self.onHoverNode(properties);
                });
             graph.on("blurNode",function(properties){
                    self.onBlurNode(properties);
                });
             graph.on('resize',function(properties){
                    self.onResize(properties);
                });
             graph.on('dragStart',function(properties){
                    self.onDragStart(properties);
                });
             graph.on('dragEnd',function(properties){
                    self.onDragEnd(properties);
                });
             graph.on('startStabilization',function(properties){
                    self.onStartStabilization(properties);
                });
             graph.on('stabilized',function(properties){
                     self.onStabilized(properties);
                });
             graph.on('viewChanged',function(properties){
                self.onViewChanged(properties);
                });

            graph.on('zoom',function(properties){
                self.onZoom(properties);
                });
          
            graph.draw();
    };
    
    this.setCustomNodeIfAdded = function(b,s1,s2) {
    	  customNodeifAdded=b;
    	  customNodeID=s1;
    	  customLabel=s2;    
    }
    
    this.setCustomEdgeIfAdded = function(b,s1,s2) {
        customEdgeifAdded=b;
        customEdgeID=s1;  
        customEdgeLabel=s2;    
    }
    
    this.updateOptions = function (o) {
        options = JSON.parse(o);
        graph.redraw();
    };

    this.addNodes = function (n) {
        nodes.add(JSON.parse(n));
    };

    this.addEdges = function (e) {
        edges.add(JSON.parse(e));

    };

    this.drawConnections = function () {
        graph.redraw();
    };

    this.removeNode = function(n){
        nodes.remove(JSON.parse(n));
    };

    this.removeEdge = function(e){
        edges.remove(JSON.parse(e));
    };

    this.updateNode = function(n){
        nodes.update(JSON.parse(n));
    };

    this.updateEdge = function(e){
        edges.update(JSON.parse(e));
    };

    this.clearNodes = function(){
        nodes.clear();
    };

    this.clearEdges = function(){
        edges.clear();
    };

    this.destroyNetwork = function(){
        graph.destroyNetwork();
    };
};
