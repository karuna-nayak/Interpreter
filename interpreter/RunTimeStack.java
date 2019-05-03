package interpreter;

import java.util.ArrayList;
import java.util.Stack;



public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;
    private int popValue;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
    /*method to dump runtime stack
    The frames are printed accroding to values of frame pointer stack.
    The range for frames, startFrameAt and endFrameAt for printing run time stack are taken from adjacent frame pointer stack values.
    If the frame start index is last element of frame pointer, end index is taken as last element of run time stack
    */
    public void dump(){
        int frameIndex;
        int startFrameAt;
        int endFrameAt;
        
        for(frameIndex = 0; frameIndex < this.framePointer.size(); frameIndex++){
            System.out.printf("[");
            startFrameAt = this.framePointer.get(frameIndex);
            //check for last element of frame pointer stack
            if(frameIndex == this.framePointer.size()-1){
                if(this.getSizeRunTimeStack()== 0){
                    endFrameAt = 0;
                } else {
                    endFrameAt = this.getSizeRunTimeStack(); 
                }               
            }else {
                endFrameAt = (this.framePointer.get(frameIndex+1));                                
            }         
           
            for(int i = startFrameAt; i<endFrameAt; i++){                  
                System.out.printf("%d",runTimeStack.get(i));
                if(i < endFrameAt-1){
                    System.out.print(",");
                }                    
            }
            System.out.print("]");
        }
    }
    
    
    //peek run time stack
    public int peek(){
        return this.runTimeStack.get(runTimeStack.size()-1);
    }
    
    //pop run time stack
    public int pop () {
        popValue = 0;
       if((runTimeStack.size()-1)>= framePointer.peek()){
        popValue = runTimeStack.get(runTimeStack.size()-1);
        this.runTimeStack.remove(this.runTimeStack.size()-1);
       }
        return popValue;       
    }
    
    //push for run time stack
    public int push(int i){
        this.runTimeStack.add(i);
        return i;   
    }
    
    //push literal value onto the stack
    public Integer push(Integer i){
        this.runTimeStack.add(i);
        return i;
    }
    
    // push Frame pointer stack
    public void newFrameAt(int offset){
        this.framePointer.push(offset);
    }
    
    //remove the frame after return
    public void popFrame(){
        this.runTimeStack.subList(this.framePointer.peek(),(this.runTimeStack.size())).clear();
        this.framePointer.pop();               
    }
    
    //store the top of the stack into offset in current frame
    public int store(int offset){
        int popedVal = pop();
        this.runTimeStack.set((this.framePointer.peek() + offset), popedVal);
        return popedVal;
    }
    
    //get runtime stack value stored at offset to load it at top
    public int load(int offset){
        return this.runTimeStack.get(offset + this.framePointer.peek());
    }
    
    //retruns size of the run time stack
    protected int getSizeRunTimeStack(){
        return this.runTimeStack.size();
    }
}


