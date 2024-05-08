package academic.model;

/**
 * @author 12S22028 - Tennov Pakpahan
 * 
 */
public class CourseOpening {
    private String codeCourse;
    private String courseName;
    private int credit;
    private String passingGrade;
    private String academicYear;
    private String semester;
    private String initLect;
    


    public CourseOpening(String codeCourse, String courseName, int credit, String passingGrade, String academicYear, String semester, String initLect) {
        this.codeCourse = codeCourse;
        this.academicYear = academicYear;
        this.semester = semester;
        this.initLect = initLect;
        this.courseName = courseName;
        this.credit = credit;
        this.passingGrade = passingGrade;
    }

    public String getCodeCourse() {
        return this.codeCourse;
    }

    public String getAcademicYear() {
        return this.academicYear;
    }

    public String getSemester() {
        return this.semester;
    }

    public String getInitLect() {
        return this.initLect;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public int getCredit(){
        return this.credit;
    }

    public String getPassingGrade(){
        return this.passingGrade;
    }

    public void showCourseOpening() {
        System.out.println(this.codeCourse + "|" + this.courseName + "|" + this.credit + "|" + this.passingGrade + "|" + this.academicYear + "|" + this.semester + "|" + this.initLect);
    }
}
