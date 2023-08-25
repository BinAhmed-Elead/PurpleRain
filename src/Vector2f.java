public class Vector2f {

    private float x;
    private float y;

    public Vector2f(float x,float y){
        this.x = x;
        this.y = y;
    }
    public Vector2f(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
