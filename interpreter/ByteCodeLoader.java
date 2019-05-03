//ByteCodeLoader class loads the bytecode objects in program class arraylist and resolves the addresses for GoTo, FalseBranch and Call 
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interpreter.ByteCode.*;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    private String[] token = new String[2];
    int lineNum = -1;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        this.program = new Program();
    }

    /**
     * This function should read one line of source code at a time. For each
     * line it should: Tokenize string to break it into parts. Grab correct
     * class name for the given ByteCode from CodeTable Create an instance of
     * the ByteCode class name returned from code table. Parse any additional
     * arguments for the given ByteCode and send them to the newly created
     * ByteCode instance via the init function.
     */

    public Program loadCodes() {
        try {
            String read;
            while ((read = byteSource.readLine()) != null) {
                lineNum++;
                token = read.split(" ", 2);
                String codeClass = CodeTable.getClassName(token[0]);
                if (codeClass.equals("LabelCode")) {
                    program.setLineNum(token[1], lineNum);
                }

                ByteCode byteCode = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());

                if (token.length == 2) {
                    byteCode.init(token[1]);
                } else {
                    byteCode.init("");
                }
                program.addObject(byteCode);
            }
            program.resolveAddrs(program);
            byteSource.close();
        } catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return program;
    }
}
