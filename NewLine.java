
public class NewLine extends Exp {

	@Override
	ValEnv eval(Env env) {
		System.out.println();
		return null;
	}

	@Override
	void print() {
		System.out.println("newline");
		
	}

}
