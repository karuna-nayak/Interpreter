//ByteCode class for WRITE, write the output on the screen
package interpreter.ByteCode;
import interpreter.*;

public class WriteCode extends ByteCode{
    
    private final String byteCodeName = "WRITE";
    
    @Override
    public void init(String param) {
        
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("\n");
        System.out.println(vm.peek());
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
}