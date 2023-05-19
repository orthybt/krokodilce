    package com.example.krokodilce.src.handlers;

    import com.example.krokodilce.src.XML_Wrappers.OrthyPoints;
    import com.example.krokodilce.src.cloud.Cloud;
    import com.example.krokodilce.src.dataObjects.OrthyPoint;
    import com.example.krokodilce.src.dataObjects.Patient;

    import java.awt.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import java.util.ArrayList;
    import java.util.List;

/**
 * A Template class for functional objects, AKA handlers :)
 * They Handle stuff
 * Try to keep class variables as specific as possible, everything else goes in
 * the cloud. This class is a good example
 * @author Orthy
 */
//****************************************************************************\\
//                              POINT HANDLER                                 \\
//****************************************************************************\\
public class PointHandler extends MouseAdapter{
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //*************************|*|********************************************\\

    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    private int sentinel = 16;  //Number of points needed for the program
    private int pointCount = 0;
    private List<Point> tempPoints = new ArrayList();
    private Boolean isFinished = false;
    private Graphics2D gfx;// NO LAG WHEN I CLICK, CAUSE NO CALL TO cloud every time a point is being generated
     //************************************************************************\\
    //                              METHODS - GFX INIT                        \\
    //************************************************************************\\
    public void initGFX(Graphics2D gfx){
        this.gfx = gfx;
        this.gfx.setColor(Color.YELLOW);
    }
    //************************************************************************\\
    //                              METHODS - MOUSE CLICK                     \\
    //************************************************************************\\
    @Override
        public void mouseClicked(MouseEvent event){
        gfx.setColor(Color.YELLOW);
        if( getPointCount() < getSentinel()){
            getTempPoints().add(event.getPoint());
            gfx.drawOval(event.getPoint().x, event.getPoint().y, 2, 2);
            getC().guiHandler().markCheckBox(getPointCount());
            setPointCount(pointCount+1);   
            //add points to points - NEEDED FOR RUNTIME
            c.p().getPoints().add(event.getPoint());
        }
        if( getPointCount() == getSentinel()){
            getC().p().setP1(getTempPoints().get(0));
            getC().p().setP2(getTempPoints().get(1));
            getC().p().setP3(getTempPoints().get(2));
            getC().p().setP4(getTempPoints().get(3));
            getC().p().setP5(getTempPoints().get(4));
            getC().p().setP6(getTempPoints().get(5));  
            getC().p().setP7(getTempPoints().get(6));
            getC().p().setP8(getTempPoints().get(7));
            getC().p().setP9(getTempPoints().get(8));
            getC().p().setP10(getTempPoints().get(9));
            getC().p().setP11(getTempPoints().get(10));
            getC().p().setP12(getTempPoints().get(11));
            getC().p().setP13(getTempPoints().get(12));
            getC().p().setP14(getTempPoints().get(13));
            getC().p().setP15(getTempPoints().get(14));
            getC().p().setP16(getTempPoints().get(15));
            //CURRENT PATIENT IS UPDATED HERE
            updatePoints(c.data().getCurrentPatient());
            setIsFinished((Boolean) true);
        }
    }   
    //************************************************************************\\
    //                              MISC METHODS                              \\
    //************************************************************************\\
        public void initPoints(List<Point> points){
            List<Point> _tempPoints = points;
            
            getC().p().setP1(_tempPoints.get(0));
            getC().p().setP2(_tempPoints.get(1));
            getC().p().setP3(_tempPoints.get(2));
            getC().p().setP4(_tempPoints.get(3));
            getC().p().setP5(_tempPoints.get(4));
            getC().p().setP6(_tempPoints.get(5));  
            getC().p().setP7(_tempPoints.get(6));
            getC().p().setP8(_tempPoints.get(7));
            getC().p().setP9(_tempPoints.get(8));
            getC().p().setP10(_tempPoints.get(9));
            getC().p().setP11(_tempPoints.get(10));
            getC().p().setP12(_tempPoints.get(11));
            getC().p().setP13(_tempPoints.get(12));
            getC().p().setP14(_tempPoints.get(13));
            getC().p().setP15(_tempPoints.get(14));
            getC().p().setP16(_tempPoints.get(15));
        }
        /**
         * ORTHY POINTS FROM POINTS DURRING POINT SELECTION
         * @return 
         */
        public OrthyPoints getOrthyPoints(){
            OrthyPoints orthyPoints = new OrthyPoints();
            tempPoints.forEach((t) -> {
                orthyPoints.getOrthyPoints().add(new OrthyPoint(t));
            });
            return orthyPoints;
        }
        /**
         * UPDATE THE POINTS OF THE CURRENT PATIENT
         * @param patient 
         */
        public void updatePoints(Patient patient){
            OrthyPoints points = getOrthyPoints();
            patient.updatePatient(points);
            c.data().setCurrentPatient(patient);
        }
        /**
         * UPDATE THE POINTS OF THE CURRENT PATIENT
         */
        public void resetPoints(){
            this.pointCount = 0;
            this.tempPoints.clear();
            this.isFinished = false;
            c.p().resetPoints_Lateral();
            Patient patient = c.data().getCurrentPatient();
            c.data().setCurrentPatient(patient.resetPatient_Points(patient));
        }
        public void loadPoints(){
            c.p().setPointsLateral(c.data().getCurrentPatient().getOrthyPoints().getPoints());
        }
        public void undoPoint(){
            int now = getPointCount();
            getC().guiHandler().unMarkCheckBox(now-1);
            getC().pointHandler().setPointCount(now-1);  
            getC().pointHandler().getTempPoints().remove(now-1);
        }
    //************************************************************************\\
    //                          GETTERS/SETTERS                               \\
    //************************************************************************\\  
    public int getSentinel() {
        return sentinel;
    }

    public void setSentinel(int sentinel) {
        this.sentinel = sentinel;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public List<Point> getTempPoints() {
        return tempPoints;
    }

    public void setTempPoints(List<Point> tempPoints) {
        this.tempPoints = tempPoints;
    }    

    public int getPointCount() {
        return pointCount;
    }

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }
    
}
