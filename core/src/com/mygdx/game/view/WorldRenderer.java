package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.objects.Coin;
import com.mygdx.game.objects.Platform;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.World;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;


/**
 * Created by ryanw on 10/13/2016.
 */
public class WorldRenderer
{
    private World world;
    private OrthographicCamera camera;
    private static final float CAMERA_WIDTH = 10f;
    private static final float CAMERA_HEIGHT = 7f;

    private ShapeRenderer debugRenderer = new ShapeRenderer();
    private Texture coinTexture;
    private SpriteBatch batch = new SpriteBatch();
    private BitmapFont font = new BitmapFont();

    private int width;
    private int height;
    private float ppuX; //pixels per unit X
    private float ppuY; //pixels per unit Y

    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
        ppuX = (float)width / CAMERA_WIDTH;
        ppuY = (float)height / CAMERA_HEIGHT;
    }

    public WorldRenderer(World world)
    {
        this.world = world;
        this.camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.camera.position.set(CAMERA_WIDTH/2f, CAMERA_HEIGHT/2f, 0);
        batch = new SpriteBatch();
        this.camera.update();
        loadTextures();
    }

    public void render()
    {
        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Platform platform: world.getPlatforms())
        {
            Rectangle rect = platform.getBounds();
            float x1 = platform.getPosition().x + rect.x;
            float y1 = platform.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(0, 0, 255, 1));
            debugRenderer.rect(x1, y1, rect.width, rect.height);
        }

        Player player = world.getPlayer();
        Rectangle rect = player.getBounds();
        float x1 = player.getPosition().x + rect.x;
        float y1 = player.getPosition().y + rect.y;
        debugRenderer.setColor(new Color(10, 20, 12, 1));
        debugRenderer.rect(x1, y1, rect.width, rect.height);

        batch.begin();
        font.setColor(Color.WHITE);
        font.draw(batch, "Score: " + player.score, 25, 450);
        drawCoins();
        batch.end();

        debugRenderer.end();
    }

    private void loadTextures()
    {
        coinTexture = new Texture(Gdx.files.internal("images/Coin.png"));
    }

    private void drawCoins()
    {
        for(Coin coin: world.getCoins())
        {
            batch.draw(coinTexture, coin.getPosition().x*ppuX, coin.getPosition().y*ppuY, Coin.SIZE*ppuX, Coin.SIZE*ppuY);
        }
    }
}
