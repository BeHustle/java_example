public class Course {
    private static int totalStudents = 0;


    private String name;


    private final String code;


    private int maxCapacity;


    private int currentCapacity = 0;


    public Course(String code, String name, int maxCapacity) {
        this.code = code;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }


    public int getCurrentCapacity() {
        return currentCapacity;
    }


    public int getMaxCapacity() {
        return maxCapacity;
    }


    public void incrementCurrentCapacity() throws IllegalStateException {
        if (currentCapacity >= maxCapacity) {
            throw new IllegalStateException("Course is full");
        }
        totalStudents++;
        currentCapacity++;
    }


    public String getName() {
        return name;
    }


    public String getCode() {
        return code;
    }


    public static int getTotalStudents() {
        return totalStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Course: " + name + ", Code: " + code + ", Current Capacity: " + currentCapacity + ", Max Capacity: " + maxCapacity + "\n";
    }
}
