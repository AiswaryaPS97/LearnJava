package org.example;
import java.util.Stack;

public class SimpleTextPad {

    public StringBuilder getText() {
        return text;
    }

    final private StringBuilder text;
    final private Stack<Operation> undoStack;
    final private Stack<Operation> redoStack;

    public SimpleTextPad() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    //for write to text editor
    public void write(String content){
        undoStack.push(new Operation("delete", text.length(), content.length(),null));
        redoStack.clear();
        text.append(content);
    }

    public void undo(){
        if(!undoStack.empty()){
            Operation lastOperation = undoStack.pop();
            if("delete".equals(lastOperation.getTask())){
                int position = lastOperation.getPosition();
                String deletedText = text.substring(position, position+lastOperation.getLength());
                text.delete(position, position+lastOperation.getLength());
                redoStack.push(new Operation("write", lastOperation.getPosition(), lastOperation.getLength(),deletedText));
            }else{
                text.insert(lastOperation.getPosition(), lastOperation.getContent());
                redoStack.push(new Operation("delete",lastOperation.getPosition(), lastOperation.getLength(), null));
            }
        }
    }

    public void redo(){
        if(!redoStack.empty()){
            Operation lastOperation = redoStack.pop();
            String task = lastOperation.getTask();
            if("write".equals(task)){
                text.insert(lastOperation.getPosition(), lastOperation.getContent());
                undoStack.push(new Operation("delete",lastOperation.getPosition(), lastOperation.getLength(), null));
            }else if("delete".equals(task)){
                int position = lastOperation.getPosition();
                String deletedText = text.substring(position, position+lastOperation.getLength());
                text.delete(position, position+lastOperation.getLength());
                undoStack.push(new Operation("write", lastOperation.getPosition(), lastOperation.getLength(),deletedText));
            }
        }
    }

}
