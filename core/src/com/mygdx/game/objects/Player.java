package com.mygdx.game.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor
{
    public static final float SPEED = 1f; //unit per second
    public static final float MAX_JUMP_SPEED = 1.75f; //unit per second
    public int score = 0;
    private static final float SIZE = 0.25f;

    private Vector2 position = new Vector2();
    private Vector2 velocity = new Vector2();
    private Rectangle bounds = new Rectangle();
    private State state;
    private Vector2 acceleration;

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public enum State{
        JUMPING, MOVING, DYING
    }

    /**
     * Constructor for a player.
     * sets the x and y position to be 0.
     */
    public Player()
    {
        position = new Vector2(0.1f, 0.5f);
        this.bounds.width = SIZE;
        this.bounds.height = SIZE;
        velocity.x = SPEED;
        state = State.MOVING;
        acceleration = new Vector2(0f, 0f);
    }

    /**
     * Returns the current state of the player.
     * @return the current state of the player.
     */
    public State getState() { return state; }

    /**
     * Gets the bounds of the player.
     * @return the bounds of the player.
     */
    public Rectangle getBounds(){ return bounds; }

    /**
     * Gets the position of the player as a vector.
     * @return the position of the player as a vector.
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Updates the player's position by time delta.
     * @param delta the time.
     */
    public void update(float delta) { position.add(velocity.cpy().scl(delta)); }

    /**
     * Sets the state of the player.
     * @param state the state of the player.
     */
    public void setState(State state) { this.state = state; }


}