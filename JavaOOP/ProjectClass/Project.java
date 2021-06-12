public class Project{
    private String name;
    private String description;

    public Project (){
        this.name = "New Project";
        this.description = " new project";
    }
	
	public Project(String name){
		this.name = name;
		this.description="new project";
	}
	
	public Project(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription (String description){
		this.description = description;
	}
	
	public String elevatorPitch () {
        System.out.println(this.name + ": " + this.description);
        return (this.name + ": " + this.description);
    }
	
}
