class Game(
	matrixValue: Int,
	matrixDefault:Int,
	val entryX: Int,
	val entryY: Int,
	val goalX: Int,
	val goalY: Int, paths: List<PathGen>,
	renderer : Maze.Renderer = Maze.defaultRenderer()
) {
	val maze = Maze(matrixValue, matrixDefault, entryX, entryY, goalX, goalY, paths, renderer)
	val dfs = ArrayDeque<Pair<Int, Int>>()
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

	init {
		alreadyVisited.addFirst(Pair(entryX, entryY))
	}

	fun solveMazeDFS() { //TODO - make solve avoid the 'hedges'!!
		while (!checkGoalState()) {
			pushChildren()
			checkEdge()
			goForward()
			popHead()
			checkGoalState()
			println("$locationX, $locationY")
		}
	}

	fun goForward() {
		if (dfs.size > 1 && alreadyVisited.contains(dfs.first())) {
			dfs.addLast(dfs.first())
			dfs.removeFirst()
		}
	}

	fun checkGoalState() : Boolean{
		return locationX == goalX && locationY == goalY
	}

	fun popHead() {
		locationX = dfs.first().first
		locationY = dfs.first().second
		alreadyVisited.addFirst(dfs.first())
		dfs.removeFirst()
	}

	fun pushChildren() {
		addUp()
		addDown()
		addRight()
		addLeft()
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

	fun removeUp() {
		dfs.remove(Pair(locationX, locationY - 1))
	}

	fun addUp() {
		dfs.addFirst(Pair(locationX, locationY - 1))
	}

	fun removeDown() {
		dfs.remove(Pair(locationX, locationY + 1))
	}

	fun addDown() {
		dfs.addFirst(Pair(locationX, locationY + 1))
	}

	fun removeRight() {
		dfs.remove(Pair(locationX + 1, locationY))
	}

	fun addRight() {
		dfs.addFirst(Pair(locationX + 1, locationY))
	}

	fun removeLeft() {
		dfs.remove(Pair(locationX - 1, locationY))
	}

	fun addLeft() {
		dfs.addFirst(Pair(locationX - 1, locationY))
	}

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