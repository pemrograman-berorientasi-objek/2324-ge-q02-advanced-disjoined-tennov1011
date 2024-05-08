package academic.model;

/**
 * @author 12S22028 - Tennov Pakpahan
 */
public class Student extends Orang implements Interface{


    private String year;
    private String studyProgram;

    public Student(String id, String name, String year, String studyProgram) {
        super(id, name);
        this.year = year;
        this.studyProgram = studyProgram;
    }



    public String getYear() {
        return this.year;
    }


    public String getStudyProgram() {
        return this.studyProgram;
    }


    public void showClass() {
        System.out.println(getId() + "|" + getName() + "|" + getYear() + "|" + getStudyProgram());
    }
}
