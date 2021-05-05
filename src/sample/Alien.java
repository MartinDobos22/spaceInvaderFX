package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Alien {

    private double width = 70;
    private double height = 40;
    private double x;
    private double y;
    private double speedX = 2;
    private double speedY = 20;
    private Image image = new Image("resources/real_ailien.png");
    private int tick = 0;
    private boolean active = true;
    public static ArrayList<Alien> aliens = new ArrayList<>();
    public static int killedAliens = 0;
    public Bullet bullet = new Bullet();

    public Alien(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(){

        if(tick < 0){
            moveLeft();
        }else{
            moveRight();
        }
        tick++;
        if(tick == 4){
            tick = -4;
            moveDown();
        }

    }

    private void moveLeft(){

        x -= speedX;

    }

    private void moveRight(){

        x += speedX;

    }

    private void moveDown(){

        y += speedY;

    }

    private void draw(){

        if(active){
            Controller.gc.drawImage(image,x,y);
        }

    }

    public static void spawn(){

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= 10; j++) {
                aliens.add(new Alien(j * 70 - 65, i * 40));
            }
        }

    }

    public static void updateAliens(){

        aliens.forEach(Alien::update);

    }

    public static void updateBullets(){

        aliens.forEach(alien -> {
            alien.bullet.update();
        });

    }

    public static void drawAliens(){

        aliens.forEach(Alien::draw);

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static ArrayList<Alien> getAliens() {
        return aliens;
    }

    public static void setAliens(ArrayList<Alien> aliens) {
        Alien.aliens = aliens;
    }

    public static int getKilledAliens() {
        return killedAliens;
    }

    public static void setKilledAliens(int killedAliens) {
        Alien.killedAliens = killedAliens;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
