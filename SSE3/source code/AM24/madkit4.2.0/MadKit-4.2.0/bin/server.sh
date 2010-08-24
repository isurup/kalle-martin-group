#!/bin/sh

if test $# -eq 0; then
    cmdfile="--config configs/remoteconfig.cfg"
else
    cmdfile=$*
fi

if [ -x $JAVA_HOME ]
  then $JAVA_HOME/bin/java -cp -Xms16m -Xmx128m ../lib/boot.jar madkit.boot.Madkit madkit.kernel.Booter --communicator-on $cmdfile
  else java -cp -Xms16m -Xmx128m ../lib/boot.jar madkit.boot.Madkit madkit.kernel.Booter --communicator-on $cmdfile
fi
