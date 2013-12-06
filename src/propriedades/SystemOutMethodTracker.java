package propriedades;

import java.io.PrintWriter;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.jvm.JVM;
import gov.nasa.jpf.jvm.MethodInfo;
import gov.nasa.jpf.jvm.ThreadInfo;
import gov.nasa.jpf.jvm.bytecode.INVOKESPECIAL;
import gov.nasa.jpf.jvm.bytecode.Instruction;
import gov.nasa.jpf.jvm.bytecode.InvokeInstruction;
import gov.nasa.jpf.jvm.bytecode.VirtualInvocation;
import gov.nasa.jpf.search.Search;

public class SystemOutMethodTracker extends ListenerAdapter {

  static final String INDENT = "  ";

  MethodInfo lastMi;
  PrintWriter out;

  public SystemOutMethodTracker (Config conf, JPF jpf) {
      out = new PrintWriter(System.out, true);
  }

  void logMethodCall(ThreadInfo ti, MethodInfo mi, int stackDepth) {
    if(mi.getClassName().equals("gov.nasa.jpf.ConsoleOutputStream") && mi.getName().equals("println")) {
        System.out.println("Printing depth of System.out.println call " + ti.getVM().getJPF().getSearch().getDepth());
    }
  }

  public void executeInstruction (JVM vm) {
    Instruction insn = vm.getLastInstruction();
    MethodInfo mi = insn.getMethodInfo();
    ThreadInfo ti = vm.getLastThreadInfo();
    if (mi != lastMi) {
      logMethodCall(ti, mi, ti.getStack().size());
      lastMi = mi;

    } else if (insn instanceof InvokeInstruction) {
      MethodInfo callee;

      if (insn instanceof VirtualInvocation) {
        VirtualInvocation callInsn = (VirtualInvocation)insn;
        int objref = callInsn.getCalleeThis(ti);
        callee = callInsn.getInvokedMethod(ti, objref);

      } else if (insn instanceof INVOKESPECIAL) {
        INVOKESPECIAL callInsn = (INVOKESPECIAL)insn;
        callee = callInsn.getInvokedMethod(ti);

      } else {
        InvokeInstruction callInsn = (InvokeInstruction)insn;
        callee = callInsn.getInvokedMethod(ti);
      }

      if (callee != null) {
        if (callee.isMJI()) {
          logMethodCall(ti, callee, ti.getStack().size()+1);
        }
      } else {
        out.println("ERROR: unknown callee of: " + insn);
      }
    }
  }

  public void searchStarted(Search search) {
    out.println("----------------------------------- search started");
  }

  public void searchFinished(Search search) {
    out.println("----------------------------------- search finished");
  }

}