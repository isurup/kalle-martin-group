
/**
 * ZwaveDevice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package _1._0._0._127;
            

            /**
            *  ZwaveDevice bean class
            */
        
        public  class ZwaveDevice
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZwaveDevice
                Namespace URI = http://127.0.0.1/
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://127.0.0.1/")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for NodeID
                        */

                        
                                    protected java.lang.String localNodeID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNodeIDTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNodeID(){
                               return localNodeID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NodeID
                               */
                               public void setNodeID(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNodeIDTracker = true;
                                       } else {
                                          localNodeIDTracker = false;
                                              
                                       }
                                   
                                            this.localNodeID=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNameTracker = true;
                                       } else {
                                          localNameTracker = false;
                                              
                                       }
                                   
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for Location
                        */

                        
                                    protected java.lang.String localLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLocationTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLocation(){
                               return localLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Location
                               */
                               public void setLocation(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLocationTracker = true;
                                       } else {
                                          localLocationTracker = false;
                                              
                                       }
                                   
                                            this.localLocation=param;
                                    

                               }
                            

                        /**
                        * field for Level
                        */

                        
                                    protected double localLevel ;
                                

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getLevel(){
                               return localLevel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Level
                               */
                               public void setLevel(double param){
                            
                                            this.localLevel=param;
                                    

                               }
                            

                        /**
                        * field for LevelTimeStamp
                        */

                        
                                    protected java.util.Calendar localLevelTimeStamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getLevelTimeStamp(){
                               return localLevelTimeStamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LevelTimeStamp
                               */
                               public void setLevelTimeStamp(java.util.Calendar param){
                            
                                            this.localLevelTimeStamp=param;
                                    

                               }
                            

                        /**
                        * field for HasBattery
                        */

                        
                                    protected boolean localHasBattery ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getHasBattery(){
                               return localHasBattery;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HasBattery
                               */
                               public void setHasBattery(boolean param){
                            
                                            this.localHasBattery=param;
                                    

                               }
                            

                        /**
                        * field for BatteryLevel
                        */

                        
                                    protected org.apache.axis2.databinding.types.UnsignedByte localBatteryLevel ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.UnsignedByte
                           */
                           public  org.apache.axis2.databinding.types.UnsignedByte getBatteryLevel(){
                               return localBatteryLevel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BatteryLevel
                               */
                               public void setBatteryLevel(org.apache.axis2.databinding.types.UnsignedByte param){
                            
                                            this.localBatteryLevel=param;
                                    

                               }
                            

                        /**
                        * field for BatteryLevelTimeStamp
                        */

                        
                                    protected java.util.Calendar localBatteryLevelTimeStamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBatteryLevelTimeStamp(){
                               return localBatteryLevelTimeStamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BatteryLevelTimeStamp
                               */
                               public void setBatteryLevelTimeStamp(java.util.Calendar param){
                            
                                            this.localBatteryLevelTimeStamp=param;
                                    

                               }
                            

                        /**
                        * field for WakeUpInterval
                        */

                        
                                    protected org.apache.axis2.databinding.types.UnsignedInt localWakeUpInterval ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.UnsignedInt
                           */
                           public  org.apache.axis2.databinding.types.UnsignedInt getWakeUpInterval(){
                               return localWakeUpInterval;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WakeUpInterval
                               */
                               public void setWakeUpInterval(org.apache.axis2.databinding.types.UnsignedInt param){
                            
                                            this.localWakeUpInterval=param;
                                    

                               }
                            

                        /**
                        * field for LastContacted
                        */

                        
                                    protected java.lang.String localLastContacted ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastContactedTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLastContacted(){
                               return localLastContacted;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastContacted
                               */
                               public void setLastContacted(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLastContactedTracker = true;
                                       } else {
                                          localLastContactedTracker = false;
                                              
                                       }
                                   
                                            this.localLastContacted=param;
                                    

                               }
                            

                        /**
                        * field for Diagnostic
                        */

                        
                                    protected java.lang.String localDiagnostic ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDiagnosticTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDiagnostic(){
                               return localDiagnostic;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Diagnostic
                               */
                               public void setDiagnostic(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDiagnosticTracker = true;
                                       } else {
                                          localDiagnosticTracker = false;
                                              
                                       }
                                   
                                            this.localDiagnostic=param;
                                    

                               }
                            

                        /**
                        * field for Manufacturer
                        */

                        
                                    protected java.lang.String localManufacturer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localManufacturerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getManufacturer(){
                               return localManufacturer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Manufacturer
                               */
                               public void setManufacturer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localManufacturerTracker = true;
                                       } else {
                                          localManufacturerTracker = false;
                                              
                                       }
                                   
                                            this.localManufacturer=param;
                                    

                               }
                            

                        /**
                        * field for Scale
                        */

                        
                                    protected java.lang.String localScale ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localScaleTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getScale(){
                               return localScale;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Scale
                               */
                               public void setScale(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localScaleTracker = true;
                                       } else {
                                          localScaleTracker = false;
                                              
                                       }
                                   
                                            this.localScale=param;
                                    

                               }
                            

                        /**
                        * field for PollingInterval
                        */

                        
                                    protected int localPollingInterval ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPollingInterval(){
                               return localPollingInterval;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PollingInterval
                               */
                               public void setPollingInterval(int param){
                            
                                            this.localPollingInterval=param;
                                    

                               }
                            

                        /**
                        * field for ProductUniqueID
                        */

                        
                                    protected java.lang.String localProductUniqueID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProductUniqueIDTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getProductUniqueID(){
                               return localProductUniqueID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ProductUniqueID
                               */
                               public void setProductUniqueID(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localProductUniqueIDTracker = true;
                                       } else {
                                          localProductUniqueIDTracker = false;
                                              
                                       }
                                   
                                            this.localProductUniqueID=param;
                                    

                               }
                            

                        /**
                        * field for Clock
                        */

                        
                                    protected _1._0._0._127.ZwaveClock localClock ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localClockTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveClock
                           */
                           public  _1._0._0._127.ZwaveClock getClock(){
                               return localClock;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Clock
                               */
                               public void setClock(_1._0._0._127.ZwaveClock param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localClockTracker = true;
                                       } else {
                                          localClockTracker = false;
                                              
                                       }
                                   
                                            this.localClock=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ZwaveDevice.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://127.0.0.1/");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZwaveDevice",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZwaveDevice",
                           xmlWriter);
                   }

               
                   }
                if (localNodeIDTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"NodeID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"NodeID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("NodeID");
                                    }
                                

                                          if (localNodeID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("NodeID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNodeID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNameTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Name", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Name");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Name");
                                    }
                                

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Name cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLocationTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Location", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Location");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Location");
                                    }
                                

                                          if (localLocation==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Location cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLocation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Level", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Level");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Level");
                                    }
                                
                                               if (java.lang.Double.isNaN(localLevel)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Level cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLevel));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"LevelTimeStamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"LevelTimeStamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("LevelTimeStamp");
                                    }
                                

                                          if (localLevelTimeStamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("LevelTimeStamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLevelTimeStamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"HasBattery", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"HasBattery");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("HasBattery");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("HasBattery cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHasBattery));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"BatteryLevel", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"BatteryLevel");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("BatteryLevel");
                                    }
                                

                                          if (localBatteryLevel==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("BatteryLevel cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBatteryLevel));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"BatteryLevelTimeStamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"BatteryLevelTimeStamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("BatteryLevelTimeStamp");
                                    }
                                

                                          if (localBatteryLevelTimeStamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("BatteryLevelTimeStamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBatteryLevelTimeStamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"WakeUpInterval", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"WakeUpInterval");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("WakeUpInterval");
                                    }
                                

                                          if (localWakeUpInterval==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("WakeUpInterval cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWakeUpInterval));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localLastContactedTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"LastContacted", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"LastContacted");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("LastContacted");
                                    }
                                

                                          if (localLastContacted==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("LastContacted cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLastContacted);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDiagnosticTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Diagnostic", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Diagnostic");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Diagnostic");
                                    }
                                

                                          if (localDiagnostic==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Diagnostic cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDiagnostic);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localManufacturerTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Manufacturer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Manufacturer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Manufacturer");
                                    }
                                

                                          if (localManufacturer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Manufacturer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localManufacturer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localScaleTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Scale", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Scale");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Scale");
                                    }
                                

                                          if (localScale==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Scale cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localScale);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PollingInterval", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PollingInterval");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PollingInterval");
                                    }
                                
                                               if (localPollingInterval==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("PollingInterval cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPollingInterval));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localProductUniqueIDTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ProductUniqueID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ProductUniqueID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ProductUniqueID");
                                    }
                                

                                          if (localProductUniqueID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ProductUniqueID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProductUniqueID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localClockTracker){
                                            if (localClock==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Clock cannot be null!!");
                                            }
                                           localClock.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","Clock"),
                                               factory,xmlWriter);
                                        }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localNodeIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "NodeID"));
                                 
                                        if (localNodeID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNodeID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("NodeID cannot be null!!");
                                        }
                                    } if (localNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Name"));
                                 
                                        if (localName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Name cannot be null!!");
                                        }
                                    } if (localLocationTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Location"));
                                 
                                        if (localLocation != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLocation));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Location cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Level"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLevel));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "LevelTimeStamp"));
                                 
                                        if (localLevelTimeStamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLevelTimeStamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("LevelTimeStamp cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "HasBattery"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHasBattery));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "BatteryLevel"));
                                 
                                        if (localBatteryLevel != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBatteryLevel));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("BatteryLevel cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "BatteryLevelTimeStamp"));
                                 
                                        if (localBatteryLevelTimeStamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBatteryLevelTimeStamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("BatteryLevelTimeStamp cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "WakeUpInterval"));
                                 
                                        if (localWakeUpInterval != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWakeUpInterval));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("WakeUpInterval cannot be null!!");
                                        }
                                     if (localLastContactedTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "LastContacted"));
                                 
                                        if (localLastContacted != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastContacted));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("LastContacted cannot be null!!");
                                        }
                                    } if (localDiagnosticTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Diagnostic"));
                                 
                                        if (localDiagnostic != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDiagnostic));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Diagnostic cannot be null!!");
                                        }
                                    } if (localManufacturerTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Manufacturer"));
                                 
                                        if (localManufacturer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localManufacturer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Manufacturer cannot be null!!");
                                        }
                                    } if (localScaleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Scale"));
                                 
                                        if (localScale != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localScale));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Scale cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "PollingInterval"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPollingInterval));
                             if (localProductUniqueIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ProductUniqueID"));
                                 
                                        if (localProductUniqueID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductUniqueID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ProductUniqueID cannot be null!!");
                                        }
                                    } if (localClockTracker){
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Clock"));
                            
                            
                                    if (localClock==null){
                                         throw new org.apache.axis2.databinding.ADBException("Clock cannot be null!!");
                                    }
                                    elementList.add(localClock);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ZwaveDevice parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZwaveDevice object =
                new ZwaveDevice();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"ZwaveDevice".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZwaveDevice)_1._0._0._127.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","NodeID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNodeID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Name").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Location").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Level").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLevel(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","LevelTimeStamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLevelTimeStamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","HasBattery").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHasBattery(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","BatteryLevel").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBatteryLevel(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","BatteryLevelTimeStamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBatteryLevelTimeStamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","WakeUpInterval").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWakeUpInterval(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","LastContacted").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastContacted(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Diagnostic").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDiagnostic(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Manufacturer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setManufacturer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Scale").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setScale(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","PollingInterval").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPollingInterval(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ProductUniqueID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProductUniqueID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Clock").equals(reader.getName())){
                                
                                                object.setClock(_1._0._0._127.ZwaveClock.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          