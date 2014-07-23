package JavaGame.Display;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Font extends UnicodeFont {

    public Font(String path, float size) {
        super(initCustomFont(path).deriveFont(0, (float) size));
        init();
    }

    public Font(String awtFont, int style, double size) {
        super(initAwtFont(awtFont, style).deriveFont(0, (float) size));
        init();
    }

    private static java.awt.Font initAwtFont(String font, int style) {
        java.awt.Font awtFont = new java.awt.Font(font, style, 1);
        return awtFont;
    }

    private static java.awt.Font initCustomFont(String path) {
        InputStream iStream = ResourceLoader.getResourceAsStream(path);
        java.awt.Font awtFont = null;
        try {
            awtFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, iStream);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return awtFont;
    }

    private void init() {
        addAsciiGlyphs();
        addGlyphs(400, 600);
        getEffects().add(new ColorEffect(Color.white));
        try {
            loadGlyphs();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
