package core;

public class OnlineCourse extends Course{
    private String platform;

    public OnlineCourse(String courseCode, String courseTitle, String platform) {
        super(courseCode, courseTitle);
        this.platform = platform;
    }
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.print(" Platform: " + getPlatform());
    }
}
