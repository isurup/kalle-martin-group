# UIC
SET(UIS_FILES Rob01Ex1Widget.ui )
RWS_QT4_WRAP_UI(UIS_OUT_H ${UIS_FILES})

# MOC
QT4_WRAP_CPP(MocSrcFiles Rob01Ex1Plugin.hpp)

# RCC
QT4_ADD_RESOURCES(RccSrcFiles resources.qrc)

# SRC files
SET(SrcFiles Rob01Ex1Plugin.cpp ${UIS_OUT_H})

# The shared library to build:
ADD_LIBRARY(Rob01Ex1 MODULE ${SrcFiles} ${MocSrcFiles}  ${RccSrcFiles})
TARGET_LINK_LIBRARIES(Rob01Ex1 ${ROBWORKSTUDIO_LIBRARIES} ${ROBWORK_LIBRARIES})