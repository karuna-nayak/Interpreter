//ByteCode class for POP, for poping the run time stack values
package interpreter.ByteCode;
import interpreter.*;

public class PopCode extends ByteCode{
    private int popNum;
    private String popParam;
    private final String byteCodeName = "POP";
    
    @Override
    public void init(String param) {
       this.popParam = param; 
       this.popNum = Integer.parseInt(popParam);
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        while(popNum != 0){
            vm.pop();
            popNum--;
        }        
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +popParam );
       }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
}