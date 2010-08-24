package turtlekit2.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLLoader {

	/** Parse the xml tree */
	public static Document getDocFromFile(String configPath){
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			File configFile =  new File(configPath);
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse( configFile);
		} catch (SAXParseException spe) {
			System.out.println("\n** Parsing error"+ ", line " + spe.getLineNumber() + ", uri " + spe.getSystemId());
			System.out.println("   " + spe.getMessage() );
			Exception  x = spe;
			if (spe.getException() != null) x = spe.getException();
			x.printStackTrace();

		} catch (SAXException sxe) {
			Exception  x = sxe;
			if (sxe.getException() != null) x = sxe.getException();
			x.printStackTrace();

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return document;
	}


	//    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	//    private void initComponents() {
	//        jSplitPane1 = new javax.swing.JSplitPane();
	//        jSplitPane2 = new javax.swing.JSplitPane();
	//        jTree1 = new javax.swing.JTree();
	//        editPanel = new javax.swing.JPanel();
	//        jSplitPane3 = new javax.swing.JSplitPane();
	//        editButtonPanel = new javax.swing.JPanel();
	//        saveButton = new javax.swing.JButton();
	//        remButton = new javax.swing.JButton();
	//        addButton = new javax.swing.JButton();
	//        launchButton = new javax.swing.JButton();
	//        resetButton = new javax.swing.JButton();
	//        commitButton = new javax.swing.JButton();
	//        textBoxPanel = new javax.swing.JPanel();
	//        rightPanel = new javax.swing.JPanel();
	//
	//        setLayout(new java.awt.BorderLayout());
	//
	//        setAutoscrolls(true);
	//        jSplitPane1.setDividerSize(10);
	//        jSplitPane1.setAutoscrolls(true);
	//        jSplitPane1.setOneTouchExpandable(true);
	//        jSplitPane1.setPreferredSize(new java.awt.Dimension(0, 0));
	//        jSplitPane2.setDividerSize(10);
	//        jSplitPane2.setAutoscrolls(true);
	//        jSplitPane2.setMinimumSize(new java.awt.Dimension(492, 382));
	//        jSplitPane2.setOneTouchExpandable(true);
	//        jTree1.setMaximumSize(new java.awt.Dimension(200, 100));
	//        jTree1.setMinimumSize(new java.awt.Dimension(50, 50));
	//        jTree1.setPreferredSize(new java.awt.Dimension(354, 548));
	//        jTree1.setRootVisible(false);
	//        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
	//            public void mouseClicked(java.awt.event.MouseEvent evt) {
	//                jTree1MouseClicked(evt);
	//            }
	//        });
	//
	//        jSplitPane2.setLeftComponent(jTree1);
	//
	//        editPanel.setLayout(new java.awt.BorderLayout());
	//
	//        editPanel.setAlignmentX(0.0F);
	//        editPanel.setAlignmentY(0.0F);
	//        editPanel.setAutoscrolls(true);
	//        editPanel.setMaximumSize(new java.awt.Dimension(0, 0));
	//        editPanel.setMinimumSize(new java.awt.Dimension(0, 0));
	//        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
	//        editButtonPanel.setLayout(new java.awt.GridLayout(1, 0));
	//
	//        saveButton.setText("Save simulation config");
	//        saveButton.setAutoscrolls(true);
	//        saveButton.setMaximumSize(new java.awt.Dimension(20, 35));
	//        saveButton.setMinimumSize(new java.awt.Dimension(20, 35));
	//        saveButton.setPreferredSize(new java.awt.Dimension(20, 30));
	//        saveButton.setRequestFocusEnabled(false);
	//        saveButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	//        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
	//        saveButton.addActionListener(new java.awt.event.ActionListener() {
	//            public void actionPerformed(java.awt.event.ActionEvent evt) {
	//                saveButtonActionPerformed(evt);
	//            }
	//        });
	//
	//        editButtonPanel.add(saveButton);
	//
	//        remButton.setText("removeNode");
	//        remButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	//        remButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
	//        remButton.addActionListener(new java.awt.event.ActionListener() {
	//            public void actionPerformed(java.awt.event.ActionEvent evt) {
	//                remButtonActionPerformed(evt);
	//            }
	//        });
	//
	//        editButtonPanel.add(remButton);
	//
	//        addButton.setText("addNode");
	//        addButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	//        addButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
	//        addButton.addActionListener(new java.awt.event.ActionListener() {
	//            public void actionPerformed(java.awt.event.ActionEvent evt) {
	//                addButtonActionPerformed(evt);
	//            }
	//        });
	//
	//        editButtonPanel.add(addButton);
	//        addButton.getAccessibleContext().setAccessibleName("addButton");
	//
	//        launchButton.setText("Launch");
	//        launchButton.setName("Launch");
	//        launchButton.setVerifyInputWhenFocusTarget(false);
	//        launchButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	//        launchButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
	//        launchButton.addActionListener(new java.awt.event.ActionListener() {
	//            public void actionPerformed(java.awt.event.ActionEvent evt) {
	//                launchButtonActionPerformed(evt);
	//            }
	//        });
	//
	//        editButtonPanel.add(launchButton);
	//
	//        resetButton.setText("Reset config");
	//        resetButton.setAutoscrolls(true);
	//        resetButton.setPreferredSize(new java.awt.Dimension(30, 35));
	//        resetButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	//        resetButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
	//        resetButton.addActionListener(new java.awt.event.ActionListener() {
	//            public void actionPerformed(java.awt.event.ActionEvent evt) {
	//                resetButtonActionPerformed(evt);
	//            }
	//        });
	//
	//        editButtonPanel.add(resetButton);
	//
	//        commitButton.setText("Commit");
	//        commitButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	//        commitButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
	//        commitButton.addActionListener(new java.awt.event.ActionListener() {
	//            public void actionPerformed(java.awt.event.ActionEvent evt) {
	//                commitButtonActionPerformed(evt);
	//            }
	//        });
	//
	//        editButtonPanel.add(commitButton);
	//
	//        jSplitPane3.setTopComponent(editButtonPanel);
	//
	//        textBoxPanel.setLayout(new java.awt.GridLayout(0, 2, 30, 10));
	//
	//        jSplitPane3.setRightComponent(textBoxPanel);
	//
	//        editPanel.add(jSplitPane3, java.awt.BorderLayout.CENTER);
	//
	//        jSplitPane2.setRightComponent(editPanel);
	//
	//        jSplitPane1.setLeftComponent(jSplitPane2);
	//
	//        jSplitPane1.setRightComponent(rightPanel);
	//
	//        add(jSplitPane1, java.awt.BorderLayout.CENTER);
	//
	//    }
	//    // </editor-fold>//GEN-END:initComponents
	//
	//    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
	//        launcher.setSimulationNode(document.getDocumentElement());
	//        //System.out.println(((AdapterNode)(jTree1.getModel().getRoot())).getNode());
	//    }//GEN-LAST:event_commitButtonActionPerformed
	//    
	//    private void launchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchButtonActionPerformed
	//        if(jTree1.getModel().isLeaf(displayedNode)){
	//            Element parameters = (Element) displayedNode.getNode();
	//            NamedNodeMap attributeList = parameters.getAttributes();
	//            int listLength = attributeList.getLength();
	//            XMLAttributes paramTable = new XMLAttributes();
	//            for(int k=0; k<listLength;k++) {
	//                paramTable.put(attributeList.item(k).getNodeName(),parameters.getAttribute(attributeList.item(k).getNodeName()));
	//            }
	//            String type = displayedNode.getNode().getNodeName();
	//            if(type.equals("Observer")){
	//                launcher.newObserver(paramTable);
	//            }else if(type.equals("Viewer")){
	//                launcher.newViewer(paramTable);
	//            }/*else if(type.equals("Manager")){
	//                launcher.newManager(paramTable);
	//            }*/else if(type.equals("Parameters")){
	//            	String nodeIdentifier = new Integer(getIndex(displayedNode.getNode().getParentNode().getParentNode())).toString()+new Integer(getIndex(displayedNode.getNode().getParentNode())).toString();
	//            	paramTable.put("node",nodeIdentifier);
	//            	paramTable.put("groupNode",new Integer(getIndex(displayedNode.getNode().getParentNode().getParentNode())).toString());
	//                paramTable.put("agentType", ((Element)(displayedNode.getNode().getParentNode())).getAttribute("agentType"));
	//                System.out.println(nodeIdentifier);
	//                launcher.newAgents(paramTable,1);
	//            }else if(type.equals("Gene")){
	//                System.out.println("Cannot be instancied dynamically yet.");
	//            }
	//        }else{
	//            String type = displayedNode.getNode().getNodeName();
	//            if(type.equals("Observers")){
	//                NodeList observersNodes = ((Element)displayedNode.getNode()).getElementsByTagName("Observer");
	//                launcher.initializeObservers(observersNodes);
	//            }else if(type.equals("Viewers")){
	//                NodeList viewersNodes = ((Element)displayedNode.getNode()).getElementsByTagName("Viewer");
	//                launcher.initializeViewers(viewersNodes);
	//            }/*else if(type.equals("Managers")){
	//                NodeList managersNodes = ((Element)displayedNode.getNode()).getElementsByTagName("Manager");
	//                launcher.initializeViewers(managersNodes);
	//            }*/else if(type.equals("Agents")){
	//                NodeList agentNodes = ((Element)displayedNode.getNode()).getElementsByTagName("Agent");
	//                launcher.createInitialPopulation(agentNodes,getIndex(displayedNode.getNode()));
	//            }else if(type.equals("Agent")){
	//            	Element agentDescription = (Element)displayedNode.getNode();
	//                String agentType = agentDescription.getAttribute("agentType");
	//                int nbAgents = Integer.parseInt(agentDescription.getAttribute("nbAgents"));
	//                NodeList parametersList = agentDescription.getElementsByTagName("Parameters");
	//                Element parameters = (Element)parametersList.item(0);
	//                NamedNodeMap attributeList = parameters.getAttributes();
	//                int listLength = attributeList.getLength();
	//                XMLAttributes agentAttribute = new XMLAttributes();
	//                for(int k=0; k<listLength;k++) {
	//                    agentAttribute.put(attributeList.item(k).getNodeName(),parameters.getAttribute(attributeList.item(k).getNodeName()));
	//                }
	//                String nodeIdentifier = new Integer(getIndex(displayedNode.getNode().getParentNode())).toString()+new Integer(getIndex(displayedNode.getNode())).toString();
	//                agentAttribute.put("node",nodeIdentifier);
	//                agentAttribute.put("groupNode",new Integer(getIndex(displayedNode.getNode().getParentNode())).toString());
	//                agentAttribute.put("agentType",agentType);
	////                System.out.println(nodeIdentifier);
	//                launcher.newAgents(agentAttribute, nbAgents);
	//            }else if(type.equals("Pool")){
	//                System.out.println("Cannot be instancied dynamically yet.");
	//            }else if(type.equals("Pools")){
	//                System.out.println("Cannot be instancied dynamically yet.");
	//            }
	//        }
	//        
	//        
	//        
	//        launcher.launch(displayedNode.getNode());
	//    }//GEN-LAST:event_launchButtonActionPerformed
	//    
	//    
	//    
	//    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
	//        Node newNode = displayedNode.getNode().cloneNode(true);
	//        displayedNode.getNode().getParentNode().appendChild(newNode);
	//    }//GEN-LAST:event_addButtonActionPerformed
	//    
	//    private void remButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remButtonActionPerformed
	//        displayedNode.getNode().getParentNode().removeChild(displayedNode.getNode());
	//    }//GEN-LAST:event_remButtonActionPerformed
	//    
	//    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
	//        saveXml(configFile);
	//    }//GEN-LAST:event_saveButtonActionPerformed
	//    
	//    public void saveXml(File file){
	//        try{
	//            //FileOutputStream fos = new FileOutputStream(configFile);
	//            Transformer serializer;
	//            ByteArrayOutputStream bout;
	//            serializer = TransformerFactory.newInstance().newTransformer();
	//            bout = new ByteArrayOutputStream();
	//            serializer.transform(new DOMSource(document), new StreamResult(bout));
	//            FileWriter fw = new FileWriter(file,false);
	//            DOMSource source = new DOMSource(document);
	//            fw.write(bout.toString());
	//            fw.flush();
	//            fw.close();
	//            
	//        } catch(Exception e){
	//            System.err.println("A l'arrache: problemes d'ecritures" + e);
	//        }
	//    }
	//    
	//    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
	//        initXmlParsing();
	//        textBoxPanel.removeAll();
	//    }//GEN-LAST:event_resetButtonActionPerformed
	//    
	//  
	//  

}
