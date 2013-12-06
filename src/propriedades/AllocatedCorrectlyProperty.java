package propriedades;

import gov.nasa.jpf.PropertyListenerAdapter;
import gov.nasa.jpf.jvm.JVM;
import gov.nasa.jpf.jvm.MethodInfo;
import gov.nasa.jpf.jvm.ThreadInfo;
import gov.nasa.jpf.jvm.bytecode.Instruction;
import gov.nasa.jpf.search.Search;
import propriedades.ListenerUtils;

public class AllocatedCorrectlyProperty  extends PropertyListenerAdapter {
	private int count = 0;   

	@Override
	public boolean check(Search search, JVM vm) {
		return (count > 0);
	}

	@Override
	public void instructionExecuted(JVM vm) {
		Instruction instruction = vm.getLastInstruction();		
		MethodInfo mi = instruction.getMethodInfo();	
		ThreadInfo ti = vm.getLastThreadInfo();
		if (!ListenerUtils.filter(instruction)) {
                    if (instruction.getSourceLine().trim().contains("ByteBuffer.allocateDirect")) {
				count ++;
                    }
		}
	} 
        
	@Override
	public String getErrorMessage() {
		return "Property Violation: count = " + count;
	}

}
