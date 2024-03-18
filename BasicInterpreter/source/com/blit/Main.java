package com.blit;


public class Main {
	/**
	 * Handle parsing arguments and CLI info. 
	 *
	 */
	public static void main (String[] args) {
		if (args.length != 1) {
			usage();
			return;
		} else if (args.length == 1){
			new Lox(args[0]);
		}
	}

	public static void usage () {
		System.out.println(
			"Usage: java -jar BasiInterpreter.jar [script path]"
		);
	}
}