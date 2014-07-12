/*
 * Copyright (c) 2013, Oskar Veerhoek
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */

// 30 Pixels = 1 Meter
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Put description here.
 *
 * @author Oskar Veerhoek
 */
public class PhysicsDemo {

    private static final String WINDOW_TITLE = "Sample Program";
    private static final int[] WINDOW_DIMENSIONS = {640, 480};
    
    private static World world = new World(new Vec2(0,-9.8f));
    private static Set<Body> bodies = new HashSet<Body>();

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT); // | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT
        for (Body body: bodies){
        	if (body.getType() == BodyType.DYNAMIC){
        		glPushMatrix();
        		Vec2 bodyPosition = body.getPosition().mul(30);
        		glTranslatef(bodyPosition.x,bodyPosition.y,0);
        		glRotated(Math.toDegrees(body.getAngle()),0,0,1);
        		glRectf(-0.75f*30,-0.75f*30,0.75f*30,0.75f*30);
        		glPopMatrix();
        	}
        }
    }

    private static void logic() {
    	world.step(1/60f,8,3);
    }

    private static void input() {
        for (Body body : bodies){
        	if (body.getType() == BodyType.DYNAMIC){
        		if (Keyboard.isKeyDown(Keyboard.KEY_A) && !Keyboard.isKeyDown(Keyboard.KEY_D)){
        			body.applyAngularImpulse(0.01f);
        		} else if (Keyboard.isKeyDown(Keyboard.KEY_D) && !Keyboard.isKeyDown(Keyboard.KEY_A)){
        			body.applyAngularImpulse(-0.01f);
        		}
        	}
        	
        	if (Mouse.isButtonDown(0)){
        		Vec2 mousePosition = new Vec2(Mouse.getX(), Mouse.getY()).mul(0.5f).mul(1/30f);
        		Vec2 bodyPosition = body.getPosition();
        		Vec2 force = mousePosition.sub(bodyPosition);
        		body.applyForce(force, body.getPosition());
        	}
        }    
        
        
    }

    private static void cleanUp(boolean asCrash) {
        // Add cleaning code here
        Display.destroy();
        System.exit(asCrash ? 1 : 0);
    }

    private static void setUpMatrices() {
        glMatrixMode(GL_PROJECTION);
        glOrtho(0,320,0,240,1,-1);
        glMatrixMode(GL_MODELVIEW);
    }

    
    private static void setUpObjects(){
    	BodyDef boxDef = new BodyDef();
    	boxDef.position.set(320/30/2,250/30/2);
    	boxDef.type = BodyType.DYNAMIC;
    	PolygonShape boxShape = new PolygonShape();
    	boxShape.setAsBox(0.75f,0.75f);
    	Body box = world.createBody(boxDef);
    	FixtureDef boxFixture = new FixtureDef();
    	boxFixture.density = 0.1f;
    	boxFixture.shape = boxShape;    	
    	box.createFixture(boxFixture);
    	bodies.add(box);
    	
    	CircleShape circle = new CircleShape();
    	circle.m_radius = 1.0f;
    	FixtureDef circleShapeDef = new FixtureDef();
    	circleShapeDef.shape = circle;
    	circleShapeDef.density = 0.1f;
    	BodyDef circleBodyDef = new BodyDef();
    	circleBodyDef.type = BodyType.DYNAMIC;
    	circleBodyDef.position.set(320/30/2,250/30/2);
    	Body ball = world.createBody(circleBodyDef);
    	ball.createFixture(circleShapeDef);
    	bodies.add(ball);
    	
    	
    	
    	
    	
    	
    	BodyDef groundDef = new BodyDef();
    	groundDef.position.set(0,0);
    	groundDef.type = BodyType.STATIC;
    	PolygonShape groundShape = new PolygonShape();
    	groundShape.setAsBox(1000,0);
    	Body ground = world.createBody(groundDef);
    	FixtureDef groundFixture = new FixtureDef();
    	groundFixture.density = 1;
    	groundFixture.restitution = 0.3f;
    	groundFixture.shape = groundShape;    	
    	ground.createFixture(groundFixture);
    	bodies.add(ground);
    }
    
    private static void setUpStates() {
        //        glEnable(GL_DEPTH_TEST);
        //        glEnable(GL_LIGHTING);
        //        glEnable(GL_BLEND);
        //        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    private static void update() {
        Display.update();
        Display.sync(60);
    }

    private static void enterGameLoop() {
        while (!Display.isCloseRequested()) {
            render();
            logic();
            input();
            update();
        }
    }

    private static void setUpDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(WINDOW_DIMENSIONS[0], WINDOW_DIMENSIONS[1]));
            Display.setTitle(WINDOW_TITLE);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            cleanUp(true);
        }
    }

    public static void main(String[] args) {
        setUpDisplay();
        setUpStates();
        setUpMatrices();
        setUpObjects();
        enterGameLoop();
        cleanUp(false);
    }
}