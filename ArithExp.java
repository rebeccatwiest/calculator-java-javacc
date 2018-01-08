
public class ArithExp extends Exp {

	String operator;
	Exp exp1, exp2;
	
	
	public ArithExp(String operator, Exp exp1, Exp exp2) {
		this.operator = operator;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	@Override
	ValEnv eval(Env env) {
		ValEnv ve1 = exp1.eval(new Env());
		ValEnv ve2 = exp2.eval(new Env());
		int i1 = (Integer) ve1.val;
		if (!(ve1.val instanceof Integer)){
			System.out.println (operator + ": expects integer for first operand");
			System.exit(3);
		}
		int i2 = (Integer) ve2.val;
		if (!(ve2.val instanceof Integer)){
			System.out.println (operator + ": expects integer for second operand");
			System.exit(3);
		}
		int result = 0;
		
		if (operator.equals("+"))
			result = i1 + i2;
		else if (operator.equals("-"))
			result = i1 - i2;
		else if (operator.equals("*"))
			result = i1 * i2;
		else if (operator.equals("/"))
			result = i1 / i2;
		else 
			throw new RuntimeException ("invalid arithmetic operation");
		return new ValEnv(result, ve2.env);
	}

	@Override
	void print() {
		System.out.print ("(");
		exp1.print();
		System.out.printf(" %s ", operator);
		exp2.print();
		System.out.print(")");

	}

}
