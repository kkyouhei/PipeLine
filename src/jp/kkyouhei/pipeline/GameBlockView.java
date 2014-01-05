package jp.kkyouhei.pipeline;

import java.util.Random;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class GameBlockView extends ImageView{

	/**
	 * <pre>
	 * 1   2   3
	 * 4   5   6
	 * 7   8   9
	 * </pre>
	 */
	private int no;

	public GameBlockView(Context context, int no) {
		super(context);
		this.no = no;

		// 画像をセット
		setImageResource();
		// ゲームに使う3*3のImageViewを生成
		setGameBlockLayoutParams();
		// クリックイベントを設定
		this.setOnClickListener(getOnClickListener(context));
	}

	private void setImageResource(){
		this.setImageResource(getImage());
	}

	private int getImage(){
		Random random = new Random();
		int imgNo = random.nextInt(5)+1;
		switch(imgNo){
			case 1 : return R.drawable.one;
			case 2 : return R.drawable.two;
			case 3 : return R.drawable.three;
			case 4 : return R.drawable.four;
			default: return R.drawable.one;
		}
	}

	private void setGameBlockLayoutParams(){
		this.setLayoutParams(
			getGameBlockLayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT
			)
		);
	}

	private FrameLayout.LayoutParams getGameBlockLayoutParams(int width, int height){
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
			width,
			height
		);
		return params;
	}

	private OnClickListener getOnClickListener(final Context context){
		return new OnClickListener(){
			@Override
			public void onClick(View v){
				Animation anim = AnimationUtils.loadAnimation(context, R.anim.rotate);
				v.startAnimation(anim);
			}
		};
	}
}
