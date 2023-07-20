package org.example;

public class GradeBook {

        private  Student topStudent;

      //  @Override
//        public String toString() {
//            return "topStudent{" +
//                    "=" + topStudent.toString()+
//                    '}';
//        }

        public void updateTopStudent(Student student){
            this.topStudent=student;
        }

        public Student getTopStudent() {
            return topStudent;
        }

    }

