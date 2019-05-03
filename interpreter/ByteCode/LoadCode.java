//ByteCode class LOAD, for loading the element at offset onto the top of teh stack
package interpreter.ByteCode;
import interpreter.*;

public class LoadCode extends ByteCode{
    
    private int offset;
    private int loadVal;
    private String[] parameter; 
    private final String byteCodeName = "LOAD";
    
    @Override
    public void init(String param) {
        parameter = param.split(" ",2);
        this.offset = Integer.parseInt(parameter[0]);  
    }
    
    @Override
   public void execute(VirtualMachine vm) {
        this.loadVal = vm.load(this.offset);
        vm.push(loadVal);
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +parameter[0] +" " +parameter[1]  );
       }
    }
    
   @Override
    public String byteCodeName(){
        return byteCodeName;
    }    
}