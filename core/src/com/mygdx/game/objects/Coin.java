package com.mygdx.game.objects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ryanw on 10/13/2016.
 */
public class Coin
{
    public static final float SIZE = .25f;
    private Vector2 position = new Vector2();
    private Rectangle bounds = new Rectangle();

    /**
     * A coin object.
     * @param position the position of the coin.
     */
    public Coin(Vector2 position)
    {
        this.position = position;
        bounds.height = SIZE;
        bounds.width = SIZE;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getPosition()
    {
        return position;
    }


}
