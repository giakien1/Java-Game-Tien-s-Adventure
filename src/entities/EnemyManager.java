package entities;

import gamestates.Playing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import utilz.LoadSave;
import static utilz.Constants.EnemyConstans.*;
public class EnemyManager {
   private Playing playing;
   private BufferedImage[][] crabbyArr;
   private ArrayList<Crabby> crabbies = new ArrayList();

   public EnemyManager(Playing playing) {
      this.playing = playing;
      loadEnemyImgs();
      addEnemies();
   }

   private void addEnemies() {
      crabbies = LoadSave.GetCrabs();
      System.out.println("size cua: " + this.crabbies.size());
   }

   public void update(int[][] lvlData) {
      for(Crabby c : crabbies) {
    	  c.update(lvlData);
      }
   }

   public void draw(Graphics g, int xLvlOffset) {
      drawCrabs(g, xLvlOffset);
   }

   private void drawCrabs(Graphics g, int xLvlOffset) {
	   for(Crabby c : crabbies)
         g.drawImage(crabbyArr[c.getEnemyState()][c.getAniIndex()], (int)c.getHitbox().x - xLvlOffset, (int)c.getHitbox().y, CRABBY_WIDTH, CRABBY_HEIGHT,null);
      }

   private void loadEnemyImgs() {
      this.crabbyArr = new BufferedImage[5][9];
      BufferedImage temp = LoadSave.GetSpriteAtlas("crabby_sprite.png");

      for(int j = 0; j < crabbyArr.length; ++j) {
         for(int i = 0; i < crabbyArr[j].length; ++i) {
            crabbyArr[j][i] = temp.getSubimage(i * CRABBY_WIDTH_DEFAULT, j * CRABBY_HEIGHT_DEFAULT, CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);
         }
      }

   }
}
