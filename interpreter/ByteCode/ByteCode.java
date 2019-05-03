
package interpreter.ByteCode;
import interpreter.*;


public abstract class ByteCode {
    public abstract void init(String arg);
    public abstract void execute(VirtualMachine vm);
    public abstract String byteCodeName();
    
}
