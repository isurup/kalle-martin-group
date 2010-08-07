rem: version with old communicator on
rem java -cp ..\lib\boot.jar madkit.boot.Madkit madkit.kernel.Booter --graphics --communicator-on --config configs\testmadkit.cfg

rem: version without any communicator on
java -cp ..\lib\boot.jar madkit.boot.Madkit madkit.kernel.Booter --graphics --config configs\testmadkit.cfg
