import java.util.regex.*;

public class TypeIdentifier {
	public static String ART_OPERATOR = "(.*\\-.*)|(.*\\+.*)|(.*\\*.*)|(.*\\/.*)";
	public static String REL_OPERATOR = "(.*\\<.*)|(.*\\<=.*)|(.*\\>.*)|(.*\\>=.*)";
	public static String LOG_OPERATOR = "(.*AND.*)|(.*OR.*)|(.*NOT.*)";

	public static String OPERATOR = "\\+|\\-|\\*|\\/|\\<|\\>|MOD|DIV|AND|OR|\\>=|\\<=";
	public static String NUMBER = "-?[0-9]+";


	public static int whatOperator(String s) {
		if (s.matches(ART_OPERATOR)) { // aritmatika
			return 1;
		} else if (s.matches(REL_OPERATOR)) { // relasional
			return 2;
		} else if (s.matches(LOG_OPERATOR)) { // logika
			return 3;
		} else { return -1; }
	}

	public static int whatAffix(String s) {
		if (s.matches("\\(.*")) { // infix
			return 1;
		} else if (s.matches("[\\+|\\-|\\*|\\/|\\<|\\>|MOD|DIV|AND|OR|NOT].*")) { // prefix
			if (s.matches("\\-[0-9].*")) {
				return 3;
			} else {
				return 2;
			}
		} else if (s.matches("[0-9].*")) { // postfix
			return 3;
		} else { return -1; }
	}

	public static boolean isOperator(String s) {
		boolean ans = (s.matches(OPERATOR)) ? true : false;
		return ans;
	}

	public static boolean isNumber(String s) {
		boolean ans = (s.matches(NUMBER)) ? true : false;
		return ans;
	}
}