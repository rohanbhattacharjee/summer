package rohan.interview.recursion;

public class Arrange8Queens {

	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		Position[] queens = board.arrange8Queens();
		
		if (queens == null) {
			System.out.println("no arrangement found");
			return;
		}
		
		for (Position queen : queens) {
			if (queen == null) {
				System.out.println("no arrangement found");
				continue;
			}
			
			System.out.println(String.format("( %d , %d )", queen.x, queen.y));
		}
	}
}

class Position {
    public int x;
    public int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ChessBoard {
    public Position[] positions;
    
    public ChessBoard() {
        this.positions = new Position[64];
    }
    
    public Position[] arrange8Queens() {
        Position[] queens = new Position[8];
        int column = 0;
        arrange8Queens(queens, column);
        return queens;
    }
    
    private void arrange8Queens(Position[] currentQueens, int column) {
        for (int row = 0; row < 8; row++) {
            Position candidatePosition = new Position(row, column);
            
            if (canAddQueen(currentQueens, candidatePosition)) {
                currentQueens[column] = candidatePosition;
                
                if (column == 7) {
                	return;
                }
                
                arrange8Queens(currentQueens, column + 1);

                if (currentQueens[column + 1] == null) {
                	currentQueens[column] = null;
                }
                else {
                	return;
                }
            }
        }
        
        currentQueens[column] = null;
    }
    
    private boolean canAddQueen(Position[] currentQueens, Position candidateQueen) {
        for (Position currentQueen : currentQueens) {
        	if (currentQueen == null) {
        		continue;
        	}
        	
            if (currentQueen.x == candidateQueen.x) {
                return false;
            }
            
            if (currentQueen.y == candidateQueen.y) {
                return false;
            }
            
            if (Math.abs(currentQueen.y - candidateQueen.y) == Math.abs(currentQueen.x - candidateQueen.x)) {
                return false;
            }
        }
        
        return true;
    }
}
