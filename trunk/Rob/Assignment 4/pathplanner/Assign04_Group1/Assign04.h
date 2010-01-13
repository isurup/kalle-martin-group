#ifndef ASSIGN04_H
#define ASSIGN04_H

#include "Assign04_global.h"

#include <rws/RobWorkStudioPlugin.hpp>

#include <rw/models/WorkCell.hpp>
#include <rw/kinematics/State.hpp>
#include <rw/kinematics/MovableFrame.hpp>

#include <rwlibs/drawable/RenderFrame.hpp>

#include "ui_Assign04Widget.h"


#include <QString>
#include <QList>
#include <QStringList>


class ASSIGN04_EXPORT assign04: public RobWorkStudioPlugin, private Ui::Assign04Widget
{
Q_OBJECT
Q_INTERFACES( RobWorkStudioPlugin )

public:
	assign04();
	~assign04();
    virtual void open(rw::models::WorkCell* workcell);

    virtual void close();

    virtual void initialize();

private slots:

	void clickBtnOpen();

    void stateChangedListener(const rw::kinematics::State& state);

private:

	rw::kinematics::MovableFrame* insertFrame(std::string name);
	void addRenderFrame(rw::kinematics::Frame* frame, float scale);

	rw::models::WorkCell* _pWorkCell;

	rw::kinematics::MovableFrame* _pTestFrame;

	QString _strAngleSet;
	bool _bolUpdating;

	void assign04::updateFrame(rw::math::Rotation3D<double> rotation);
	void assign04::enableInterface(bool b);
};

#endif // ASSIGN04_H
