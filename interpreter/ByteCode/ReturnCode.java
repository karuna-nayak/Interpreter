//ByteCode class for RETURN, pop the top of teh run time stack, remove the frame and reset the program control to called function
package interpreter.ByteCode;
import interpreter.*;

public class ReturnCode extends ByteCode{
    private int address;
    private String label;
    private int poppedVal;
    private final String byteCodeName = "RETURN";
        
    @Override
    public void init(String param) {
        this.label = param;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        poppedVal = vm.pop();
        vm.popFrame();
        vm.push(poppedVal);
        address = vm.popReturnAddress();
        vm.setPc(address);
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +label );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
}