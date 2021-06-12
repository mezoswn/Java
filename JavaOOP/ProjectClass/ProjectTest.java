public class ProjectTest{
    public static void main(String[] args){
        Project firstProject = new Project();
        Project secondProject = new Project("Project Two");
        Project thirdProject = new Project("Project Three", "custom description.");

        firstProject.elevatorPitch();
        secondProject.elevatorPitch();
        firstProject.setName("Moath's Project");
        firstProject.setDescription("MS new description");
        firstProject.elevatorPitch();
	}
}