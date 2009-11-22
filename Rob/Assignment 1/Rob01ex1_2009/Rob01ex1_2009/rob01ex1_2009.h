#ifndef ROB01EX1_2009_H
#define ROB01EX1_2009_H

#include "rob01ex1_2009_global.h"

#include <rws/RobWorkStudioPlugin.hpp>

#include <rw/models/WorkCell.hpp>
#include <rw/kinematics/State.hpp>
#include <rw/kinematics/MovableFrame.hpp>

#include <rwlibs/drawable/RenderFrame.hpp>

#include "ui_Rob01Ex1Widget.h"


#include <QString>
#include <QList>
#include <QStringList>


class ROB01EX1_2009_EXPORT Rob01ex1_2009: public RobWorkStudioPlugin, private Ui::Rob01Ex1Widget
{
Q_OBJECT
Q_INTERFACES( RobWorkStudioPlugin )

public:
	Rob01ex1_2009();
	~Rob01ex1_2009();
    virtual void open(rw::models::WorkCell* workcell);

    virtual void close();

    virtual void initialize();

private slots:

	void clickBtnInsertFrame();
	void clickBtnSolve();

	void clickBtnSliderReset();

    void clickBtnUser1();
    void clickBtnUser2();
    void clickBtnUser3();
    void clickBtnUser4();

    void valueChangedRPY();

    void angleSetSelected(QString);

    void stateChangedListener(const rw::kinematics::State& state);

private:

	rw::kinematics::MovableFrame* insertFrame(std::string name);
	void addRenderFrame(rw::kinematics::Frame* frame, float scale);

	rw::models::WorkCell* _pWorkCell;

	rw::kinematics::MovableFrame* _pTestFrame;

	QString _strAngleSet;
	bool _bolUpdating;

	rw::math::RPY<double> Rob01ex1_2009::updateAngles();
	rw::math::Rotation3D<double> Rob01ex1_2009::updateRotation();
	void Rob01ex1_2009::updateFrame(rw::math::Rotation3D<double> rotation);
	void Rob01ex1_2009::enableInterface(bool b);
};

#endif // ROB01EX1_2009_H
