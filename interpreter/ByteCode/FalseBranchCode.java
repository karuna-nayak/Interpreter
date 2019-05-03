//ByteCode class for FALSEBRANCH, for branching code based on top of the stack
package interpreter.ByteCode;
import interpreter.*;

public class FalseBranchCode extends ByteCode{    
    private String labelToGo;
    private int lineToGo;
    private int popVal;
    private final String byteCodeName = "FALSEBRANCH" ;
    
    @Override
    public void init(String param) {
        this.labelToGo = param;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        this.popVal = vm.pop();
        if (this.popVal == 0){
            vm.setPc((this.lineToGo)-1);
        }         
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
