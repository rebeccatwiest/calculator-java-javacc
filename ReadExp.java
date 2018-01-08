import java.util.Scanner;

public class ReadExp extends Exp{
	int i;

	@Override
	ValEnv eval(Env env) {
		Scanner in = new Scanner(System.in);
		try {
			this.i = Integer.parseInt(in.next());
			in.close();
		} 
		catch (NumberFormatException e) {
		    System.out.print("read expects type <integer>");
		    System.exit(13);
		}
		return new ValEnv(i, env);
	}

	@Override
	void print() {
		System.out.print("read");
		
	}
}
