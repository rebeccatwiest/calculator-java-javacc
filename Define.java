
public class Define extends Exp{
	
	Exp name;
	Exp exp;
	
	public Define (Exp exp1, Exp exp2){
		this.name = exp1;
		this.exp = exp2;
	}

	@Override
	ValEnv eval(Env env) {
		name = (Exp) exp.eval(env).val;
		return new ValEnv (name, env);
	}

	@Override
	void print() {
		System.out.print("define " + name + exp);
		
	}

}
