//ByteCode class for GOTO, to transfer the control of the program 
package interpreter.ByteCode;
import interpreter.*;

public class GotoCode extends ByteCode{
    private String labelToGo;
    private int lineToGo;
    private final String byteCodeName = "GOTO" ;
    
    @Override
    public void init(String param) {
        this.labelToGo = param;
    }
    
    @Override
    public void execute(VirtualMachine vm ) {        
        vm.setPc((this.lineToGo)-1);
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +labelToGo  );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
    public String getLabel(){
        return this.labelToGo;
    }
    
    public void setLine(int lineNo){
        this.lineToGo = lineNo;
    }
    
}
