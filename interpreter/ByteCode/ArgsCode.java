//ByteCode calss for ARGS. This will create a new frame with number of arguments passed as offset 
package interpreter.ByteCode;
import interpreter.*;


public class ArgsCode extends ByteCode {
    private int offset;
    private int address;
    private final String byteCodeName = "ARGS";
    
    
    @Override
    public void init(String param) {
        this.offset = Integer.parseInt(param);   
    }
    
    @Override
    public void execute(VirtualMachine vm) {
       address = vm.getSizeRunStack()- this.offset;
       vm.newFrameAt(address);
       if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +offset );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
}
