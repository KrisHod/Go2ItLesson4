package com.go2it.Lesson4;

public class Dog {
    private String ears;
    private String teeth;
    private String paws;
    private String head;
    private boolean hasTail;
    private String name;
    private int age;
    private String color;
    private String breed;

    public Dog(String ears, String teeth, String paws, String head, boolean hasTail, String name) {
        this.ears = ears;
        this.teeth = teeth;
        this.paws = paws;
        this.head = head;
        this.hasTail = hasTail;
        this.name = name;
    }

    public Dog(String ears, String teeth, String paws, String head, boolean hasTail, String name, int age) { // overloaded constructor
        this.ears = ears;
        this.teeth = teeth;
        this.paws = paws;
        this.head = head;
        this.hasTail = hasTail;
        this.name = name;
        this.age = age;
    }

    public String walk(boolean likeWalk) {
        if (likeWalk == true) {
            return " likes to walk";
        } else {
            return " doesn't like to walk";
        }
    }

    public String run(int speed) {
        if (speed > 20) {
            return " runs fast";
        } else {
            return " runs slow";
        }
    }

    public String bark(boolean hasLoudVoice) {
        if (hasLoudVoice == true) {
            return " barks loud";
        } else {
            return " barks quiet";
        }
    }

    public String sleep(int sleepHours) {
        if (sleepHours > 15) {
            return " sleeps a lot";
        } else {
            return " sleeps a little";
        }
    }

    public int play(int playHours) {
        return playHours;
    }

    public String getEars() {
        return ears;
    }

    public void setEars(String ears) {
        this.ears = ears;
    }

    public String getTeeth() {
        return teeth;
    }

    public void setTeeth(String teeth) {
        this.teeth = teeth;
    }

    public String getPaws() {
        return paws;
    }

    public void setPaws(String paws) {
        this.paws = paws;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public String setHasTail(boolean hasTail) {
        if (hasTail == true) {
            return "yes";
        } else {
            return "no";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "ears='" + ears + '\'' +
                ", teeth='" + teeth + '\'' +
                ", paws='" + paws + '\'' +
                ", head='" + head + '\'' +
                ", hasTail=" + hasTail +
                ", name='" + name + '\'' +
                ", age=" + age;
    }

    public static void main(String[] args) {
        Dog barbos = new Dog("long", "white", "short", "small", false, "Barbos");
        Dog baron = new Dog("short", "white", "long", "huge", true, "Baron", 5);

        System.out.println("The first dog has next properties: " + barbos);
        System.out.println(barbos.name + barbos.walk(true) + "," + barbos.run(10) + "," + barbos.bark(true) +
                "," + barbos.sleep(10) + ", plays " + barbos.play(6) + " hours a day.");
        System.out.println();
        System.out.println("The second dog has next properties: " + baron);
        System.out.println(baron.name + baron.walk(false) + "," + baron.run(30) + "," + baron.bark(false) +
                "," + baron.sleep(15) + ", plays " + baron.play(3) + " hours a day.");
    }
}
