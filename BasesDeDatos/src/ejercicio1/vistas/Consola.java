package ejercicio1.vistas;

import java.util.Scanner;

public class Consola {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	static Scanner sc;

	static {
		try {
			sc = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void escribir(String str, String color) {
		System.out.println(color + str + ANSI_RESET);
	}

	public static void escribir(String str) {
		System.out.println(str);
	}

	public static void escribir() {
		System.out.println();
	}

	public static void error(String str) {
		System.out.println(ANSI_RED + str + ANSI_RESET);
	}

	public static String repeat(String s, int cantidad) {
		String str = "";
		for (int i = 1; i <= cantidad; i++) {
			str += s;
		}
		return str;
	}

	public static void limpiarPantalla(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			System.out.println();
		}
	}

	public static String getString(String label) {
		if (label == null)
			throw new IllegalArgumentException("label no puede ser nula.");
		System.out.print(label);
		String str = sc.nextLine();
		return str;
	}

	public static int getInt(String label) {
		if (label == null)
			throw new IllegalArgumentException("label no puede ser nula.");
		System.out.print(label);
		int n = Integer.parseInt(sc.nextLine());
		return n;
	}

	public static int getIntInRange(int minimo, int maximo, String label) {
		if (minimo > maximo)
			throw new IllegalArgumentException("minimo debe ser menor que maximo.");
		if (label == null)
			throw new IllegalArgumentException("label no puede ser nula.");
		int n;
		do {
			n = getInt(label);
		} while (n < minimo || n > maximo);
		return n;
	}

	public static boolean confirmar(String label) {
		System.out.print("¿" + label + " (S/N)?");
		String str = sc.nextLine();
		return str.toLowerCase().equals("s");
	}

	public static void pausar() {
		System.out.println();
		System.out.print("Pulsa ENTER para continuar.");
		sc.nextLine();
	}

}
