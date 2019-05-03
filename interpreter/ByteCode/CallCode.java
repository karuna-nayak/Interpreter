//ByteCode class for CALL, to push current address into return address stack and transfer the control to called function
package interpreter.ByteCode;
import interpreter.*;

public class CallCode extends ByteCode{
    
    private String labelToGo;
    private int lineToGo;
    private String byteCodeName = "CALL";
     
    @Override
    public void init(String param) {
        this.labelToGo = param;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getPc());//push current address into return address stack
        vm.setPc((this.lineToGo)-1);//transfer the control to called function
        if (vm.getDump()) {
            System.out.println("\n" +byteCodeName +" " +labelToGo);
        }        
    }    
       
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
    public String getLabel(){
        return this.labelToGo;
    }
    
    public void setLine(int lineNo){
        this.lineToGo = lineNo;
    }
    
}
