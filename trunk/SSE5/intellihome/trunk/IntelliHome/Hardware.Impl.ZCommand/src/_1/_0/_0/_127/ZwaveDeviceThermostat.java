
/**
 * ZwaveDeviceThermostat.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package _1._0._0._127;
            

            /**
            *  ZwaveDeviceThermostat bean class
            */
        
        public  class ZwaveDeviceThermostat extends _1._0._0._127.ZwaveDevice
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZwaveDeviceThermostat
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
                        * field for AutoChangeOverSetPoint
                        */

                        
                                    protected double localAutoChangeOverSetPoint ;
                                

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getAutoChangeOverSetPoint(){
                               return localAutoChangeOverSetPoint;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AutoChangeOverSetPoint
                               */
                               public void setAutoChangeOverSetPoint(double param){
                            
                                            this.localAutoChangeOverSetPoint=param;
                                    

                               }
                            

                        /**
                        * field for AutoChangeOverSetPointTimestamp
                        */

                        
                                    protected java.util.Calendar localAutoChangeOverSetPointTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getAutoChangeOverSetPointTimestamp(){
                               return localAutoChangeOverSetPointTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AutoChangeOverSetPointTimestamp
                               */
                               public void setAutoChangeOverSetPointTimestamp(java.util.Calendar param){
                            
                                            this.localAutoChangeOverSetPointTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for AutoChangeOverScale
                        */

                        
                                    protected _1._0._0._127.ZwaveDeviceTemperatureScale localAutoChangeOverScale ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveDeviceTemperatureScale
                           */
                           public  _1._0._0._127.ZwaveDeviceTemperatureScale getAutoChangeOverScale(){
                               return localAutoChangeOverScale;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AutoChangeOverScale
                               */
                               public void setAutoChangeOverScale(_1._0._0._127.ZwaveDeviceTemperatureScale param){
                            
                                            this.localAutoChangeOverScale=param;
                                    

                               }
                            

                        /**
                        * field for AutoChangeOverScaleTimestamp
                        */

                        
                                    protected java.util.Calendar localAutoChangeOverScaleTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getAutoChangeOverScaleTimestamp(){
                               return localAutoChangeOverScaleTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AutoChangeOverScaleTimestamp
                               */
                               public void setAutoChangeOverScaleTimestamp(java.util.Calendar param){
                            
                                            this.localAutoChangeOverScaleTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for SupportsClimateSchedule
                        */

                        
                                    protected boolean localSupportsClimateSchedule ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getSupportsClimateSchedule(){
                               return localSupportsClimateSchedule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SupportsClimateSchedule
                               */
                               public void setSupportsClimateSchedule(boolean param){
                            
                                            this.localSupportsClimateSchedule=param;
                                    

                               }
                            

                        /**
                        * field for CoolingSetPoint
                        */

                        
                                    protected double localCoolingSetPoint ;
                                

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getCoolingSetPoint(){
                               return localCoolingSetPoint;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CoolingSetPoint
                               */
                               public void setCoolingSetPoint(double param){
                            
                                            this.localCoolingSetPoint=param;
                                    

                               }
                            

                        /**
                        * field for CoolingSetPointTimestamp
                        */

                        
                                    protected java.util.Calendar localCoolingSetPointTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getCoolingSetPointTimestamp(){
                               return localCoolingSetPointTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CoolingSetPointTimestamp
                               */
                               public void setCoolingSetPointTimestamp(java.util.Calendar param){
                            
                                            this.localCoolingSetPointTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for HeatingSetPoint
                        */

                        
                                    protected double localHeatingSetPoint ;
                                

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getHeatingSetPoint(){
                               return localHeatingSetPoint;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HeatingSetPoint
                               */
                               public void setHeatingSetPoint(double param){
                            
                                            this.localHeatingSetPoint=param;
                                    

                               }
                            

                        /**
                        * field for HeatingSetPointTimestamp
                        */

                        
                                    protected java.util.Calendar localHeatingSetPointTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getHeatingSetPointTimestamp(){
                               return localHeatingSetPointTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HeatingSetPointTimestamp
                               */
                               public void setHeatingSetPointTimestamp(java.util.Calendar param){
                            
                                            this.localHeatingSetPointTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for CoolingScale
                        */

                        
                                    protected _1._0._0._127.ZwaveDeviceTemperatureScale localCoolingScale ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveDeviceTemperatureScale
                           */
                           public  _1._0._0._127.ZwaveDeviceTemperatureScale getCoolingScale(){
                               return localCoolingScale;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CoolingScale
                               */
                               public void setCoolingScale(_1._0._0._127.ZwaveDeviceTemperatureScale param){
                            
                                            this.localCoolingScale=param;
                                    

                               }
                            

                        /**
                        * field for CoolingScaleTimestamp
                        */

                        
                                    protected java.util.Calendar localCoolingScaleTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getCoolingScaleTimestamp(){
                               return localCoolingScaleTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CoolingScaleTimestamp
                               */
                               public void setCoolingScaleTimestamp(java.util.Calendar param){
                            
                                            this.localCoolingScaleTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for HeatingScale
                        */

                        
                                    protected _1._0._0._127.ZwaveDeviceTemperatureScale localHeatingScale ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveDeviceTemperatureScale
                           */
                           public  _1._0._0._127.ZwaveDeviceTemperatureScale getHeatingScale(){
                               return localHeatingScale;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HeatingScale
                               */
                               public void setHeatingScale(_1._0._0._127.ZwaveDeviceTemperatureScale param){
                            
                                            this.localHeatingScale=param;
                                    

                               }
                            

                        /**
                        * field for HeatingScaleTimestamp
                        */

                        
                                    protected java.util.Calendar localHeatingScaleTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getHeatingScaleTimestamp(){
                               return localHeatingScaleTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HeatingScaleTimestamp
                               */
                               public void setHeatingScaleTimestamp(java.util.Calendar param){
                            
                                            this.localHeatingScaleTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for SupportedThermostatModes
                        */

                        
                                    protected _1._0._0._127.ArrayOfZwaveDeviceThermostatMode localSupportedThermostatModes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSupportedThermostatModesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ArrayOfZwaveDeviceThermostatMode
                           */
                           public  _1._0._0._127.ArrayOfZwaveDeviceThermostatMode getSupportedThermostatModes(){
                               return localSupportedThermostatModes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SupportedThermostatModes
                               */
                               public void setSupportedThermostatModes(_1._0._0._127.ArrayOfZwaveDeviceThermostatMode param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSupportedThermostatModesTracker = true;
                                       } else {
                                          localSupportedThermostatModesTracker = false;
                                              
                                       }
                                   
                                            this.localSupportedThermostatModes=param;
                                    

                               }
                            

                        /**
                        * field for SupportedThermostatModesTimestamp
                        */

                        
                                    protected java.util.Calendar localSupportedThermostatModesTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getSupportedThermostatModesTimestamp(){
                               return localSupportedThermostatModesTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SupportedThermostatModesTimestamp
                               */
                               public void setSupportedThermostatModesTimestamp(java.util.Calendar param){
                            
                                            this.localSupportedThermostatModesTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for ThermostatMode
                        */

                        
                                    protected _1._0._0._127.ZwaveDeviceThermostatMode localThermostatMode ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveDeviceThermostatMode
                           */
                           public  _1._0._0._127.ZwaveDeviceThermostatMode getThermostatMode(){
                               return localThermostatMode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ThermostatMode
                               */
                               public void setThermostatMode(_1._0._0._127.ZwaveDeviceThermostatMode param){
                            
                                            this.localThermostatMode=param;
                                    

                               }
                            

                        /**
                        * field for ModeTimestamp
                        */

                        
                                    protected java.util.Calendar localModeTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getModeTimestamp(){
                               return localModeTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ModeTimestamp
                               */
                               public void setModeTimestamp(java.util.Calendar param){
                            
                                            this.localModeTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for FanMode
                        */

                        
                                    protected _1._0._0._127.ZwaveDeviceThermostatFanMode localFanMode ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveDeviceThermostatFanMode
                           */
                           public  _1._0._0._127.ZwaveDeviceThermostatFanMode getFanMode(){
                               return localFanMode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FanMode
                               */
                               public void setFanMode(_1._0._0._127.ZwaveDeviceThermostatFanMode param){
                            
                                            this.localFanMode=param;
                                    

                               }
                            

                        /**
                        * field for FanModeTimestamp
                        */

                        
                                    protected java.util.Calendar localFanModeTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getFanModeTimestamp(){
                               return localFanModeTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FanModeTimestamp
                               */
                               public void setFanModeTimestamp(java.util.Calendar param){
                            
                                            this.localFanModeTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for SupportedFanModes
                        */

                        
                                    protected _1._0._0._127.ArrayOfZwaveDeviceThermostatFanMode localSupportedFanModes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSupportedFanModesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ArrayOfZwaveDeviceThermostatFanMode
                           */
                           public  _1._0._0._127.ArrayOfZwaveDeviceThermostatFanMode getSupportedFanModes(){
                               return localSupportedFanModes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SupportedFanModes
                               */
                               public void setSupportedFanModes(_1._0._0._127.ArrayOfZwaveDeviceThermostatFanMode param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSupportedFanModesTracker = true;
                                       } else {
                                          localSupportedFanModesTracker = false;
                                              
                                       }
                                   
                                            this.localSupportedFanModes=param;
                                    

                               }
                            

                        /**
                        * field for SupportedFanModesTimestamp
                        */

                        
                                    protected java.util.Calendar localSupportedFanModesTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getSupportedFanModesTimestamp(){
                               return localSupportedFanModesTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SupportedFanModesTimestamp
                               */
                               public void setSupportedFanModesTimestamp(java.util.Calendar param){
                            
                                            this.localSupportedFanModesTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for OperatingState
                        */

                        
                                    protected _1._0._0._127.ZwaveDeviceThermostatOperatingState localOperatingState ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveDeviceThermostatOperatingState
                           */
                           public  _1._0._0._127.ZwaveDeviceThermostatOperatingState getOperatingState(){
                               return localOperatingState;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OperatingState
                               */
                               public void setOperatingState(_1._0._0._127.ZwaveDeviceThermostatOperatingState param){
                            
                                            this.localOperatingState=param;
                                    

                               }
                            

                        /**
                        * field for OperatingStateTimestamp
                        */

                        
                                    protected java.util.Calendar localOperatingStateTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getOperatingStateTimestamp(){
                               return localOperatingStateTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OperatingStateTimestamp
                               */
                               public void setOperatingStateTimestamp(java.util.Calendar param){
                            
                                            this.localOperatingStateTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for ClimateSchedule
                        */

                        
                                    protected _1._0._0._127.ZwaveClimateSchedule localClimateSchedule ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localClimateScheduleTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveClimateSchedule
                           */
                           public  _1._0._0._127.ZwaveClimateSchedule getClimateSchedule(){
                               return localClimateSchedule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ClimateSchedule
                               */
                               public void setClimateSchedule(_1._0._0._127.ZwaveClimateSchedule param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localClimateScheduleTracker = true;
                                       } else {
                                          localClimateScheduleTracker = false;
                                              
                                       }
                                   
                                            this.localClimateSchedule=param;
                                    

                               }
                            

                        /**
                        * field for ClimateScheduleTimestamp
                        */

                        
                                    protected java.util.Calendar localClimateScheduleTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getClimateScheduleTimestamp(){
                               return localClimateScheduleTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ClimateScheduleTimestamp
                               */
                               public void setClimateScheduleTimestamp(java.util.Calendar param){
                            
                                            this.localClimateScheduleTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for ClimateScheduleOverideState
                        */

                        
                                    protected _1._0._0._127.ZwaveClimateScheduleState localClimateScheduleOverideState ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveClimateScheduleState
                           */
                           public  _1._0._0._127.ZwaveClimateScheduleState getClimateScheduleOverideState(){
                               return localClimateScheduleOverideState;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ClimateScheduleOverideState
                               */
                               public void setClimateScheduleOverideState(_1._0._0._127.ZwaveClimateScheduleState param){
                            
                                            this.localClimateScheduleOverideState=param;
                                    

                               }
                            

                        /**
                        * field for ClimateScheduleOverride
                        */

                        
                                    protected _1._0._0._127.ZwaveClimateScheduleOverride localClimateScheduleOverride ;
                                

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ZwaveClimateScheduleOverride
                           */
                           public  _1._0._0._127.ZwaveClimateScheduleOverride getClimateScheduleOverride(){
                               return localClimateScheduleOverride;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ClimateScheduleOverride
                               */
                               public void setClimateScheduleOverride(_1._0._0._127.ZwaveClimateScheduleOverride param){
                            
                                            this.localClimateScheduleOverride=param;
                                    

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
                       ZwaveDeviceThermostat.this.serialize(parentQName,factory,xmlWriter);
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
                

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://127.0.0.1/");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZwaveDeviceThermostat",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZwaveDeviceThermostat",
                           xmlWriter);
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
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"AutoChangeOverSetPoint", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"AutoChangeOverSetPoint");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("AutoChangeOverSetPoint");
                                    }
                                
                                               if (java.lang.Double.isNaN(localAutoChangeOverSetPoint)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("AutoChangeOverSetPoint cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAutoChangeOverSetPoint));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"AutoChangeOverSetPointTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"AutoChangeOverSetPointTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("AutoChangeOverSetPointTimestamp");
                                    }
                                

                                          if (localAutoChangeOverSetPointTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("AutoChangeOverSetPointTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAutoChangeOverSetPointTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localAutoChangeOverScale==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AutoChangeOverScale cannot be null!!");
                                            }
                                           localAutoChangeOverScale.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","AutoChangeOverScale"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"AutoChangeOverScaleTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"AutoChangeOverScaleTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("AutoChangeOverScaleTimestamp");
                                    }
                                

                                          if (localAutoChangeOverScaleTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("AutoChangeOverScaleTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAutoChangeOverScaleTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SupportsClimateSchedule", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SupportsClimateSchedule");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SupportsClimateSchedule");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("SupportsClimateSchedule cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSupportsClimateSchedule));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"CoolingSetPoint", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"CoolingSetPoint");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("CoolingSetPoint");
                                    }
                                
                                               if (java.lang.Double.isNaN(localCoolingSetPoint)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("CoolingSetPoint cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCoolingSetPoint));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"CoolingSetPointTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"CoolingSetPointTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("CoolingSetPointTimestamp");
                                    }
                                

                                          if (localCoolingSetPointTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CoolingSetPointTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCoolingSetPointTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"HeatingSetPoint", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"HeatingSetPoint");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("HeatingSetPoint");
                                    }
                                
                                               if (java.lang.Double.isNaN(localHeatingSetPoint)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("HeatingSetPoint cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeatingSetPoint));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"HeatingSetPointTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"HeatingSetPointTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("HeatingSetPointTimestamp");
                                    }
                                

                                          if (localHeatingSetPointTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("HeatingSetPointTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeatingSetPointTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localCoolingScale==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CoolingScale cannot be null!!");
                                            }
                                           localCoolingScale.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","CoolingScale"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"CoolingScaleTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"CoolingScaleTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("CoolingScaleTimestamp");
                                    }
                                

                                          if (localCoolingScaleTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CoolingScaleTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCoolingScaleTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localHeatingScale==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HeatingScale cannot be null!!");
                                            }
                                           localHeatingScale.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","HeatingScale"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"HeatingScaleTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"HeatingScaleTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("HeatingScaleTimestamp");
                                    }
                                

                                          if (localHeatingScaleTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("HeatingScaleTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeatingScaleTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localSupportedThermostatModesTracker){
                                            if (localSupportedThermostatModes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SupportedThermostatModes cannot be null!!");
                                            }
                                           localSupportedThermostatModes.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","SupportedThermostatModes"),
                                               factory,xmlWriter);
                                        }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SupportedThermostatModesTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SupportedThermostatModesTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SupportedThermostatModesTimestamp");
                                    }
                                

                                          if (localSupportedThermostatModesTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SupportedThermostatModesTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSupportedThermostatModesTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localThermostatMode==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ThermostatMode cannot be null!!");
                                            }
                                           localThermostatMode.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","ThermostatMode"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ModeTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ModeTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ModeTimestamp");
                                    }
                                

                                          if (localModeTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ModeTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModeTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localFanMode==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FanMode cannot be null!!");
                                            }
                                           localFanMode.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","FanMode"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"FanModeTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"FanModeTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("FanModeTimestamp");
                                    }
                                

                                          if (localFanModeTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("FanModeTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFanModeTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localSupportedFanModesTracker){
                                            if (localSupportedFanModes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SupportedFanModes cannot be null!!");
                                            }
                                           localSupportedFanModes.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","SupportedFanModes"),
                                               factory,xmlWriter);
                                        }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SupportedFanModesTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SupportedFanModesTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SupportedFanModesTimestamp");
                                    }
                                

                                          if (localSupportedFanModesTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SupportedFanModesTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSupportedFanModesTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localOperatingState==null){
                                                 throw new org.apache.axis2.databinding.ADBException("OperatingState cannot be null!!");
                                            }
                                           localOperatingState.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","OperatingState"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"OperatingStateTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"OperatingStateTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("OperatingStateTimestamp");
                                    }
                                

                                          if (localOperatingStateTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OperatingStateTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOperatingStateTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localClimateScheduleTracker){
                                            if (localClimateSchedule==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ClimateSchedule cannot be null!!");
                                            }
                                           localClimateSchedule.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","ClimateSchedule"),
                                               factory,xmlWriter);
                                        }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ClimateScheduleTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ClimateScheduleTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ClimateScheduleTimestamp");
                                    }
                                

                                          if (localClimateScheduleTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ClimateScheduleTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localClimateScheduleTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localClimateScheduleOverideState==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ClimateScheduleOverideState cannot be null!!");
                                            }
                                           localClimateScheduleOverideState.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","ClimateScheduleOverideState"),
                                               factory,xmlWriter);
                                        
                                            if (localClimateScheduleOverride==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ClimateScheduleOverride cannot be null!!");
                                            }
                                           localClimateScheduleOverride.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","ClimateScheduleOverride"),
                                               factory,xmlWriter);
                                        
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

                
                    attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
                    attribList.add(new javax.xml.namespace.QName("http://127.0.0.1/","ZwaveDeviceThermostat"));
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
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "AutoChangeOverSetPoint"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAutoChangeOverSetPoint));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "AutoChangeOverSetPointTimestamp"));
                                 
                                        if (localAutoChangeOverSetPointTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAutoChangeOverSetPointTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("AutoChangeOverSetPointTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "AutoChangeOverScale"));
                            
                            
                                    if (localAutoChangeOverScale==null){
                                         throw new org.apache.axis2.databinding.ADBException("AutoChangeOverScale cannot be null!!");
                                    }
                                    elementList.add(localAutoChangeOverScale);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "AutoChangeOverScaleTimestamp"));
                                 
                                        if (localAutoChangeOverScaleTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAutoChangeOverScaleTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("AutoChangeOverScaleTimestamp cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SupportsClimateSchedule"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSupportsClimateSchedule));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "CoolingSetPoint"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCoolingSetPoint));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "CoolingSetPointTimestamp"));
                                 
                                        if (localCoolingSetPointTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCoolingSetPointTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("CoolingSetPointTimestamp cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "HeatingSetPoint"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeatingSetPoint));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "HeatingSetPointTimestamp"));
                                 
                                        if (localHeatingSetPointTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeatingSetPointTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("HeatingSetPointTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "CoolingScale"));
                            
                            
                                    if (localCoolingScale==null){
                                         throw new org.apache.axis2.databinding.ADBException("CoolingScale cannot be null!!");
                                    }
                                    elementList.add(localCoolingScale);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "CoolingScaleTimestamp"));
                                 
                                        if (localCoolingScaleTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCoolingScaleTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("CoolingScaleTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "HeatingScale"));
                            
                            
                                    if (localHeatingScale==null){
                                         throw new org.apache.axis2.databinding.ADBException("HeatingScale cannot be null!!");
                                    }
                                    elementList.add(localHeatingScale);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "HeatingScaleTimestamp"));
                                 
                                        if (localHeatingScaleTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeatingScaleTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("HeatingScaleTimestamp cannot be null!!");
                                        }
                                     if (localSupportedThermostatModesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SupportedThermostatModes"));
                            
                            
                                    if (localSupportedThermostatModes==null){
                                         throw new org.apache.axis2.databinding.ADBException("SupportedThermostatModes cannot be null!!");
                                    }
                                    elementList.add(localSupportedThermostatModes);
                                }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SupportedThermostatModesTimestamp"));
                                 
                                        if (localSupportedThermostatModesTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSupportedThermostatModesTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SupportedThermostatModesTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ThermostatMode"));
                            
                            
                                    if (localThermostatMode==null){
                                         throw new org.apache.axis2.databinding.ADBException("ThermostatMode cannot be null!!");
                                    }
                                    elementList.add(localThermostatMode);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ModeTimestamp"));
                                 
                                        if (localModeTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModeTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ModeTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "FanMode"));
                            
                            
                                    if (localFanMode==null){
                                         throw new org.apache.axis2.databinding.ADBException("FanMode cannot be null!!");
                                    }
                                    elementList.add(localFanMode);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "FanModeTimestamp"));
                                 
                                        if (localFanModeTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFanModeTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("FanModeTimestamp cannot be null!!");
                                        }
                                     if (localSupportedFanModesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SupportedFanModes"));
                            
                            
                                    if (localSupportedFanModes==null){
                                         throw new org.apache.axis2.databinding.ADBException("SupportedFanModes cannot be null!!");
                                    }
                                    elementList.add(localSupportedFanModes);
                                }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SupportedFanModesTimestamp"));
                                 
                                        if (localSupportedFanModesTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSupportedFanModesTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SupportedFanModesTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "OperatingState"));
                            
                            
                                    if (localOperatingState==null){
                                         throw new org.apache.axis2.databinding.ADBException("OperatingState cannot be null!!");
                                    }
                                    elementList.add(localOperatingState);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "OperatingStateTimestamp"));
                                 
                                        if (localOperatingStateTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOperatingStateTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("OperatingStateTimestamp cannot be null!!");
                                        }
                                     if (localClimateScheduleTracker){
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ClimateSchedule"));
                            
                            
                                    if (localClimateSchedule==null){
                                         throw new org.apache.axis2.databinding.ADBException("ClimateSchedule cannot be null!!");
                                    }
                                    elementList.add(localClimateSchedule);
                                }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ClimateScheduleTimestamp"));
                                 
                                        if (localClimateScheduleTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localClimateScheduleTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ClimateScheduleTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ClimateScheduleOverideState"));
                            
                            
                                    if (localClimateScheduleOverideState==null){
                                         throw new org.apache.axis2.databinding.ADBException("ClimateScheduleOverideState cannot be null!!");
                                    }
                                    elementList.add(localClimateScheduleOverideState);
                                
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ClimateScheduleOverride"));
                            
                            
                                    if (localClimateScheduleOverride==null){
                                         throw new org.apache.axis2.databinding.ADBException("ClimateScheduleOverride cannot be null!!");
                                    }
                                    elementList.add(localClimateScheduleOverride);
                                

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
        public static ZwaveDeviceThermostat parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZwaveDeviceThermostat object =
                new ZwaveDeviceThermostat();

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
                    
                            if (!"ZwaveDeviceThermostat".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZwaveDeviceThermostat)_1._0._0._127.ExtensionMapper.getTypeObject(
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
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","AutoChangeOverSetPoint").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAutoChangeOverSetPoint(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","AutoChangeOverSetPointTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAutoChangeOverSetPointTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","AutoChangeOverScale").equals(reader.getName())){
                                
                                                object.setAutoChangeOverScale(_1._0._0._127.ZwaveDeviceTemperatureScale.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","AutoChangeOverScaleTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAutoChangeOverScaleTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SupportsClimateSchedule").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSupportsClimateSchedule(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","CoolingSetPoint").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCoolingSetPoint(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","CoolingSetPointTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCoolingSetPointTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","HeatingSetPoint").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHeatingSetPoint(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","HeatingSetPointTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHeatingSetPointTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","CoolingScale").equals(reader.getName())){
                                
                                                object.setCoolingScale(_1._0._0._127.ZwaveDeviceTemperatureScale.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","CoolingScaleTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCoolingScaleTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","HeatingScale").equals(reader.getName())){
                                
                                                object.setHeatingScale(_1._0._0._127.ZwaveDeviceTemperatureScale.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","HeatingScaleTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHeatingScaleTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SupportedThermostatModes").equals(reader.getName())){
                                
                                                object.setSupportedThermostatModes(_1._0._0._127.ArrayOfZwaveDeviceThermostatMode.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SupportedThermostatModesTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSupportedThermostatModesTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ThermostatMode").equals(reader.getName())){
                                
                                                object.setThermostatMode(_1._0._0._127.ZwaveDeviceThermostatMode.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ModeTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setModeTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","FanMode").equals(reader.getName())){
                                
                                                object.setFanMode(_1._0._0._127.ZwaveDeviceThermostatFanMode.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","FanModeTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFanModeTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SupportedFanModes").equals(reader.getName())){
                                
                                                object.setSupportedFanModes(_1._0._0._127.ArrayOfZwaveDeviceThermostatFanMode.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SupportedFanModesTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSupportedFanModesTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","OperatingState").equals(reader.getName())){
                                
                                                object.setOperatingState(_1._0._0._127.ZwaveDeviceThermostatOperatingState.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","OperatingStateTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOperatingStateTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ClimateSchedule").equals(reader.getName())){
                                
                                                object.setClimateSchedule(_1._0._0._127.ZwaveClimateSchedule.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ClimateScheduleTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setClimateScheduleTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ClimateScheduleOverideState").equals(reader.getName())){
                                
                                                object.setClimateScheduleOverideState(_1._0._0._127.ZwaveClimateScheduleState.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ClimateScheduleOverride").equals(reader.getName())){
                                
                                                object.setClimateScheduleOverride(_1._0._0._127.ZwaveClimateScheduleOverride.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
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
           
          