public class WriteExp extends Exp {
	
	Exp i;
	int val;
	
	public WriteExp(Exp i){
		this.i = i;
	}
	
	public void print() {
		System.out.print("write ");
		i.print();
	}

	@Override
	ValEnv eval(Env env) {
		try{
			val = Integer.parseInt(i.eval(env).val.toString());
		}
		catch (NumberFormatException e) {
		    System.out.print("write: expects type <integer> as 1st argument");
		    System.exit(3);
		}
		System.out.print(val);
		return new ValEnv(i, env);
	}
}