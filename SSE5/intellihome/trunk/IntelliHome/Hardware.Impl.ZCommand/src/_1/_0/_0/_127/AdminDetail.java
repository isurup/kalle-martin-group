
/**
 * AdminDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package _1._0._0._127;
            

            /**
            *  AdminDetail bean class
            */
        
        public  class AdminDetail
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AdminDetail
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
                        * field for Lic
                        */

                        
                                    protected _1._0._0._127.License localLic ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLicTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.License
                           */
                           public  _1._0._0._127.License getLic(){
                               return localLic;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Lic
                               */
                               public void setLic(_1._0._0._127.License param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLicTracker = true;
                                       } else {
                                          localLicTracker = false;
                                              
                                       }
                                   
                                            this.localLic=param;
                                    

                               }
                            

                        /**
                        * field for ServerPassword
                        */

                        
                                    protected java.lang.String localServerPassword ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localServerPasswordTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getServerPassword(){
                               return localServerPassword;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ServerPassword
                               */
                               public void setServerPassword(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localServerPasswordTracker = true;
                                       } else {
                                          localServerPasswordTracker = false;
                                              
                                       }
                                   
                                            this.localServerPassword=param;
                                    

                               }
                            

                        /**
                        * field for SMTPserver
                        */

                        
                                    protected java.lang.String localSMTPserver ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSMTPserverTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSMTPserver(){
                               return localSMTPserver;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMTPserver
                               */
                               public void setSMTPserver(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSMTPserverTracker = true;
                                       } else {
                                          localSMTPserverTracker = false;
                                              
                                       }
                                   
                                            this.localSMTPserver=param;
                                    

                               }
                            

                        /**
                        * field for SMTPusername
                        */

                        
                                    protected java.lang.String localSMTPusername ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSMTPusernameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSMTPusername(){
                               return localSMTPusername;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMTPusername
                               */
                               public void setSMTPusername(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSMTPusernameTracker = true;
                                       } else {
                                          localSMTPusernameTracker = false;
                                              
                                       }
                                   
                                            this.localSMTPusername=param;
                                    

                               }
                            

                        /**
                        * field for SMTPpassword
                        */

                        
                                    protected java.lang.String localSMTPpassword ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSMTPpasswordTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSMTPpassword(){
                               return localSMTPpassword;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMTPpassword
                               */
                               public void setSMTPpassword(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSMTPpasswordTracker = true;
                                       } else {
                                          localSMTPpasswordTracker = false;
                                              
                                       }
                                   
                                            this.localSMTPpassword=param;
                                    

                               }
                            

                        /**
                        * field for SMTPport
                        */

                        
                                    protected java.lang.String localSMTPport ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSMTPportTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSMTPport(){
                               return localSMTPport;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMTPport
                               */
                               public void setSMTPport(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSMTPportTracker = true;
                                       } else {
                                          localSMTPportTracker = false;
                                              
                                       }
                                   
                                            this.localSMTPport=param;
                                    

                               }
                            

                        /**
                        * field for SMTPFromEmail
                        */

                        
                                    protected java.lang.String localSMTPFromEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSMTPFromEmailTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSMTPFromEmail(){
                               return localSMTPFromEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMTPFromEmail
                               */
                               public void setSMTPFromEmail(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSMTPFromEmailTracker = true;
                                       } else {
                                          localSMTPFromEmailTracker = false;
                                              
                                       }
                                   
                                            this.localSMTPFromEmail=param;
                                    

                               }
                            

                        /**
                        * field for ABEEmail
                        */

                        
                                    protected java.lang.String localABEEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localABEEmailTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getABEEmail(){
                               return localABEEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEEmail
                               */
                               public void setABEEmail(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localABEEmailTracker = true;
                                       } else {
                                          localABEEmailTracker = false;
                                              
                                       }
                                   
                                            this.localABEEmail=param;
                                    

                               }
                            

                        /**
                        * field for ABEUsername
                        */

                        
                                    protected java.lang.String localABEUsername ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localABEUsernameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getABEUsername(){
                               return localABEUsername;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEUsername
                               */
                               public void setABEUsername(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localABEUsernameTracker = true;
                                       } else {
                                          localABEUsernameTracker = false;
                                              
                                       }
                                   
                                            this.localABEUsername=param;
                                    

                               }
                            

                        /**
                        * field for ABEServer
                        */

                        
                                    protected java.lang.String localABEServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localABEServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getABEServer(){
                               return localABEServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEServer
                               */
                               public void setABEServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localABEServerTracker = true;
                                       } else {
                                          localABEServerTracker = false;
                                              
                                       }
                                   
                                            this.localABEServer=param;
                                    

                               }
                            

                        /**
                        * field for ABEPort
                        */

                        
                                    protected java.lang.String localABEPort ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localABEPortTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getABEPort(){
                               return localABEPort;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEPort
                               */
                               public void setABEPort(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localABEPortTracker = true;
                                       } else {
                                          localABEPortTracker = false;
                                              
                                       }
                                   
                                            this.localABEPort=param;
                                    

                               }
                            

                        /**
                        * field for ABEType
                        */

                        
                                    protected java.lang.String localABEType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localABETypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getABEType(){
                               return localABEType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEType
                               */
                               public void setABEType(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localABETypeTracker = true;
                                       } else {
                                          localABETypeTracker = false;
                                              
                                       }
                                   
                                            this.localABEType=param;
                                    

                               }
                            

                        /**
                        * field for ABEEnable
                        */

                        
                                    protected boolean localABEEnable ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getABEEnable(){
                               return localABEEnable;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEEnable
                               */
                               public void setABEEnable(boolean param){
                            
                                            this.localABEEnable=param;
                                    

                               }
                            

                        /**
                        * field for ABESSL
                        */

                        
                                    protected boolean localABESSL ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getABESSL(){
                               return localABESSL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABESSL
                               */
                               public void setABESSL(boolean param){
                            
                                            this.localABESSL=param;
                                    

                               }
                            

                        /**
                        * field for ABEInterval
                        */

                        
                                    protected int localABEInterval ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getABEInterval(){
                               return localABEInterval;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ABEInterval
                               */
                               public void setABEInterval(int param){
                            
                                            this.localABEInterval=param;
                                    

                               }
                            

                        /**
                        * field for Users
                        */

                        
                                    protected _1._0._0._127.ArrayOfUser localUsers ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUsersTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return _1._0._0._127.ArrayOfUser
                           */
                           public  _1._0._0._127.ArrayOfUser getUsers(){
                               return localUsers;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Users
                               */
                               public void setUsers(_1._0._0._127.ArrayOfUser param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUsersTracker = true;
                                       } else {
                                          localUsersTracker = false;
                                              
                                       }
                                   
                                            this.localUsers=param;
                                    

                               }
                            

                        /**
                        * field for DHCPEnabled
                        */

                        
                                    protected boolean localDHCPEnabled ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getDHCPEnabled(){
                               return localDHCPEnabled;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DHCPEnabled
                               */
                               public void setDHCPEnabled(boolean param){
                            
                                            this.localDHCPEnabled=param;
                                    

                               }
                            

                        /**
                        * field for IPAddress
                        */

                        
                                    protected java.lang.String localIPAddress ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIPAddressTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIPAddress(){
                               return localIPAddress;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IPAddress
                               */
                               public void setIPAddress(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIPAddressTracker = true;
                                       } else {
                                          localIPAddressTracker = false;
                                              
                                       }
                                   
                                            this.localIPAddress=param;
                                    

                               }
                            

                        /**
                        * field for SubnetMask
                        */

                        
                                    protected java.lang.String localSubnetMask ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubnetMaskTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubnetMask(){
                               return localSubnetMask;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubnetMask
                               */
                               public void setSubnetMask(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSubnetMaskTracker = true;
                                       } else {
                                          localSubnetMaskTracker = false;
                                              
                                       }
                                   
                                            this.localSubnetMask=param;
                                    

                               }
                            

                        /**
                        * field for Gateway
                        */

                        
                                    protected java.lang.String localGateway ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGatewayTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGateway(){
                               return localGateway;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Gateway
                               */
                               public void setGateway(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGatewayTracker = true;
                                       } else {
                                          localGatewayTracker = false;
                                              
                                       }
                                   
                                            this.localGateway=param;
                                    

                               }
                            

                        /**
                        * field for DNSServer
                        */

                        
                                    protected java.lang.String localDNSServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDNSServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDNSServer(){
                               return localDNSServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DNSServer
                               */
                               public void setDNSServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDNSServerTracker = true;
                                       } else {
                                          localDNSServerTracker = false;
                                              
                                       }
                                   
                                            this.localDNSServer=param;
                                    

                               }
                            

                        /**
                        * field for AvailableFirmware
                        */

                        
                                    protected java.lang.String localAvailableFirmware ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAvailableFirmwareTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAvailableFirmware(){
                               return localAvailableFirmware;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AvailableFirmware
                               */
                               public void setAvailableFirmware(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAvailableFirmwareTracker = true;
                                       } else {
                                          localAvailableFirmwareTracker = false;
                                              
                                       }
                                   
                                            this.localAvailableFirmware=param;
                                    

                               }
                            

                        /**
                        * field for MyZCommandEnabled
                        */

                        
                                    protected boolean localMyZCommandEnabled ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getMyZCommandEnabled(){
                               return localMyZCommandEnabled;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MyZCommandEnabled
                               */
                               public void setMyZCommandEnabled(boolean param){
                            
                                            this.localMyZCommandEnabled=param;
                                    

                               }
                            

                        /**
                        * field for MyZCommandAddress
                        */

                        
                                    protected java.lang.String localMyZCommandAddress ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMyZCommandAddressTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMyZCommandAddress(){
                               return localMyZCommandAddress;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MyZCommandAddress
                               */
                               public void setMyZCommandAddress(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMyZCommandAddressTracker = true;
                                       } else {
                                          localMyZCommandAddressTracker = false;
                                              
                                       }
                                   
                                            this.localMyZCommandAddress=param;
                                    

                               }
                            

                        /**
                        * field for MyZCommandPort
                        */

                        
                                    protected java.lang.String localMyZCommandPort ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMyZCommandPortTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMyZCommandPort(){
                               return localMyZCommandPort;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MyZCommandPort
                               */
                               public void setMyZCommandPort(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMyZCommandPortTracker = true;
                                       } else {
                                          localMyZCommandPortTracker = false;
                                              
                                       }
                                   
                                            this.localMyZCommandPort=param;
                                    

                               }
                            

                        /**
                        * field for CurrentTime
                        */

                        
                                    protected java.lang.String localCurrentTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCurrentTimeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCurrentTime(){
                               return localCurrentTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CurrentTime
                               */
                               public void setCurrentTime(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCurrentTimeTracker = true;
                                       } else {
                                          localCurrentTimeTracker = false;
                                              
                                       }
                                   
                                            this.localCurrentTime=param;
                                    

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
                       AdminDetail.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":AdminDetail",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AdminDetail",
                           xmlWriter);
                   }

               
                   }
                if (localLicTracker){
                                            if (localLic==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Lic cannot be null!!");
                                            }
                                           localLic.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","Lic"),
                                               factory,xmlWriter);
                                        } if (localServerPasswordTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ServerPassword", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ServerPassword");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ServerPassword");
                                    }
                                

                                          if (localServerPassword==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ServerPassword cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localServerPassword);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSMTPserverTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SMTPserver", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SMTPserver");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SMTPserver");
                                    }
                                

                                          if (localSMTPserver==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SMTPserver cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSMTPserver);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSMTPusernameTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SMTPusername", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SMTPusername");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SMTPusername");
                                    }
                                

                                          if (localSMTPusername==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SMTPusername cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSMTPusername);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSMTPpasswordTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SMTPpassword", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SMTPpassword");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SMTPpassword");
                                    }
                                

                                          if (localSMTPpassword==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SMTPpassword cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSMTPpassword);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSMTPportTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SMTPport", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SMTPport");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SMTPport");
                                    }
                                

                                          if (localSMTPport==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SMTPport cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSMTPport);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSMTPFromEmailTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SMTPFromEmail", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SMTPFromEmail");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SMTPFromEmail");
                                    }
                                

                                          if (localSMTPFromEmail==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SMTPFromEmail cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSMTPFromEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localABEEmailTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEEmail", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEEmail");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEEmail");
                                    }
                                

                                          if (localABEEmail==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ABEEmail cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localABEEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localABEUsernameTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEUsername", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEUsername");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEUsername");
                                    }
                                

                                          if (localABEUsername==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ABEUsername cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localABEUsername);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localABEServerTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEServer");
                                    }
                                

                                          if (localABEServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ABEServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localABEServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localABEPortTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEPort", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEPort");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEPort");
                                    }
                                

                                          if (localABEPort==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ABEPort cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localABEPort);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localABETypeTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEType");
                                    }
                                

                                          if (localABEType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ABEType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localABEType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEEnable", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEEnable");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEEnable");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ABEEnable cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEEnable));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABESSL", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABESSL");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABESSL");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ABESSL cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABESSL));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ABEInterval", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ABEInterval");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ABEInterval");
                                    }
                                
                                               if (localABEInterval==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ABEInterval cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEInterval));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localUsersTracker){
                                            if (localUsers==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Users cannot be null!!");
                                            }
                                           localUsers.serialize(new javax.xml.namespace.QName("http://127.0.0.1/","Users"),
                                               factory,xmlWriter);
                                        }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DHCPEnabled", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DHCPEnabled");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DHCPEnabled");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("DHCPEnabled cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDHCPEnabled));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localIPAddressTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IPAddress", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IPAddress");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IPAddress");
                                    }
                                

                                          if (localIPAddress==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("IPAddress cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIPAddress);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubnetMaskTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SubnetMask", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SubnetMask");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SubnetMask");
                                    }
                                

                                          if (localSubnetMask==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SubnetMask cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubnetMask);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localGatewayTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Gateway", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Gateway");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Gateway");
                                    }
                                

                                          if (localGateway==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Gateway cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGateway);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDNSServerTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DNSServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DNSServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DNSServer");
                                    }
                                

                                          if (localDNSServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DNSServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDNSServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAvailableFirmwareTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"AvailableFirmware", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"AvailableFirmware");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("AvailableFirmware");
                                    }
                                

                                          if (localAvailableFirmware==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("AvailableFirmware cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAvailableFirmware);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MyZCommandEnabled", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MyZCommandEnabled");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MyZCommandEnabled");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MyZCommandEnabled cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMyZCommandEnabled));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMyZCommandAddressTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MyZCommandAddress", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MyZCommandAddress");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MyZCommandAddress");
                                    }
                                

                                          if (localMyZCommandAddress==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MyZCommandAddress cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMyZCommandAddress);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMyZCommandPortTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MyZCommandPort", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MyZCommandPort");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MyZCommandPort");
                                    }
                                

                                          if (localMyZCommandPort==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MyZCommandPort cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMyZCommandPort);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCurrentTimeTracker){
                                    namespace = "http://127.0.0.1/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"CurrentTime", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"CurrentTime");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("CurrentTime");
                                    }
                                

                                          if (localCurrentTime==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("CurrentTime cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCurrentTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
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

                 if (localLicTracker){
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Lic"));
                            
                            
                                    if (localLic==null){
                                         throw new org.apache.axis2.databinding.ADBException("Lic cannot be null!!");
                                    }
                                    elementList.add(localLic);
                                } if (localServerPasswordTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ServerPassword"));
                                 
                                        if (localServerPassword != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localServerPassword));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ServerPassword cannot be null!!");
                                        }
                                    } if (localSMTPserverTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SMTPserver"));
                                 
                                        if (localSMTPserver != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSMTPserver));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SMTPserver cannot be null!!");
                                        }
                                    } if (localSMTPusernameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SMTPusername"));
                                 
                                        if (localSMTPusername != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSMTPusername));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SMTPusername cannot be null!!");
                                        }
                                    } if (localSMTPpasswordTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SMTPpassword"));
                                 
                                        if (localSMTPpassword != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSMTPpassword));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SMTPpassword cannot be null!!");
                                        }
                                    } if (localSMTPportTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SMTPport"));
                                 
                                        if (localSMTPport != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSMTPport));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SMTPport cannot be null!!");
                                        }
                                    } if (localSMTPFromEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SMTPFromEmail"));
                                 
                                        if (localSMTPFromEmail != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSMTPFromEmail));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SMTPFromEmail cannot be null!!");
                                        }
                                    } if (localABEEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEEmail"));
                                 
                                        if (localABEEmail != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEEmail));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ABEEmail cannot be null!!");
                                        }
                                    } if (localABEUsernameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEUsername"));
                                 
                                        if (localABEUsername != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEUsername));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ABEUsername cannot be null!!");
                                        }
                                    } if (localABEServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEServer"));
                                 
                                        if (localABEServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ABEServer cannot be null!!");
                                        }
                                    } if (localABEPortTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEPort"));
                                 
                                        if (localABEPort != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEPort));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ABEPort cannot be null!!");
                                        }
                                    } if (localABETypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEType"));
                                 
                                        if (localABEType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ABEType cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEEnable"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEEnable));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABESSL"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABESSL));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "ABEInterval"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localABEInterval));
                             if (localUsersTracker){
                            elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Users"));
                            
                            
                                    if (localUsers==null){
                                         throw new org.apache.axis2.databinding.ADBException("Users cannot be null!!");
                                    }
                                    elementList.add(localUsers);
                                }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "DHCPEnabled"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDHCPEnabled));
                             if (localIPAddressTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "IPAddress"));
                                 
                                        if (localIPAddress != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIPAddress));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("IPAddress cannot be null!!");
                                        }
                                    } if (localSubnetMaskTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "SubnetMask"));
                                 
                                        if (localSubnetMask != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubnetMask));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SubnetMask cannot be null!!");
                                        }
                                    } if (localGatewayTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "Gateway"));
                                 
                                        if (localGateway != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGateway));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Gateway cannot be null!!");
                                        }
                                    } if (localDNSServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "DNSServer"));
                                 
                                        if (localDNSServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDNSServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DNSServer cannot be null!!");
                                        }
                                    } if (localAvailableFirmwareTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "AvailableFirmware"));
                                 
                                        if (localAvailableFirmware != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAvailableFirmware));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("AvailableFirmware cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "MyZCommandEnabled"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMyZCommandEnabled));
                             if (localMyZCommandAddressTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "MyZCommandAddress"));
                                 
                                        if (localMyZCommandAddress != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMyZCommandAddress));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MyZCommandAddress cannot be null!!");
                                        }
                                    } if (localMyZCommandPortTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "MyZCommandPort"));
                                 
                                        if (localMyZCommandPort != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMyZCommandPort));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MyZCommandPort cannot be null!!");
                                        }
                                    } if (localCurrentTimeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://127.0.0.1/",
                                                                      "CurrentTime"));
                                 
                                        if (localCurrentTime != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCurrentTime));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("CurrentTime cannot be null!!");
                                        }
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
        public static AdminDetail parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AdminDetail object =
                new AdminDetail();

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
                    
                            if (!"AdminDetail".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AdminDetail)_1._0._0._127.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Lic").equals(reader.getName())){
                                
                                                object.setLic(_1._0._0._127.License.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ServerPassword").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setServerPassword(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SMTPserver").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSMTPserver(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SMTPusername").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSMTPusername(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SMTPpassword").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSMTPpassword(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SMTPport").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSMTPport(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SMTPFromEmail").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSMTPFromEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEEmail").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEUsername").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEUsername(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEPort").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEPort(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEEnable").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEEnable(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABESSL").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABESSL(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","ABEInterval").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setABEInterval(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Users").equals(reader.getName())){
                                
                                                object.setUsers(_1._0._0._127.ArrayOfUser.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","DHCPEnabled").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDHCPEnabled(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","IPAddress").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIPAddress(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","SubnetMask").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubnetMask(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","Gateway").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGateway(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","DNSServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDNSServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","AvailableFirmware").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAvailableFirmware(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","MyZCommandEnabled").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMyZCommandEnabled(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","MyZCommandAddress").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMyZCommandAddress(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","MyZCommandPort").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMyZCommandPort(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://127.0.0.1/","CurrentTime").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCurrentTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
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
           
          