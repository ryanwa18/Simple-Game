package com.mygdx.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by ryanw on 10/13/2016.
 */
public class World
{
    private Array<Platform> platforms = new Array<Platform>();
    private Array<Coin> coins = new Array<Coin>();
    private Player player;
    private float width;
    private float height;

    /**
     * Returns the world's platforms.
     * @return the world's platforms.
     */
    public Array<Platform> getPlatforms()
    {
        return platforms;
    }

    /**
     * Returns the world's coins.
     * @return the world's coins.
     */
    public Array<Coin> getCoins()
    {
        return coins;
    }

    /**
     * Returns the world's player.
     * @return the world's player.
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Default constructor for the World.
     */
    public World()
    {
        createWorld();
        width = 10f;
        height = 7f;
    }

    /**
     * Creates and adds platforms, the player and coins to the world.
     */
    public void createWorld()
    {
        player = new Player();

        platforms.add(new Platform(10f, new Vector2(0f, 0f)));
        /**
        platforms.add(new Platform(2f, new Vector2(2f, 1f)));
        platforms.add(new Platform(2f, new Vector2(4f, 2f)));
        platforms.add(new Platform(2f, new Vector2(6f, 3f)));
        platforms.add(new Platform(2f, new Vector2(8f, 4f)));
         */

        coins.add(new Coin(new Vector2(1f, 1f)));
        coins.add(new Coin(new Vector2(3f, 1f)));
        coins.add(new Coin(new Vector2(5f, 1f)));
        coins.add(new Coin(new Vector2(7f, 1f)));
        coins.add(new Coin(new Vector2(9f, 1f)));
    }

    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }
}
