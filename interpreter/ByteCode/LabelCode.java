//ByteCode for LABEL, stores the label used in program control transfer 
package interpreter.ByteCode;
import interpreter.*;

public class LabelCode extends ByteCode {
    private String labelToGo;
    private final String byteCodeName = "LABEL";
    
    @Override
    public void init(String param) {
        this.labelToGo = param;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +labelToGo  );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
}
