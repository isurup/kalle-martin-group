echo off

set CMD=%1 %2 %3 %4
rem if "%1%2%3%4" == "" set CMD=--config configs\testconfig.cfg
if "%1%2%3%4" == "" set CMD=--config configs\testconfig.cfg

java -cp ..\lib\boot.jar madkit.boot.Madkit madkit.kernel.Booter --graphics --communicator-on %CMD%
