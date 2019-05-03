//ByteCode class for READ. It reads the input and push it in run time stack 
package interpreter.ByteCode;

import interpreter.*;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    private int inputVal;
    private boolean inputNotInt = true;
    private final String byteCodeName = "READ";

    @Override
    public void init(String param) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter a positive integer value ");
        while (inputNotInt) {
            if (input.hasNextInt()) {
                inputVal = input.nextInt();
                if (inputVal < 0) {
                    System.out.println("Incorrect input, please enter an positive integer value ");
                } else {
                    vm.push(inputVal);
                    inputNotInt = false;
                }
            } else {
                System.out.println("Incorrect input, please enter an integer value ");
                input.next();
            }
        }
        if (vm.getDump()) {
            System.out.println("\n" + byteCodeName);
        }
    }

    @Override
    public String byteCodeName() {
        return byteCodeName;
    }
}
