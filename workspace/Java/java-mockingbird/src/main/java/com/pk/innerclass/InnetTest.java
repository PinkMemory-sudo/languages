package com.pk.innerclass;

import lombok.Data;

import java.util.Stack;

public class InnetTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.setCompany("GIOC");
        OutClass.InnerClass innerClass = outClass.new InnerClass();
        System.out.println(innerClass.getConpany());
    }
}

@Data
class OutClass {

    private String company;

    class InnerClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getConpany(){
            return company;
        }
    }
}
