//ByteCode class for LIT, to store the literal values onto top of the run time stack
package interpreter.ByteCode;
import interpreter.*;

public class LitCode extends ByteCode{
    private Integer val;
    private String args;
    private String[] parameter;
    private final String byteCodeName = "LIT";
    
    @Override
    public void init(String param) {
        args = param;
        parameter = param.split(" ",2);
        this.val = Integer.parseInt(parameter[0]); 
    }
    
    @Override
    public void execute(VirtualMachine vm) {
       vm.push(this.val);
       if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +args );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }    
}