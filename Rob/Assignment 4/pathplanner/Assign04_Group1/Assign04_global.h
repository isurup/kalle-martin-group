#ifndef ASSIGN04_GLOBAL_H
#define ASSIGN04_GLOBAL_H

#include <Qt/qglobal.h>

#ifdef ASSIGN04_LIB
# define ASSIGN04_EXPORT Q_DECL_EXPORT
#else
# define ASSIGN04_EXPORT Q_DECL_IMPORT
#endif

#endif // ASSIGN04_GLOBAL_H
