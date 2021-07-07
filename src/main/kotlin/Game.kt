class Game(matrixValue: Int, matrixDefault:Int, entryX: Int, entryY: Int, val goalX: Int, val goalY: Int, paths: List<PathGen>) {
	val maze = Maze(matrixValue, matrixDefault, entryX, entryY, goalX, goalY, paths)
	val dfs = ArrayDeque<Pair<Int, Int>>()
	var locationX : Int = entryX
	var locationY : Int = entryX

	fun checkGoalState() : Boolean{
		return locationX == goalX && locationY == goalY
	}

	fun popHead() {
		locationX = dfs.first().first
		locationY = dfs.first().second
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