package org.example;

import java.util.Map;

    public class Main {
        public static void main(String[] args) {
            final ShareResource<Student> shareResource=new ShareResource<>();
            final GradeBook gradeBook=new GradeBook();
            Thread threadA =new Thread(()->{
                while (true){
                    shareResource.addToList(new Student());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread threadB =new Thread(()->{
                while (true){
                    Student student=shareResource.removeFromList();
                    if (student!=null){
                        System.out.println("Processed" +student);
                        if (gradeBook.getTopStudent()==student){
                            gradeBook.updateTopStudent(null);
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread threadC =new Thread(()->{
                while (true) {
                    int max=0;
                    int average;
                    int sum;
                    for (int i = 0; i <shareResource.getList().size() ; i++) {
                        Student currentStudent=shareResource.getList().get(i);
                        Map<String, Integer> coursesGrades = currentStudent.getCoursesGrades();
                        sum=0;
                        for (int j=0; j<coursesGrades.size(); j++) {
                            String key=String.valueOf( currentStudent.getCourses().get(j));
                            int grade=coursesGrades.get(key);
                            sum+=grade;
                        }
                        average=sum/coursesGrades.size();
                        if (average>max){
                            max=average;
                            gradeBook.updateTopStudent(currentStudent);
                            System.out.println("topStudent" +currentStudent);
                        }
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadA.start();
            threadB.start();
            threadC.start();
        }

    }

