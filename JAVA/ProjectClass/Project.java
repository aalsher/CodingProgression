
public class Project {
  private String name, description;
  //Overload the constructor method in three different ways.
  public Project(){
    this("First Project", "Project description here");
    System.out.println(this);
  }
  public Project(String name, String description){
    this.name = name;
    this.description = description;
    System.out.println(this);
  }

  public Project(String name){
    this.name = name;
    this.description= "This is my first project";
    System.out.println(this);
  }

  //Create an instance method called elevatorPitch that will return the name and description separated by a colon.
  public String elevatorPitch() {
    System.out.println(""+ this.name + ";"+ this.description);
    return ""+ this.name + ";"+ this.description;
  }
}
