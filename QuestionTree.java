import java.io.*;
import java.util.*;
public class QuestionTree{
    private QuestionNode overallRoot;
    private Scanner console;

    public QuestionTree(){
        this.overallRoot = new QuestionNode("computer");
        this.console = new Scanner(System.in);
    }

    public void read(Scanner input){
        QuestionNode newRoot = new QuestionNode(null);
        overallRoot = read(input, newRoot);
    }

    private QuestionNode read(Scanner input, QuestionNode root){
        if (input.hasNextLine()){
            String type = input.nextLine();
            String text = input.nextLine();
            if (type.equals("Q:")){
                root.text = text;
                root.yes = read(input, new QuestionNode(null));
                root.no = read(input, new QuestionNode(null));
            }else {
                root.text = text;
            }
        }
        return root;
    }

    public void write(PrintStream output){
        write(output, overallRoot);
    }

    private void write(PrintStream output, QuestionNode root){
        if (root != null){
            if (root.no == null && root.yes == null)
                output.println("A:");
            else    
                output.println("Q:");
            output.println(root.text);
            write(output, root.yes);
            write(output, root.no);
        }
    }

    public void askQuestions() {
        overallRoot = askQuestions(overallRoot);
    }

    private QuestionNode askQuestions(QuestionNode root) {
        if (root != null){
            if (root.no == null && root.yes == null) {
                if (yesTo("Would your object happen to be " + root.text + "?"))
                    System.out.println("Great, I got it right!");
                else {
                    System.out.print("What is the name of your object? ");
                    String object = console.nextLine();
                    System.out.println("Please give me a yes/no question that");
                    System.out.println("distinguishes between your object");
                    System.out.print("and mine--> ");
                    String question = console.nextLine();
                    boolean answer = yesTo("And what is the answer for your object?");
                    if (!answer) 
                        root = new QuestionNode(question, new QuestionNode(object), root);
                    else 
                        root = new QuestionNode(question, root, new QuestionNode(object));
                }
            }else {
                if(yesTo(root.text))
                    root.yes = askQuestions(root.yes);
                else 
                    root.no = askQuestions(root.no);
                
            }
        }
        return root;
    }


    


    public boolean yesTo(String prompt) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }
}
