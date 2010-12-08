

/**
 * ZCommandWSZCommandWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.zcommand.scheme;

    /*
     *  ZCommandWSZCommandWSSoap java interface
     */

    public interface ZCommandWSZCommandWSSoap {
          

        /**
          * Auto generated method signature
          * Get the device location
                    * @param getLocation
                
         */

         
                     public _1._0._0._127.GetLocationResponse getLocation(

                        _1._0._0._127.GetLocation getLocation)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set various properties of a thermostat. Set a parameter to null to ignore it
                    * @param setThermostat
                
         */

         
                     public _1._0._0._127.SetThermostatResponse setThermostat(

                        _1._0._0._127.SetThermostat setThermostat)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set Network Information
                    * @param setNetworkInfo
                
         */

         
                     public _1._0._0._127.SetNetworkInfoResponse setNetworkInfo(

                        _1._0._0._127.SetNetworkInfo setNetworkInfo)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Synchronize the time on a device with that of Z-Command, if supported by the device
                    * @param synchronizeTime
                
         */

         
                     public _1._0._0._127.SynchronizeTimeResponse synchronizeTime(

                        _1._0._0._127.SynchronizeTime synchronizeTime)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Add a new device to the network
                    * @param addDevice
                
         */

         
                     public _1._0._0._127.AddDeviceResponse addDevice(

                        _1._0._0._127.AddDevice addDevice)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Sets a device configuration parameter according to the manufacturer's specification
                    * @param setConfigurationParameter
                
         */

         
                     public _1._0._0._127.SetConfigurationParameterResponse setConfigurationParameter(

                        _1._0._0._127.SetConfigurationParameter setConfigurationParameter)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set SMTP Information
                    * @param setSMTPInfo
                
         */

         
                     public _1._0._0._127.SetSMTPInfoResponse setSMTPInfo(

                        _1._0._0._127.SetSMTPInfo setSMTPInfo)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Returns all devices without querying them first
                    * @param getDevices
                
         */

         
                     public _1._0._0._127.GetDevicesResponse getDevices(

                        _1._0._0._127.GetDevices getDevices)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Return available scenes
                    * @param getScenes
                
         */

         
                     public _1._0._0._127.GetScenesResponse getScenes(

                        _1._0._0._127.GetScenes getScenes)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getUsers
                
         */

         
                     public _1._0._0._127.GetUsersResponse getUsers(

                        _1._0._0._127.GetUsers getUsers)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Associate a device
                    * @param addAssociation
                
         */

         
                     public _1._0._0._127.AddAssociationResponse addAssociation(

                        _1._0._0._127.AddAssociation addAssociation)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Reset a device
                    * @param resetDevice
                
         */

         
                     public _1._0._0._127.ResetDeviceResponse resetDevice(

                        _1._0._0._127.ResetDevice resetDevice)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Save a configuration
                    * @param setConfig
                
         */

         
                     public _1._0._0._127.SetConfigResponse setConfig(

                        _1._0._0._127.SetConfig setConfig)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Perform initial query on a device. This will query for battery support and manufacturer name.
                    * @param queryDeviceInit
                
         */

         
                     public _1._0._0._127.QueryDeviceInitResponse queryDeviceInit(

                        _1._0._0._127.QueryDeviceInit queryDeviceInit)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get the device name
                    * @param getName
                
         */

         
                     public _1._0._0._127.GetNameResponse getName(

                        _1._0._0._127.GetName getName)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the climate control schedule for a thermostat
                    * @param setClimateSchedule
                
         */

         
                     public _1._0._0._127.SetClimateScheduleResponse setClimateSchedule(

                        _1._0._0._127.SetClimateSchedule setClimateSchedule)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param resetController
                
         */

         
                     public _1._0._0._127.ResetControllerResponse resetController(

                        _1._0._0._127.ResetController resetController)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Delete a scene
                    * @param deleteScene
                
         */

         
                     public _1._0._0._127.DeleteSceneResponse deleteScene(

                        _1._0._0._127.DeleteScene deleteScene)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Aborts a device addition or reset operation
                    * @param abortAddOrResetDevice
                
         */

         
                     public _1._0._0._127.AbortAddOrResetDeviceResponse abortAddOrResetDevice(

                        _1._0._0._127.AbortAddOrResetDevice abortAddOrResetDevice)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the wakeup interval in minutes for a battery-operated device
                    * @param setWakeUpInterval
                
         */

         
                     public _1._0._0._127.SetWakeUpIntervalResponse setWakeUpInterval(

                        _1._0._0._127.SetWakeUpInterval setWakeUpInterval)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Delete a user
                    * @param deleteUser
                
         */

         
                     public _1._0._0._127.DeleteUserResponse deleteUser(

                        _1._0._0._127.DeleteUser deleteUser)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param deleteRule
                
         */

         
                     public _1._0._0._127.DeleteRuleResponse deleteRule(

                        _1._0._0._127.DeleteRule deleteRule)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Gets a device configuration parameter according to the manufacturer's specification
                    * @param getConfigurationParameter
                
         */

         
                     public _1._0._0._127.GetConfigurationParameterResponse getConfigurationParameter(

                        _1._0._0._127.GetConfigurationParameter getConfigurationParameter)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Sets a rule.
                    * @param setRule
                
         */

         
                     public _1._0._0._127.SetRuleResponse setRule(

                        _1._0._0._127.SetRule setRule)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param queryBattery
                
         */

         
                     public _1._0._0._127.QueryBatteryResponse queryBattery(

                        _1._0._0._127.QueryBattery queryBattery)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Clone an existing rule
                    * @param cloneRule
                
         */

         
                     public _1._0._0._127.CloneRuleResponse cloneRule(

                        _1._0._0._127.CloneRule cloneRule)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Sets the polling interval for a device. Use a node ID of 0 to set the global default
                    * @param setPollingInterval
                
         */

         
                     public _1._0._0._127.SetPollingIntervalResponse setPollingInterval(

                        _1._0._0._127.SetPollingInterval setPollingInterval)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Returns all devices without querying them first
                    * @param getDevices2
                
         */

         
                     public _1._0._0._127.GetDevices2Response getDevices2(

                        _1._0._0._127.GetDevices2 getDevices2)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPCController
                
         */

         
                     public _1._0._0._127.GetPCControllerResponse getPCController(

                        _1._0._0._127.GetPCController getPCController)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the device location
                    * @param setLocation
                
         */

         
                     public _1._0._0._127.SetLocationResponse setLocation(

                        _1._0._0._127.SetLocation setLocation)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Activate a scene
                    * @param activateScene
                
         */

         
                     public _1._0._0._127.ActivateSceneResponse activateScene(

                        _1._0._0._127.ActivateScene activateScene)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param queryDevice
                
         */

         
                     public _1._0._0._127.QueryDeviceResponse queryDevice(

                        _1._0._0._127.QueryDevice queryDevice)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Receive network information from another controller
                    * @param receiveNetworkInfo
                
         */

         
                     public _1._0._0._127.ReceiveNetworkInfoResponse receiveNetworkInfo(

                        _1._0._0._127.ReceiveNetworkInfo receiveNetworkInfo)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get events log
                    * @param getLog
                
         */

         
                     public _1._0._0._127.GetLogResponse getLog(

                        _1._0._0._127.GetLog getLog)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param setUser
                
         */

         
                     public _1._0._0._127.SetUserResponse setUser(

                        _1._0._0._127.SetUser setUser)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * For Z-Command GX1's use. Executes at boot-up.
                    * @param init
                
         */

         
                     public _1._0._0._127.InitResponse init(

                        _1._0._0._127.Init init)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set the device name
                    * @param setName
                
         */

         
                     public _1._0._0._127.SetNameResponse setName(

                        _1._0._0._127.SetName setName)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Remove failed nodes from the network. This function is not for removing properly functioning nodes
                    * @param removeFailedDevice
                
         */

         
                     public _1._0._0._127.RemoveFailedDeviceResponse removeFailedDevice(

                        _1._0._0._127.RemoveFailedDevice removeFailedDevice)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get groups and devices association of a device.
                    * @param getAssociations
                
         */

         
                     public _1._0._0._127.GetAssociationsResponse getAssociations(

                        _1._0._0._127.GetAssociations getAssociations)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Create or update a scene
                    * @param setScene
                
         */

         
                     public _1._0._0._127.SetSceneResponse setScene(

                        _1._0._0._127.SetScene setScene)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Special commands
                    * @param auxCommand
                
         */

         
                     public _1._0._0._127.AuxCommandResponse auxCommand(

                        _1._0._0._127.AuxCommand auxCommand)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getConfig
                
         */

         
                     public _1._0._0._127.GetConfigResponse getConfig(

                        _1._0._0._127.GetConfig getConfig)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get current climate schedule override
                    * @param getClimateScheduleOverride
                
         */

         
                     public _1._0._0._127.GetClimateScheduleOverrideResponse getClimateScheduleOverride(

                        _1._0._0._127.GetClimateScheduleOverride getClimateScheduleOverride)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Set climate schedule override
                    * @param setClimateScheduleOverride
                
         */

         
                     public _1._0._0._127.SetClimateScheduleOverrideResponse setClimateScheduleOverride(

                        _1._0._0._127.SetClimateScheduleOverride setClimateScheduleOverride)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Remove a node ID from device association
                    * @param removeAssociation
                
         */

         
                     public _1._0._0._127.RemoveAssociationResponse removeAssociation(

                        _1._0._0._127.RemoveAssociation removeAssociation)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get admin info that includes server password, SMTP details etc
                    * @param getAdminDetail
                
         */

         
                     public _1._0._0._127.GetAdminDetailResponse getAdminDetail(

                        _1._0._0._127.GetAdminDetail getAdminDetail)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param setDeviceLevel
                
         */

         
                     public _1._0._0._127.SetDeviceLevelResponse setDeviceLevel(

                        _1._0._0._127.SetDeviceLevel setDeviceLevel)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param getUser
                
         */

         
                     public _1._0._0._127.GetUserResponse getUser(

                        _1._0._0._127.GetUser getUser)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Get set rules
                    * @param getRules
                
         */

         
                     public _1._0._0._127.GetRulesResponse getRules(

                        _1._0._0._127.GetRules getRules)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Queries a device then returns it
                    * @param getDevice
                
         */

         
                     public _1._0._0._127.GetDeviceResponse getDevice(

                        _1._0._0._127.GetDevice getDevice)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Gets the polling interval for a device. Use a node ID of 0 to get the global default
                    * @param getPollingInterval
                
         */

         
                     public _1._0._0._127.GetPollingIntervalResponse getPollingInterval(

                        _1._0._0._127.GetPollingInterval getPollingInterval)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * Send network information to another controller
                    * @param sendNetworkInfo
                
         */

         
                     public _1._0._0._127.SendNetworkInfoResponse sendNetworkInfo(

                        _1._0._0._127.SendNetworkInfo sendNetworkInfo)
                        throws java.rmi.RemoteException
             ;

        

        
       //
       }
    