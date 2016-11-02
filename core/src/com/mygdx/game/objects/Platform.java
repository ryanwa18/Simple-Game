package com.mygdx.game.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ryanw on 10/12/2016.
 */
public class Platform
{
    static final float HEIGHT = 0.5f;

    private Vector2 position = new Vector2();
    private Rectangle bounds = new Rectangle();
    /**
     * Constructor for a platform.
     * @param length the length of the platform.
     * @param position the position of the platform.
     */
    public Platform(float length, Vector2 position)
    {
        this.position = position;
        this.bounds.width = length;
        this.bounds.height = HEIGHT;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getPosition() {
        return position;
    }
}
