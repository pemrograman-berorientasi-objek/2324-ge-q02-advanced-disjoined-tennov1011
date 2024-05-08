package academic.driver;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import academic.model.Enrollment;
import academic.model.Lecturer;
import academic.model.Student;
import academic.model.Course;
import academic.model.CourseOpening;

/**
 * @author 12S22028 _ Tennov Pakpahan
 * 
 */
public class Driver1 {
    public static void main(String[] _args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Student> student = new ArrayList<Student>();
        ArrayList<Course> course = new ArrayList<Course>();
        ArrayList<Enrollment> enrollment = new ArrayList<Enrollment>();
        ArrayList<Lecturer> lecturer = new ArrayList<Lecturer>();
        ArrayList<CourseOpening> courseOpening = new ArrayList<CourseOpening>();
        // ArrayList<Course> tes = new ArrayList<Course>();

        int loop = 1;

        String save[] = new String[10];
        int index = 0;
        for (int i = 0; i < index; i++) {
            save[i] = "";
        }
        while (loop == 1 && in.hasNextLine()) {

            String simpan = "";
            String cmd = in.nextLine();
            if (cmd.equals("---")) {
                loop = 4;
            } else {
                String tok[] = cmd.split("#");
                if (tok[0].equals("course-add")) {
                    boolean isCourse = false;
                    for (int i = 0; i < course.size(); i++) {
                        if (tok[1].equals(course.get(i).getCodeCourse())) {
                            isCourse = true;
                            break;
                        }
                    }
                    if (!isCourse) {
                        course.add(new Course(tok[1], tok[2], Integer.parseInt(tok[3]), tok[4]));
                    }
                } else if (tok[0].equals("course-open")) {
                    String courseName = "";
                    int credit = 0;
                    String passingGrade = "";

                    for (Course C : course) {
                        if (C.getCodeCourse().equals(tok[1])) {
                            courseName = C.getMajor();
                            credit = C.getCredit();
                            passingGrade = C.getPassingGrade();
                        }
                    }
                    boolean isLec = false;
                    String[] pecah = tok[4].split(",");
                    for (int i = 0; i < pecah.length; i++) {
                        for (Lecturer L : lecturer) {
                            if (L.getInitLect().equals(pecah[i])) {
                                isLec = true;
                                if (i == pecah.length - 1) {
                                    simpan = simpan.concat(pecah[i] + " " + "(" + L.getEmailLect() + ")");
                                } else {
                                    simpan = simpan.concat(pecah[i] + " " + "(" + L.getEmailLect() + ")" + ";");
                                }
                            }
                        }
                    }
                    boolean isCrs = false;
                    for (Course C : course) {
                        if (C.getCodeCourse().equals(tok[1])) {
                            isCrs = true;
                        }
                    }
                    if (isCrs == true && isLec == true) {
                        // System.out.println(simpan);
                        courseOpening.add(
                                new CourseOpening(tok[1], courseName, credit, passingGrade, tok[2], tok[3], simpan));

                    }

                } else if (tok[0].equals("course-history")) {
                    String codeCrs = tok[1];
                    courseOpening.sort((s1, s2) -> s2.getSemester().compareTo(s1.getSemester()));
                    for (CourseOpening co : courseOpening) {
                        if (co.getCodeCourse().equals(codeCrs)) {
                            co.showCourseOpening();
                        }
                        for (Enrollment E : enrollment) {
                            if (E.getAcademicYear().equals(co.getAcademicYear())
                                    && E.getCodeCourse().equals(co.getCodeCourse())
                                    && E.getSemester().equals(co.getSemester())) {
                                E.showEnrollment();
                            }
                        }
                    }

                } else if (tok[0].equals("student-add")) {
                    boolean isStudent = false;
                    for (int i = 0; i < student.size(); i++) {
                        if (tok[1].equals(student.get(i).getId())) {
                            isStudent = true;
                            break;
                        }
                    }
                    if (!isStudent) {
                        student.add(new Student(tok[1], tok[2], tok[3], tok[4]));
                    }
                } else if (tok[0].equals("enrollment-add")) {
                    enrollment.add(new Enrollment(tok[1], tok[2], tok[3], tok[4]));
                } else if (tok[0].equals("lecturer-add")) {
                    boolean isLecturer = false;
                    for (int i = 0; i < lecturer.size(); i++) {
                        if (tok[1].equals(lecturer.get(i).getId())) {
                            isLecturer = true;
                            break;
                        }
                    }
                    if (!isLecturer) {
                        lecturer.add(new Lecturer((tok[1]), tok[2], tok[3], tok[4], tok[5]));
                    }
                } else if (tok[0].equals("enrollment-grade")) {
                    String gradeInput = tok[5];
                    for (Enrollment enr : enrollment) {
                        if (enr.getIdStd().equals(tok[2]) && enr.getCodeCourse().equals(tok[1])
                                && enr.getSemester().equals(tok[4]) && enr.getAcademicYear().equals(tok[3])) {
                            enr.setGrade(gradeInput);
                            // enr.setRemedial(gradeInput);
                        }
                    }

                } else if (tok[0].equals("student-details")) {
                    String nimStd = tok[1];
                    int totalCredit = 0;
                    double ips = 0.00;
                    String[] grade = new String[50];
                    String[] codeCrs = new String[50];
                    int idx = 0;
                    double totalSeluruh = 0.00;

                    for (int i = 0; i < enrollment.size(); i++) {
                        if (enrollment.get(i).getIdStd().equals(nimStd)) {
                            codeCrs[idx] = enrollment.get(i).getCodeCourse();
                            if (enrollment.get(i).getDetect() == 1) {
                                grade[idx] = enrollment.get(i).getGrade();
                            } else {
                                grade[idx] = enrollment.get(i).getGrade();
                            }
                            idx++;
                        }
                    }

                    for (int i = 0; i < idx; i++) {
                        for (int j = i + 1; j < idx; j++) {
                            if (codeCrs[i].equals(codeCrs[j])) {
                                codeCrs[i] = codeCrs[j];
                                grade[i] = grade[j];
                                grade[j] = null;
                                codeCrs[j] = null;
                                idx--;
                            }
                        }
                    }

                    for (int i = 0; i < idx; i++) {
                        for (Course crs : course) {
                            if (codeCrs[i].equals(crs.getCodeCourse())) {
                                totalCredit += crs.getCredit();
                            }
                        }
                    }

                    for (int i = 0; i < idx; i++) {
                        for (Course crs : course) {
                            if (codeCrs[i].equals(crs.getCodeCourse())) {
                                if (grade[i].equals("A")) {
                                    ips += 4.00 * crs.getCredit();
                                } else if (grade[i].equals("AB")) {
                                    ips += 3.50 * crs.getCredit();
                                } else if (grade[i].equals("B")) {
                                    ips += 3.00 * crs.getCredit();
                                } else if (grade[i].equals("BC")) {
                                    ips += 2.50 * crs.getCredit();
                                } else if (grade[i].equals("C")) {
                                    ips += 2.00 * crs.getCredit();
                                } else if (grade[i].equals("D")) {
                                    ips += 1.00 * crs.getCredit();
                                } else if (grade[i].equals("E")) {
                                    ips += 0.00 * crs.getCredit();
                                }
                            }
                        }
                    }
                    if (totalCredit == 0) {
                        totalSeluruh = 0.00;
                    } else {
                        totalSeluruh = ips / totalCredit;

                    }

                    for (Student std : student) {
                        if (std.getId().equals(nimStd)) {
                            if (totalCredit == 0) {
                                System.out.println(std.getId() + "|" + std.getName() + "|" + std.getYear() + "|"
                                        + std.getStudyProgram() + "|"
                                        + (String.format("%.2f", totalSeluruh) + "|" + totalCredit));
                            } else {
                                System.out.println(std.getId() + "|" + std.getName() + "|" + std.getYear() + "|"
                                        + std.getStudyProgram() + "|"
                                        + (String.format("%.2f", totalSeluruh) + "|" + totalCredit));
                            }
                        }
                    }

                } else if (tok[0].equals("enrollment-remedial")) {
                    String gradeInput = tok[5];
                    for (Enrollment enr : enrollment) {
                        if (enr.getIdStd().equals(tok[2]) && enr.getCodeCourse().equals(tok[1])
                                && !enr.getGrade().equals("None")
                                && enr.getSemester().equals(tok[4]) && enr.getAcademicYear().equals(tok[3])
                                && enr.getDetect() == 0) {
                            enr.setRemedial(gradeInput);
                            enr.setGrade(gradeInput);
                            enr.setDetect(1);
                        }
                    }
                } else if (tok[0].equals("find-the-best-student")) {
                    String year = tok[1];
                    String semester = tok[2];
                    String[] nimStd = new String[20];
                    String[] grade = new String[20];
                    int best = 0;
                    String bestStudent = "";
                    int idx = 0;
                    String odd = "";
                    String even = "";
                    for (Enrollment E : enrollment) {
                        if (E.getAcademicYear().equals(year) && E.getSemester().equals(semester)) {
                            nimStd[idx] = E.getIdStd();
                            grade[idx] = E.getGrade();
                            idx++;
                        }
                    }

                    for (int i = 0; i < idx; i++) {
                        if (enrollment.get(i).getAcademicYear().equals(year)) {
                            best = Integer.parseInt(nimStd[i].substring(7));
                        }
                        if (best % 2 == 0) {
                            bestStudent = nimStd[i];
                        }
                    }

                    for (Enrollment E : enrollment) {
                        if (E.getIdStd().equals(bestStudent) && E.getAcademicYear().equals(year)
                                && E.getSemester().equals("odd")) {
                            odd = E.getGrade();
                        } else if (E.getIdStd().equals(bestStudent) && E.getAcademicYear().equals(year)
                                && E.getSemester().equals("even")) {
                            even = E.getGrade();

                        }
                    }
                    save[index] = bestStudent + "|" + odd + "/" + even;
                    index++;

                        // for (int i = 0; i < idx; i++) {
                        //     if (enrollment.get(i).getIdStd().equals(bestStudent)
                        //             && enrollment.get(i).getAcademicYear().equals(year)) {
                        //         System.out.println(save);
                        //     }
                        // }
                    }
                }
            }

            for (int i = 0; i < lecturer.size(); i++) {
                lecturer.get(i).showClass();
            }
            for (int i = 0; i < course.size(); i++) {
                System.out.println(course.get(i).toString());
            }
            for (Student s : student) {
                s.showClass();
            }
            for (Enrollment e : enrollment) {
                e.showEnrollment();
            }
            for (int i = 0; i < index; i++) {
                System.out.println(save[i]);
            }

            in.close();
        }
    }

