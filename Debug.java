import java.util.*;
import java.io.*;

public class Debug {
    public static void main(String[] args) throws FileNotFoundException{
        String QUESTION_FILE = "question.txt";
        QuestionTree questions = new QuestionTree();
        questions.read(new Scanner(new File(QUESTION_FILE)));
    }
}
