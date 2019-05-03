//The class VirtualMachine is the way to access the run time stack via its methods.
package interpreter;

import java.util.Stack;
import interpreter.ByteCode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpFlag = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        while(isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(dumpFlag && !(code.byteCodeName().equals("DUMP"))){ //execute dump for all byte codes other than DUMP
                runStack.dump();
            }
            pc++;
        }
    }
    
    public void setPc(int num){
        this.pc = num;
    }
    
    public int getPc(){
        return this.pc;
    }
    
    public void setRunFlag(){
        this.isRunning = false;
    }
    
    //set dumpFlag when DUMP ON
    public void setDump(String dump){
        if (dump.equals("ON")){
            this.dumpFlag = true;
        } else this.dumpFlag = false;
    }
    
    public boolean getDump(){
        return this.dumpFlag;
    }       
    
    //push for run time stack
    public int push(int val){
       return runStack.push(val);
    }
    
    //Push the literal value onto the stack
    public Integer push(Integer val){
        return runStack.push(val);
    }
    
    //pop run time stack
    public int pop() {
        return runStack.pop();
    }
    
    //peek from run time stack
    public int peek(){
        return this.runStack.peek();
    }
    
    //push frame pointer 
    public void newFrameAt(int frameAddress){
        runStack.newFrameAt(frameAddress);
    }
    
    //push return address stack to store the current pc
    public void pushReturnAddress(int address){
        returnAddrs.push(address);
    }
    
    //pop the return address stack to restore PC
    public int popReturnAddress(){
        return (Integer)returnAddrs.pop();
    }      
        
    public void popFrame(){
        this.runStack.popFrame();
    }       
    
    public void store(int offset){
        runStack.store(offset);
    }    
    
     public int load(int offset){
        return this.runStack.load(offset);
    }
    //get size of run time stack 
    public int getSizeRunStack(){
        return runStack.getSizeRunTimeStack();
    }   
    
}
