//Bytecode class for HALT. This will exit from the program by setting run flag of VM is false.
package interpreter.ByteCode;
import interpreter.*;

public class HaltCode extends ByteCode{
    private final String byteCodeName = "HALT";
    
    @Override
    public void init(String param) {
        
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.setRunFlag();
        if (vm.getDump()) {
            System.out.println("\n" + byteCodeName);
        }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
}