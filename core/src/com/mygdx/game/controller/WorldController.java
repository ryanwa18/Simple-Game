package com.mygdx.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.objects.Coin;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.World;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ryanw on 10/13/2016.
 */
public class WorldController
{
    private World world;
    private Player player;
    private boolean canJump;

    enum Keys {
        JUMP
    }
    static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
    static {
        keys.put(Keys.JUMP, false);
    };

    public WorldController(World world)
    {
        this.world = world;
        this.player = world.getPlayer();
    }
    public void jumpPressed()
    {
        keys.get(keys.put(Keys.JUMP, true));
    }
    public void jumpReleased()
    {
        keys.get(keys.put(Keys.JUMP, false));
    }

    public void update(float delta)
    {
        processInput();
        checkCollisionWithCoins();
        player.update(delta);

        //Loops player's x position
        if (player.getPosition().x > world.getWidth())
        {
            player.setPosition(new Vector2(0f, player.getPosition().y));
        }
    }

    private void processInput()
    {
        if (keys.get(Keys.JUMP) && canJump)
        {
            player.getVelocity().y = Player.MAX_JUMP_SPEED;
            player.setState(Player.State.JUMPING);
            canJump = false;
        }
        else
        {
            if (player.getPosition().y > 0.5f)
            {
                player.getVelocity().y -= 0.06f;
            }
            else
            {
                player.getVelocity().y = 0f;
                canJump = true;
                player.setState(Player.State.MOVING);
            }
        }
    }

    private void checkCollisionWithCoins()
    {
        Array<Coin> coins = world.getCoins();
        int numCoins = coins.size;

        if (numCoins == 0)
        {
            repopulateCoins();
        }

        for (int i = 0; i < numCoins; i++)
        {
            Coin coin = coins.get(i);
            if (coin.getPosition().y - player.getPosition().y < 0.1f &&
                    coin.getPosition().x - player.getPosition().x <= 0.2f
                        && coin.getPosition().x - player.getPosition().x >= -.1f) {
                if (coin.getBounds().overlaps(player.getBounds())) {
                    if (coins.get(i) != null) {
                        coins.removeIndex(i);
                        numCoins = coins.size;
                        player.score++;
                    }
                }
            }
        }
    }

    private void repopulateCoins()
    {
        Array<Coin> coins = world.getCoins();
        Array<Integer> randNums = new Array<Integer>();
        for (int i = 1; i < 10; i++)
        {
            Integer integer = new Integer(i);
            randNums.add(integer);
        }

        for (int i = 0; i < 5; i++)
        {
            int randX = (int) (Math.random()*9);
            Integer newX = randNums.get(randX);
            float X = (float) newX;
            coins.add(new Coin(new Vector2(X, 1f)));
        }
    }
}
