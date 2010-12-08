

/**
 * ZCommandWSZCommandWSSoap12.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.zcommand.scheme;

    /*
     *  ZCommandWSZCommandWSSoap12 java interface
     */

    public interface ZCommandWSZCommandWSSoap12 {
          

        /**
          * Auto generated method signature
          * Get the device location
                    * @param getLocation208
                
         */

         
                     public _1._0._0._127.GetLocationResponse getLocation(

                        _1._0._0._127.GetLocation getLocation208)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set various properties of a thermostat. Set a parameter to null to ignore it
                    * @param setThermostat210
                
         */

         
                     public _1._0._0._127.SetThermostatResponse setThermostat(

                        _1._0._0._127.SetThermostat setThermostat210)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set Network Information
                    * @param setNetworkInfo212
                
         */

         
                     public _1._0._0._127.SetNetworkInfoResponse setNetworkInfo(

                        _1._0._0._127.SetNetworkInfo setNetworkInfo212)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Synchronize the time on a device with that of Z-Command, if supported by the device
                    * @param synchronizeTime214
                
         */

         
                     public _1._0._0._127.SynchronizeTimeResponse synchronizeTime(

                        _1._0._0._127.SynchronizeTime synchronizeTime214)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Add a new device to the network
                    * @param addDevice216
                
         */

         
                     public _1._0._0._127.AddDeviceResponse addDevice(

                        _1._0._0._127.AddDevice addDevice216)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Sets a device configuration parameter according to the manufacturer's specification
                    * @param setConfigurationParameter218
                
         */

         
                     public _1._0._0._127.SetConfigurationParameterResponse setConfigurationParameter(

                        _1._0._0._127.SetConfigurationParameter setConfigurationParameter218)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set SMTP Information
                    * @param setSMTPInfo220
                
         */

         
                     public _1._0._0._127.SetSMTPInfoResponse setSMTPInfo(

                        _1._0._0._127.SetSMTPInfo setSMTPInfo220)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Returns all devices without querying them first
                    * @param getDevices222
                
         */

         
                     public _1._0._0._127.GetDevicesResponse getDevices(

                        _1._0._0._127.GetDevices getDevices222)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Return available scenes
                    * @param getScenes224
                
         */

         
                     public _1._0._0._127.GetScenesResponse getScenes(

                        _1._0._0._127.GetScenes getScenes224)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getUsers226
                
         */

         
                     public _1._0._0._127.GetUsersResponse getUsers(

                        _1._0._0._127.GetUsers getUsers226)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Associate a device
                    * @param addAssociation228
                
         */

         
                     public _1._0._0._127.AddAssociationResponse addAssociation(

                        _1._0._0._127.AddAssociation addAssociation228)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Reset a device
                    * @param resetDevice230
                
         */

         
                     public _1._0._0._127.ResetDeviceResponse resetDevice(

                        _1._0._0._127.ResetDevice resetDevice230)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Save a configuration
                    * @param setConfig232
                
         */

         
                     public _1._0._0._127.SetConfigResponse setConfig(

                        _1._0._0._127.SetConfig setConfig232)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Perform initial query on a device. This will query for battery support and manufacturer name.
                    * @param queryDeviceInit234
                
         */

         
                     public _1._0._0._127.QueryDeviceInitResponse queryDeviceInit(

                        _1._0._0._127.QueryDeviceInit queryDeviceInit234)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get the device name
                    * @param getName236
                
         */

         
                     public _1._0._0._127.GetNameResponse getName(

                        _1._0._0._127.GetName getName236)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the climate control schedule for a thermostat
                    * @param setClimateSchedule238
                
         */

         
                     public _1._0._0._127.SetClimateScheduleResponse setClimateSchedule(

                        _1._0._0._127.SetClimateSchedule setClimateSchedule238)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param resetController240
                
         */

         
                     public _1._0._0._127.ResetControllerResponse resetController(

                        _1._0._0._127.ResetController resetController240)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Delete a scene
                    * @param deleteScene242
                
         */

         
                     public _1._0._0._127.DeleteSceneResponse deleteScene(

                        _1._0._0._127.DeleteScene deleteScene242)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Aborts a device addition or reset operation
                    * @param abortAddOrResetDevice244
                
         */

         
                     public _1._0._0._127.AbortAddOrResetDeviceResponse abortAddOrResetDevice(

                        _1._0._0._127.AbortAddOrResetDevice abortAddOrResetDevice244)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the wakeup interval in minutes for a battery-operated device
                    * @param setWakeUpInterval246
                
         */

         
                     public _1._0._0._127.SetWakeUpIntervalResponse setWakeUpInterval(

                        _1._0._0._127.SetWakeUpInterval setWakeUpInterval246)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Delete a user
                    * @param deleteUser248
                
         */

         
                     public _1._0._0._127.DeleteUserResponse deleteUser(

                        _1._0._0._127.DeleteUser deleteUser248)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param deleteRule250
                
         */

         
                     public _1._0._0._127.DeleteRuleResponse deleteRule(

                        _1._0._0._127.DeleteRule deleteRule250)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Gets a device configuration parameter according to the manufacturer's specification
                    * @param getConfigurationParameter252
                
         */

         
                     public _1._0._0._127.GetConfigurationParameterResponse getConfigurationParameter(

                        _1._0._0._127.GetConfigurationParameter getConfigurationParameter252)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Sets a rule.
                    * @param setRule254
                
         */

         
                     public _1._0._0._127.SetRuleResponse setRule(

                        _1._0._0._127.SetRule setRule254)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param queryBattery256
                
         */

         
                     public _1._0._0._127.QueryBatteryResponse queryBattery(

                        _1._0._0._127.QueryBattery queryBattery256)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Clone an existing rule
                    * @param cloneRule258
                
         */

         
                     public _1._0._0._127.CloneRuleResponse cloneRule(

                        _1._0._0._127.CloneRule cloneRule258)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Sets the polling interval for a device. Use a node ID of 0 to set the global default
                    * @param setPollingInterval260
                
         */

         
                     public _1._0._0._127.SetPollingIntervalResponse setPollingInterval(

                        _1._0._0._127.SetPollingInterval setPollingInterval260)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Returns all devices without querying them first
                    * @param getDevices2262
                
         */

         
                     public _1._0._0._127.GetDevices2Response getDevices2(

                        _1._0._0._127.GetDevices2 getDevices2262)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPCController264
                
         */

         
                     public _1._0._0._127.GetPCControllerResponse getPCController(

                        _1._0._0._127.GetPCController getPCController264)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the device location
                    * @param setLocation266
                
         */

         
                     public _1._0._0._127.SetLocationResponse setLocation(

                        _1._0._0._127.SetLocation setLocation266)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Activate a scene
                    * @param activateScene268
                
         */

         
                     public _1._0._0._127.ActivateSceneResponse activateScene(

                        _1._0._0._127.ActivateScene activateScene268)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param queryDevice270
                
         */

         
                     public _1._0._0._127.QueryDeviceResponse queryDevice(

                        _1._0._0._127.QueryDevice queryDevice270)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Receive network information from another controller
                    * @param receiveNetworkInfo272
                
         */

         
                     public _1._0._0._127.ReceiveNetworkInfoResponse receiveNetworkInfo(

                        _1._0._0._127.ReceiveNetworkInfo receiveNetworkInfo272)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get events log
                    * @param getLog274
                
         */

         
                     public _1._0._0._127.GetLogResponse getLog(

                        _1._0._0._127.GetLog getLog274)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param setUser276
                
         */

         
                     public _1._0._0._127.SetUserResponse setUser(

                        _1._0._0._127.SetUser setUser276)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * For Z-Command GX1's use. Executes at boot-up.
                    * @param init278
                
         */

         
                     public _1._0._0._127.InitResponse init(

                        _1._0._0._127.Init init278)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the device name
                    * @param setName280
                
         */

         
                     public _1._0._0._127.SetNameResponse setName(

                        _1._0._0._127.SetName setName280)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Remove failed nodes from the network. This function is not for removing properly functioning nodes
                    * @param removeFailedDevice282
                
         */

         
                     public _1._0._0._127.RemoveFailedDeviceResponse removeFailedDevice(

                        _1._0._0._127.RemoveFailedDevice removeFailedDevice282)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get groups and devices association of a device.
                    * @param getAssociations284
                
         */

         
                     public _1._0._0._127.GetAssociationsResponse getAssociations(

                        _1._0._0._127.GetAssociations getAssociations284)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Create or update a scene
                    * @param setScene286
                
         */

         
                     public _1._0._0._127.SetSceneResponse setScene(

                        _1._0._0._127.SetScene setScene286)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Special commands
                    * @param auxCommand288
                
         */

         
                     public _1._0._0._127.AuxCommandResponse auxCommand(

                        _1._0._0._127.AuxCommand auxCommand288)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getConfig290
                
         */

         
                     public _1._0._0._127.GetConfigResponse getConfig(

                        _1._0._0._127.GetConfig getConfig290)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get current climate schedule override
                    * @param getClimateScheduleOverride292
                
         */

         
                     public _1._0._0._127.GetClimateScheduleOverrideResponse getClimateScheduleOverride(

                        _1._0._0._127.GetClimateScheduleOverride getClimateScheduleOverride292)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set climate schedule override
                    * @param setClimateScheduleOverride294
                
         */

         
                     public _1._0._0._127.SetClimateScheduleOverrideResponse setClimateScheduleOverride(

                        _1._0._0._127.SetClimateScheduleOverride setClimateScheduleOverride294)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Remove a node ID from device association
                    * @param removeAssociation296
                
         */

         
                     public _1._0._0._127.RemoveAssociationResponse removeAssociation(

                        _1._0._0._127.RemoveAssociation removeAssociation296)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get admin info that includes server password, SMTP details etc
                    * @param getAdminDetail298
                
         */

         
                     public _1._0._0._127.GetAdminDetailResponse getAdminDetail(

                        _1._0._0._127.GetAdminDetail getAdminDetail298)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param setDeviceLevel300
                
         */

         
                     public _1._0._0._127.SetDeviceLevelResponse setDeviceLevel(

                        _1._0._0._127.SetDeviceLevel setDeviceLevel300)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getUser302
                
         */

         
                     public _1._0._0._127.GetUserResponse getUser(

                        _1._0._0._127.GetUser getUser302)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get set rules
                    * @param getRules304
                
         */

         
                     public _1._0._0._127.GetRulesResponse getRules(

                        _1._0._0._127.GetRules getRules304)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Queries a device then returns it
                    * @param getDevice306
                
         */

         
                     public _1._0._0._127.GetDeviceResponse getDevice(

                        _1._0._0._127.GetDevice getDevice306)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Gets the polling interval for a device. Use a node ID of 0 to get the global default
                    * @param getPollingInterval308
                
         */

         
                     public _1._0._0._127.GetPollingIntervalResponse getPollingInterval(

                        _1._0._0._127.GetPollingInterval getPollingInterval308)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Send network information to another controller
                    * @param sendNetworkInfo310
                
         */

         
                     public _1._0._0._127.SendNetworkInfoResponse sendNetworkInfo(

                        _1._0._0._127.SendNetworkInfo sendNetworkInfo310)
                        throws java.rmi.RemoteException
             ;

        

        
       //
       }
    