//ByteCode class DUMP, to set dump flag ON or OFF
package interpreter.ByteCode;
import interpreter.*;

public class DumpCode extends ByteCode{
    private String dump;
    private String byteCodeName = "DUMP";
    
    @Override
    public void init(String param) {
        this.dump = param;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.setDump(dump);
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
}