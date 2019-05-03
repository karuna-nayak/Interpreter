//ByteCode class for BOP, to perform the binary and logical operations on operands in run time stack
package interpreter.ByteCode;
import interpreter.*;

public class BopCode extends ByteCode{
    private String operator;
    private int operand1, operand2;
    private boolean tempOp1, tempOp2;
    private final String byteCodeName = "BOP";
    
    @Override
    public void init(String param) {
       this.operator = param;   
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        this.operand2 = vm.pop();
        this.operand1 = vm.pop();
        
        if (this.operator.equals("+")){
            vm.push((operand1 + operand2));
        } else if (this.operator.equals("-")){
            vm.push((operand1 - operand2));
        } else if (this.operator.equals("*")){
            vm.push((operand1 * operand2));
        } else if (this.operator.equals("/")){
            vm.push((operand1 - operand2));
        } else if (this.operator.equals("<=")){
            if(operand1 <= operand2){
                vm.push(1);
            }else vm.push(0);
        } else if (this.operator.equals(">=")){
            if(operand1 >= operand2){
                vm.push(1);
            }else vm.push(0); 
        }else if (this.operator.equals("==")){
            if(operand1 == operand2){
                vm.push(1);
            }else vm.push(0);  
        }else if (this.operator.equals("!=")){
            if(operand1 != operand2){
                vm.push(1);
            }else vm.push(0); 
        }else if (this.operator.equals("<")){
            if(operand1 < operand2){
                vm.push(1);
            }else vm.push(0); 
        }else if (this.operator.equals(">")){
            if(operand1 > operand2){
                vm.push(1);
            }else vm.push(0);  
           
        }else if (this.operator.equals("&")){
            if(operand1 != 0 ){
                this.tempOp1 = true;
            } else  this.tempOp1 = false;
            
            if(operand2 != 0 ){
                this.tempOp2 = true;
            } else this.tempOp2 = false;
            
            if(tempOp1 & tempOp2){
                vm.push(1);
            } else vm.push(0);     
        } else if (this.operator.equals("|")){
            if(operand1 != 0 ){
                this.tempOp1 = true;
            } else  this.tempOp1 = false;
            
            if(operand2 != 0 ){
                this.tempOp2 = true;
            } else this.tempOp2 = false;
            
            if(tempOp1 | tempOp2){
                vm.push(1);
            } else vm.push(0);     
        }    
        if (vm.getDump()) {
           System.out.println("\n" +byteCodeName +" " +operator );
        }
    }
    
    @Override
    public String byteCodeName(){
        return byteCodeName;
    }
    
}
