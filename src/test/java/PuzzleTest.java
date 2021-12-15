import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class PuzzleTest {
	@Test
	void testGamePlay() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(0));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicOne");
		char[] chars = path.toCharArray();
		char[] pathArray = {'U','L','U','L','U'};
		assertArrayEquals(pathArray, chars, "Wrong");
	}

	@Test
	void testGamePlay2() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(1));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicOne");
		char[] chars = path.toCharArray();
		char[] pathArray = {'R','U','U','L','D','L','D','L','U','U'};
		assertArrayEquals(pathArray, chars, "Wrong");
	}

	@Test
	void testGamePlay3() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(2));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicOne");
		char[] chars = path.toCharArray();
		char[] pathArray = {'L','D','L','L','U','U','R','D','L','U','U','R','R','D','D','L','L','U','R','D','R','U','L','L'};
		assertArrayEquals(pathArray, chars, "Wrong");
	}

	@Test
	void testGamePlay4() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(3));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicOne");
		char[] chars = path.toCharArray();
		char[] pathArray = {'D','L','L','L','U','R','D','D','R','U','L','U','U'};
		assertArrayEquals(pathArray, chars, "Wrong");
	}

	@Test
	void testGamePlay5() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(4));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicOne");
		char[] chars = path.toCharArray();
		char[] pathArray = {'R','R','R','U','L','L','L','U','R','R','R','U','L','L'};
		assertArrayEquals(pathArray, chars, "Wrong");
	}

	@Test
	void testGamePlay6() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(5));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicTwo");
		char[] chars = path.toCharArray();
		char[] pathArray = {'L', 'U', 'R', 'U', 'U', 'L', 'L', 'D', 'R', 'U', 'L', 'D', 'D', 'D', 'L', 'U', 'R', 'U', 'U'};
		assertArrayEquals(pathArray, chars, "Wrong");
	}

	@Test
	void testGamePlay7() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(6));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicTwo");
		char[] chars = path.toCharArray();
		assertEquals(17, chars.length, "Wrong");
	}

	@Test
	void testGamePlay8() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(7));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicTwo");
		char[] chars = path.toCharArray();
		assertEquals(10, chars.length, "Wrong");
	}

	@Test
	void testGamePlay9() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(8));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicTwo");
		char[] chars = path.toCharArray();
		assertEquals(13, chars.length, "Wrong");
	}

	@Test
	void testGamePlay10() {
		PuzzleList puzzles = new PuzzleList();
		A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
		Node startState = new Node(puzzles.getPuzzle(9));
		startState.setDepth(0);
		String path = solution.A_Star(startState, "heuristicTwo");
		char[] chars = path.toCharArray();
		assertEquals(19, chars.length, "Wrong");
	}
}
