package singleton;

public class World {

	private static World singleton = null;

	private World() {

		System.out.println(">>> New World Created\n");

	}
}
