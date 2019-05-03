//Program class stores the bytecode objects 
//It implements a hashmap to store the lines numbers for GoTo, FalseBaranch and Call bytecodes

package interpreter;

import java.util.ArrayList;
import interpreter.ByteCode.*;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private ByteCode checkByteCode;
    //Hash map to store label address
    private static HashMap< String, Integer> addressLabel = new HashMap< >();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    protected void addObject(ByteCode byteCode){
        this.program.add(byteCode);
    }    

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
       for(int i=0; i < program.getSize(); i++) {
            checkByteCode = program.getCode(i);
            if(checkByteCode instanceof GotoCode){
               String label = ((GotoCode)checkByteCode).getLabel();
               int line = getLineNum(label);
               ((GotoCode)checkByteCode).setLine(line);                
            } else if(checkByteCode instanceof FalseBranchCode){
               String label = ((FalseBranchCode)checkByteCode).getLabel(); 
               int line = getLineNum(label);
               ((FalseBranchCode)checkByteCode).setLine(line);
            }  else if(checkByteCode instanceof CallCode){
               String label = ((CallCode)checkByteCode).getLabel(); 
               int line = getLineNum(label);
               ((CallCode)checkByteCode).setLine(line); 
            }   
        }      
    }

    
    public int getLineNum(String label ){
       return Program.addressLabel.get(label);        
    }
    
    public void setLineNum(String label, int in ){
       Program.addressLabel.put(label, in);
    }

}
