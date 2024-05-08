package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22028 - Tennov Pakpahan
 */
public class Course {
    private String codeCourse;
    private String major;
    private String passingGrade;
    private String LecEmail ;
    private int credit;
    // private ArrayList<Lecturer> lecturer;
   
    public Course(String codeCourse, String major, int credit, String passingGrade) {
        this.codeCourse = codeCourse;
        this.major = major;
        this.passingGrade = passingGrade;
        this.credit = credit;
        // this.LecEmail = email;
        // this.lecturer = lecturer;

    }



    public String getMajor() {
        return this.major;
    }

    public String getCodeCourse() {
        return this.codeCourse;
    }

    public int getCredit() {
        return this.credit;
    }


    public String getPassingGrade() {
        return this.passingGrade;
    }

    public String getKeterangan() {
        return this.LecEmail;
    }


    public void showCourse() {
        System.out.print(getCodeCourse() + "|" + getMajor() + "|" + getCredit() + "|" + getPassingGrade());
    }

        @Override
        public String toString() {
            return codeCourse + "|" + major + "|" + credit + "|"
                    + passingGrade ;
        }

}


    // StringBuilder sb  = new StringBuilder();
    // public String assInit(ArrayList<Course> course, ArrayList<Lecturer> lecturer){
    //     for(int i = 0; i < course.size(); i++){
    //         for(int j = 0; j < lecturer.size(); j++){
    //             String [] lecId = course.get(i).getKeterangan().split(",");
    //             for(int k = 0; k < lecId.length; k++){
    //                 if(lecturer.get(j).getInitLect().equals(lecId[k])){
    //                     sb.append(lecturer.get(j).getInitLect() + " " + "(" + lecturer.get(j).getEmailLect() + ")");
    //                     if(k < lecId.length - 1){
    //                         sb.append(";");
    //                     }
    //                 }
    //             }
    //         }
    //         sb.setLength(0);
    //     }
    //     return sb.toString();
    // }

    // public void deletebuild(){
    //     sb.setLength(0);
    // }

    
    // public void initId(ArrayList<Lecturer> lecturer, String[] lecId) {
    //     System.out.print("(");
    //     for (int i = 0; i < lecturer.size(); i++) {
    //         Lecturer lec = lecturer.get(i);
    //         System.out.print(lec.getInitLect() + "(" + lec.getEmailLect() + ")");
    //         if (i < lecturer.size() - 1) {
    //             System.out.print("; ");
    //         }
    //     }
    //     System.out.println(")");
    // }