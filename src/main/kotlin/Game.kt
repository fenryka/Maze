import kotlin.collections.ArrayDeque

class Game(
	matrixValue: Int,
	matrixDefault:Int,
	val entryX: Int,
	val entryY: Int,
	val goalX: Int,
	val goalY: Int, paths: List<PathGen>,
	algorithmToUse: String,
	renderer : Maze.Renderer = Maze.defaultRenderer(),
) {
//TODO - why can't I pass in the algo property and inject? Better ways?
//TODO - investigate BFS

	val maze = Maze(matrixValue, matrixDefault, entryX, entryY, goalX, goalY, paths, renderer)
	val algorithm: String = algorithmToUse
	val deque = ArrayDeque<Pair<Int, Int>>()

	val alreadyVisited = ArrayDeque<Pair<Int, Int>>()
	var locationX : Int = entryX
	var locationY : Int = entryX

	//##DFS##
	//1. Pop head
	//2. Check if goal state
	//3. Ask Maze where can I go
	//4. Prune out previously visited nodes
	//5. Add children to START
	//6. goto 1

	//##BFS##
	//1. Pop head
	//2. Check if goal state
	//3. Ask Maze where can I go
	//4. Prune out previously visited nodes
	//5. Add children to END
	//6. goto 1

	init {
		alreadyVisited.addFirst(Pair(entryX, entryY))
	}

	fun solveMaze(algorithm: String) {
		while (!checkGoalState()) {
			pushChildren(algorithm)
			checkEdge()
			checkHedge()
			goForward()
			popHead()
			checkGoalState()
			println("$locationX, $locationY")
		}
	}


	fun pushChildren(algorithm: String) {
		addUp(algorithm)
		addDown(algorithm)
		addRight(algorithm)
		addLeft(algorithm)
	}

	fun addUp(algorithm: String) {
		when(algorithm.uppercase()) {
			"DFS" -> deque.addFirst(Pair(locationX, locationY - 1))
			"BFS" -> deque.addLast(Pair(locationX, locationY - 1))
		}
	}

	fun addDown(algorithm: String) {
		when(algorithm.uppercase()) {
			"DFS" -> deque.addFirst(Pair(locationX, locationY + 1))
			"BFS" -> deque.addLast(Pair(locationX, locationY + 1))
		}
	}

	fun addRight(algorithm: String) {
		when(algorithm.uppercase()) {
			"DFS" -> deque.addFirst(Pair(locationX + 1, locationY))
			"BFS" -> deque.addLast(Pair(locationX + 1, locationY))
		}
	}

	fun addLeft(algorithm: String) {
		when(algorithm.uppercase()) {
			"DFS" -> deque.addFirst(Pair(locationX - 1, locationY))
			"BFS" -> deque.addLast(Pair(locationX - 1, locationY))
		}
	}

	//-------------generic-----------------

	//controls


	fun popHead() {
		locationX = deque.first().first
		locationY = deque.first().second
		alreadyVisited.addFirst(deque.first())
		deque.removeFirst()
	}

	fun checkGoalState() : Boolean{
		return locationX == goalX && locationY == goalY
	}

	fun goForward() {
		if (deque.size > 1 && alreadyVisited.contains(deque.first())) {
			deque.addLast(deque.first())
			deque.removeFirst()
		}
	}

	fun checkHedge() {
		for(pair in deque) {
			if(maze.matrix[pair.first][pair.second] == 0) {
				deque.remove(pair)
			}
		}
	}

	fun checkEdge() {
		when (locationX) {
			//can't call left
			0 -> removeLeft()
			//can't call right
			maze.matrix.size - 1 -> removeRight()
		}
		when (locationY) {
			//can't call up
			0 -> removeUp()
			//can't call down
			maze.matrix.size - 1 -> removeDown()
		}
	}

	//#removing#

	fun removeDown() {
		deque.remove(Pair(locationX, locationY + 1))
	}

	fun removeUp() {
		deque.remove(Pair(locationX, locationY - 1))
	}

	fun removeRight() {
		deque.remove(Pair(locationX + 1, locationY))
	}

	fun removeLeft() {
		deque.remove(Pair(locationX - 1, locationY))
	}

	//#checkDirection#

	fun up() : Boolean{
		return maze.matrix[locationX][locationY - 1] == 1
	}

	fun down() : Boolean{
		return maze.matrix[locationX][locationY + 1] == 1
	}

	fun right() : Boolean{
		return maze.matrix[locationX + 1][locationY] == 1
	}

	fun left() : Boolean{
		return maze.matrix[locationX - 1][locationY] == 1
	}
}