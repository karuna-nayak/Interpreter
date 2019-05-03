//ByteCode class for STORE, pop the top of the stack and store the value in offset position
package interpreter.ByteCode;
import interpreter.*;

public class StoreCode extends ByteCode{
    private int offset;
    private String[] parameter;
    private final String byteCodeName = "STORE";
    
    @Override
    public void init(String param) {
        parameter = param.split(" ",2);
        this.offset = Integer.parseInt(parameter[0]);  
    }
    
    @Override
    public void execute(VirtualMachine vm) {
       vm.store(offset);
       if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +parameter[0]+" " +parameter[1]);
       }        
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }   
   
}