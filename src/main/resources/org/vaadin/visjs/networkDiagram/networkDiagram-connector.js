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
        //graph.redraw();
    }

    this.init = function(o){
        options = JSON.parse(o);
        options.manipulation.addNode=function(nodeData,callback) { if (customNodeifAdded==true) {nodeData.label=customNodeLabel;nodeData.id=customNodeID;} self.onManipulationNodeAdded(nodeData);callback(nodeData); };
        options.manipulation.addEdge=function(edgeData,callback) { if (customEdgeifAdded==true) {edgeData.label=customEdgeLabel;edgeData.id=customEdgeID;} self.onManipulationEdgeAdded(edgeData);callback(edgeData); };
        options.manipulation.deleteNode=function(nodeData,callback) { self.onManipulationNodeDeleted(nodeData);callback(nodeData); };
        options.manipulation.deleteEdge=function(edgeData,callback) { self.onManipulationEdgeDeleted(edgeData);callback(edgeData); };
        options.manipulation.editEdge=function(edgeData,callback) {  self.onManipulationEdgeEdited(edgeData);callback(edgeData); };


        nodes = new vis.DataSet();
        edges = new vis.DataSet();
        container = this.getElement();
        graph = new vis.Network(container,{ nodes: nodes, edges: edges } , options);

        	graph.on('select',function(properties){
        		self.onSelect(properties);
            });
            graph.on('selectNode',function(properties){
                self.onSelectNode(properties);
                });
            graph.on('selectEdge',function(properties){
                self.onSelectEdge(properties);
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
             graph.on('hoverEdge',function(properties){
                 self.onHoverEdge(properties);
             });
	         graph.on("blurEdge",function(properties){
	               self.onBlurEdge(properties);
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
             graph.on('dragging',function(properties){
                 self.onDragging(properties);
             });
             graph.on('startStabilization',function(properties){
                    self.onStartStabilization(properties);
                });
             graph.on('stabilized',function(properties){
                     self.onStabilized(properties);
                });
            
            graph.on('zoom',function(properties){
                self.onZoom(properties);
                });
          
            graph.on('oncontext',function(properties){
                self.onContext(properties);
                });
            graph.on('hold',function(properties){
                self.onHold(properties);
                });
            graph.on('release',function(properties){
                self.onRelease(properties);
                });
            graph.on('deselectNode',function(properties){
                self.onDeselectNode(properties);
                });
            graph.on('deselectEdge',function(properties){
                self.onDeselectEdge(properties);
                });           
            graph.on('showPopup',function(properties){
                self.onShowPopup(properties);
                });            
            graph.on('hidePopup',function(properties){
                self.onHidePopup(properties);
                });
            
            graph.on('initRedraw',function(properties){
                self.onInitRedraw(properties);
                });
            
            graph.on('beforeDrawing',function(properties){
                self.onBeforeDrawing(properties);
                });
            
            graph.on('afterDrawing',function(properties){
                self.onAfterDrawing(properties);
                });
            
            
      
            //graph.draw();
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
    
    this.focusNode = function (id) {
    	graph.focus(id);

    };
    
    
    this.addNodeMode = function (){
    	graph.addNodeMode();
    }
    this.addEdgeMode = function (){
    	graph.addEdgeMode();
    }
    
    this.enableEditMode = function (){
    	graph.enableEditMode();
    }
    
    this.disableEditMode = function (){
    	graph.disableEditMode();
    }
    this.editEdgeMode = function (){
    	graph.editEdgeMode();
    }
    this.deleteSelected = function (){
    	graph.deleteSelected();
    }
    this.fit = function (){
    	graph.fit();
    }
    
    this.getSelection = function (){
    	self.onGetSelection(graph.getSelection());
    }
    
    this.storePositions = function (){
    	graph.storePositions();
    }
    this.moveNode = function (n,x,y){
    	graph.moveNode(n,x,y);
    }
    this.setSize = function (x,y){
    	graph.setSize(x,y);
    }
    
    this.stabalize = function (i){
    	graph.stabalize(i);
    }
    this.unselectAll = function (){
    	graph.unselectAll();
    }
    this.releaseNode = function (){
    	graph.releaseNode();
    }
};
