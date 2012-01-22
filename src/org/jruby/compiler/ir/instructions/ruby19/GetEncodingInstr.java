package org.jruby.compiler.ir.instructions.ruby19;

import java.util.Map;

import org.jcodings.Encoding;
import org.jruby.compiler.ir.Operation;
import org.jruby.compiler.ir.operands.Operand;
import org.jruby.compiler.ir.operands.Variable;
import org.jruby.compiler.ir.representations.InlinerInfo;
import org.jruby.compiler.ir.instructions.Instr;
import org.jruby.compiler.ir.instructions.ResultInstr;
import org.jruby.runtime.Block;
import org.jruby.runtime.DynamicScope;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

public class GetEncodingInstr extends Instr implements ResultInstr {
    private final Encoding encoding;
    private Variable result;

    public GetEncodingInstr(Variable result, Encoding encoding) {
        super(Operation.GET_ENCODING);

        this.result = result;
		  this.encoding = encoding;
    }

    @Override
    public Operand[] getOperands() {
        return EMPTY_OPERANDS;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + encoding + ")";
    }
    
    @Override
    public Variable getResult() {
        return result;
    }

    @Override
    public void updateResult(Variable v) {
        this.result = v;
    }

    @Override
    public Instr cloneForInlining(InlinerInfo ii) {
        return new GetEncodingInstr(ii.getRenamedVariable(result), encoding);
    }

    @Override
    public Object interpret(ThreadContext context, DynamicScope currDynScope, IRubyObject self, Object[] temp, Block block) {
        return context.getRuntime().getEncodingService().getEncoding(encoding);
    }
}
