package academic.model;

/**
 * @author 12S22028 - Tennov Pakpahan
 */
public class Enrollment {
    private String IdStd;
    private String codeCourse;
    private String academicYear;
    private String semester;
    private String grade = "None";
    private String remedial = "";
    private int detect = 0;
    private String best;

    public Enrollment(String codeCourse, String idStd, String academicYear, String semester){
        this.codeCourse = codeCourse;
        this.IdStd = idStd;
        this.academicYear = academicYear;
        this.semester = semester;

    }

    public String getCodeCourse(){
        return this.codeCourse;
    }

    public void setDetect(int detect){
        this.detect = detect;
    }
    public int getDetect(){
        return this.detect;
    }

    public void setBest(String best){
        this.best = best;
    }
    public String getBest(){
        return this.best;
    }

    public String getIdStd(){
        return this.IdStd;
    }

    public String getSemester(){
        return this.semester;
    }
    

    public String getAcademicYear(){
        return this.academicYear;
    }

    public String getRemedial(){
        return this.remedial;
    }

    public String getGrade(){
        return this.grade;
    }

    public void setCourse(String codeCourse){
        this.codeCourse = codeCourse;
    }
    public void setGrade(String grd){
        this.grade = grd;
    }

    public void setRemedial(String prvGrade){
        // this.remedial = prvGrade;
        this.remedial += prvGrade + "(" + this.grade + ")";
    }

    public void showBest(){
        System.out.println(getBest());
    }
    
    public void showEnrollment(){
        if (remedial == "") {
            System.out.println(getCodeCourse() + "|" + getIdStd() + "|" + getAcademicYear() + "|" + getSemester() + "|" + getGrade());
        }else{
            System.out.println(getCodeCourse() + "|" + getIdStd() + "|" + getAcademicYear() + "|" + getSemester() + "|" + getRemedial());
        }
    }
}