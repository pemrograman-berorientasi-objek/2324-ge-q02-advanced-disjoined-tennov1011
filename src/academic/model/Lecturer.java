package academic.model;

public class Lecturer extends Orang implements Interface{

    private String initLect;
    private String emailLect;
    private String studyProgram;

    public Lecturer (String id, String name, String initLect, String emailLect, String studyProgram){
        super(id, name);
        this.initLect = initLect;
        this.emailLect = emailLect;
        this.studyProgram = studyProgram;
    }
    

    public String getInitLect(){
        return this.initLect;
    }
    public String getEmailLect(){
        return this.emailLect;
    }
    public String getStudyProgram(){
        return this.studyProgram;
    }

    public void showClass(){
        System.out.println(getId() + "|" + getName() + "|" + getInitLect() + "|" + getEmailLect() + "|" + getStudyProgram());
    }

}
