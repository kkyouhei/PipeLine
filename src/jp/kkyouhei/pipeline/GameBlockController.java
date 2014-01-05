package jp.kkyouhei.pipeline;

import java.util.ArrayList;
import android.content.Context;
import android.widget.GridLayout;

public class GameBlockController {

	private static Context context = null;

	private static GameBlockController instance = null;

	private ArrayList<GameBlockView> gameboard = null;

	private GameBlockController(Context context){
		GameBlockController.context = context;
		GameBlockController.instance = this;
		this.gameboard = generateGameBoard();
	}

	public static GameBlockController getInstance(Context context){
		if(instance == null){
			return new GameBlockController(context);
		}
		return GameBlockController.instance;
	}

	public ArrayList<GameBlockView> getGameboard(){
		return this.gameboard;
	}

	/**
	 * 3*3��GameBlockView���쐬
	 * <pre>
	 * 1   2   3
	 * 4   5   6
	 * 7   8   9
	 * </pre>
	 * @return ArrayList<GameBlockView>
	 */
    private ArrayList<GameBlockView> generateGameBoard(){
    	ArrayList<GameBlockView> gameboard = new ArrayList<GameBlockView>();
    	for(int i=0 ; i<9 ; i++){
    		gameboard.add(new GameBlockView(context, i));
    	}
    	return gameboard;
    }

    /**
     * GameBlockView��Ώۂ�GridLayout�ɒǉ�
     * @param layout GameBlock�̒ǉ���GridLayout
     */
	public void addGameBlock(GridLayout layout){
        for(GameBlockView imgView : this.gameboard){
        	layout.addView(imgView);
        }
	}
}
