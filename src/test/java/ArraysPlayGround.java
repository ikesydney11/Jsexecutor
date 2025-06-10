import java.util.ArrayList;

public class ArraysPlayGround {
    static String Schoolnames;
    static  String SchoolLocation;

    String[] names = {"Julie", "John", "Sochukwu", "Chioma", "Ogor Bom BOM"};
    static ArrayList <String> Names = new ArrayList<>();

    public static void main(String[] args) {
        Names.add("John");
        Names.add("Mark");
        Names.add("Cyril");
        Names.add("Pastor Eze");
        Names.set(0, "Omenorgor");
        int i;
        for (i = 0; i < Names.size(); i++) ;

        System.out.println(Names);
    }
    public String getSchoolnames(){
        return Schoolnames;
    }
    public String setSchoolnames(String newName){
         Schoolnames = newName;

        return newName;
    }
}
