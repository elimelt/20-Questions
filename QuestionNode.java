// Name: Elijah Melton
// TA: James Hu
// Ass: 6

// single nodes of a QuestionTree. Nodes can either be objects, in which
// case they have a yes and no child, or answers, in which case their children
// are null. Each node contains text corresponding to either a question or object
public class QuestionNode{
    public String text;
    public QuestionNode no;
    public QuestionNode yes;

    
    public QuestionNode(String text, QuestionNode no, QuestionNode yes){
        this.text = text;
        this.no = no;
        this.yes = yes;
    }

    public QuestionNode(String text){
        this(text, null, null);
    }

    public QuestionNode(){
        this(null, null, null);
    }


}
