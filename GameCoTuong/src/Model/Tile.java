package Model;

public class Tile {
	int x;
	int y;
	int size;
	
	public Tile() {
		this(0,0,100);
	}
	public Tile(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public Tile(int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x=x2;
		this.y=y2;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
