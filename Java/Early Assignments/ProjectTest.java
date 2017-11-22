public class ProjectTest{
    public static void main(String[] args){

        Project project1 = new Project();
        Project project2 = new Project("Manhattan");
        Project project3 = new Project("Welcome Bee Overlords", "We, for one, welcome our new Bee Overlords");

        project1.setName("Eat Hotdogs");
        project1.setDesc("I am going to eat my weight in hotdogs and then explode.  And hopefully die.");

        System.out.println(project1.getName());
        System.out.println(project1.getDesc());

        System.out.println(project3.elevatorPitch());
        System.out.println(project2.elevatorPitch());


    }

}