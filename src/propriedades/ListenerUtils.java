package propriedades;

import gov.nasa.jpf.jvm.MethodInfo;
import gov.nasa.jpf.jvm.Step;
import gov.nasa.jpf.jvm.bytecode.Instruction;

public class ListenerUtils {
    
    public static boolean filter(Instruction instruction) {
        MethodInfo mi = instruction.getMethodInfo();
        return filter(mi);
    }
    
    public static boolean filter(MethodInfo method) {
        if(method == null)
            return true;
        String fileName = method.getClassName();
        return filter(fileName);
    }
    
    public static boolean filter(Step linha) {
       String fileName = linha.getInstruction().getFileLocation();
    	 return filter(fileName);
    }
    
    private static boolean filter(String fileName) {
        boolean result = fileName.startsWith("java")
        || fileName.startsWith("sun")
        || fileName.startsWith("gov")
        || fileName.startsWith("[VM]");
        return result;
    }
    
    
    
}
